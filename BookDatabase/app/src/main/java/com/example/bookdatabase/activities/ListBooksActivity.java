package com.example.bookdatabase.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookdatabase.R;
import com.example.bookdatabase.adapter.BookAdapter;
import com.example.bookdatabase.db.DbHelper;
import com.example.bookdatabase.model.Book;

import java.util.ArrayList;

public class ListBooksActivity extends AppCompatActivity {
    private BookAdapter adapter;
    private ArrayList<Book> booksArrayList;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        RecyclerView recyclerView = findViewById(R.id.rview);
        adapter = new BookAdapter(this);

        dbHelper = new DbHelper(this);
        booksArrayList = dbHelper.getAllUsers();
        adapter.setListBooks(booksArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListBooksActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.list_groups), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();
        booksArrayList = dbHelper.getAllUsers();
        adapter.setListBooks(booksArrayList);
        adapter.notifyDataSetChanged();
    }
}
