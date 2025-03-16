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

public class LingkaranActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputJari;
    private Button btnHitungLingkaran;
    private TextView txtHasilLingkaran;

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        // Inisialisasi UI
        inputJari = findViewById(R.id.inputJari);
        btnHitungLingkaran = findViewById(R.id.btnHitungLingkaran);
        txtHasilLingkaran = findViewById(R.id.txtHasilLingkaran);

        // Event klik tombol hitung
        btnHitungLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasLingkaran();
            }
        });
    }

    private void hitungLuasLingkaran() {
        String jariStr = inputJari.getText().toString().trim();

        inputJari.setBackgroundColor(Color.WHITE);

        if (jariStr.isEmpty()) {
            inputJari.setError("Jari-jari tidak boleh kosong!");
            inputJari.setBackgroundColor(Color.parseColor("#FFCDD2")); // Merah muda
            Toast.makeText(this, "Mohon isi semua bidang!", Toast.LENGTH_SHORT).show();
            return;
        }

        float jari = Float.parseFloat(jariStr);

        float luas = (float) (Math.PI * jari * jari);

        txtHasilLingkaran.setText("Hasil: " + luas);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btnBack) {
            Intent mainIntent = new Intent(LingkaranActivity.this, MainActivity.class);
            startActivity(mainIntent);
        }
    }
}
