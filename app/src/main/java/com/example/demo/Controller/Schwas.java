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

public class Schwas extends AppCompatActivity implements LessonListAdapter.ItemClickListener {
    LessonListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list);
        RecyclerView recyclerView = findViewById(R.id.lesson_list_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        String[] lessons = {"a", "e", "i", "o", "u"};
        adapter = new LessonListAdapter(this, lessons);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // open the appropriate lesson page using the getLessonName method on the adapter
        if (adapter.getLessonName(position) == "a") {
            startActivity(new Intent(Schwas.this, SchwasA.class));
        }
    }
}
