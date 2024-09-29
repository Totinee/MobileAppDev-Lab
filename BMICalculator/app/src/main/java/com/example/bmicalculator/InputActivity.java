package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    EditText editTextAge, editTextHeight, editTextWeight;
    Spinner  spinnerHeightUnit, spinnerWeightUnit;
    RadioGroup radioGroupGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // Find views by ID
        editTextAge = findViewById(R.id.editTextAge);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerHeightUnit = findViewById(R.id.spinnerHeightUnit); // Spinner for height unit
        spinnerWeightUnit = findViewById(R.id.spinnerWeightUnit); // Spinner for weight unit

        Button btnResult = findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values
                int age = Integer.parseInt(editTextAge.getText().toString());

                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                String gender = "";
                if (selectedGenderId == R.id.radioMale) {
                    gender = "Male";
                } else if (selectedGenderId == R.id.radioFemale) {
                    gender = "Female";
                }

                float height = Float.parseFloat(editTextHeight.getText().toString());
                float weight = Float.parseFloat(editTextWeight.getText().toString());

                // Get selected height and weight units from Spinners
                String heightUnit = spinnerHeightUnit.getSelectedItem().toString();
                String weightUnit = spinnerWeightUnit.getSelectedItem().toString();

                // Convert height to meters if entered in feet-inches
                if (heightUnit.equals("Feet/Inches (ft/in)")) {
                    height = (float) (height * 0.3048); // Convert feet to meters
                } else {
                    height /= 100; // Convert cm to meters
                }

                // Convert weight to kg if entered in pounds
                if (weightUnit.equals("Pounds (lbs)")) {
                    weight = (float) (weight * 0.453592); // Convert pounds to kg
                }

                // Calculate BMI
                float bmi = weight / (height * height);

                // Determine BMI category
                String bmiCategory;
                if (bmi < 18.5) {
                    bmiCategory = getString(R.string.bmi_underweight);
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    bmiCategory = getString(R.string.bmi_normal);
                } else if (bmi >= 25 && bmi < 29.9) {
                    bmiCategory = getString(R.string.bmi_overweight);
                } else if (bmi >= 30 && bmi < 34.9) {
                    bmiCategory = getString(R.string.bmi_obese_1);
                } else if (bmi >= 35 && bmi < 39.9) {
                    bmiCategory = getString(R.string.bmi_obese_2);
                } else {
                    bmiCategory = getString(R.string.bmi_obese_3);
                }

                // Pass the BMI and category to the ResultActivity
                Intent intent = new Intent(InputActivity.this, ResultActivity.class);
                intent.putExtra("bmi_value", bmi);
                intent.putExtra("age", age);
                intent.putExtra("gender", gender);
                intent.putExtra("Category", bmiCategory);
                startActivity(intent);
            }
        });

    }
}
