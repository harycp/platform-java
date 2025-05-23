package com.example.crud_api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FootballApi {

    @GET("players.json")
    Call<PlayerResponse<PlayerItem>> getPlayer();
}
