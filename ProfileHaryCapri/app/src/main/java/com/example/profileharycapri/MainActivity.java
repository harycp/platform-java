package com.example.profileharycapri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Profile Hary Capri");
        }

        btnNextActivity = (Button)findViewById(R.id.btn_nextActivity);
        btnNextActivity.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id .main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_nextActivity) {
            ArrayList<Schedule> scheduleList = new ArrayList<>();
            scheduleList.add(new Schedule("Bahasa Inggris", "Senin"));
            scheduleList.add(new Schedule("Deep Learning", "Senin"));
            scheduleList.add(new Schedule("Teori Bahasa dan Automata", "Selasa"));
            scheduleList.add(new Schedule("Komputasi Paralel dan Terdistribusi", "Selasa"));
            scheduleList.add(new Schedule("Pengembangan Perangkat Lunak Berorientasi Service", "Selasa"));
            scheduleList.add(new Schedule("Pembelajaran Mesin", "Selasa"));
            scheduleList.add(new Schedule("Analisis dan Desain Perangkat Lunak", "Kamis"));
            scheduleList.add(new Schedule("Pemrograman Berbasis Platform", "Jumat"));
            scheduleList.add(new Schedule("Praktikum Pemrograman Berbasis Platform", "Jumat"));

            Intent moveWithObjectIntent = new Intent(MainActivity.this, JadwalKuliahActivity.class);
            moveWithObjectIntent.putParcelableArrayListExtra(JadwalKuliahActivity.EXTRA_SCHEDULE, scheduleList);
            startActivity(moveWithObjectIntent);
        }
    }

}