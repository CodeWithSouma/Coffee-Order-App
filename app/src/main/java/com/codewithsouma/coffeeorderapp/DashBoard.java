package com.codewithsouma.coffeeorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {
    private final int[] coffeeImages = {
            R.drawable.americano,
            R.drawable.black_coffee,
            R.drawable.cappuccino,
            R.drawable.mocha,
            R.drawable.latte,
            R.drawable.espresso };

    private String[] coffeeNames;
    private String[] coffeeDescriptions;
    private String[] coffeePrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        coffeeNames = getResources().getStringArray(R.array.coffee_names);
        coffeeDescriptions = getResources().getStringArray(R.array.coffee_description);
        coffeePrices = getResources().getStringArray(R.array.coffee_prices);

    }

    public void handleClick(View view) {
        int cardIndex = -1;

        if (view == findViewById(R.id.americano_card_ID))
            cardIndex = 0;
        else if (view == findViewById(R.id.black_coffee_card_ID))
            cardIndex = 1;
        else if (view == findViewById(R.id.cappuccino_card_ID))
            cardIndex = 2;
        else if (view == findViewById(R.id.mocha_card_ID))
            cardIndex = 3;
        else if (view == findViewById(R.id.latte_card_ID))
            cardIndex = 4;
        else if (view == findViewById(R.id.espresso_card_ID))
            cardIndex = 5;

        collectDataAndStartNextActivity(cardIndex);

    }

    private void collectDataAndStartNextActivity(int cardIndex) {
        String coffeeName = coffeeNames[cardIndex];
        String coffeeDescription = coffeeDescriptions[cardIndex];
        int coffeeImage = coffeeImages[cardIndex];
        double coffeePrice = Double.parseDouble(coffeePrices[cardIndex]);

        startOrderSummaryActivity(coffeeName, coffeeDescription, coffeeImage,coffeePrice);
    }

    private void startOrderSummaryActivity(String coffeeName, String coffeeDescription, int coffeeImage, double coffeePrice) {
        Intent orderSummaryActivity = new Intent(this, OrderSummary.class);
        orderSummaryActivity.putExtra("coffeeName",coffeeName);
        orderSummaryActivity.putExtra("coffeeImage",coffeeImage);
        orderSummaryActivity.putExtra("coffeeDescription",coffeeDescription);
        orderSummaryActivity.putExtra("coffeePrice",coffeePrice);
        this.startActivity(orderSummaryActivity);
    }

}