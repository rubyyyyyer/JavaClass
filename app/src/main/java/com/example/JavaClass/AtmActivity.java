package com.example.JavaClass;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.JavaClass.databinding.ActivityAtmBinding;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;

public class AtmActivity extends AppCompatActivity {
    private static final int REQUEST_LOGIN = 100;
    Boolean logon = false;
    private AppBarConfiguration appBarConfiguration;
    private ActivityAtmBinding binding;
    private ActivityResultLauncher<Intent> requestDataLaunch;

    String[] functions = null;
    private String TAG =AtmActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAtmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

  /*


/*        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.toolbar);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);*/

      /*  binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });*/
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
//        Log.d(TAG, userIDS );
//        getSupportActionBar().setTitle("歡迎,"+ userIDS);

        getSupportActionBar().setTitle("歡迎,Ruby");
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


/*    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.toolbar);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}
