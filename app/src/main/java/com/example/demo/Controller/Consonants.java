package com.example.demo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.demo.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Consonants extends AppCompatActivity implements TopicListAdapter.ItemClickListener {

    TopicListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consonants);
        RecyclerView recyclerView = findViewById(R.id.consonants_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] topics = {"hard and soft c and g", "beginning 3-letter blends", "silent"};
        adapter = new TopicListAdapter(this, topics);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // start corresponding activities
    }
}
