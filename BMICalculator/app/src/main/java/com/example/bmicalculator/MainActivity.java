package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_ADD_BMI = 1;
    private Button btnBmiActivity;
    private TextView tvHistoryList;
    private ArrayList<BMI> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnBmiActivity = (Button)findViewById(R.id.btn_bmi_activity);
        btnBmiActivity.setOnClickListener(this);

        tvHistoryList = (TextView)findViewById(R.id.tv_history_list);

        displayHistoryList();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_bmi_activity) {
            Intent BmiIntent = new Intent(MainActivity.this, BmiActivity.class);
            startActivityForResult(BmiIntent, REQUEST_CODE_ADD_BMI);
        }
    }

    private void displayHistoryList() {
        StringBuilder builder = new StringBuilder();
        for (BMI bmi : historyList) {
            builder.append("Weight: ").append(bmi.getWeight()).append("\n")
                    .append("Height: ").append(bmi.getHeight()).append("\n")
                    .append("Result: ").append(bmi.getResult()).append("\n")
                    .append("Status: ").append(bmi.getStatus()).append("\n");
        }
        tvHistoryList.setText(builder.toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD_BMI && resultCode == RESULT_OK && data != null) {
            BMI newBmi = data.getParcelableExtra("new_bmi");
            if (newBmi != null) {
                historyList.add(newBmi);
                displayHistoryList();
            }
        }
    }

}