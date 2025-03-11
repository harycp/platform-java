package com.example.layoutgetcontact;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuote;
    private Button btnGenerateQuote;
    private EditText etName;
    private OkHttpClient client = new OkHttpClient();

    private  static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.et_name);
        tvQuote = findViewById(R.id.tv_quote);
        btnGenerateQuote = findViewById(R.id.btn_generate_quote);

        btnGenerateQuote.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();

            if (!name.isEmpty()) {
                fetchRandomQuote(name);
            } else {
                etName.setError(getString(R.string.error_no_name));
                etName.requestFocus();
                Toast.makeText(MainActivity.this, getString(R.string.error_no_name), Toast.LENGTH_SHORT).show();
            }
        });

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvQuote.setText(result);
        }

    }

    private void fetchRandomQuote(String name) {
        String url = "https://official-joke-api.appspot.com/random_joke";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() -> tvQuote.setText(getString(R.string.fetch_failed)));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        String responseData = response.body().string();
                        JSONObject jsonObject = new JSONObject(responseData);
                        String setup = jsonObject.getString("setup");
                        String punchline = jsonObject.getString("punchline");

                        runOnUiThread(() -> {
                            String greeting = String.format(getString(R.string.name_greeting), name);
                            tvQuote.setText(greeting + "\n\n" + setup + "\n" + punchline);
                        });
                    } catch (Exception e) {
                        runOnUiThread(() -> tvQuote.setText(getString(R.string.parse_error)));
                    }
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvQuote.getText().toString());
    }

}
