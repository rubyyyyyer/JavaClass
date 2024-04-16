package com.example.JavaClass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText input_userid;
    private EditText input_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        input_userid = findViewById(R.id.input_userid);
        input_passwd = findViewById(R.id.input_passwd);
    }

    public void login(View view){
        String i_ui = input_userid.getText().toString();
        String i_pw = input_passwd.getText().toString();

        if ( i_ui.equals("ruby") && i_pw.equals("1234")){
            finish();
        }
    }
    public void cancel(View view){

    }
}