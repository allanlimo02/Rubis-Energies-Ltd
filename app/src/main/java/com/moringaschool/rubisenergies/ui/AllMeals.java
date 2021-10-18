package com.moringaschool.rubisenergies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.rubisenergies.R;
import com.moringaschool.rubisenergies.connection.YelpApi;
import com.moringaschool.rubisenergies.connection.RapidClient;
import com.moringaschool.rubisenergies.models.Event;
import com.moringaschool.rubisenergies.models.YelpEventSearchResponse;


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
        String event_search=intent.getStringExtra("foodsearch");

        //parsing user input to api endpoints
        YelpApi client = RapidClient.getClient();
        Call<YelpEventSearchResponse> call=client.getRubisEnergies(event_search);

        call.enqueue(new Callback<YelpEventSearchResponse>() {
            @Override
            public void onResponse(Call<YelpEventSearchResponse> call, Response<YelpEventSearchResponse> response) {

                if(response.isSuccessful()){
                    hideProgressBar();
                    List<Event> eventsList=response.body().getEvents();
                    String[]event=new String[eventsList.size()];
                    String[] eventLocation=new String[eventsList.size()];

                    for (int i=0;i<event.length;i++){
                        event[i]=eventsList.get(i).getName();
//                        String description=eventsList.get(i).getDescription();
//                        String url=eventsList.get(i).getEventSiteUrl();
                    }


                    ArrayAdapter arrayAdapter=new FoodAdapter(AllMeals.this,android.R.layout.simple_list_item_1,event);
                    allRest.setAdapter(arrayAdapter);
                }else{
                    hideProgressBar();
                    showFailureMessage();


                }
            }

            @Override
            public void onFailure(Call<YelpEventSearchResponse> call, Throwable t) {
                hideProgressBar();
                showUnsuccessfulMessage();
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