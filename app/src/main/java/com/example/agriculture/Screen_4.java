package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agriculture.adapter.InfoAdapter;
import com.example.agriculture.models.AppModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Screen_4 extends AppCompatActivity {

    private int id;
    private  String content,name;
    DatabaseHandler databaseHandler;
//    TextView textView;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);
        databaseHandler= new DatabaseHandler(this);
//            textView=findViewById(R.id.textView);

        layout = findViewById(R.id.linearLayout);
        id=getIntent().getIntExtra("id",0);
        content=getIntent().getStringExtra("content");
        name=getIntent().getStringExtra("name");
        getSupportActionBar().setTitle(name);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        textView.setText(content);
        inflateData(content);
    }

    public void inflateData(String content) {
        try {
            String[] arr = content.split("\n");
            for (String elem : arr) {
                if(elem.length()<2) return;
                Log.e("Db contents", elem);
                layout.addView(getView(elem));
            }
        } catch (Exception e) {
            Log.e("sdfdsd", e.getMessage());
            Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show();
        }
    }
    public View getView(String content) throws IOException {
        // we process 3 types of views
        // 1. #H: headers, where text is bold
        // 2. #I: images
        // 3. normal text content

        String type = content.substring(0, 2);
        if (type.equals("#H")) {
            TextView textView = new TextView(this);
            textView.setText(content.substring(2));
            textView.setPadding(0,40,0,20);
            textView.setTypeface(null, Typeface.BOLD);
            return textView;
        } else if (type.equals("#I")) {
            InputStream image = getAssets().open("grapes.jpeg");
//            InputStream image = getAssets().open(content.substring(2));
            Drawable d = Drawable.createFromStream(image, null);
            ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(d);
            imageView.setPadding(0,30,0,30);
            return imageView;
        } else {
            TextView textView = new TextView(this);
            textView.setText(content);
            return textView;
        }
    }
}