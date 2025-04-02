package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CalorieFormActivity extends AppCompatActivity {

    private EditText weightInput, heightInput, ageInput;
    private Button calculateButton, bmiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_form);

        weightInput = findViewById(R.id.calorieWeightInput);
        heightInput = findViewById(R.id.calorieHeightInput);
        ageInput = findViewById(R.id.calorieAgeInput);
        calculateButton = findViewById(R.id.calculateCaloriesButton);
        bmiButton = findViewById(R.id.bmiButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = weightInput.getText().toString();
                String height = heightInput.getText().toString();
                String age = ageInput.getText().toString();

                if (!weight.isEmpty() && !height.isEmpty() && !age.isEmpty()) {
                    Intent intent = new Intent(CalorieFormActivity.this, CalorieResultActivity.class);
                    intent.putExtra("weight", weight);
                    intent.putExtra("height", height);
                    intent.putExtra("age", age);
                    startActivity(intent);
                }
            }
        });

        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalorieFormActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
