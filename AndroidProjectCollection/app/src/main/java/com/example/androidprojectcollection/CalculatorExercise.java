package com.example.androidprojectcollection;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class CalculatorExercise extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);
        initButtons();
        textResult = findViewById(R.id.result_tv);
        equationString = findViewById(R.id.solution_tv);
        setButtonOnClicks();
    }
    private Button btnEquate;
    private Button btnAdd;
    private Button btnMultiply;
    private Button btnMinus;
    private Button btnDivide;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnDecimal;
    private TextView textResult;
    private TextView equationString;
    private boolean hasDecimal;
    public Calculator calculator = new Calculator();

    private void initButtons() {
        btnDivide = findViewById(R.id.button_div);
        btnAdd = findViewById(R.id.button_plus);
        btnMinus = findViewById(R.id.button_min);
        btnMultiply = findViewById(R.id.button_multi);
        btnDecimal = findViewById(R.id.button_decimal);
        btnEquate = findViewById(R.id.button_equal);
        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);
    }
    private void setButtonOnClicks() {
        btnDivide.setOnClickListener(v -> opChecker("/"));
        btnMinus.setOnClickListener(v -> opChecker("-"));
        btnAdd.setOnClickListener(v -> opChecker("+"));
        btnMultiply.setOnClickListener(v -> opChecker("*"));
        btnDecimal.setOnClickListener(v -> {
            if(!hasDecimal) {
                textResult.append(".");
                hasDecimal = true;
            } else {
                Context context = getApplicationContext();
                String invalidFormat = "Invalid format.";
                Toast toast = Toast.makeText(context, invalidFormat, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        btn0.setOnClickListener(v -> equationString.append("0"));
        btn1.setOnClickListener(v -> equationString.append("1"));
        btn2.setOnClickListener(v -> equationString.append("2"));
        btn3.setOnClickListener(v -> equationString.append("3"));
        btn4.setOnClickListener(v -> equationString.append("4"));
        btn5.setOnClickListener(v -> equationString.append("5"));
        btn6.setOnClickListener(v -> equationString.append("6"));
        btn7.setOnClickListener(v -> equationString.append("7"));
        btn8.setOnClickListener(v -> equationString.append("8"));
        btn9.setOnClickListener(v -> equationString.append("9"));

        btnEquate.setOnClickListener(v -> {
            String evaluate = String.valueOf(equationString.getText());
            String last = evaluate.substring(evaluate.length() - 1);

            if(last.equals("/") || last.equals("+") || last.equals("-") || last.equals("*")) {
                Context context = getApplicationContext();
                String invalidFormat = "Invalid format.";
                Toast toast = Toast.makeText(context, invalidFormat, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                textResult.setText(calculator.calculate(evaluate, true));
            }
        });
    }
    private void opChecker(String op) {
        String temp =  String.valueOf(equationString.getText());
        StringBuilder sb = new StringBuilder();
        if(temp.isEmpty()) {
            return;
        }
        String last = temp.substring(temp.length() - 1);
        if(last.equals("/") || last.equals("+") || last.equals("*") || last.equals("-")) {
            temp = temp.substring(0, temp.length() - 1);
        } else {
            hasDecimal = false;
        }
        sb.append(temp);
        sb.append(op);
        equationString.setText(sb);
        textResult.setText(calculator.calculate(temp, false));
    }
}