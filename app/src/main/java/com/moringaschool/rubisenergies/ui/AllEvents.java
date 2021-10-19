package com.moringaschool.rubisenergies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class AllEvents extends AppCompatActivity {
    @BindView(R.id.listView) ListView allRest;
    @BindView(R.id.welcome) TextView mUsername;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar)  ProgressBar mProgressBar;

    private ListView singleRestaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_events);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String eventSearch=intent.getStringExtra("eventSearch");
        //parsing user input to api endpoints

        YelpApi client = RapidClient.getClient();
        Call<YelpEventSearchResponse> call=client.getRubisEnergies(eventSearch);

        call.enqueue(new Callback<YelpEventSearchResponse>() {
            @Override
            public void onResponse(Call<YelpEventSearchResponse> call, Response<YelpEventSearchResponse> response) {
                hideProgressBar();
//                if(response.code()==400){
//                    try {
//                        Log.d("response","Your response is events"+response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
                if(response.isSuccessful()){
//                    assert response.body() != null;
                    List<Event> eventsList=response.body().getEvents();
//                    Log.d("response","Your response is ListEvents Arrays"+eventsList);
                    String[]event=new String[eventsList.size()];
//                    Log.d("Length","Is"+event.length);
                    String[] eventLocation=new String[eventsList.size()];
                    String[] siteUrl=new String[eventsList.size()];
                    for (int i=0;i<event.length;i++){
                        event[i]=eventsList.get(i).getName();
                        eventLocation[i]=eventsList.get(i).getCategory();
                        siteUrl[i]=eventsList.get(i).getEventSiteUrl();
                    }

//                    for(int i=1;i<eventLocation.length;i++){
//                        eventLocation[i]=eventsList.get(i).getDescription();
//                    }
                    ArrayAdapter arrayAdapter=new ArrayAdapter(AllEvents.this,android.R.layout.simple_list_item_1,event);
                    allRest.setAdapter(arrayAdapter);
                }else{
                    showFailureMessage();
                }
            }
            @Override
            public void onFailure(Call<YelpEventSearchResponse> call, Throwable t) {
                Log.e("Error Message", "onFailure: ",t );
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