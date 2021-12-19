package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class FormulationActivity extends AppCompatActivity {

    EditText area,spacing,areaAnsET,fruitSet,totalFruits,fruitSetAns,totalPlant,avgWeight,yieldAns;
    MaterialButton areaBtn,calculateFruitBtn,yieldBtn;
    TextView areaAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulation);
        area = findViewById(R.id.areaET);
        spacing=findViewById(R.id.spacingET);
        areaAnsET=findViewById(R.id.areaAnsET);
        areaBtn=findViewById(R.id.calculatePlantBtn);
        fruitSet=findViewById(R.id.initialFruitET);
        totalFruits=findViewById(R.id.totalFlowersET);
        fruitSetAns=findViewById(R.id.setCentAnsET);
        calculateFruitBtn=findViewById(R.id.calculateFruitBtn);
        totalPlant=findViewById(R.id.totalPlantsET);
        avgWeight=findViewById(R.id.avgWeightET);
        yieldAns=findViewById(R.id.yieldAnsET);
        yieldBtn=findViewById(R.id.calculateYieldBtn);

        areaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(area.getText().toString().trim().matches("") ||spacing.getText().toString().trim().matches("") ){
                    Toast.makeText(getApplicationContext(), "Please enter area and spacing to calculate plant population!", Toast.LENGTH_SHORT).show();
                }else{
                    Integer val = Integer.parseInt(area.getText().toString());
                    Integer val2 = Integer.parseInt(spacing.getText().toString());

                    areaAnsET.setText(String.valueOf((int)Math.floor(val*10000/(val2*val2))));
                }
            }
        });
        calculateFruitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fruitSet.getText().toString().trim().matches("") ||totalFruits.getText().toString().trim().matches("") ){
                    Toast.makeText(getApplicationContext(), "Please enter initial fruit set and total flowers to calculate Fruit set percentage!", Toast.LENGTH_SHORT).show();
                }else{
                    Integer val = Integer.parseInt(fruitSet.getText().toString());
                    Integer val2 = Integer.parseInt(totalFruits.getText().toString());

                    fruitSetAns.setText(((val*100)/val2) + " %");
                }
            }
        });
        yieldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalPlant.getText().toString().trim().matches("") ||avgWeight.getText().toString().trim().matches("") ){
                    Toast.makeText(getApplicationContext(), "Please enter total number of plants and average weight to calculate Yield", Toast.LENGTH_SHORT).show();
                }else{
                    Integer val = Integer.parseInt(totalPlant.getText().toString());
                    Double val2 = Double.parseDouble(avgWeight.getText().toString());

                    yieldAns.setText(String.valueOf(val*val2));
                }
            }
        });
    }
}