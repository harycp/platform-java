package com.example.utspraktikum;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final int waktu_loading = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageView logo = findViewById(R.id.logo);

        ObjectAnimator fadeInLogo = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);
        fadeInLogo.setDuration(500);
        fadeInLogo.setInterpolator(new AccelerateDecelerateInterpolator());
        fadeInLogo.start();

        new Handler().postDelayed(() -> {
            ObjectAnimator fadeOutLogo = ObjectAnimator.ofFloat(logo, "alpha", 1f, 0f);
            fadeOutLogo.setDuration(500);
            fadeOutLogo.setInterpolator(new AccelerateDecelerateInterpolator());
            fadeOutLogo.start();
        }, 4500);

        new Handler().postDelayed(() -> {
            Makanan makanan = new Makanan();
            makanan.setNama("Burgo");
            makanan.setAsal("Palembang");
            makanan.setHarga(25000.0);

            Intent home = new Intent(MainActivity.this, HomeActivity.class);
            home.putExtra("makanan", makanan);
            startActivity(home);
            finish();
        }, waktu_loading);
    }
}