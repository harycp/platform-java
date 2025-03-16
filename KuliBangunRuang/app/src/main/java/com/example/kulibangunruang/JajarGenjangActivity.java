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

public class JajarGenjangActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputAlas, inputTinggi;
    private Button btnHitung;
    private TextView txtHasil;

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jajar_genjang);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        inputAlas = findViewById(R.id.inputAlas);
        inputTinggi = findViewById(R.id.inputTinggi);
        btnHitung = findViewById(R.id.btnHitung);
        txtHasil = findViewById(R.id.txtHasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuas();
            }
        });
    }

    private void hitungLuas() {
        String alasStr = inputAlas.getText().toString().trim();
        String tinggiStr = inputTinggi.getText().toString().trim();

        boolean isValid = true;

        inputAlas.setBackgroundColor(Color.WHITE);
        inputTinggi.setBackgroundColor(Color.WHITE);

        if (alasStr.isEmpty()) {
            inputAlas.setError("Alas tidak boleh kosong!");
            inputAlas.setBackgroundColor(Color.parseColor("#FFCDD2")); // Merah muda
            isValid = false;
        }

        if (tinggiStr.isEmpty()) {
            inputTinggi.setError("Tinggi tidak boleh kosong!");
            inputTinggi.setBackgroundColor(Color.parseColor("#FFCDD2")); // Merah muda
            isValid = false;
        }

        if (!isValid) {
            Toast.makeText(this, "Mohon isi semua bidang!", Toast.LENGTH_SHORT).show();
            return;
        }

        float alas = Float.parseFloat(alasStr);
        float tinggi = Float.parseFloat(tinggiStr);

        float luas = alas * tinggi;

        txtHasil.setText("Hasil: " + luas);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btnBack) {
            Intent mainIntent = new Intent(JajarGenjangActivity.this, MainActivity.class);
            startActivity(mainIntent);
        }
    }
}
