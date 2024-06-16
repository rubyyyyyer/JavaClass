package com.example.JavaClass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FunctionAdapterLine extends RecyclerView.Adapter<FunctionAdapterLine.FunctionViewHolder> {
    private final String[] functions;
    Context context;
    public FunctionAdapterLine(Context context){
         this.context = context;
         functions = context.getResources().getStringArray(R.array.functions);
    }
    @NonNull
    @Override
    public FunctionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new FunctionViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull FunctionViewHolder holder, int position) {
        if (holder.nameText != null) {
            holder.nameText.setText(functions[position]);
        }
    }
    @Override
    public int getItemCount() {
        return functions.length;
    }
    public class FunctionViewHolder extends RecyclerView.ViewHolder{
        TextView nameText;
        @SuppressLint("ResourceType")
        public FunctionViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(android.R.id.text1);
        }
    }
}
