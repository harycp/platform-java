package com.example.utspraktikum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DestinasiWisataActivity extends AppCompatActivity {

    public static final String EXTRA_WISATA = "extra_wisata";

    private TextView fieldDeskripsi, fieldNama, fieldLokasi;
    private LinearLayout containerKeunikan;

    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_destinasi_wisata);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Destinasi Wisata Impian");
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnKembali = findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener(v -> {
            Intent backToHome = new Intent(DestinasiWisataActivity.this, HomeActivity.class);
            startActivity(backToHome);
            finish();
        });

        fieldDeskripsi = findViewById(R.id.fieldDeskripsi);
        fieldNama = findViewById(R.id.fieldNama);     // Tambahkan ID di XML
        fieldLokasi = findViewById(R.id.fieldLokasi); // Tambahkan ID di XML
        containerKeunikan = findViewById(R.id.containerKeunikan); // Tambahkan container di XML

        ArrayList<Wisata> wisataList = getIntent().getParcelableArrayListExtra(EXTRA_WISATA);

        if (wisataList != null && !wisataList.isEmpty()) {
            Wisata wisata = wisataList.get(0);

            fieldNama.setText(wisata.getNama());
            fieldLokasi.setText(wisata.getLokasi());
            fieldDeskripsi.setText(wisata.getDeskripsi());

            for (String item : wisata.getKeunikan()) {
                TextView bullet = new TextView(this);
                bullet.setText("• " + item);
                bullet.setTextSize(16);
                bullet.setTextColor(getResources().getColor(android.R.color.black));
                bullet.setPadding(0, 4, 0, 4);
                containerKeunikan.addView(bullet);
            }
        }
    }
}