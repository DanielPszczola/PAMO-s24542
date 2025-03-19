package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weightInput = findViewById(R.id.weightInput);
        EditText heightInput = findViewById(R.id.heightInput);
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView resultText = findViewById(R.id.resultText);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightStr = weightInput.getText().toString();
                String heightStr = heightInput.getText().toString();

                if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                    double weight = Double.parseDouble(weightStr);
                    double height = Double.parseDouble(heightStr) / 100;
                    double bmi = weight / (height * height);

                    String status;
                    if (bmi < 18.5) {
                        status = "Niedowaga";
                    } else if (bmi < 25) {
                        status = "Optimum";
                    } else if (bmi < 30) {
                        status = "Nadwaga";
                    } else {
                        status = "Otyłość";
                    }

                    resultText.setText(String.format("BMI: %.2f\nStatus: %s", bmi, status));
                }
            }
        });
    }
}
