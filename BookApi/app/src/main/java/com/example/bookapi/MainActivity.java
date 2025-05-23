package com.example.bookapi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MyBook myBook;
    BookAdapter bookAdapter;
    RecyclerView rv_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv_book = findViewById(R.id.rv_book);
        myBook = new MyBook(this);

        rv_book.setHasFixedSize(true);
        rv_book.setLayoutManager(new LinearLayoutManager(this));


        bookAdapter = new BookAdapter(myBook);
        rv_book.setAdapter(bookAdapter);

        getDataBook();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getDataBook() {
        myBook.getInstance().getBook().enqueue(new Callback<BookResponse<BookItem>>() {
            @Override
            public void onResponse(Call<BookResponse<BookItem>> call, Response<BookResponse<BookItem>> response) {
                BookResponse<BookItem> resp = response.body();
                if (resp.getResult() != null && resp.getResult().size() > 0){
                    bookAdapter = new BookAdapter(resp.getResult(),MainActivity.this);
                    rv_book.setAdapter(bookAdapter);
                }else {
                    Toast.makeText(MainActivity.this, "Tidak ada data atau respons kosong.", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<BookResponse<BookItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }
}