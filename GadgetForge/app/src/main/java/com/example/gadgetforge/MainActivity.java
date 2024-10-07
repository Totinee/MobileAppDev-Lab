package com.example.gadgetforge;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ImageView profileIcon;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Profile Icon click
        profileIcon = findViewById(R.id.profileIcon);
        profileIcon.setOnClickListener(view -> showProfilePopup(view));

        // Handle menu dropdown for categories, cart, etc.
        findViewById(R.id.logoImage).setOnClickListener(view -> showMenuPopup(view));
    }

    // Method for showing profile details popup
    private void showProfilePopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.profile_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem -> {
            int id = menuItem.getItemId();

            // Handling the profile menu items
            if (id == R.id.edit_account) {
                Toast.makeText(this, "Edit Account Selected", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        popupMenu.show();
    }

    // Method for showing categories and other options dropdown
    private void showMenuPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.main_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem -> {
            int id = menuItem.getItemId();
            if (id == R.id.edit_account) {
                Toast.makeText(this, "Edit Account Selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.categories) {
                Toast.makeText(this, "Categories Selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.cart) {
                Toast.makeText(this, "Cart Selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.favourites) {
                Toast.makeText(this, "Favourites Selected", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.logout) {
                Toast.makeText(this, "Logout Selected", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        popupMenu.show();
    }
}
