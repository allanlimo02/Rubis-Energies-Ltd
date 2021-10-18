package com.moringaschool.rubisenergies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.rubisenergies.BuildConfig;
import com.moringaschool.rubisenergies.R;
import com.moringaschool.rubisenergies.connection.RapidApi;
import com.moringaschool.rubisenergies.connection.RapidClient;
import com.moringaschool.rubisenergies.models.Food;
import com.moringaschool.rubisenergies.models.RapidApiResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllMeals extends AppCompatActivity {
    @BindView(R.id.listView) ListView allRest;
    @BindView(R.id.welcome) TextView mUsername;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar)  ProgressBar mProgressBar;

    private ListView singleRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_meals);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String food_search=intent.getStringExtra("foodsearch");

        //parsing user input to api endpoints
        RapidApi client= RapidClient.getClient();
        Call<RapidApiResponse> call=client.getRubisEnergies(food_search, BuildConfig.RAPIDAPI_KEY);


        call.enqueue(new Callback<RapidApiResponse>() {
            @Override
            public void onResponse(Call<RapidApiResponse> call, Response<RapidApiResponse> response) {

                if(response.isSuccessful()){
                    hideProgressBar();
                    showFailureMessage();



//                    ArrayAdapter arrayAdapter=new FoodAdapter(AllMeals.this,android.R.layout.simple_list_item_1,foods);
//                    allRest.setAdapter(arrayAdapter);
                }else{
                    hideProgressBar();
//                    showFailureMessage();
                    mErrorTextView.setText("Your %food_search% api was succsessfu;;");

                }
            }

            @Override
            public void onFailure(Call<RapidApiResponse> call, Throwable t) {
                hideProgressBar();
                mErrorTextView.setText("Your api was succsessfu;;");
            }
        });
    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}