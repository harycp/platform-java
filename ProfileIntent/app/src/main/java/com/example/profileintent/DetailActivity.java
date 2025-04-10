package com.example.profileintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_PROFILE = "extra_profile";

    private TextView tvProfileDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);
        }

        tvProfileDetails = findViewById(R.id.tv_profile_details);
        Profile profile = getIntent().getParcelableExtra(EXTRA_PROFILE);

        String text = "Nama Panggilan : " + profile.getName() + "\n" +
                      "NIM : " + profile.getNim() + "\n" +
                      "Alamat : " + profile.getAddress() + "\n" +
                      "Hobi : " + profile.getHobby() + "\n" +
                      "Ideal : " + profile.getIdeal();

        tvProfileDetails.setText(text);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}