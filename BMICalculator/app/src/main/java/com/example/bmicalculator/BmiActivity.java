package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BmiActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etWeight, etHeight;
    private Button btnCalculate;
    private TextView teResult;
    private ArrayList<BMI> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);

        etWeight = findViewById(R.id.et_weight);
        etHeight = findViewById(R.id.et_height);
        teResult = findViewById(R.id.te_result);

        btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            if (etWeight.getText().toString().isEmpty() || etHeight.getText().toString().isEmpty()) {
                Toast.makeText(this, "Masukkan berat dan tinggi badan!", Toast.LENGTH_SHORT).show();
                return;
            }

            double weight = Double.parseDouble(etWeight.getText().toString());
            double height = Double.parseDouble(etHeight.getText().toString());


            if (height == 0) {
                Toast.makeText(this, "Tinggi tidak boleh 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            double result = weight / ((height / 100) * (height / 100));

            String status;
            if (result < 18.5) {
                status = "Kurus (Underweight)";
            } else if (result >= 18.5 && result < 25) {
                status = "Normal";
            } else if (result >= 25 && result < 30) {
                status = "Gemuk (Overweight)";
            } else {
                status = "Obesitas (Obese)";
            }

            BMI newBmi = new BMI(weight, height, result, status);
            historyList.add(newBmi);

            teResult.setText(String.format("BMI Anda: %.2f\nStatus: %s", result, status));

            Intent resultIntent = new Intent();
            resultIntent.putExtra("new_bmi", newBmi);
            setResult(RESULT_OK, resultIntent);
        }
    }
}
