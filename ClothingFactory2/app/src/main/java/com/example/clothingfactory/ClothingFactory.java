package com.example.clothingfactory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ClothingFactory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView resultTextView = findViewById(R.id.resultTextView);

        Intent intent = getIntent();
        String selectedCategory = intent.getStringExtra("selectedCategory");

        if (selectedCategory != null) {
            switch (selectedCategory) {
                case "Male":
                    resultTextView.setText("Available Dresses: \nShirt \nT-Shirt \nJeans \nBlazer");
                    break;
                case "Female":
                    resultTextView.setText("Available Dresses: \nDress \nSkirt \nTops \nSaree");
                    break;
                case "Child":
                    resultTextView.setText("Available Dresses: \nKids T-Shirt \nShorts \nFrocks \nKids Jeans");
                    break;
                default:
                    resultTextView.setText("No category selected");
            }
        }
    }
}