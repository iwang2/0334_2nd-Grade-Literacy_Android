package com.example.demo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import java.util.HashMap;
import java.util.Map;

public class PuzzleList extends AppCompatActivity implements ItemClickListener {
    PuzzleListAdapter adapter;
    Map<String, String[]> topicToLesson = Topic.topicToLesson;
    // reverse mapping of topicToLesson
    Map<String, String> lessonToTopic = new HashMap<String, String>();
    String[] lessons = {"a", "ai", "ar1", "ar2", "au", "aw", "ay",
            "c1", "c2",
            "e", "ea1", "ea2", "ee", "er", "ew",
            "g1", "g2", "g3", "gh",
            "i", "ir",
            "kn",
            "o", "oa", "oi", "oo1", "oo2", "or1", "or2", "ou", "ow1", "ow2", "oy",
            "sc", "scr", "spl", "spr", "str",
            "u", "ur",
            "wr"};

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
        adapter = new PuzzleListAdapter(lessons);
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
