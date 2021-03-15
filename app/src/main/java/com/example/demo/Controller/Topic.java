package com.example.demo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.demo.R;
import java.util.HashMap;
import java.util.Map;


public class Topic extends AppCompatActivity implements ItemClickListener {
    LessonListAdapter adapter;
    ImageButton quizButton;
    ImageButton repeatButton;
    String topicName;


    static Map<String, String[]> topicToLesson = new HashMap<String, String[]>() {{
        put("hard and soft c and g", new String[] {"c1", "c2", "g1", "g2", "g3"});
        put("beginning 3-letter blends", new String[] {"scr", "spl", "spr", "str"});
        put("silent", new String[] {"gh", "kn", "sc", "wr"});
        put("pairs", new String[] {"ai", "au", "aw", "ay", "ea1", "ea2", "ee", "ew", "oa", "oi", "oo1", "oo2",
                "ou", "ow1", "ow2", "oy"});
        put("with r", new String[] {"ar1", "ar2", "er", "ir", "or1", "or2", "ur"});
        put("schwas", new String[] {"a", "e", "i", "o", "u"});
    }};
    public void onHome(View view) {
        Intent home = new Intent(Topic.this, MainActivity.class);
        startActivity(home);
    }
    public void onBack(View view) {
        onBackPressed();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_list);
        RecyclerView recyclerView = findViewById(R.id.lesson_list_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        Intent topicIntent = getIntent();
        topicName = topicIntent.getStringExtra("topicName");

        String[] lessons = topicToLesson.get(topicName);

        adapter = new LessonListAdapter(this, lessons);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        buttonVisibility();
    }

    @Override
    public void onItemClick(View view, int position) {
        // open the appropriate lesson page using the getLessonName method on the adapter
        String lessonName = adapter.getLessonName(position);

        Intent lessonIntent = new Intent(Topic.this, Lesson.class);
        lessonIntent.putExtra("lessonName", lessonName);
        lessonIntent.putExtra("lessons", adapter.getLessons());
        lessonIntent.putExtra("position", adapter.getLessonPosition(lessonName));

        Intent topicIntent = getIntent();
        lessonIntent.putExtra("topicName", topicIntent.getStringExtra("topicName"));

        startActivity(lessonIntent);
    }


    public void buttonVisibility(){
        quizButton = findViewById(R.id.quiz_button);
        quizButton.setVisibility(View.VISIBLE);
        repeatButton = findViewById(R.id.repeat_button);
        repeatButton.setVisibility(View.VISIBLE);
    }

    public void onQuiz(View view) {
        Intent quizIntent = new Intent(Topic.this, Quiz.class);
        quizIntent.putExtra("ifTopic", "true");
        quizIntent.putExtra("name", topicName);
        startActivity(quizIntent);


    }
}
