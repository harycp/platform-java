package com.example.utspraktikum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView nama;
    private TextView asal;
    private TextView harga;
    private Button btnNextActiviy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Makanan Favorit Saya");
        }

        btnNextActiviy = (Button)findViewById(R.id.btn_nextActivity);
        btnNextActiviy.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Makanan makanan = getIntent().getParcelableExtra("makanan");

        if (makanan != null) {
            nama = findViewById(R.id.fieldNama);
            asal = findViewById(R.id.fieldAsal);
            harga = findViewById(R.id.fieldHarga);

            nama.setText(makanan.getNama());
            asal.setText(makanan.getAsal());
            harga.setText(String.format("Rp. %,d", (int) makanan.getHarga()));
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_nextActivity) {
            ArrayList<Wisata> listWisata = new ArrayList<>();

            Wisata wisata = new Wisata();
            wisata.setNama("Danau Zürich");
            wisata.setLokasi("Swiss, Zürich");
            wisata.setDeskripsi("Danau Zürich bagi saya adalah tempat yang begitu menenangkan dan memesona. Airnya jernih, dikelilingi pegunungan Alpen yang tampak di kejauhan, memberikan suasana damai yang sulit ditemukan di tempat lain. Saya suka berjalan-jalan di sepanjang tepi danau, menikmati udara segar, melihat kapal berlalu-lalang, dan merasakan ketenangan yang alami. ");

            ArrayList<String> keunikan = new ArrayList<>();
            keunikan.add("Dikelilingi Pegunungan Alpen");
            keunikan.add("Tepi Danau yang Ramah Pejalan Kaki");
            keunikan.add("Perahu Kayuh dan Kapal Tenang");

            wisata.setKeunikan(keunikan);

            listWisata.add(wisata);

            Intent moveWithObjectIntent = new Intent(HomeActivity.this, DestinasiWisataActivity.class);
            moveWithObjectIntent.putParcelableArrayListExtra(DestinasiWisataActivity.EXTRA_WISATA, listWisata);
            startActivity(moveWithObjectIntent);
        }
    }
}