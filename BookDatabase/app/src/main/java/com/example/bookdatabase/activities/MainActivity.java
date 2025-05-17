package com.example.bookdatabase.activities;

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

import com.example.bookdatabase.R;
import com.example.bookdatabase.db.DbHelper;

public class MainActivity extends AppCompatActivity {
    DbHelper dbHelper;
    private EditText etTitle, etWriter, etPages;
    private Button btnSave, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
        etTitle = findViewById(R.id.edt_title);
        etWriter = findViewById(R.id.edt_writer);
        etPages = findViewById(R.id.edt_pages);
        btnSave = findViewById(R.id.btn_submit);
        btnList = findViewById(R.id.btn_list);

        btnSave.setOnClickListener(v -> {
            String title = etTitle.getText().toString().trim();
            String writer = etWriter.getText().toString().trim();
            String pagesStr = etPages.getText().toString().trim();

            if (title.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Title harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (writer.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Writer harus diisi!", Toast.LENGTH_SHORT).show();
            } else if (pagesStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Error: Pages harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    int pages = Integer.parseInt(pagesStr);
                    dbHelper.addUserDetail(title, writer, pages);
                    etTitle.setText("");
                    etWriter.setText("");
                    etPages.setText("");
                    Toast.makeText(MainActivity.this, "Simpan berhasil!", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Pages harus berupa angka!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListBooksActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}