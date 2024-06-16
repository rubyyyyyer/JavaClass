package com.example.JavaClass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AtmActivity extends AppCompatActivity {
    private static final int REQUEST_LOGIN = 100;
    Boolean logon = false;

    private ActivityResultLauncher<Intent> requestDataLaunch;

    private String TAG =AtmActivity.class.getSimpleName() ;
    String userID ;
    private List<Function> functions;


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


        userID = getSharedPreferences("atm",MODE_PRIVATE)
                .getString("userID","");

        //Toolbar設定
        setToolbar();


/*        //Recycler-Line
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Adapter-line
        FunctionAdapterLine adapter = new FunctionAdapterLine(this);
        recyclerView.setAdapter(adapter);
        */

        //Recycler-Data
        functions();


        //Recycler-Grid
        RecyclerView recyclerView =findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        //Adapter-Grid
        FunctionAdapterGrid adapter = new FunctionAdapterGrid();
        recyclerView.setAdapter(adapter);
    }

    //Adapter-Grid-Class
    public class FunctionAdapterGrid extends RecyclerView.Adapter<FunctionAdapterGrid.FunctionViewHolder>{

        @NonNull
        @Override
        public FunctionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_icon,parent,false);
            return new FunctionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FunctionViewHolder holder, int position) {
            Function function = functions.get(position);
            holder.nameText.setText(function.getNameText());
            holder.iconImg.setImageResource(function.getIconImg());
        }

        @Override
        public int getItemCount() {
            return functions.size();
        }

        public class FunctionViewHolder extends RecyclerView.ViewHolder{
            ImageView iconImg ;
            TextView nameText;

            public FunctionViewHolder(@NonNull View itemView) {
                super(itemView);
                iconImg = itemView.findViewById(R.id.item_icon);
                nameText = itemView.findViewById(R.id.item_text);


            }
        }

    }



    private void functions() {
        functions = new ArrayList<>();
        String[] functionsText =getResources().getStringArray(R.array.functions);
        functions.add(new Function(functionsText[0], R.drawable.func_transaction));
        functions.add(new Function(functionsText[1], R.drawable.func_balance));
        functions.add(new Function(functionsText[2], R.drawable.func_finance));
        functions.add(new Function(functionsText[3], R.drawable.func_contacts));
        functions.add(new Function(functionsText[4], R.drawable.func_exit));
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

    @Override
    protected void onResume() {
        super.onResume();

        //重新抓取登入資料-->使用者名稱
        userID = getSharedPreferences("atm",MODE_PRIVATE)
                .getString("userID","");
        Log.d(TAG, "onResume: "+userID);

        //Toolbar設定
        setToolbar();
    }
}
