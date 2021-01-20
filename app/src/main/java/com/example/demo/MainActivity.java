package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConsonants(View view) {
        startActivity(new Intent(MainActivity.this, Consonants.class));
    }

    public void onVowels(View view) {
        startActivity(new Intent(MainActivity.this, Vowels.class));
    }
}