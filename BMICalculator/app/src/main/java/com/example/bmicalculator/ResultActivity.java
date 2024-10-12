package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView textViewResult, textViewCategory;
    Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewResult = findViewById(R.id.textViewResult);
        textViewCategory = findViewById(R.id.textViewCategory);
        btnBackToHome = findViewById(R.id.btnBackToHome);

        // Retrieve the BMI data passed from InputActivity
        Intent intent = getIntent();
        //String bmi = intent.getStringExtra("BMI");
        float bmi = intent.getFloatExtra("bmi_value", 0.0f);
        String category = intent.getStringExtra("Category");

        // Set the BMI and category on the screen
        textViewResult.setText("Your BMI is: " + String.format("%.2f", bmi));
        textViewCategory.setText("You are in the " + category + " category.");

        // Button to go back to the first activity
        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }
}
