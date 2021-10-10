package com.moringaschool.rubisenergies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllRestaurants extends AppCompatActivity {
    @BindView(R.id.allRest) ListView allRest;

     String[] restaurants = new String[] {"Nyama Mama", "Subway","KFC","Pizza Inn","Chicken Inn","Galitos","Teriyaki","Art-cafe","Dominos","Carribean Foods"};
     private ListView singleRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_restaurants);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        allRest.setAdapter(adapter);


    }

}