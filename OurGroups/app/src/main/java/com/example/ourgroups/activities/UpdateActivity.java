package com.example.ourgroups.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ourgroups.R;
import com.example.ourgroups.db.DbHelper;
import com.example.ourgroups.model.Group;

public class UpdateActivity extends AppCompatActivity {
    private DbHelper dbHelper;
    private EditText etName, etNim, etEmail, etKelompok, etAplikasi;
    private Button btnSave;
    private Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbHelper = new DbHelper(this);
        etName = findViewById(R.id.edt_name);
        etNim = findViewById(R.id.edt_nim);
        etEmail = findViewById(R.id.edt_email);
        etKelompok = findViewById(R.id.edt_kelompok);
        etAplikasi = findViewById(R.id.edt_aplikasi);
        btnSave = findViewById(R.id.btn_submit);
        Intent intent = getIntent();
        group = (Group) intent.getSerializableExtra("user");

        etName.setText(group.getName());
        etNim.setText(group.getNim());
        etEmail.setText(group.getEmail());
        etKelompok.setText(group.getKelompok());
        etAplikasi.setText(group.getAplikasi());

        btnSave.setOnClickListener((View v) -> {
            dbHelper.updateUser(group.getId(), etName.getText().toString(), etNim.getText().toString(), etEmail.getText().toString(), etKelompok.getText().toString(), etAplikasi.getText().toString());
            Toast.makeText(UpdateActivity.this, "Updated berhasil!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
