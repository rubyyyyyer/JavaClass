package com.example.javaclass;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //bmi的方法名稱，必須和onClick上的名稱一模一樣，包含大小寫。
    public void bmi(View view) {

        //取得輸入方塊(身高、體重)的值
        EditText inputWeight = findViewById(R.id.input_weight);
        EditText inputHeight = findViewById(R.id.input_height);

        //將取得的值(Editable)轉換為字串(String)
        String weightS = inputWeight.getText().toString();
        String heightS = inputHeight.getText().toString();

        //將身高、體重的值由字串(String)轉為浮點數(float)
        float weight = Float.parseFloat(weightS);
        float height = Float.parseFloat(heightS);

        //運算bmi值
        float bmi = weight / (height*height);

        //列印到控制台，類似system.out.println
        Log.d("MainActivity","BMI:" + bmi);
    }
}