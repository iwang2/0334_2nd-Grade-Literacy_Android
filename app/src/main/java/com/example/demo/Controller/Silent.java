package com.example.demo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class Silent extends AppCompatActivity implements LessonListAdapter.ItemClickListener {
    LessonListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list);
        RecyclerView recyclerView = findViewById(R.id.lesson_list_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        String[] lessons = {"kn", "wr", "sc", "ck"};
        adapter = new LessonListAdapter(this, lessons);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // open the appropriate lesson page using the getLessonName method on the adapter
        String lesson = adapter.getLessonName(position);
        if (lesson.equals("kn")) {
            startActivity(new Intent(Silent.this, SilentKn.class));
        } else if (lesson.equals("wr")) {
            startActivity(new Intent(Silent.this, SilentWr.class));
        } else if (lesson.equals("sc")) {
            startActivity(new Intent(Silent.this, SilentSc.class));
        } else if (lesson.equals("ck")) {
            startActivity(new Intent(Silent.this, SilentWr.class));
        }
    }
}
