package com.example.demo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ConsonantsVowels extends AppCompatActivity implements TopicListAdapter.ItemClickListener {

    TopicListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] topics;
        RecyclerView recyclerView;
        if (Boolean.valueOf(getIntent().getStringExtra("ifConsonants"))) {
            setContentView(R.layout.consonants);
            recyclerView = findViewById(R.id.consonants_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            topics = new String[]{"hard and soft c and g", "beginning 3-letter blends", "silent"};
        } else {
            setContentView(R.layout.vowels);
            recyclerView = findViewById(R.id.vowels_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            topics = new String[]{"pairs", "with r", "schwas"};
        }

        adapter = new TopicListAdapter(this, topics);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    public void onBack(View view) {
        onBackPressed();
    }

    @Override
    public void onItemClick(View view, int position) {
        String topicName = adapter.getTopicName(position);
        Intent topicIntent = new Intent(ConsonantsVowels.this, Topic.class);
        topicIntent.putExtra("topicName", topicName);
        startActivity(topicIntent);
    }
    public void onHome(View view) {
        Intent home = new Intent(ConsonantsVowels.this, MainActivity.class);
        startActivity(home);
    }
}
