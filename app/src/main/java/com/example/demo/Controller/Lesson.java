package com.example.demo.Controller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;

public class Lesson extends AppCompatActivity {
    ImageButton quizButton;
    ImageButton repeatButton;
    String lessonNameString;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);
        TextView lessonName = (TextView) findViewById(R.id.lesson_title);
        Intent lessonIntent = getIntent();
        lessonNameString = lessonIntent.getStringExtra("lessonName");
        lessonName.setText(lessonNameString);
        buttonVisibility();
    }
    public void onHome(View view) {
        Intent home = new Intent(Lesson.this, MainActivity.class);
        startActivity(home);
    }
    public void onBack(View view) { onBackPressed(); }

    public void buttonVisibility(){
        quizButton = findViewById(R.id.quiz_button);
        quizButton.setVisibility(View.VISIBLE);
        repeatButton = findViewById(R.id.repeat_button);
        repeatButton.setVisibility(View.VISIBLE);
    }

    public void onQuiz(View view) {
        Intent quizIntent = new Intent(Lesson.this, Quiz.class);
        quizIntent.putExtra("ifTopic", false);
        quizIntent.putExtra("name", lessonNameString);
        startActivity(quizIntent);
    }
}
