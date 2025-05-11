package com.example.bmicalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput;
    private EditText heightInput;
    private TextView resultText;
    private double weight = 0.0;
    private double height = 0.0;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private Button chartButton;

    private Button calorieButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        resultText = findViewById(R.id.resultText);
        calorieButton = findViewById(R.id.calorieButton);

        weightInput.addTextChangedListener(bmiTextWatcher);
        heightInput.addTextChangedListener(bmiTextWatcher);

        chartButton = findViewById(R.id.chartButton);
        chartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BmiChartActivity.class);
                startActivity(intent);
            }
        });

        calorieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalorieFormActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculateBMI() {
        String status = BMIcalculator.getBMIStatus(weight, height);
        if (!status.equals("Nieprawidłowe dane")) {
            double heightMeters = height / 100.0;
            double bmi = weight / (heightMeters * heightMeters);
            resultText.setText("BMI: " + decimalFormat.format(bmi) + "\nStatus: " + status);
        } else {
            resultText.setText("");
        }
    }

    private final TextWatcher bmiTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                weight = Double.parseDouble(weightInput.getText().toString());
            } catch (NumberFormatException e) {
                weight = 0.0;
            }

            try {
                height = Double.parseDouble(heightInput.getText().toString());
            } catch (NumberFormatException e) {
                height = 0.0;
            }

            calculateBMI();
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };
}
