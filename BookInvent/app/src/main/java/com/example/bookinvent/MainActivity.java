package com.example.bookinvent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_ADD_BOOK = 1;
    private Button btnAddBookActivity;
    private TextView tvBookList;
    private ArrayList<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnAddBookActivity = (Button)findViewById(R.id.btn_add_book_data_activitty);
        btnAddBookActivity.setOnClickListener(this);

        tvBookList = (TextView)findViewById(R.id.tv_book_list);

        displayBookList();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_add_book_data_activitty) {
            Intent BookIntent = new Intent(MainActivity.this, BookActivity.class);
            startActivityForResult(BookIntent, REQUEST_CODE_ADD_BOOK);
        }
    }

    private void displayBookList() {
        StringBuilder builder = new StringBuilder();
        for (Book book : bookList) {
            builder.append("Title: ").append(book.getTitle()).append("\n")
                    .append("Author: ").append(book.getAuthor()).append("\n")
                    .append("Genre: ").append(book.getGenre()).append("\n")
                    .append("Pages: ").append(book.getPages()).append("\n")
                    .append("ISBN: ").append(book.getIsbn()).append("\n\n");
        }
        tvBookList.setText(builder.toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD_BOOK && resultCode == RESULT_OK && data != null) {
            Book newBook = data.getParcelableExtra("new_book");
            if (newBook != null) {
                bookList.add(newBook);
                displayBookList();
            }
        }
    }

}