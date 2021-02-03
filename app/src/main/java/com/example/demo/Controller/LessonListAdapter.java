package com.example.demo.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class LessonListAdapter extends RecyclerView.Adapter<LessonListAdapter.ViewHolder> {
    private String[] lessons;
    private ItemClickListener listener;

    LessonListAdapter(Context context, String[] lessons) {
        this.lessons = lessons;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            textView = (TextView) view.findViewById(R.id.lesson_textview);
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
                .inflate(R.layout.lesson_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(lessons[position]);
    }

    @Override
    public int getItemCount() {
        return lessons.length;
    }

    String getLessonName(int position) {
        return lessons[position];
    }

    void setClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
