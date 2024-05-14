package com.example.JavaClass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText input_userid;
    private EditText input_passwd;
    private CheckBox chk_rememberID;
    private String userID ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_userid = findViewById(R.id.input_userid);
        input_passwd = findViewById(R.id.input_passwd);

        String userID = getSharedPreferences("atm",MODE_PRIVATE)
                .getString("userID","");

        input_userid.setText(userID);
        chk_rememberID = findViewById(R.id.chk_rememberID);
        chk_rememberID.setChecked(
                getSharedPreferences("atm",MODE_PRIVATE)
                        .getBoolean("chk_rememberID",false));
        chk_rememberID.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getSharedPreferences("atm",MODE_PRIVATE)
                        .edit()
                        .putBoolean("chk_rememberID",isChecked)
                        .apply();
            }
        });
    }

    public void login(View view){
        String i_ui = input_userid.getText().toString();
        String i_pw = input_passwd.getText().toString();

        //
//        Intent intent = new Intent(this, AtmActivity.class);



        FirebaseDatabase.getInstance().getReference("users").child(i_ui).child("passwd")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String firebasePW = (String) dataSnapshot.getValue();
//                        System.out.println("我在這:" + firebasePW);
                        boolean chk_rememberID;

                        if (i_pw.equals(firebasePW)){
                             chk_rememberID =  getSharedPreferences("atm",MODE_PRIVATE)
                                    .getBoolean("chk_rememberID",false);

                            if (chk_rememberID){
                                //save userID
                            getSharedPreferences("atm",MODE_PRIVATE)
                                    .edit()
                                    .putString("userID",i_ui)
                                    .apply();

//                                intent.putExtra("userID",i_ui);
//                                startActivity(intent);

                            }else{
                                getSharedPreferences("atm",MODE_PRIVATE)
                                        .edit()
                                        .putString("userID","")
                                        .apply();
                            }

                            Toast.makeText(LoginActivity.this,i_ui + " ,登入成功",Toast.LENGTH_LONG)
                                    .show();
                           setResult(RESULT_OK);
                           finish();
                        }else{
                            /*Toast.makeText(LoginActivity.this,"登入失敗",Toast.LENGTH_LONG)
                                    .show();*/
                            new AlertDialog.Builder(LoginActivity.this)
                                    .setTitle("Error")
                                    .setMessage("帳密錯誤")
                                    .setPositiveButton("重新輸入", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {


                                            userID = getSharedPreferences("atm",MODE_PRIVATE)
                                                    .getString("userID","");

                                            if (i_ui.equals(userID)){
                                                getSharedPreferences("atm",MODE_PRIVATE)
                                                        .edit()
                                                        .putString("userID",i_ui)
                                                        .apply();
                                            }else{
                                                input_userid.setText("");
                                            }

                                            input_passwd.setText("");

                                        }
                                    })
                                    .show();

                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

    }
    public void cancel(View view){
        finish();
    }
}