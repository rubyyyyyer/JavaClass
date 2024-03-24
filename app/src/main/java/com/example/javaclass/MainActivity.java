package com.example.javaclass;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    }

    private void findViews() {
        inputWeight = findViewById(R.id.input_weight);
        inputHeight = findViewById(R.id.input_height);
        result_bmi = findViewById(R.id.result_bmi);
    }

    public void bmi(View view) {
        String weightS = inputWeight.getText().toString();
        String heightS = inputHeight.getText().toString();
        float weight = Float.parseFloat(weightS);
        float height = Float.parseFloat(heightS);
        float bmi = weight / (height*height);
        Log.d("MainActivity","BMI:" + bmi);
        Toast.makeText(this,"Calculate BMI Result："+bmi,Toast.LENGTH_LONG).show();


        result_bmi.setText(""+bmi);
    }
}