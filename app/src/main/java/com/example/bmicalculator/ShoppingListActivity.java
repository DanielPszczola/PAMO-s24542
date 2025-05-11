package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListActivity extends AppCompatActivity {

    private RecyclerView shoppingRecyclerView;
    private ShoppingListAdapter adapter;
    private List<ShoppingItem> shoppingItems;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        shoppingRecyclerView = findViewById(R.id.shoppingRecyclerView);
        shoppingRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        shoppingItems = new ArrayList<>();
        shoppingItems.add(new ShoppingItem("Makaron pełnoziarnisty"));
        shoppingItems.add(new ShoppingItem("Pomidory"));
        shoppingItems.add(new ShoppingItem("Cebula"));
        shoppingItems.add(new ShoppingItem("Czosnek"));
        shoppingItems.add(new ShoppingItem("Oliwa"));
        shoppingItems.add(new ShoppingItem("Bazylia"));

        adapter = new ShoppingListAdapter(shoppingItems);
        shoppingRecyclerView.setAdapter(adapter);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
