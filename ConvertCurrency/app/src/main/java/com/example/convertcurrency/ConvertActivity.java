package com.example.convertcurrency;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class ConvertActivity extends AppCompatActivity {

    private EditText amountInput;
    private Spinner fromCurrency, toCurrency;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        amountInput = findViewById(R.id.amount_input);
        fromCurrency = findViewById(R.id.from_currency);
        toCurrency = findViewById(R.id.to_currency);
        convertButton = findViewById(R.id.convert_button);
        resultText = findViewById(R.id.result_text);

        // Mengisi Spinner dari strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.currency_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromCurrency.setAdapter(adapter);
        toCurrency.setAdapter(adapter);

        convertButton.setOnClickListener(v -> convertCurrency());
    }

    private void convertCurrency() {
        String from = fromCurrency.getSelectedItem().toString();
        String to = toCurrency.getSelectedItem().toString();
        String amountStr = amountInput.getText().toString().trim();

        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Masukkan jumlah uang", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Format jumlah tidak valid", Toast.LENGTH_SHORT).show();
            return;
        }

        // Hardcoded exchange rates (misalnya dari USD)
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("EUR", 0.91);
        rates.put("IDR", 15432.5);
        rates.put("JPY", 132.1);
        rates.put("GBP", 0.78);
        rates.put("AUD", 1.52);
        rates.put("CAD", 1.34);
        rates.put("CHF", 0.92);
        rates.put("CNY", 7.14);
        rates.put("SGD", 1.36);

        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            Toast.makeText(this, "Mata uang tidak ditemukan", Toast.LENGTH_SHORT).show();
            return;
        }

        // Konversi dari mata uang asal ke USD dulu, lalu ke mata uang tujuan
        double amountInUSD = amount / rates.get(from);
        double convertedAmount = amountInUSD * rates.get(to);

        resultText.setText(String.format("%.2f %s", convertedAmount, to));
    }
}
