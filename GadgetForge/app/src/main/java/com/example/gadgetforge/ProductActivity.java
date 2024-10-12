package com.example.gadgetforge;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        // You can retrieve data from the Intent if needed
        // Intent intent = getIntent();
        // String someData = intent.getStringExtra("key");
    }
}
