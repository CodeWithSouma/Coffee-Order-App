package com.codewithsouma.coffeeorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderSummary extends AppCompatActivity {
    //    private int quantity = 2;

    private int coffeeImage;
    private String coffeeName;
    private String coffeeDescription;

    private ImageView coffeeImageView;
    private TextView coffeeNameTextView;
    private TextView coffeeDescriptionTextView;

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

//        displayQuantity();
//        displayPrice();

    }

    private void findAllViews() {
        coffeeImageView = this.findViewById(R.id.coffee_image_view_ID);
        coffeeNameTextView = this.findViewById(R.id.coffee_name_text_view_ID);
        coffeeDescriptionTextView = this.findViewById(R.id.coffee_description_text_view_ID);
    }

    private void updateUI() {
        coffeeImageView.setImageResource(coffeeImage);
        coffeeNameTextView.setText(coffeeName);
        coffeeDescriptionTextView.setText(coffeeDescription);
    }

    private void collectDataFromIntent(Bundle bundle) {
        coffeeName = bundle.getString("coffeeName");
        coffeeDescription = bundle.getString("coffeeDescription");
        coffeeImage = bundle.getInt("coffeeImage");
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