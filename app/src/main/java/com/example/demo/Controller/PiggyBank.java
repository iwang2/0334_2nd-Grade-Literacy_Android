package com.example.demo.Controller;
import Model.Model;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;


public class PiggyBank extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piggy_bank);
        ImageView one_coin_1 = (ImageView) findViewById(R.id.one_coin_1);
        ImageView one_coin_2 = (ImageView) findViewById(R.id.one_coin_2);
        ImageView one_coin_3 = (ImageView) findViewById(R.id.one_coin_3);
        ImageView one_coin_4 = (ImageView) findViewById(R.id.one_coin_4);
        if (Model.coins % 5 == 0) {
            one_coin_1.setVisibility(View.INVISIBLE);
            one_coin_2.setVisibility(View.INVISIBLE);
            one_coin_3.setVisibility(View.INVISIBLE);
            one_coin_4.setVisibility(View.INVISIBLE);
        }
        if (Model.coins % 5 == 1) {
            one_coin_2.setVisibility(View.INVISIBLE);
            one_coin_3.setVisibility(View.INVISIBLE);
            one_coin_4.setVisibility(View.INVISIBLE);
        }
        if (Model.coins % 5 == 2) {
            one_coin_3.setVisibility(View.INVISIBLE);
            one_coin_4.setVisibility(View.INVISIBLE);
        }
        if (Model.coins % 5 == 3) {
            one_coin_4.setVisibility(View.INVISIBLE);
        }
        ImageView five_coin_1 = (ImageView) findViewById(R.id.five_coin_2);
        ImageView five_coin_2 = (ImageView) findViewById(R.id.five_coin_1);
        ImageView five_coin_3 = (ImageView) findViewById(R.id.five_coin_4);
        ImageView five_coin_4 = (ImageView) findViewById(R.id.five_coin_3);

        if (Model.coins % 25 < 5) {
            five_coin_1.setVisibility(View.INVISIBLE);
            five_coin_2.setVisibility(View.INVISIBLE);
            five_coin_3.setVisibility(View.INVISIBLE);
            five_coin_4.setVisibility(View.INVISIBLE);
        }
        if (Model.coins % 25 < 10) {
            five_coin_2.setVisibility(View.INVISIBLE);
            five_coin_3.setVisibility(View.INVISIBLE);
            five_coin_4.setVisibility(View.INVISIBLE);
        }
        if (Model.coins % 25 < 15) {
            five_coin_3.setVisibility(View.INVISIBLE);
            five_coin_4.setVisibility(View.INVISIBLE);
        }
        if (Model.coins % 25 < 20) {
            five_coin_4.setVisibility(View.INVISIBLE);
        }
        ImageView bag_coin_1 = (ImageView) findViewById(R.id.bag_coin_1);
        ImageView bag_coin_2 = (ImageView) findViewById(R.id.bag_coin_2);
        ImageView bag_coin_3 = (ImageView) findViewById(R.id.bag_coin_3);
        ImageView bag_coin_4 = (ImageView) findViewById(R.id.bag_coin_4);
        if (Model.coins % 125 < 25) {
            bag_coin_1.setVisibility(View.INVISIBLE);
            bag_coin_2.setVisibility(View.INVISIBLE);
            bag_coin_3.setVisibility(View.INVISIBLE);
            bag_coin_4.setVisibility(View.INVISIBLE);
        }
        if (Model.coins % 125 < 50) {
            bag_coin_2.setVisibility(View.INVISIBLE);
            bag_coin_3.setVisibility(View.INVISIBLE);
            bag_coin_4.setVisibility(View.INVISIBLE);
        }
        if (Model.coins % 125 < 75) {
            bag_coin_3.setVisibility(View.INVISIBLE);
            bag_coin_4.setVisibility(View.INVISIBLE);
        }
        if (Model.coins % 125 < 100) {
            bag_coin_4.setVisibility(View.INVISIBLE);
        }

    }


    public void onHome(View view) {
        Intent home = new Intent(PiggyBank.this, MainActivity.class);
        startActivity(home);
    }

    public void onBank(View view) {
        Intent bank = new Intent(PiggyBank.this, PiggyBank.class);
        startActivity(bank);
    }


    public void onBack(View view) {
        onBackPressed();
    }
}