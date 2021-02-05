package com.example.demo.Controller;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

public class Beginning3Spl extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);
        TextView lessonName = (TextView) findViewById(R.id.lesson_title);
        lessonName.setText("spl");
    }
}
