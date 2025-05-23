package com.example.bookapi;

import android.content.Context;

public class MyBook {
    BookApi bookApi;

    public MyBook(Context context) {
        bookApi = RetrofitBuilder.builder(context).create(BookApi.class);
    }

    public BookApi getInstance() {
        return bookApi;
    }
}
