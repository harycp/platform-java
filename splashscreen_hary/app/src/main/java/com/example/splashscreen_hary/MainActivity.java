package com.example.splashscreen_hary;

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
    private final int waktu_loading = 11000;
    private TextView tvHaryc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = findViewById(R.id.logo);
        tvHaryc = findViewById(R.id.tv_haryc);

        String fullText = "haryc_";
        SpannableString spannableString = new SpannableString(fullText);
        spannableString.setSpan(new ForegroundColorSpan(Color.GRAY), 0, fullText.length() - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.GREEN), fullText.length() - 1, fullText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvHaryc.setText(spannableString);

        ObjectAnimator fadeInLogo = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);
        ObjectAnimator fadeInText = ObjectAnimator.ofFloat(tvHaryc, "alpha", 0f, 1f);

        fadeInLogo.setDuration(3000);
        fadeInText.setDuration(3000);

        fadeInLogo.setInterpolator(new AccelerateDecelerateInterpolator());
        fadeInText.setInterpolator(new AccelerateDecelerateInterpolator());

        fadeInLogo.start();
        fadeInText.start();

        new Handler().postDelayed(() -> {
            ObjectAnimator fadeOutLogo = ObjectAnimator.ofFloat(logo, "alpha", 1f, 0f);
            ObjectAnimator fadeOutText = ObjectAnimator.ofFloat(tvHaryc, "alpha", 1f, 0f);

            fadeOutLogo.setDuration(2000);
            fadeOutText.setDuration(2000);

            fadeOutLogo.setInterpolator(new AccelerateDecelerateInterpolator());
            fadeOutText.setInterpolator(new AccelerateDecelerateInterpolator());

            fadeOutLogo.start();
            fadeOutText.start();
        }, 8000);

        new Handler().postDelayed(() -> {
            Intent home = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(home);
            finish();
        }, waktu_loading);
    }
}
