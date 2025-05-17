package com.example.bookdatabase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import com.example.bookdatabase.R;
import com.example.bookdatabase.db.DbHelper;
import com.example.bookdatabase.model.Book;

public class UpdateActivity extends AppCompatActivity {
    private DbHelper dbHelper;
    private EditText etTitle, etWriter, etPages;
    private Button btnSave;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_update);
        dbHelper = new DbHelper(this);
        etTitle= findViewById(R.id.edt_title);
        etWriter = findViewById(R.id.edt_writer);
        etPages = findViewById(R.id.edt_pages);
        btnSave = findViewById(R.id.btn_submit);
        Intent intent = getIntent();
        book = (Book) intent.getSerializableExtra("user");

        etTitle.setText(book.getTitle());
        etWriter.setText(book.getWriter());
        etPages.setText(String.valueOf(book.getPages()));

        btnSave.setOnClickListener((View v) -> {
            dbHelper.updateUser(book.getId(), etTitle.getText().toString(), etWriter.getText().toString(), Integer.parseInt(etPages.getText().toString()));
            Toast.makeText(UpdateActivity.this, "Updated berhasil!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
