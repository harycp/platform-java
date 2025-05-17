package com.example.ourgroups.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ourgroups.R;
import com.example.ourgroups.db.DbHelper;

public class MainActivity extends AppCompatActivity {
    DbHelper dbHelper;
    private EditText etName, etNim, etEmail, etKelompok, etAplikasi;
    private Button btnSave, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        etName = findViewById(R.id.edt_name);
        etNim = findViewById(R.id.edt_nim);
        etEmail = findViewById(R.id.edt_email);
        etKelompok = findViewById(R.id.edt_kelompok);
        etAplikasi = findViewById(R.id.edt_aplikasi);
        btnSave = findViewById(R.id.btn_submit);
        btnList = findViewById(R.id.btn_list);

        btnSave.setOnClickListener(v -> {
            if (etNim.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Nim harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (etName.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Nama harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.addUserDetail(etName.getText().toString(), etNim.getText().toString(), etEmail.getText().toString(), etKelompok.getText().toString(), etAplikasi.getText().toString());
                etName.setText("");
                etNim.setText("");
                Toast.makeText(MainActivity.this, "Simpan berhasil!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListGroupsActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}