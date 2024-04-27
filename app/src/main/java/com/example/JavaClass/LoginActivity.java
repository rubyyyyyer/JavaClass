package com.example.JavaClass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSharedPreferences("atm",MODE_PRIVATE)
                .edit()
                .putInt("LEVEL",20)
                .putString("NAME","ruby")
                .apply();

        int level = getSharedPreferences("atm",MODE_PRIVATE)
                .getInt("LEVEL",0);

        Log.d(TAG, "onCreate: "+level);

        input_userid = findViewById(R.id.input_userid);
        input_passwd = findViewById(R.id.input_passwd);
    }

    public void login(View view){
        String i_ui = input_userid.getText().toString();
        String i_pw = input_passwd.getText().toString();

        FirebaseDatabase.getInstance().getReference("users").child(i_ui).child("passwd")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String firebasePW = (String) dataSnapshot.getValue();
                        System.out.println("我在這:" + firebasePW);
                        if (i_pw.equals(firebasePW)){
                            Toast.makeText(LoginActivity.this,"登入成功",Toast.LENGTH_LONG)
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
                                        }
                                    })
                                    .show();
                            input_userid.setText("");
                            input_passwd.setText("");
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });


      /*  if ( i_ui.equals("ruby") && i_pw.equals("1234")){
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG)
                    .show();
            setResult(RESULT_OK);
            finish();
        }else{
            Toast.makeText(this,"登入失敗",Toast.LENGTH_LONG)
                    .show();
        }*/
    }
    public void cancel(View view){
        finish();
    }
}