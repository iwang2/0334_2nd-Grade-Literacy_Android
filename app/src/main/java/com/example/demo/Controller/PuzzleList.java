package com.example.demo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Model;

public class PuzzleList extends AppCompatActivity implements ItemClickListener {
    PuzzleListAdapter adapter;
    Map<String, String[]> topicToLesson = Topic.topicToLesson;
    // reverse mapping of topicToLesson
    Map<String, String> lessonToTopic = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_list);
        RecyclerView recyclerView = findViewById(R.id.puzzle_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        for (Map.Entry<String, String[]> e : topicToLesson.entrySet()) {
            String topic = e.getKey();
            for (String lesson: e.getValue()) {
                lessonToTopic.put(lesson, topic);
            }
        }
        adapter = new PuzzleListAdapter((String[]) Model.puzzleEarned.keySet().toArray());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(View view, int position) {
        String lesson = adapter.getPuzzleName(position);
        String topic = lessonToTopic.get(lesson);
        String[] lessons = topicToLesson.get(topic);
        Intent intent = new Intent(PuzzleList.this, Lesson.class);
        intent.putExtra("lessonName", lesson);
        intent.putExtra("lessons", lessons);
        for (int i = 0; i < lessons.length; i++) {
            if (lessons[i].equals(lesson)) {
                intent.putExtra("position", i);
            }
        }
        intent.putExtra("topicName", topic);

        startActivity(intent);
    }
}
