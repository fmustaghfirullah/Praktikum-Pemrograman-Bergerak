package com.example.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvDisplay;
    private String currentNumber = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tvDisplay = findViewById(R.id.tvDisplay);

        // Number buttons
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

        // Operation buttons
        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);
        findViewById(R.id.btnPercent).setOnClickListener(this);

        // Function buttons
        findViewById(R.id.btnEquals).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);
        findViewById(R.id.btnDot).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText = button.getText().toString();

        int id = v.getId();

        if (id == R.id.btn0 || id == R.id.btn1 || id == R.id.btn2 ||
                id == R.id.btn3 || id == R.id.btn4 || id == R.id.btn5 ||
                id == R.id.btn6 || id == R.id.btn7 || id == R.id.btn8 ||
                id == R.id.btn9) {

            if (isNewOperation) {
                currentNumber = "";
                isNewOperation = false;
            }
            currentNumber += buttonText;
            tvDisplay.setText(currentNumber);

        } else if (id == R.id.btnDot) {
            if (!currentNumber.contains(".")) {
                if (currentNumber.isEmpty()) {
                    currentNumber = "0";
                }
                currentNumber += ".";
                tvDisplay.setText(currentNumber);
            }

        } else if (id == R.id.btnClear) {
            currentNumber = "";
            operator = "";
            firstNumber = 0;
            isNewOperation = true;
            tvDisplay.setText("0");

        } else if (id == R.id.btnDelete) {
            if (!currentNumber.isEmpty()) {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                tvDisplay.setText(currentNumber.isEmpty() ? "0" : currentNumber);
            }

        } else if (id == R.id.btnPlus || id == R.id.btnMinus ||
                id == R.id.btnMultiply || id == R.id.btnDivide) {

            if (!currentNumber.isEmpty()) {
                if (!operator.isEmpty()) {
                    calculateResult();
                } else {
                    firstNumber = Double.parseDouble(currentNumber);
                }
                operator = buttonText;
                isNewOperation = true;
            }

        } else if (id == R.id.btnPercent) {
            if (!currentNumber.isEmpty()) {
                double value = Double.parseDouble(currentNumber);
                value = value / 100;
                currentNumber = formatResult(value);
                tvDisplay.setText(currentNumber);
            }

        } else if (id == R.id.btnEquals) {
            calculateResult();
        }
    }

    private void calculateResult() {
        if (!currentNumber.isEmpty() && !operator.isEmpty()) {
            double secondNumber = Double.parseDouble(currentNumber);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "×":
                    result = firstNumber * secondNumber;
                    break;
                case "÷":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        tvDisplay.setText("Error");
                        currentNumber = "";
                        operator = "";
                        return;
                    }
                    break;
            }

            currentNumber = formatResult(result);
            tvDisplay.setText(currentNumber);
            firstNumber = result;
            operator = "";
            isNewOperation = true;
        }
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.format("%.8f", result).replaceAll("0*$", "").replaceAll("\\.$", "");
        }
    }
}