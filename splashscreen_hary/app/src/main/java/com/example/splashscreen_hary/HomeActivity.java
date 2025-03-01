package com.example.splashscreen_hary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView tvClickMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvClickMessage = findViewById(R.id.tv_click_message);
        Button btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(v -> {
            tvClickMessage.setVisibility(View.VISIBLE);
        });
    }
}
