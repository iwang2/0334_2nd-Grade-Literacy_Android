package com.example.demo.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.R;

import java.util.Map;

import Model.Model;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
        setContentView(R.layout.activity_main);
    }

    private void loadData() {
        SharedPreferences sp_v = getSharedPreferences("visited", MODE_PRIVATE);
        Map<String, ?> visitedEntries = sp_v.getAll();
        for (Map.Entry<String, ?> entry : visitedEntries.entrySet()) {
            Model.visit(entry.getKey());
        }

        SharedPreferences sp_tc = getSharedPreferences("totalCoin", MODE_PRIVATE);
        Model.addCoins(sp_tc.getInt("coin", 0));

        SharedPreferences sp_c = getSharedPreferences("coin", MODE_PRIVATE);
        Map<String, ?> allCoins = sp_c.getAll();
        for (Map.Entry<String, ?> entry : allCoins.entrySet()) {
              Model.setCoinsFromMap(entry.getKey(), Integer.parseInt(entry.getValue().toString()));
        }

        SharedPreferences sp_p = getSharedPreferences("puzzle", MODE_PRIVATE);
        Map<String, ?> allEntries = sp_p.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            char [] chars = entry.getValue().toString().toCharArray();
            for (int i = 0; i < 16; i++) {
                if (chars[i] == '1') {
                    Model.puzzleEarned.get(entry.getKey()).add(i);
                }
            }
        }

        SharedPreferences sp_g = getSharedPreferences("goldStar", MODE_PRIVATE);
        Map<String, ?> goldCoinEntries = sp_g.getAll();
        System.out.println(goldCoinEntries);
        for (Map.Entry<String, ?> entry : goldCoinEntries.entrySet()) {
            Model.setGoldStar(entry.getKey(), Integer.parseInt(entry.getValue().toString()));
        }
        SharedPreferences sp_s = getSharedPreferences("silverStar", MODE_PRIVATE);
        Map<String, ?> silverCoinEntries = sp_s.getAll();
        for (Map.Entry<String, ?> entry : silverCoinEntries.entrySet()) {
            Model.setSilverStar(entry.getKey(), Integer.parseInt(entry.getValue().toString()));
        }


    }

    public void onConsonants(View view) {
        Intent consonantsIntent = new Intent(MainActivity.this, ConsonantsVowels.class);
        consonantsIntent.putExtra("ifConsonants", "true");
        startActivity(consonantsIntent);
    }

    public void onVowels(View view) {
        Intent vowelsIntent = new Intent(MainActivity.this, ConsonantsVowels.class);
        vowelsIntent.putExtra("ifConsonants", "false");
        startActivity(vowelsIntent);
    }

    public void onHome(View view) {
//        Intent home = new Intent(MainActivity.this, MainActivity.class);
//        startActivity(home);
    }

    public void onBank(View view) {
        Intent bank = new Intent(MainActivity.this, PiggyBank.class);
        startActivity(bank);
    }

    public void onBack(View view) {
        onBackPressed();
    }

    public void onPuzzle(View view) {
        Intent intent = new Intent(getApplicationContext(), PuzzleList.class);
        startActivity(intent);
    }


}