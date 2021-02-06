package com.example.demo.Controller;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

public class Lesson extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);
        TextView lessonName = (TextView) findViewById(R.id.lesson_title);
        Intent lessonIntent = getIntent();
        lessonName.setText(lessonIntent.getStringExtra("lessonName"));
    }
}
