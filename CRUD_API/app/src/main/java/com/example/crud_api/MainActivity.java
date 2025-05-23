package com.example.crud_api;

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

    MyPlayer myPlayer;
    PlayerAdapter playerAdapter;
    RecyclerView rv_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rv_player = findViewById(R.id.rv_player);
        myPlayer = new MyPlayer(this);

        rv_player.setHasFixedSize(true);
        rv_player.setLayoutManager(new LinearLayoutManager(this));


        playerAdapter = new PlayerAdapter(myPlayer);
        rv_player.setAdapter(playerAdapter);

        getDataPlayer();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getDataPlayer() {
        myPlayer.getInstance().getPlayer().enqueue(new Callback<PlayerResponse<PlayerItem>>() {
            @Override
            public void onResponse(Call<PlayerResponse<PlayerItem>> call, Response<PlayerResponse<PlayerItem>> response) {
                PlayerResponse<PlayerItem> resp = response.body();
                if (resp.getResult() != null && resp.getResult().size() > 0){
                    playerAdapter = new PlayerAdapter(resp.getResult(),MainActivity.this);
                    rv_player.setAdapter(playerAdapter);
                }else {
                    Toast.makeText(MainActivity.this, "Tidak ada data atau respons kosong.", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<PlayerResponse<PlayerItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }

}