package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.agriculture.adapter.InfoAdapter;

public class Screen3 extends AppCompatActivity {

    RecyclerView recyclerView;
    InfoAdapter adapter;
    String info_tab[]= {"Introduction","Crop Production","Varieties","Pest Management","Disease Management","Harvest","Post Harvest",
    "Contact Us"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        recyclerView=findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new InfoAdapter(this,info_tab);
        recyclerView.setAdapter(adapter);

    }
}