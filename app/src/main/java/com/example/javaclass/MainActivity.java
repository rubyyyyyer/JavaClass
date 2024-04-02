package com.example.javaclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputHeight;
    private EditText inputWeight;
    private TextView resultBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputHeight = findViewById(R.id.input_height);
        inputWeight = findViewById(R.id.input_weight);
        resultBmi = findViewById(R.id.result_bmi);
        Button btn_info = findViewById(R.id.btn_info);
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI")
                        .setMessage("Body Mass Index (BMI) is a person's weight in kilograms divided by the square of height in meters. A high BMI can indicate high body fatness. BMI screens for weight categories that may lead to health problems, but it does not diagnose the body fatness or health of an individual.")
                        .setPositiveButton("Close",null)
                        .show();
            }
        });


    }

    public void bmi(View view){
        String input_Hs = inputHeight.getText().toString();
        String input_Ws = inputWeight.getText().toString();
        float input_Hf = Float.valueOf(input_Hs);
        float input_Wf = Float.valueOf(input_Ws);

        float bmi = input_Wf / (input_Hf*input_Hf);
        Toast.makeText(this,"BMI"+bmi,Toast.LENGTH_LONG).show();
        resultBmi.setText(""+bmi);

        new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage(""+bmi)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputHeight.setText("");
                        inputWeight.setText("");


                    }
                })
                .show();

    }
}