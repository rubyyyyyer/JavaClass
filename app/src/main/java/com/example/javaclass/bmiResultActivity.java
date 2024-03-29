package com.example.javaclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class bmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        TextView result_bmi = findViewById(R.id.result_bmi);

        Float bmi = getIntent().getFloatExtra("BMI",0);

        result_bmi.setText(""+bmi);
    }
}