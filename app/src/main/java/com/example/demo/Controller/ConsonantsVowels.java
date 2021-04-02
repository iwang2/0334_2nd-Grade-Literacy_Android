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

import java.util.HashMap;
import java.util.Map;

public class ConsonantsVowels extends AppCompatActivity implements ItemClickListener {

    TopicListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] topics;
        int[] icons;
        RecyclerView recyclerView;
        if (Boolean.valueOf(getIntent().getStringExtra("ifConsonants"))) {
            setContentView(R.layout.consonants);
            recyclerView = findViewById(R.id.consonants_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            topics = new String[]{"hard and soft c and g", "beginning 3-letter blends", "silent"};
            icons = new int[]{R.drawable.topic_icon_hardsoftcg, R.drawable.topic_icon_3letterblend, R.drawable.topic_icon_silent};
        } else {
            setContentView(R.layout.vowels);
            recyclerView = findViewById(R.id.vowels_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            topics = new String[]{"pairs", "with r", "schwas"};
            icons = new int[]{R.drawable.topic_icon_pairs, R.drawable.topic_icon_withr, R.drawable.topic_icon_schwas};
        }

        adapter = new TopicListAdapter(this, topics, icons);
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
    public void onBank(View view) {
        Intent bank = new Intent(ConsonantsVowels.this, PiggyBank.class);
        startActivity(bank);
    }

}
