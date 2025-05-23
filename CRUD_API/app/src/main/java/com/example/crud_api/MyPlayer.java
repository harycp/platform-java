package com.example.crud_api;

import android.content.Context;

public class MyPlayer {

    FootballApi footballApi;

    public MyPlayer(Context context) {
        footballApi = RetrofitBuilder.builder(context)
                .create(FootballApi.class);

    }

    public FootballApi getInstance() {
        return footballApi;
    }
}
