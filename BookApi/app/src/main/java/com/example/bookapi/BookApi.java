package com.example.bookapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookApi {
    @GET("/")
    Call<BookResponse<BookItem>> getBook();
}
