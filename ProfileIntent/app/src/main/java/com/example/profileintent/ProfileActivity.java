package com.example.profileintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    public static String EXTRA_PROFILE = "extra_profile";
    private TextView tvObject;

    private EditText etName, etNim, etAddress, etHobby, etIdeal;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);
        }

        tvObject = (TextView)findViewById(R.id.tv_object_received);
        Profile mProfile = getIntent().getParcelableExtra(EXTRA_PROFILE);
        String text = "Nama lengkap : " + mProfile.getFullName();

        tvObject.setText(text);

        etName = (EditText)findViewById(R.id.et_name);
        etNim = (EditText)findViewById(R.id.et_nim);
        etAddress = (EditText)findViewById(R.id.et_address);
        etHobby = (EditText)findViewById(R.id.et_hobby);
        etIdeal = (EditText)findViewById(R.id.et_ideal);

        btnSubmit = (Button)findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btn_submit) {
            String name = etName.getText().toString();
            long nim = Long.parseLong(etNim.getText().toString());
            String address = etAddress.getText().toString();
            String hobby = etHobby.getText().toString();
            String ideal = etIdeal.getText().toString();

            Profile profile = new Profile();
            profile.setName(name);
            profile.setNim(nim);
            profile.setAddress(address);
            profile.setHobby(hobby);
            profile.setIdeal(ideal);

            Intent intent = new Intent(ProfileActivity.this, DetailActivity.class);
            intent.putExtra(EXTRA_PROFILE, profile);
            startActivity(intent);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}