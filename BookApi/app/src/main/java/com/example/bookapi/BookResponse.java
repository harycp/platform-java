package com.example.bookapi;

import java.util.List;

public class BookResponse<T> {
    List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
