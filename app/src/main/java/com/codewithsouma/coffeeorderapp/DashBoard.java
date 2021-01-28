package com.codewithsouma.coffeeorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {
//    private int quantity = 2;
    private final int[] coffeeImages = {
            R.drawable.americano,
            R.drawable.black_coffee,
            R.drawable.cappuccino,
            R.drawable.mocha,
            R.drawable.latte,
            R.drawable.espresso };

    private String[] coffeeNames;
    private String[] coffeeDescriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        coffeeNames = getResources().getStringArray(R.array.coffee_names);
        coffeeDescriptions = getResources().getStringArray(R.array.coffee_description);

//        displayQuantity();
//        displayPrice();
    }

    public void handleClick(View view) {
        int cardIndex = 0;

        if (view == findViewById(R.id.americano_card_ID))
            cardIndex = 0;


        collectDataAndStartNextActivity(cardIndex);


    }

    private void collectDataAndStartNextActivity(int cardIndex) {
        String coffeeName = coffeeNames[cardIndex];
        String coffeeDescription = coffeeDescriptions[cardIndex];
        int coffeeImage = coffeeImages[cardIndex];

        startOrderSummaryActivity(coffeeName, coffeeDescription, coffeeImage);
    }

    private void startOrderSummaryActivity(String coffeeName, String coffeeDescription, int coffeeImage) {
        Intent orderSummaryActivity = new Intent(this, OrderSummary.class);
        orderSummaryActivity.putExtra("coffeeName",coffeeName);
        orderSummaryActivity.putExtra("coffeeImage",coffeeImage);
        orderSummaryActivity.putExtra("coffeeDescription",coffeeDescription);
        this.startActivity(orderSummaryActivity);
    }

   /* public void submitOrder(View view) {
        displayQuantity();
        displayPrice();
        displayOrderSummary("Souma");
        startActivity(new Intent(this,OrderSummary.class));
    }*/

    /*private int calculatePrice() {
        final int PRICE_OF_EVERY_CUP = 5;
        return quantity * PRICE_OF_EVERY_CUP;
    }

    private void displayQuantity() {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(Integer.toString(quantity));
    }

    private void displayPrice() {
        int price = calculatePrice();
        TextView priceTextView = findViewById(R.id.price_text_view);
        String formattedPrice = NumberFormat.getCurrencyInstance(Locale.US).format(price);
        priceTextView.setText("Total price: " + formattedPrice);
    }*/

    /*public void displayOrderSummary(String name) {
        int price = calculatePrice();
        TextView orderSummaryTextView = findViewById(R.id.order_summary_textView);
        String orderSummary = "Name: " + name + " !!!\n" +
                "Quantity: " + quantity + " cup of coffee " +
                "\nTotal price: $" + price + " \n" +
                "Thank you!!!";
        orderSummaryTextView.setText(orderSummary);

    }*/

/*    public void increment(View view) {
        quantity++;
        displayQuantity();
        displayPrice();
    }

    public void decrement(View view) {
        if (quantity <= 1) return;
        quantity--;
        displayQuantity();
        displayPrice();
    }*/
}