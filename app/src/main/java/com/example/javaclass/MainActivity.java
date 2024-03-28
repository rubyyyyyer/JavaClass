package com.example.javaclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputWeight;
    private EditText inputHeight;
    private TextView result_bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        String hello = getResources().getString(R.string.hello);
    }

    private void findViews() {
        inputWeight = findViewById(R.id.input_weight);
        inputHeight = findViewById(R.id.input_height);
        result_bmi = findViewById(R.id.result_bmi);
        Button btn_information = findViewById(R.id.btn_Infomation);
        btn_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.bmi)
                        .setMessage(R.string.bmi_info)
                        .setPositiveButton(R.string.close,null)
                        .show();
            }
        });
    }

    public void bmi(View view) {
        String weightS = inputWeight.getText().toString();
        String heightS = inputHeight.getText().toString();
        float weight = Float.parseFloat(weightS);
        float height = Float.parseFloat(heightS);
        float bmi = weight / (height*height);
        Log.d("MainActivity","BMI:" + bmi);
        Toast.makeText(this,"Calculate BMI Result："+bmi,Toast.LENGTH_LONG).show();

        new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage(""+bmi)
                .setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputHeight.setText("");
                        inputWeight.setText("");
                    }
                })
                .show();

        result_bmi.setText(""+bmi);
    }









}















