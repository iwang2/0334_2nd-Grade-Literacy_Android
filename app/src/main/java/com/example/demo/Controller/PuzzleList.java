package com.example.demo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

        // put completed puzzles first
        List<String> alphabetic = new ArrayList<>(Model.puzzleEarned.keySet());
        Collections.sort(alphabetic);
        List<String> completed = new ArrayList<>();
        List<String> not = new ArrayList<>();
        for (String puzzle: alphabetic) {
            if (Model.puzzleEarned.get(puzzle).size() >= 12) {
                completed.add(puzzle);
            } else {
                not.add(puzzle);
            }
        }
        completed.addAll(not);
        String[] puzzles = completed.toArray(new String[Model.puzzleEarned.size()]);

        adapter = new PuzzleListAdapter(puzzles, recyclerView);
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

    public void onHome(View view) {
        Intent home = new Intent(PuzzleList.this, MainActivity.class);
        startActivity(home);
    }
    public void onBank(View view) {
        Intent bank = new Intent(PuzzleList.this, PiggyBank.class);
        startActivity(bank);
    }

    public void onPuzzle(View view) {
        // nothing
    }

    public void onBack(View view) {
        onBackPressed();
    }
}
