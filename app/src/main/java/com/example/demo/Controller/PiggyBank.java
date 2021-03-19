package com.example.demo.Controller;
import Model.Model;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;


public class PiggyBank extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView totalCoinText, leftCoinText, spentCoinText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piggy_bank);
        int[] coinsValue = new int[5];
        int[] coinsNum = new int[5];
        int count = 0;
        int coins = Model.getCoins();
        if (coins / 250 >= 1) {
            coinsValue[count] = 250;
            coinsNum[count] = coins / 250;
            count++;
        }
        if (coins % 250 / 50 >= 1) {
            coinsValue[count] = 50;
            coinsNum[count] = coins % 250 / 50;
            count++;
        }
        if (coins % 250 % 50 / 10 >= 1) {
            coinsValue[count] = 10;
            coinsNum[count] = coins % 250 % 50 / 10;
            count++;
        }
        if (coins % 250 % 50 % 10 / 2 >=1) {
            coinsValue[count] = 2;
            coinsNum[count] = coins % 250 % 50 % 10 / 2;
            count++;
        }
        if (coins % 250 % 50 % 10 % 2 ==1) {
            coinsValue[count] = 1;
            coinsNum[count] = 1;
            count++;
        }
        int[] finalCoinsValue = new int[count];
        int[] finalCoinsNum = new int[count];
        for (int i = 0; i < count; i++) {
            finalCoinsNum[i] = coinsNum[i];
            finalCoinsValue[i] = coinsValue[i];
        }
        recyclerView = findViewById(R.id.bank_recycler);
        BankAdapter bankAdapter = new BankAdapter(this, finalCoinsValue, finalCoinsNum);
        recyclerView.setAdapter(bankAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        totalCoinText = findViewById(R.id.totalCoinText);
        totalCoinText.setText(String.valueOf(coins));
        leftCoinText = findViewById(R.id.leftCoinText);
        leftCoinText.setText(String.valueOf(coins));
        spentCoinText = findViewById(R.id.spentCoinText);
        spentCoinText.setText("0");


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