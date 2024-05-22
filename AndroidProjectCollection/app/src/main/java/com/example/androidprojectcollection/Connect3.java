package com.example.androidprojectcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Connect3 extends AppCompatActivity {

    private Button[][] buttons = new Button[5][5];
    private boolean player1Turn = true;
    private TextView textViewPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);

        textViewPlayer = findViewById(R.id.txtViewPlayer);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);

                // Set tags to buttons to identify their column
                buttons[i][j].setTag(j);

                if (i == 0) {
                    buttons[i][j].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onFirstRowButtonClick(v);
                        }
                    });
                }
            }
        }

        Button buttonReset = findViewById(R.id.btnRestart);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    public void onFirstRowButtonClick(View v) {
        Button clickedButton = (Button) v;
        int col = (int) clickedButton.getTag();
        int row = findEmptyRow(col);

        if (row != -1) {
            Button lastEmptyButton = buttons[row][col];
            if (player1Turn) {
                lastEmptyButton.setText("1");
                lastEmptyButton.setBackgroundColor(Color.DKGRAY);
                textViewPlayer.setText(R.string.player2turn);
            } else {
                lastEmptyButton.setText("2");
                lastEmptyButton.setBackgroundColor(Color.MAGENTA);
                textViewPlayer.setText(R.string.player1turn);
            }

            // Check for a win after each move
            if (checkForWin(row, col)) {
                if (player1Turn) {
                    playerWins(1);
                } else {
                    playerWins(2);
                }
            }

            // Toggle player turn
            player1Turn = !player1Turn;
        }
    }

    private int findEmptyRow(int col) {
        for (int i = 4; i >= 0; i--) {
            if (buttons[i][col].getText().toString().isEmpty()) {
                return i;
            }
        }
        return -1; // Column is full
    }

    private boolean checkForWin(int row, int col) {
        String[][] field = new String[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        // Check rows
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals(field[i][j + 1]) &&
                        field[i][j].equals(field[i][j + 2]) &&
                        !field[i][j].equals("")) {
                    return true;
                }
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (field[i][j].equals(field[i + 1][j]) &&
                        field[i][j].equals(field[i + 2][j]) &&
                        !field[i][j].equals("")) {
                    return true;
                }
            }
        }

        // Check diagonals
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals(field[i + 1][j + 1]) &&
                        field[i][j].equals(field[i + 2][j + 2]) &&
                        !field[i][j].equals("")) {
                    return true;
                }

                if (field[i][j + 2].equals(field[i + 1][j + 1]) &&
                        field[i][j + 2].equals(field[i + 2][j]) &&
                        !field[i][j + 2].equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void playerWins(int player) {
        String message;
        if (player == 1) {
            message = getString(R.string.player1wins);
        } else {
            message = getString(R.string.player2wins);
        }
        textViewPlayer.setText(message);
        disableButtons();
    }

    private void resetGame() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setBackgroundColor(Color.parseColor("#00FF5D"));
                buttons[i][j].setEnabled(true);
            }
        }

        player1Turn = true;
        textViewPlayer.setText(R.string.player1turn);
    }

    private void disableButtons() {
        // Disable all buttons
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}
