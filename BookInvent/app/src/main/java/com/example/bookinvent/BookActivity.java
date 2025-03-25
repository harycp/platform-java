package com.example.bookinvent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etTitle, etAuthor, etGenre, etPages, etIsbn;
    private Button btnSubmit;
    private static ArrayList<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book);

        etTitle = findViewById(R.id.et_title);
        etAuthor = findViewById(R.id.et_author);
        etGenre = findViewById(R.id.et_genre);
        etPages = findViewById(R.id.et_pages);
        etIsbn = findViewById(R.id.et_isbn);
        btnSubmit = (Button)findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_submit) {
            String title = etTitle.getText().toString();
            String author = etAuthor.getText().toString();
            String genre = etGenre.getText().toString();
            int pages = Integer.parseInt(etPages.getText().toString());
            String isbn = etIsbn.getText().toString();

            Book newBook = new Book(title, author, genre, pages, isbn);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("new_book", newBook);
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
}