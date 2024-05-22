package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Button changeBtn = findViewById(R.id.btnTransformingButton);

        switch (item.getItemId()) {
            case R.id.change_bg:
                int randomColor = getRandomColor();
                changeBtn.setBackgroundColor(randomColor);
                return true;

            case R.id.change_txt_color:
                int randomTxtColor = getRandomColor();
                changeBtn.setTextColor(randomTxtColor);
                return true;

            case R.id.change_text:
                changeBtn.setText("New Button Text");
                return true;

            case R.id.Promptbtn:
                Toast.makeText(MenuExercise.this, "You pressed Prompt Button!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.change_size:
                changeBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                return true;

            case R.id.mItemReset:
                changeBtn.setTextColor(getColor(R.color.white));
                changeBtn.setBackgroundColor(getColor(R.color.purple_200));
                changeBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                return true;

            case R.id.mItemExit:
                Intent intent1 = new Intent(MenuExercise.this, MainActivity.class);
                startActivity(intent1);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private int getRandomColor() {
        int[] colors = {
                Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
                Color.WHITE, Color.CYAN, Color.MAGENTA, Color.LTGRAY
        };
        return colors[new Random().nextInt(colors.length)];
    }
}