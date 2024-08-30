package com.example.clothingfactory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ClothesExpert expert = new ClothesExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSelectGender(View view) {
        Spinner GenderSpinner = (Spinner) findViewById(R.id.GenderSpinner);
        String SelectedGender = String.valueOf(GenderSpinner.getSelectedItem());

        List<String> genderList = expert.getGender(SelectedGender);

        StringBuilder genderFormatted = new StringBuilder();
        for (String menu : genderList) {
            genderFormatted.append(menu).append('\n');
        }

        TextView MenuTextView = (TextView) findViewById(R.id.ChoiceTextView);
        MenuTextView.setText(genderFormatted);
    }
}