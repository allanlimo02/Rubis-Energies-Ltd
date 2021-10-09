package com.moringaschool.rubisenergies;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.loginButton) Button mLoginButton;
//    private Button mLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        //Creating onclick listener for landing page button
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome to Rubis Energy! \n Please Log-In to continue", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);

            }
        });
    }

}