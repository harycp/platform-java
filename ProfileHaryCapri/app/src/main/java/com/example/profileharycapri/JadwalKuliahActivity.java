package com.example.profileharycapri;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JadwalKuliahActivity extends AppCompatActivity {

    public static final String EXTRA_SCHEDULE = "extra_schedule";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jadwal_kuliah);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);
            getSupportActionBar().setTitle("Detail Jadwal Kuliah Semester 6");
        }

        LinearLayout container = findViewById(R.id.container_schedule);
        ArrayList<Schedule> scheduleList = getIntent().getParcelableArrayListExtra(EXTRA_SCHEDULE);

        Map<String, ArrayList<String>> scheduleMap = new HashMap<>();
        String[] days = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};

        for (String day : days) {
            scheduleMap.put(day, new ArrayList<>());
        }

        if (scheduleList != null) {
            for (Schedule schedule : scheduleList) {
                scheduleMap.get(schedule.getDay()).add(schedule.getCourseName());
            }
        }

        for (String day : days) {
            ArrayList<String> courses = scheduleMap.get(day);

            CardView cardView = new CardView(this);
            LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            cardParams.setMargins(0, 0, 0, 24);
            cardView.setLayoutParams(cardParams);
            cardView.setCardElevation(8);
            cardView.setRadius(24);
            cardView.setUseCompatPadding(true);

            LinearLayout innerLayout = new LinearLayout(this);
            innerLayout.setOrientation(LinearLayout.VERTICAL);
            innerLayout.setPadding(32, 32, 32, 32);

            TextView dayTitle = new TextView(this);
            dayTitle.setText(day);
            dayTitle.setTextSize(20);
            dayTitle.setTypeface(Typeface.DEFAULT_BOLD);
            dayTitle.setTextColor(getResources().getColor(android.R.color.black));
            innerLayout.addView(dayTitle);

            TextView courseText = new TextView(this);
            courseText.setTextSize(16);
            courseText.setTextColor(getResources().getColor(android.R.color.darker_gray));

            if (courses == null || courses.isEmpty()) {
                courseText.setText("Kosong / Libur");
            } else {
                StringBuilder courseList = new StringBuilder();
                for (String course : courses) {
                    courseList.append("• ").append(course).append("\n");
                }
                courseText.setText(courseList.toString().trim());
            }

            innerLayout.addView(courseText);
            cardView.addView(innerLayout);
            container.addView(cardView);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
