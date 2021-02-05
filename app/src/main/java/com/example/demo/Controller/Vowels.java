package com.example.demo.Controller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.demo.R;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Vowels extends AppCompatActivity implements TopicListAdapter.ItemClickListener {

    TopicListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vowels);

        RecyclerView recyclerView = findViewById(R.id.vowels_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] topics = {"Vowel Pairs", "With R", "Schwas"};
        adapter = new TopicListAdapter(this, topics);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapter.getTopicName(position) == "Schwas") {
            startActivity(new Intent(Vowels.this, Schwas.class));
        }
        if (adapter.getTopicName(position) == "Vowel Pairs") {
            startActivity(new Intent(Vowels.this, Pairs.class));
        }

    }


}
