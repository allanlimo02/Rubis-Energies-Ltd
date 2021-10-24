package com.moringaschool.rubisenergies.ui;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.moringaschool.rubisenergies.R;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    @BindView(R.id.loginButton) Button mLoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Creating onclick listener for landing page button
         mLoginButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view==mLoginButton){
            Intent intent=new Intent(MainActivity.this, SearchFood.class);
            startActivity(intent);
        }

//                Toast.makeText(MainActivity.this, "Welcome to Rubis Energy! \n Please Log-In to continue", Toast.LENGTH_LONG).show();

    }
}