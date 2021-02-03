package com.example.demo.Controller;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class TopicListAdapter extends RecyclerView.Adapter<TopicListAdapter.ViewHolder> {

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    private String[] topics;
    private ItemClickListener listener;

    TopicListAdapter(Context context, String[] topics) {
        this.topics = topics;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            textView = (TextView) view.findViewById(R.id.topic_list_item_text);
        }

        public TextView getTextView() {
            return textView;
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
