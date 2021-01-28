package com.codewithsouma.coffeeorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderSummary extends AppCompatActivity {
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
}