package com.example.androidprojectcollection;

import static com.example.androidprojectcollection.R.id.btnLayoutExercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btnPI, btnM, btnConnect3, btnMterm;

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
                Toast.makeText(MainActivity.this, "Welcome to Instagram", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(MainActivity.this, "Buttons!", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(MainActivity.this, "Calculator", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(MainActivity.this, "Fill Up Forms", Toast.LENGTH_SHORT).show();
                startActivity(intentPI);
            }
        });

        btnM = findViewById(R.id.btnMenus);
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentM = new Intent(
                        MainActivity.this,
                        MenuExercise.class
                );
                Toast.makeText(MainActivity.this, "Menu Exercise", Toast.LENGTH_SHORT).show();
                startActivity(intentM);
            }
        });

        btnConnect3 = findViewById(R.id.btnConnect3);
        btnConnect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentConnect = new Intent(
                        MainActivity.this,
                        Connect3.class
                );
                Toast.makeText(MainActivity.this, "Connect 3", Toast.LENGTH_SHORT).show();
                startActivity(intentConnect);
            }
        });

        btnMterm = findViewById(R.id.btnMidterm);
        btnMterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentColorGame = new Intent(
                        MainActivity.this,
                        ColorGame.class
                );
                Toast.makeText(MainActivity.this, "Color Game", Toast.LENGTH_SHORT).show();
                startActivity(intentColorGame);
            }
        });

    }
}