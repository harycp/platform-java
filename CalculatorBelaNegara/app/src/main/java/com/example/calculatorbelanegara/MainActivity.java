package com.example.calculatorbelanegara;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private  static final String STATE_RESULT = "state_result";

    // Operator Konstanta
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';

    // Variabel untuk Kalkulasi
    private char currentOperator;
    private double firstValue = Double.NaN;
    private double secondValue;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Format desimal
        decimalFormat = new DecimalFormat("#.##########");

        // Inisialisasi TextView
        inputDisplay = findViewById(R.id.input);
        outputDisplay = findViewById(R.id.output);

        // Tombol angka (0-9)
        int[] numberButtons = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int i = 0; i < numberButtons.length; i++) {
            final int number = i;
            findViewById(numberButtons[i]).setOnClickListener(view -> appendNumber(number));
        }

        // Tombol titik desimal
        findViewById(R.id.btnPoint).setOnClickListener(view -> {
            if (!inputDisplay.getText().toString().contains(".")) {
                inputDisplay.append(".");
            }
        });

        // Tombol operasi matematika
        findViewById(R.id.add).setOnClickListener(view -> performOperation(ADDITION, "+"));
        findViewById(R.id.subtract).setOnClickListener(view -> performOperation(SUBTRACTION, "-"));
        findViewById(R.id.multiply).setOnClickListener(view -> performOperation(MULTIPLICATION, "x"));
        findViewById(R.id.division).setOnClickListener(view -> performOperation(DIVISION, "/"));
        findViewById(R.id.percent).setOnClickListener(view -> performOperation(PERCENT, "%"));

        // Tombol Clear
        findViewById(R.id.clear).setOnClickListener(view -> clearDisplay());

        // Tombol OFF (Keluar dari aplikasi)
        findViewById(R.id.off).setOnClickListener(view -> finish());

        // Tombol sama dengan (=)
        findViewById(R.id.equal).setOnClickListener(view -> {
            calculateResult();
            outputDisplay.setText(decimalFormat.format(firstValue));
            firstValue = Double.NaN;
            currentOperator = '0';
        });

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            inputDisplay.setText(result);
            outputDisplay.setText(result);
        }
    }

    // Menambahkan angka ke input
    private void appendNumber(int number) {
        inputDisplay.append(String.valueOf(number));
    }

    // Menjalankan operasi matematika
    private void performOperation(char operation, String symbol) {
        calculateResult();
        currentOperator = operation;
        outputDisplay.setText(decimalFormat.format(firstValue) + symbol);
        inputDisplay.setText(null);
    }

    // Melakukan perhitungan
    private void calculateResult() {
        if (!Double.isNaN(firstValue)) {
            if (!inputDisplay.getText().toString().isEmpty()) {
                secondValue = Double.parseDouble(inputDisplay.getText().toString());
                inputDisplay.setText(null);

                switch (currentOperator) {
                    case ADDITION:
                        firstValue += secondValue;
                        break;
                    case SUBTRACTION:
                        firstValue -= secondValue;
                        break;
                    case MULTIPLICATION:
                        firstValue *= secondValue;
                        break;
                    case DIVISION:
                        firstValue /= secondValue;
                        break;
                    case PERCENT:
                        firstValue %= secondValue;
                        break;
                }
            }
        } else {
            try {
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            } catch (Exception ignored) {
            }
        }
    }

    // Menghapus tampilan input/output
    private void clearDisplay() {
        if (inputDisplay.getText().length() > 0) {
            CharSequence currentText = inputDisplay.getText();
            inputDisplay.setText(currentText.subSequence(0, currentText.length() - 1));
        } else {
            firstValue = Double.NaN;
            secondValue = Double.NaN;
            inputDisplay.setText("");
            outputDisplay.setText("");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, inputDisplay.getText().toString());
        outState.putString(STATE_RESULT, outputDisplay.getText().toString());
    }
}
