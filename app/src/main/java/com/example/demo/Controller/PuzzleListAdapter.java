package com.example.demo.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class PuzzleListAdapter extends RecyclerView.Adapter<PuzzleListAdapter.ViewHolder> {
    private String[] puzzles;
    private ItemClickListener listener;

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            textView = (TextView) view.findViewById(R.id.puzzle_name);
        }
        @Override
        public void onClick(View v) {
            listener.onItemClick(v, getAdapterPosition());
        }

        public TextView getTextView() {
            return textView;
        }
    }

    PuzzleListAdapter(String[] puzzles) {
        this.puzzles = puzzles;
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
        holder.getTextView().setText(puzzles[position]);
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
