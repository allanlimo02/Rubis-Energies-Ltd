package com.moringaschool.rubisenergies.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.moringaschool.rubisenergies.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserRegistration extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.createUserButton)    Button mCreateUserButton;
    @BindView(R.id.nameEditText)    EditText mNameEditText;
    @BindView(R.id.emailEditText)    EditText mEmailEditText;
    @BindView(R.id.passwordEditText)    EditText mPasswordEditText;
    @BindView(R.id.confirmPasswordEditText)    EditText mConfirmPasswordEditText;
    @BindView(R.id.loginTextView)  TextView mLoginTextView;
    @BindView(R.id.firebaseProgressBar) ProgressBar mSignInProgressBar;
    @BindView(R.id.loadingTextView) TextView mLoadingSignUp;
    private String mName;

    public static final String TAG = UserRegistration.class.getSimpleName();
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        ButterKnife.bind(this);

        mLoginTextView.setOnClickListener(this);
        mCreateUserButton.setOnClickListener(this);

        mAuth=FirebaseAuth.getInstance();
        createAuthStateListener();
    }

    @Override
    public void onClick(View view) {
        if (view == mLoginTextView) {
            Intent intent = new Intent(UserRegistration.this, LogIn.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (view == mCreateUserButton) {
            createNewUser();
        }
    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent( UserRegistration.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    // create user
    private void createNewUser() {
        final String name = mNameEditText.getText().toString().trim();
        final String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();
        Toast.makeText(UserRegistration.this,name, Toast.LENGTH_SHORT).show();

        boolean validmName = isValidName(mName);


        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(name);
        boolean validPassword = isValidPassword(password, confirmPassword);
//        if (!validEmail || !validName || !validPassword) return;
//            mAuth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(this, task -> {
//                        if (task.isSuccessful()) {
//                        Log.d(TAG, "Authentication successful");
//                    } else {
//                        Toast.makeText(UserRegistration.this, "Authentication failed.",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
//        //
        if (!validEmail || !validName || !validPassword) return;
        showProgressBar();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        hideProgressBar();
                        if (task.isSuccessful()) {
                            Toast.makeText(UserRegistration.this, "Authentication Accepted.",
                                    Toast.LENGTH_LONG).show();
//                            Log.d(TAG, "Authentication successful");
                        } else {
                            Toast.makeText(UserRegistration.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


//    Onstart and onStop methods
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
    //Validation
//    email validation
    private boolean isValidEmail(String email) {
        boolean isGoodEmail =
                (email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            mEmailEditText.setError("Please enter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    // validate name
    private boolean isValidName(String name) {
//         if (name.length()==0) {
//            mNameEditText.setError("Please enter your name");
//            return false;
//        }
        return true;
//    }
    }
        //Validate email

    private boolean isValidPassword(String password, String confirmPassword) {
        if (password.length() < 6) {
            mPasswordEditText.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!password.equals(confirmPassword)) {
            mPasswordEditText.setError("Passwords do not match");
            return false;
        }
        return true;
//    }
    }
    //Progress bar hide and show
    private void showProgressBar() {
        mSignInProgressBar.setVisibility(View.VISIBLE);
        mLoadingSignUp.setVisibility(View.VISIBLE);
        mLoadingSignUp.setText("Sign Up process in Progress");
    }
    private void hideProgressBar() {
        mSignInProgressBar.setVisibility(View.GONE);
        mLoadingSignUp.setVisibility(View.GONE);
    }
}