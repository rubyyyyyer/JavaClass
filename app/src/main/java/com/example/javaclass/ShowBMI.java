package com.example.javaclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowBMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_bmi);
        TextView showBMI = findViewById(R.id.result_bmi);
        float bmi = getIntent().getFloatExtra("BMI",0);
//        showBMI.setText(String.format("%s", bmi));
        showBMI.setText("" + bmi);
    }
}