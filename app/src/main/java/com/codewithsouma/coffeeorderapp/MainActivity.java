package com.codewithsouma.coffeeorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity();
        displayPrice();
    }

    public void submitOrder(View view) {
        displayQuantity();
        displayPrice();
    }

    private int calculatePrice() {
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
        priceTextView.setText(formattedPrice);
    }

    public void increment(View view) {
        quantity++;
        displayQuantity();
        displayPrice();
    }

    public void decrement(View view) {
        quantity--;
        displayQuantity();
        displayPrice();
    }
}