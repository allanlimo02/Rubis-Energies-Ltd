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

public class SignIn extends AppCompatActivity {
    @BindView(R.id.submit) Button mSignIn;
    @BindView(R.id.username) EditText mUsername;
    @BindView(R.id.password) EditText mPassword;
    @BindView(R.id.trials) TextView attempts;
    @BindView(R.id.ingr) EditText ingr;
    @BindView(R.id.invalids) TextView mInvalids;
    @BindView(R.id.blankname) TextView mBlankname;
    private int counter =3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(mUsername.getText().toString(),mPassword.getText().toString());
            }
        });



    }
    public void validate(String username, String password){
        if((username.equals("Admin"))&&(password.equals("1234"))){
            Intent intent= new Intent(SignIn.this,AllRestaurants.class);
            String name =ingr.getText().toString();
            intent.putExtra("name",name);
            startActivity(intent);

        }
        else {
            counter--;
            mInvalids.setText("Invalid Username or Password");
            if(counter==0){
                mSignIn.setEnabled(false);
//                attempts.setText("Remaining Attempts"+String.valueOf(counter));
            }
        }

    }
}