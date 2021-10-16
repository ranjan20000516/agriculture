package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.agriculture.adapter.InfoAdapter;
import com.example.agriculture.models.AppModel;

import java.util.ArrayList;

public class Screen_4 extends AppCompatActivity {

    private int id;
    private  String content,name;
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    DatabaseHandler databaseHandler;
    InfoAdapter adapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);
        ArrayList<AppModel> appModels = new ArrayList<>();
        databaseHandler= new DatabaseHandler(this);
            textView=findViewById(R.id.textView);

        id=getIntent().getIntExtra("id",0);
        content=getIntent().getStringExtra("content");
        Log.i("contact us",content.toLowerCase());
        name=getIntent().getStringExtra("name");
        getSupportActionBar().setTitle(name);
        appModels= databaseHandler.getModelsbyID(id);
        recyclerView=findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        linearLayout = findViewById(R.id.contactUs);

        adapter=new InfoAdapter(this,appModels);
        if(name.toLowerCase().equals("contact us")){
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
            linearLayout.setVisibility(View.VISIBLE);
        }
       else if(appModels.size()==0){
            textView.setText(content);
            recyclerView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }
        recyclerView.setAdapter(adapter);

    }
}