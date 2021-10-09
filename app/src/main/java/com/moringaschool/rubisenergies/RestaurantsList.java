package com.moringaschool.rubisenergies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RestaurantsList extends AppCompatActivity {
    private String restaurants[]={"Dominos","Nyama Mama","Pizza Inn","Java Square","Chicken Inn","Santorini","Simba Saloon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_list);

    }
}