package com.example.agriculture.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriculture.R;
import com.example.agriculture.Screen3;
import com.example.agriculture.Screen_2;
import com.example.agriculture.Screen_4;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.infoViewHolder> {

    String data[];
    Context context;

    public InfoAdapter(Context context, String[] data) {
        this.data=data;
        this.context=context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public infoViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info,parent,false);
        infoViewHolder viewHolder=new infoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull InfoAdapter.infoViewHolder holder, int position) {
       holder.text.setText(data[position]);
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent3=new Intent(context, Screen_4.class);
               intent3.putExtra("headline",data[position]);
               context.startActivity(intent3);
           }
       });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class infoViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public infoViewHolder(final View View) {
            super(View);
             text=View.findViewById(R.id.text1);
        }
    }
}
