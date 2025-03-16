package com.example.portofolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnRedirectActivity;
    private Button btnProfileActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnRedirectActivity = (Button)findViewById(R.id.btn_redirect_activity);
        btnRedirectActivity.setOnClickListener(this);

        btnProfileActivity = (Button)findViewById(R.id.btn_profile_activity);
        btnProfileActivity.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_redirect_activity) {
            Intent redirectIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.haryc.me"));
            startActivity(redirectIntent);
        }

        if (v.getId() == R.id.btn_profile_activity) {
            Intent profileIntent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(profileIntent);
        }
    }
}