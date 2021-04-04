package com.example.demo.Controller;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

import Model.Model;

public class PuzzleListAdapter extends RecyclerView.Adapter<PuzzleListAdapter.ViewHolder> {
    private String[] puzzles;
    private ItemClickListener listener;
    private View view;

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private CardView card;
        public ImageView image;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            textView = (TextView) view.findViewById(R.id.puzzle_name);
            card = (CardView) view.findViewById(R.id.puzzle_list_item);
            image = (ImageView) view.findViewById(R.id.puzzle_image);
        }
        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }

        public TextView getTextView() {
            return textView;
        }

        public CardView getCard() { return card; }
    }

    PuzzleListAdapter(String[] puzzles, View view) {
        this.puzzles = puzzles;
        this.view = view;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.puzzle_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CardView card = holder.getCard();
        if (Model.puzzleEarned.get(puzzles[position]).size() >= 12) {
            // set the correct image
            holder.image.setVisibility(View.VISIBLE);
        } else {
            holder.image.setVisibility(View.INVISIBLE);
            String lesson = puzzles[position];
            int i = lesson.length();
            while (i > 0 && Character.isDigit(lesson.charAt(i-1))) {
                i--;
            }
            holder.getTextView().setText(lesson.substring(0, i));
        }
    }

    @Override
    public int getItemCount() {
        return puzzles.length;
    }

    void setClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    String getPuzzleName(int position) {
        return puzzles[position];
    }
}
