package com.example.demo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;

import com.example.demo.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
public class Pairs extends AppCompatActivity implements LessonListAdapter.ItemClickListener {

    LessonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list);
        RecyclerView recyclerView = findViewById(R.id.lesson_list_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        String lessons[] = {"ai", "au", "aw", "ay", "ea", "ea", "ee", "ew", "oa", "oi", "oo", "oo",
                "ou", "ow", "ow", "oy"};
        adapter = new LessonListAdapter(this, lessons);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
/*        String lesson = adapter.getLessonName(position);
        if (lesson.equals("ai")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("au")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("aw")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("ay")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("ea")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("ea")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("ee")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("ew")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("oa")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("oi")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("oo")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("oo")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("ou")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("ow")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("ow")) {
            startActivity(new Intent(Pairs.this, .class));
        } else if (lesson.equals("oy")) {
            startActivity(new Intent(Pairs.this, .class));
        }*/
    }
}
