package com.example.androidprojectcollection;

import static com.example.androidprojectcollection.R.id.btnLayoutExercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btnPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnLayoutExercise);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(
                        MainActivity.this,// context
                        LayoutExercise.class//destination activity
                );
                startActivity(intent1);
            }
        });

        btn2 = findViewById(R.id.btnButtonExercise);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(
                        MainActivity.this,// context
                        ButtonExercise.class//destination activity
                );
                startActivity(intent2);
            }
        });

        btn3 = findViewById(R.id.btnCalculatorExercise);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(
                        MainActivity.this,// context
                        CalculatorExercise.class//destination activity
                );
                startActivity(intent3);
            }
        });
        btnPI = findViewById(R.id.btnPassingIntents);
        btnPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPI = new Intent(
                        MainActivity.this,
                        PassingIntentsExercise.class
                );
                startActivity(intentPI);
            }
        });

    }
}