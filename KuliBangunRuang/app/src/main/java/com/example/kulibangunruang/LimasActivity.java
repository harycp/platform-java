package com.example.kulibangunruang;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LimasActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputLuasAlas, inputTinggiLimas;
    private Button btnHitungLimas;
    private TextView txtHasilLimas;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limas);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        inputLuasAlas = findViewById(R.id.inputLuasAlas);
        inputTinggiLimas = findViewById(R.id.inputTinggiLimas);
        btnHitungLimas = findViewById(R.id.btnHitungLimas);
        txtHasilLimas = findViewById(R.id.txtHasilLimas);

        btnHitungLimas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungVolumeLimas();
            }
        });
    }

    private void hitungVolumeLimas() {
        String luasAlasStr = inputLuasAlas.getText().toString().trim();
        String tinggiStr = inputTinggiLimas.getText().toString().trim();

        inputLuasAlas.setBackgroundColor(Color.WHITE);
        inputTinggiLimas.setBackgroundColor(Color.WHITE);

        boolean isValid = true;

        if (luasAlasStr.isEmpty()) {
            inputLuasAlas.setError("Luas alas tidak boleh kosong!");
            inputLuasAlas.setBackgroundColor(Color.parseColor("#FFCDD2")); // Merah muda
            isValid = false;
        }

        if (tinggiStr.isEmpty()) {
            inputTinggiLimas.setError("Tinggi limas tidak boleh kosong!");
            inputTinggiLimas.setBackgroundColor(Color.parseColor("#FFCDD2")); // Merah muda
            isValid = false;
        }

        if (!isValid) {
            Toast.makeText(this, "Mohon isi semua bidang!", Toast.LENGTH_SHORT).show();
            return;
        }

        float luasAlas = Float.parseFloat(luasAlasStr);
        float tinggi = Float.parseFloat(tinggiStr);

        float volume = (1f / 3f) * luasAlas * tinggi;

        txtHasilLimas.setText("Hasil: " + volume);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btnBack) {
            Intent mainIntent = new Intent(LimasActivity.this, MainActivity.class);
            startActivity(mainIntent);
        }
    }
}
