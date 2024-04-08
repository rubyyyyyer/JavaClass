package com.example.javaclass;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        //search:FadeMove
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        inputHeight = findViewById(R.id.input_height);
        inputWeight = findViewById(R.id.input_weight);
        resultBmi = findViewById(R.id.result_bmi);
        Button btn_info = findViewById(R.id.btn_info);
        btn_info.setOnClickListener(new View.OnClickListener() {
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




    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    public void bmi(View view){
        String input_Hs = inputHeight.getText().toString();
        String input_Ws = inputWeight.getText().toString();
        float input_Hf = Float.parseFloat(input_Hs);
        float input_Wf = Float.parseFloat(input_Ws);

        float bmi = input_Wf / (input_Hf*input_Hf);
        Toast.makeText(this,getString(R.string.bmi)+bmi,Toast.LENGTH_LONG).show();
//        resultBmi.setText(""+bmi);
        resultBmi.setText(String.format("%s", bmi));

        /*new AlertDialog.Builder(this)
                .setTitle(R.string.bmi)
                .setMessage(""+bmi)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputHeight.setText("");
                        inputWeight.setText("");


                    }
                })
                .show();*/

        Intent intentToShowBMI = new Intent(this, ShowBMI.class);
        intentToShowBMI.putExtra("BMI",bmi);
        startActivity(intentToShowBMI);







    }
}