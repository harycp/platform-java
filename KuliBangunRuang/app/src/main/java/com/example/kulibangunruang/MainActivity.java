package com.example.kulibangunruang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJajarGenjangActivity;
    private Button btnLingkaranActivity;
    private Button btnLimasActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnJajarGenjangActivity = (Button)findViewById(R.id.btn_jajargenjang_activity);
        btnJajarGenjangActivity.setOnClickListener(this);

        btnLingkaranActivity = (Button)findViewById(R.id.btn_lingkaran_activity);
        btnLingkaranActivity.setOnClickListener(this);

        btnLimasActivity = (Button)findViewById(R.id.btn_limas_activity);
        btnLimasActivity.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_jajargenjang_activity) {
            Intent jajarGenjangIntent = new Intent(MainActivity.this, JajarGenjangActivity.class);
            startActivity(jajarGenjangIntent);
        }

        if (v.getId() == R.id.btn_lingkaran_activity) {
            Intent lingkaranIntent = new Intent(MainActivity.this, LingkaranActivity.class);
            startActivity(lingkaranIntent);
        }

        if (v.getId() == R.id.btn_limas_activity) {
            Intent limasIntent = new Intent(MainActivity.this, LimasActivity.class);
            startActivity(limasIntent);
        }
    }
}