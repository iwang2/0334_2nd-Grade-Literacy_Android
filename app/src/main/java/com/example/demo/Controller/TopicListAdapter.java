package com.example.demo.Controller;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.ViewHolder> {

    private String[] topics;
    private int[] icons;
    private ItemClickListener listener;

    TopicListAdapter(Context context, String[] topics, int[] icons) {
        this.topics = topics;
        this.icons = icons;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ImageView icon;
        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            textView = (TextView) view.findViewById(R.id.topic_list_item_text);
            icon = (ImageView) view.findViewById(R.id.topic_list_icon);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getIcon() {
            return icon;
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topic_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(topics[position]);
        holder.getIcon().setImageResource(icons[position]);
    }

    String getTopicName(int position) {
        return topics[position];
    }

    @Override
    public int getItemCount() {
        return topics.length;
    }

    void setClickListener(ItemClickListener listener) {
        this.listener = listener;
    }
}
