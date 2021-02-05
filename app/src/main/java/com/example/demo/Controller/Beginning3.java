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

public class Beginning3 extends AppCompatActivity implements LessonListAdapter.ItemClickListener {
    LessonListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list);
        RecyclerView recyclerView = findViewById(R.id.lesson_list_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        String[] lessons = {"scr", "spl", "spr", "str"};
        adapter = new LessonListAdapter(this, lessons);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // open the appropriate lesson page using the getLessonName method on the adapter
        String lesson = adapter.getLessonName(position);
        if (lesson.equals("scr")) {
            startActivity(new Intent(Beginning3.this, Beginning3Scr.class));
        } else if (lesson.equals("spl")) {
            startActivity(new Intent(Beginning3.this, Beginning3Spl.class));
        } else if (lesson.equals("spr")) {
            startActivity(new Intent(Beginning3.this, Beginning3Spr.class));
        } else if (lesson.equals("str")) {
            startActivity(new Intent(Beginning3.this, Beginning3Str.class));
        }
    }
}
