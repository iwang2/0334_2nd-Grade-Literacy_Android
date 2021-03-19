package com.example.demo.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.ViewHolder> {
    Context context;
    int[] coinsValue;
    int[] coinsNum;
    public BankAdapter(Context ct, int[] finalCoinsValue, int[] finalCoinsNum) {
        coinsValue = finalCoinsValue;
        coinsNum = finalCoinsNum;
        context = ct;
    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.bank_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        System.out.println(coinsValue[position]);
        if (coinsValue[position] == 250) {
            holder.view1.setImageResource(R.drawable.armoredcar);
            holder.view2.setImageResource(R.drawable.armoredcar);
            holder.view3.setImageResource(R.drawable.armoredcar);
            holder.view4.setImageResource(R.drawable.armoredcar);
            if (coinsNum[position] == 1) {
                holder.view1.setVisibility(View.INVISIBLE);
                holder.view2.setVisibility(View.INVISIBLE);
                holder.view4.setVisibility(View.INVISIBLE);
            } else if (coinsNum[position] == 2) {
                holder.view1.setVisibility(View.INVISIBLE);
                holder.view4.setVisibility(View.INVISIBLE);
            } else if (coinsNum[position] == 3) {
                holder.view4.setVisibility(View.INVISIBLE);
            }
            holder.view1.requestLayout();
            holder.view2.requestLayout();
            holder.view3.requestLayout();
            holder.view4.requestLayout();
            holder.view1.getLayoutParams().width = 200;
            holder.view2.getLayoutParams().width = 200;
            holder.view3.getLayoutParams().width = 200;
            holder.view4.getLayoutParams().width = 200;
            holder.view1.getLayoutParams().height = 175;
            holder.view2.getLayoutParams().height = 175;
            holder.view3.getLayoutParams().height = 175;
            holder.view4.getLayoutParams().height = 175;
        }
        if (coinsValue[position] == 50) {
            holder.view1.setImageResource(R.drawable.money_bag_new);
            holder.view2.setImageResource(R.drawable.money_bag_new);
            holder.view3.setImageResource(R.drawable.money_bag_new);
            holder.view4.setImageResource(R.drawable.money_bag_new);
            if (coinsNum[position] == 1) {
                holder.view1.setVisibility(View.INVISIBLE);
                holder.view2.setVisibility(View.INVISIBLE);
                holder.view4.setVisibility(View.INVISIBLE);
            } else if (coinsNum[position] == 2) {
                holder.view1.setVisibility(View.INVISIBLE);
                holder.view4.setVisibility(View.INVISIBLE);
            } else if (coinsNum[position] == 3) {
                holder.view4.setVisibility(View.INVISIBLE);
            }
            holder.view1.requestLayout();
            holder.view2.requestLayout();
            holder.view3.requestLayout();
            holder.view4.requestLayout();
            holder.view1.getLayoutParams().width = 180;
            holder.view2.getLayoutParams().width = 180;
            holder.view3.getLayoutParams().width = 180;
            holder.view4.getLayoutParams().width = 180;
            holder.view1.getLayoutParams().height = 150;
            holder.view2.getLayoutParams().height = 150;
            holder.view3.getLayoutParams().height = 150;
            holder.view4.getLayoutParams().height = 150;
        }
        if (coinsValue[position] == 10) {
            holder.view1.setImageResource(R.drawable.stack_of_coins_5);
            holder.view2.setImageResource(R.drawable.stack_of_coins_5);
            holder.view3.setImageResource(R.drawable.stack_of_coins_5);
            holder.view4.setImageResource(R.drawable.stack_of_coins_5);
            if (coinsNum[position] == 1) {
                holder.view1.setVisibility(View.INVISIBLE);
                holder.view2.setVisibility(View.INVISIBLE);
                holder.view4.setVisibility(View.INVISIBLE);
            } else if (coinsNum[position] == 2) {
                holder.view1.setVisibility(View.INVISIBLE);
                holder.view4.setVisibility(View.INVISIBLE);
            } else if (coinsNum[position] == 3) {
                holder.view4.setVisibility(View.INVISIBLE);
            }
            holder.view1.requestLayout();
            holder.view2.requestLayout();
            holder.view3.requestLayout();
            holder.view4.requestLayout();
            holder.view1.getLayoutParams().width = 200;
            holder.view2.getLayoutParams().width = 200;
            holder.view3.getLayoutParams().width = 200;
            holder.view4.getLayoutParams().width = 200;
            holder.view1.getLayoutParams().height = 150;
            holder.view2.getLayoutParams().height = 150;
            holder.view3.getLayoutParams().height = 150;
            holder.view4.getLayoutParams().height = 150;
        }
        if (coinsValue[position] == 2) {
            holder.view1.setImageResource(R.drawable.coin_gold_new);
            holder.view2.setImageResource(R.drawable.coin_gold_new);
            holder.view3.setImageResource(R.drawable.coin_gold_new);
            holder.view4.setImageResource(R.drawable.coin_gold_new);
            holder.view1.requestLayout();
            holder.view2.requestLayout();
            holder.view3.requestLayout();
            holder.view4.requestLayout();
            holder.view1.getLayoutParams().width = 150;
            holder.view2.getLayoutParams().width = 150;
            holder.view3.getLayoutParams().width = 150;
            holder.view4.getLayoutParams().width = 150;
            holder.view1.getLayoutParams().height = 120;
            holder.view2.getLayoutParams().height = 120;
            holder.view3.getLayoutParams().height = 120;
            holder.view4.getLayoutParams().height = 120;

            if (coinsNum[position] == 1) {
                holder.view1.setVisibility(View.INVISIBLE);
                holder.view2.setVisibility(View.INVISIBLE);
                holder.view4.setVisibility(View.INVISIBLE);
            } else if (coinsNum[position] == 2) {
                holder.view1.setVisibility(View.INVISIBLE);
                holder.view4.setVisibility(View.INVISIBLE);
            } else if (coinsNum[position] == 3) {
                holder.view4.setVisibility(View.INVISIBLE);
            }
        }
        if (coinsValue[position] == 1) {
            holder.view1.setImageResource(R.drawable.silver_coin_new);
            holder.view2.setImageResource(R.drawable.silver_coin_new);
            holder.view3.setImageResource(R.drawable.silver_coin_new);
            holder.view4.setImageResource(R.drawable.silver_coin_new);

            holder.view1.setVisibility(View.INVISIBLE);
            holder.view2.setVisibility(View.INVISIBLE);
            holder.view4.setVisibility(View.INVISIBLE);
            holder.view1.requestLayout();
            holder.view2.requestLayout();
            holder.view3.requestLayout();
            holder.view4.requestLayout();
            holder.view1.getLayoutParams().width = 150;
            holder.view2.getLayoutParams().width = 150;
            holder.view3.getLayoutParams().width = 150;
            holder.view4.getLayoutParams().width = 150;
            holder.view1.getLayoutParams().height = 120;
            holder.view2.getLayoutParams().height = 120;
            holder.view3.getLayoutParams().height = 120;
            holder.view4.getLayoutParams().height = 120;

        }
    }

    @Override
    public int getItemCount() {
        return coinsValue.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView view1, view2, view3, view4;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view1 = itemView.findViewById(R.id.bank_view1);
            view2 = itemView.findViewById(R.id.bank_view2);
            view3 = itemView.findViewById(R.id.bank_view3);
            view4 = itemView.findViewById(R.id.bank_view4);
        }
    }
}
