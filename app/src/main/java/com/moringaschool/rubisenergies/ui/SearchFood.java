package com.moringaschool.rubisenergies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.rubisenergies.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchFood extends AppCompatActivity {
    @BindView(R.id.food_search) EditText food_search;
    @BindView(R.id.submit) Button submit;
    @BindView(R.id.error) TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food);
        ButterKnife.bind(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String foodsearch=food_search.getText().toString();
                if(foodsearch.length()==0){
                    error.setText("This field cannot be blank");
                }else {
                    Intent intent=new Intent(SearchFood.this,AllMeals.class);
                    intent.putExtra("foodsearch",foodsearch);
                    startActivity(intent);

                }
            }
        });
    }
}