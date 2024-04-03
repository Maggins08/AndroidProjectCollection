package com.example.androidprojectcollection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Random;

public class ButtonExercise extends AppCompatActivity {

    Button btnToast;
    Button btnClose;
    Button btnDisappear;
    Button btnChangeBG;
    Button btnChangebtnBG;
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        btnClose = findViewById(R.id.btnButtonClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentClose = new Intent(
                        ButtonExercise.this,// context
                        ReturnExercise.class//destination activity
                );
                startActivity(intentClose);
            }
        });

        btnToast = findViewById(R.id.btnButtonToast);
        btnToast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(ButtonExercise.this, "imnida", Toast.LENGTH_SHORT).show();
            }
        });

        btnDisappear = findViewById(R.id.btnButtonDisappear);
        btnDisappear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btnDisappear.setVisibility(View.GONE);
            }
        });
        mainLayout = findViewById(R.id.layout);
        btnChangeBG = findViewById(R.id.btnButtonChangeBG); // Initialize the new button
        btnChangeBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackgroundColorRandom();
            }
        });

        btnChangebtnBG = findViewById(R.id.btnButtonChangebtnBG);
        btnChangebtnBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBtnBackgroundColorRandom();
            }
        });

    }

    // Method to change background color of btnDisappear to a random color
    private void changeBackgroundColorRandom() {
        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        mainLayout.setBackgroundColor(color);
    }
    private void changeBtnBackgroundColorRandom() {
        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        btnChangebtnBG.setBackgroundColor(color);
    }
}
