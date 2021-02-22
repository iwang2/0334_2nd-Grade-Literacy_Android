package com.example.demo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import java.util.HashMap;
import java.util.Map;


public class Topic extends AppCompatActivity implements LessonListAdapter.ItemClickListener {
    LessonListAdapter adapter;

    Map<String, String[]> topicToLesson = new HashMap<String, String[]>() {{
        put("hard and soft c and g", new String[] {"c", "c", "g", "g", "g"});
        put("beginning 3-letter blends", new String[] {"scr", "spl", "spr", "str"});
        put("silent", new String[] {"kn", "wr", "sc", "ck"});
        put("pairs", new String[] {"ai", "au", "aw", "ay", "ea", "ea", "ee", "ew", "oa", "oi", "oo", "oo",
                "ou", "ow", "ow", "oy"});
        put("with r", new String[] {"ar", "ar", "er", "ir", "or", "or", "ur"});
        put("schwas", new String[] {"a", "e", "i", "o", "u"});
    }};
    public void onHome(View view) {
        Intent home = new Intent(Topic.this, MainActivity.class);
        startActivity(home);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list);
        RecyclerView recyclerView = findViewById(R.id.lesson_list_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        Intent topicIntent = getIntent();
        String topicName = topicIntent.getStringExtra("topicName");

        String[] lessons = topicToLesson.get(topicName);
        adapter = new LessonListAdapter(this, lessons);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // open the appropriate lesson page using the getLessonName method on the adapter
        String lessonName = adapter.getLessonName(position);
        Intent lessonIntent = new Intent(Topic.this, Lesson.class);
        lessonIntent.putExtra("lessonName", lessonName);
        startActivity(lessonIntent);
    }
}
