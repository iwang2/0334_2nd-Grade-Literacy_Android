package com.example.demo.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onConsonants(View view) {
        Intent consonantsIntent = new Intent(MainActivity.this, ConsonantsVowels.class);
        consonantsIntent.putExtra("ifConsonants", "true");
        startActivity(consonantsIntent);
    }

    public void onVowels(View view) {
        Intent vowelsIntent = new Intent(MainActivity.this, ConsonantsVowels.class);
        vowelsIntent.putExtra("ifConsonants", "false");
        startActivity(vowelsIntent);
    }

    public void onHome(View view) {
        Intent home = new Intent(MainActivity.this, MainActivity.class);
        startActivity(home);
    }

    public void onBack(View view) {
        onBackPressed();
    }
}