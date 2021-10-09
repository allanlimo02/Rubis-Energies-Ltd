package com.moringaschool.rubisenergies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignIn extends AppCompatActivity {
    @BindView(R.id.submit) Button mSignIn;
    @BindView(R.id.username) EditText mUsername;
    @BindView(R.id.password) EditText mPassword;
    private int counter =3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                validate(mUsername.getText().toString(),mPassword.getText().toString());
                Intent intent= new Intent(SignIn.this,RestaurantsList.class);
                startActivity(intent);
            }
        });



    }
//    public void validate(String username, String password){
//        if((username.equals("Admin"))&&(password.equals("1234"))){
//
//        }
//        else {
//            counter--;
//            if(counter==0){
//                mSignIn.setEnabled(false);
//            }
//        }
//
//    }
}