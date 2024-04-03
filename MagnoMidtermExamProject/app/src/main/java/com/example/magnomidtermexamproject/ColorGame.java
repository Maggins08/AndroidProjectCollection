package com.example.magnomidtermexamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import java.util.*;

public class ColorGame extends AppCompatActivity {
    private static final int NUM_COLORS = 3;
    private static final int[] COLORS = {Color.RED,Color.GREEN,Color.BLUE};
    Button bton1;
    Button bton2;
    Button bton3;
    Button bton4;
    Button bton5;
    Button bton6;
    Button bton7;
    Button bton8;
    Button bton9;
    Button btnRtn;

    boolean val = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_game);

    }

    void init(){
        bton1 = findViewById(R.id.btn1);
        bton2 = findViewById(R.id.btn2);
        bton3 = findViewById(R.id.btn3);
        bton4 = findViewById(R.id.btn4);
        bton5 = findViewById(R.id.btn5);
        bton6 = findViewById(R.id.btn6);
        bton7 = findViewById(R.id.btn7);
        bton8 = findViewById(R.id.btn8);
        bton9 = findViewById(R.id.btn9);
        btnRtn = findViewById(R.id.btnReturn);
    }
}