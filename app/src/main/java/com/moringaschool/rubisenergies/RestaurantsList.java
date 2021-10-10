package com.moringaschool.rubisenergies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsList extends AppCompatActivity {
    @BindView(R.id.welcomeMessage) TextView mWelcomeMessage;
    private String restaurants[]={"Dominos","Nyama Mama","Pizza Inn","Java Square","Chicken Inn","Santorini","Simba Saloon","Burger King","Teriyaki"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_list);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String welcome= "Welcome to Rubis ";
        mWelcomeMessage.setText(welcome+name);
    }
}