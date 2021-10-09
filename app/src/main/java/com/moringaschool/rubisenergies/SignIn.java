package com.moringaschool.rubisenergies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignIn extends AppCompatActivity {
    @BindView(R.id.signin) Button mSignIn;
    @BindView(R.id.username) EditText mUsername;
    @BindView(R.id.password) EditText mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

    }
}