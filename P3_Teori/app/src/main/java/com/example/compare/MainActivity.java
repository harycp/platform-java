package com.example.compare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView tvCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Hary Capri");
        }

        tvCounter = findViewById(R.id.tvCounter);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);

        btnPlus.setOnClickListener(v -> {
            counter++;
            tvCounter.setText(String.valueOf(counter));
        });

        btnMinus.setOnClickListener(v -> {
            counter--;
            tvCounter.setText(String.valueOf(counter));
        });
    }
}
