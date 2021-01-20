package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Consonants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consonants);
    }

    public void onClick(View view) {
        startActivity(new Intent(Consonants.this, LessonList.class));
    }
}
