package com.example.androidprojectcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class ColorGame extends AppCompatActivity implements View.OnClickListener {

    Button[][] buttons = new Button[3][3];
    int[][] colors = new int[3][3];
    boolean gameEnded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_game);

        buttons[0][0] = findViewById(R.id.button_1);
        buttons[0][1] = findViewById(R.id.button_2);
        buttons[0][2] = findViewById(R.id.button_3);
        buttons[1][0] = findViewById(R.id.button_4);
        buttons[1][1] = findViewById(R.id.button_5);
        buttons[1][2] = findViewById(R.id.button_6);
        buttons[2][0] = findViewById(R.id.button_7);
        buttons[2][1] = findViewById(R.id.button_8);
        buttons[2][2] = findViewById(R.id.button_9);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setOnClickListener(this);
            }
        }

        // Generate random colors
        generateRandomColors();

        // Update button colors with the generated random colors
        updateButtonColors();

        Button returnButton = findViewById(R.id.button_restart);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomColors();
                gameEnded = false;
                updateButtonColors();
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (!gameEnded) {
            Button button = (Button) view;
            if (!button.equals(buttons[1][1])) {
                int row = -1, col = -1;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (buttons[i][j].equals(button)) {
                            row = i;
                            col = j;
                            break;
                        }
                    }
                }
                if (row != -1 && col != -1) {
                    changeAdjacentColors(row, col);
                    updateButtonColors();
                    if (checkWinCondition()) {
                        gameEnded = true;
                        Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    private void generateRandomColors() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                colors[i][j] = random.nextInt(3);
            }
        }
    }

    private void changeAdjacentColors(int row, int col) {
        int nextColor = (colors[row][col] + 1) % 3;
        colors[row][col] = nextColor;

        if (row - 1 >= 0)
            colors[row - 1][col] = nextColor;
        if (row + 1 < 3)
            colors[row + 1][col] = nextColor;
        if (col - 1 >= 0)
            colors[row][col - 1] = nextColor;
        if (col + 1 < 3)
            colors[row][col + 1] = nextColor;
    }

    private void updateButtonColors() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int color = getColorForIndex(colors[i][j]);
                buttons[i][j].setBackgroundColor(color);
            }
        }
    }

    private int getColorForIndex(int index) {
        switch (index) {
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.BLUE;
            default:
                return Color.BLACK;
        }
    }

    private boolean checkWinCondition() {
        int firstColor = colors[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (colors[i][j] != firstColor) {
                    return false;
                }
            }
        }
        return true;
    }
}