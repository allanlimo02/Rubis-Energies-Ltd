package com.moringaschool.rubisenergies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.rubisenergies.Constants;
import com.moringaschool.rubisenergies.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchEvent extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentAddress;

    private DatabaseReference mSearchedLocation;

    @BindView(R.id.food_search) EditText food_search;
    @BindView(R.id.submit) Button submit;
    @BindView(R.id.sharedPreference) Button sharedPreference;
//    @BindView(R.id.error) TextView error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);
        ButterKnife.bind(this);

        //add searched location to firebase
        mSearchedLocation= FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);

        submit.setOnClickListener(this);
        sharedPreference.setOnClickListener(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor=mSharedPreferences.edit();

//        if(mSharedPreferences.equals("")){
//
//        }
//        mRecentAddress = mSharedPreferences.getString(Constants.LOCATION_PREFERENCE, null);
//        Log.d("Here is message ","Here is the address "+mRecentAddress);
    }
    @Override
    public void onClick(View view) {
        if(view==submit){
                String eventSearch=food_search.getText().toString();
                addToSharedPreferences(eventSearch);
                saveLocationToFirebase(eventSearch);
                Intent intent=new Intent(SearchEvent.this, AllEvents.class);
                intent.putExtra("eventSearch",eventSearch);
                startActivity(intent);
        }
        if(view==sharedPreference){
            Intent intent=new Intent(SearchEvent.this, AllEvents.class);
            intent.putExtra("eventSearch",mRecentAddress);
            startActivity(intent);

        }
    }
    //save into shared preference
    private void addToSharedPreferences(String eventSearch) {
        mEditor.putString(Constants.LOCATION_PREFERENCE, eventSearch).apply();
    }
    //Save into database

    public void saveLocationToFirebase(String location) {
        mSearchedLocation.setValue(location);
    }

}