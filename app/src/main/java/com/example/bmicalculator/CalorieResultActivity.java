package com.example.bmicalculator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.text.NumberFormat;

public class CalorieResultActivity extends AppCompatActivity {

    private TextView resultTextView, recipeContent;
    private Button backToFormButton;

    private Button shoppingListButton;
    private double weight, height;
    private int age;
    private final NumberFormat numberFormat = NumberFormat.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_result);

        resultTextView = findViewById(R.id.calorieResultText);
        recipeContent = findViewById(R.id.recipeContent);
        backToFormButton = findViewById(R.id.backToFormButton);

        weight = Double.parseDouble(getIntent().getStringExtra("weight"));
        height = Double.parseDouble(getIntent().getStringExtra("height"));
        age = Integer.parseInt(getIntent().getStringExtra("age"));

        calculate();

        backToFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalorieResultActivity.this, CalorieFormActivity.class);
                startActivity(intent);
            }
        });
        shoppingListButton = findViewById(R.id.shoppingListButton);
        shoppingListButton.setOnClickListener(v -> {
            Intent intent = new Intent(CalorieResultActivity.this, ShoppingListActivity.class);
            startActivity(intent);
        });
    }

    private void calculate() {
        double bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        double tdee = bmr * 1.55;

        resultTextView.setText("Twoje dzienne zapotrzebowanie kaloryczne: "
                + numberFormat.format(tdee) + " kcal");

        String recipe;
        if (tdee < 2000) {
            recipe = "\u2022 Sałatka z kurczakiem i warzywami\nSkładniki: pierś z kurczaka, mix sałat, pomidor, ogórek, oliwa z oliwek.\n\nKaloryczność: ok. 450 kcal.";
        } else {
            recipe = "\u2022 Makaron pełnoziarnisty z sosem pomidorowym\nSkładniki: makaron, pomidory, cebula, czosnek, oliwa, bazylia.\n\nKaloryczność: ok. 600 kcal.";
        }

        recipeContent.setText(recipe);
    }
}
