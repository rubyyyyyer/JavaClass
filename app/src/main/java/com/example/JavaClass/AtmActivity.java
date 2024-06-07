package com.example.JavaClass;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AtmActivity extends AppCompatActivity {
    private static final int REQUEST_LOGIN = 100;
    Boolean logon = false;

    private ActivityResultLauncher<Intent> requestDataLaunch;

    private String TAG =AtmActivity.class.getSimpleName() ;
    String userID ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_atm);

     requestDataLaunch = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK){
                    logon = true;
                }else{
                    finish();
                }
            }
        });
        Intent intent = new Intent(this, LoginActivity.class);
        requestDataLaunch.launch(intent);

        //Toolbar設定
       userID = getSharedPreferences("atm",MODE_PRIVATE)
                .getString("userID","");

        setToolbar();


        //Recycler
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Adapter
        FunctionAdapter adapter = new FunctionAdapter(this);
        recyclerView.setAdapter(adapter);


    }

    private void setToolbar() {
        /**初始化Toolbar*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        /**將Toolbar綁定到setSupportActionBar*/
        setSupportActionBar(toolbar);
        /**設置大標題*/
//        String userIDS = getIntent().getStringExtra("userID");
//        Log.d(TAG, userIDS);
        Log.d(TAG, "我在這" + userID);
        getSupportActionBar().setTitle("歡迎,"+userID);
        /**設置大標題字體顏色*/
        //Resources.getColor(int id) 已棄用
        //toolbar.setTitleTextColor(getResources().getColor(R.color.blue));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.blue));
        /**設置副標題*/
//        toolbar.setSubtitle("副標題");
//        /**設置副標題字體顏色*/
//        toolbar.setSubtitleTextColor(R.color.blue);
        /**設置標題前方的Icon圖樣*/
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_logout));
        /**設置前方Icon與Title之距離為0(預設的很遠...)*/
        toolbar.setContentInsetStartWithNavigation(150);

        /**設置Icon圖樣的點擊事件*/
        toolbar.setNavigationOnClickListener(v->{
            Toast.makeText(this, "結束", Toast.LENGTH_SHORT).show();

        });
//        toolbar.inflateMenu(請自己在menu設置一個xml檔案);
//        如果想使用xml Layout檔案，請去建一個吧～

    }



}
