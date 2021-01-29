package com.codewithsouma.coffeeorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class OrderSummary extends AppCompatActivity {
    private int coffeeImage;
    private String coffeeName;
    private String coffeeDescription;
    private double priceOfEveryCup;
    private int quantity = 1;

    private ImageView coffeeImageView;
    private TextView coffeeNameTextView;
    private TextView coffeeDescriptionTextView;
    private TextView quantityTextView;
    private TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary);

        findAllViews();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            collectDataFromIntent(bundle);
            updateUI();
        }
    }

    private void findAllViews() {
        coffeeImageView = this.findViewById(R.id.coffee_image_view_ID);
        coffeeNameTextView = this.findViewById(R.id.coffee_name_text_view_ID);
        coffeeDescriptionTextView = this.findViewById(R.id.coffee_description_text_view_ID);
        quantityTextView = this.findViewById(R.id.quantity_text_view);
        priceTextView = this.findViewById(R.id.price_text_view);
    }

    private void updateUI() {
        coffeeImageView.setImageResource(coffeeImage);
        coffeeNameTextView.setText(coffeeName);
        coffeeDescriptionTextView.setText(coffeeDescription);
        displayQuantity();
        displayPrice();
    }

    private void collectDataFromIntent(Bundle bundle) {
        coffeeName = bundle.getString("coffeeName");
        coffeeDescription = bundle.getString("coffeeDescription");
        coffeeImage = bundle.getInt("coffeeImage");
        priceOfEveryCup = bundle.getDouble("coffeePrice");
    }

    public void increment(View view) {
        quantity++;
        displayQuantity();
        displayPrice();
    }

    public void decrement(View view) {
        if (quantity <= 1) return;
        quantity--;
        displayQuantity();
        displayPrice();
    }


    private void displayQuantity() {
        quantityTextView.setText(Integer.toString(quantity));
    }

     /* public void submitOrder(View view) {
        displayQuantity();
        displayPrice();
        displayOrderSummary("Souma");
    }*/

    private double calculatePrice() {
        return quantity * priceOfEveryCup;
    }

    private void displayPrice() {
        double price = calculatePrice();
        String formattedPrice = NumberFormat.getCurrencyInstance(Locale.US).format(price);
        priceTextView.setText(formattedPrice);
    }

    /*public void displayOrderSummary(String name) {
        int price = calculatePrice();
        TextView orderSummaryTextView = findViewById(R.id.order_summary_textView);
        String orderSummary = "Name: " + name + " !!!\n" +
                "Quantity: " + quantity + " cup of coffee " +
                "\nTotal price: $" + price + " \n" +
                "Thank you!!!";
        orderSummaryTextView.setText(orderSummary);

    }*/


}