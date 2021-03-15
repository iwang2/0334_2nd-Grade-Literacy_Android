package com.example.demo.Controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import java.util.ArrayList;

public class LessonListAdapter extends RecyclerView.Adapter<LessonListAdapter.ViewHolder> {
    private String[] lessons;
    private ItemClickListener listener;
    private Context context;

    LessonListAdapter(Context context, String[] lessons) {
        this.lessons = lessons;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            textView = (TextView) view.findViewById(R.id.lesson_list_text);
            imageView = (ImageView) view.findViewById(R.id.lesson_list_image);
        }

        public TextView getTextView() {
            return textView;
        }
        public ImageView getImageView() {return imageView; }

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
        String lessonName = lessons[position];
        if (Character.isDigit(lessonName.toCharArray()[lessonName.length()-1])) {
            lessonName = lessonName.substring(0, lessonName.length()-1);
        }
        holder.getTextView().setText(lessonName);
        String imageName = "topic_page_" + lessonName + position;
        int id = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName() );
        holder.getImageView().setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return lessons.length;
    }

    String getLessonName(int position) {
        return lessons[position];
    }

    String[] getLessons() {return lessons;}

    int getLessonPosition(String lessonName) {
        int position = 0;
        for (String s: lessons) {
            if (s == lessonName) return position;
            position++;
        }
        //should never reach here.
        return 0;
    }

    void setClickListener(ItemClickListener listener) {
        this.listener = listener;
    }
}
