package com.androidcodr.fibbonaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTerm;
    private TextView textViewResult;
    private FibonacciService fibonacciService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTerm = findViewById(R.id.editTextTerm);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        fibonacciService = new FibonacciService();

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtine termenul introdus de utilizator
                String termStr = editTextTerm.getText().toString();
                if (!termStr.isEmpty()) {
                    int term = Integer.parseInt(termStr);

                    // Calculeaza termenul din seria Fibonacci folosind serviciul
                    fibonacciService.calculateFibonacci(term, new FibonacciService.OnFibonacciCalculated() {
                        @Override
                        public void onResult(int result) {
                            // Actualizeaza UI-ul cu rezultatul primit
                            textViewResult.setText("Termenul " + term + " din seria Fibonacci este: " + result);
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Introdu un numar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
