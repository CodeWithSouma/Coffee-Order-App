package com.codewithsouma.coffeeorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

      public void submitOrder(View view) {
        String subject = "Order "+quantity+" cup of coffee";
        String email = "shop@loverspoint.com";
        String name = "Soumadip Dey";

        displayQuantity();
        displayPrice();
        String orderSummary = getOrderSummary(name);
        composeEmail(email, subject, orderSummary);
    }

    private double calculatePrice() {
        return quantity * priceOfEveryCup;
    }

    private void displayPrice() {
        double price = calculatePrice();
        String formattedPrice = NumberFormat.getCurrencyInstance(Locale.US).format(price);
        priceTextView.setText(formattedPrice);
    }


    public String getOrderSummary(String name) {
        double price = calculatePrice();
        return "Name: " + name + "\n" +
                "Coffee type: "+coffeeName+"\n"+
                "Quantity: " + quantity + " cup of coffee " +
                "\nTotal price: $" + price + " \n" +
                "Thank you!!!";
    }

    public void composeEmail(String email, String subject, String orderSummary) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,orderSummary);
        startActivity(intent);
    }


}