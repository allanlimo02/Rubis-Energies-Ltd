package com.moringaschool.rubisenergies.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaRouter;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moringaschool.rubisenergies.Adapters.ListAdapter;
import com.moringaschool.rubisenergies.Constants;
import com.moringaschool.rubisenergies.R;
import com.moringaschool.rubisenergies.connection.YelpApi;
import com.moringaschool.rubisenergies.connection.RapidClient;
import com.moringaschool.rubisenergies.models.Event;
import com.moringaschool.rubisenergies.models.YelpEventSearchResponse;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllEvents extends AppCompatActivity {
    @BindView(R.id.welcome) TextView mUsername;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar)  ProgressBar mProgressBar;
    @BindView(R.id.recyclerView)  RecyclerView mRecyclerView;

    private ListAdapter listAdapter;
    public List<Event> eventListFinal;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private ListView singleRestaurant;
    private String recentSearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_events);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String eventSearch=intent.getStringExtra("eventSearch");
//        String recentSearch= mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
        //parsing user input to api endpoints
        mSharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        recentSearch=mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);

            YelpApi client = RapidClient.getClient();
            Call<YelpEventSearchResponse> call=client.getRubisEnergies(eventSearch);
            call.enqueue(new Callback<YelpEventSearchResponse>() {
                @Override
                public void onResponse(Call<YelpEventSearchResponse> call, Response<YelpEventSearchResponse> response) {
                    hideProgressBar();
                    if(response.isSuccessful()){
                        eventListFinal=response.body().getEvents();
                        listAdapter=new ListAdapter(AllEvents.this,eventListFinal);
                        mRecyclerView.setAdapter(listAdapter);
                        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(AllEvents.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                        showEventsList();
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

            ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
            itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
    String deletedEvent=null;

    //Drag & drop methods come here
    ItemTouchHelper.SimpleCallback simpleCallback= new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN |ItemTouchHelper.START|ItemTouchHelper.END,
            ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int fromPosition=viewHolder.getAdapterPosition();
            int toPosition=target.getAbsoluteAdapterPosition();
            Collections.swap(eventListFinal,fromPosition,toPosition);

            recyclerView.getAdapter().notifyItemMoved(fromPosition,toPosition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position=viewHolder.getPosition();
            if(direction==ItemTouchHelper.LEFT){
                eventListFinal.remove(position);
                deletedEvent= String.valueOf(eventListFinal.get(position));
                listAdapter.notifyItemRemoved(position);
//                recyclerView.getAdapter().


            }
            if(direction==ItemTouchHelper.RIGHT){
                eventListFinal.remove(position);
            }

        }
    };

    // End of
    public void getEvent(String location){
        YelpApi client = RapidClient.getClient();
        Call<YelpEventSearchResponse> call=client.getRubisEnergies(location);
        call.enqueue(new Callback<YelpEventSearchResponse>() {
            @Override
            public void onResponse(Call<YelpEventSearchResponse> call, Response<YelpEventSearchResponse> response) {
                hideProgressBar();
//
                if(response.isSuccessful()){
                    eventListFinal=response.body().getEvents();
                    listAdapter=new ListAdapter(AllEvents.this,eventListFinal);
                    mRecyclerView.setAdapter(listAdapter);
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(AllEvents.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    showEventsList();
//
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
    private void showEventsList(){
        mRecyclerView.setVisibility(View.VISIBLE);
    }
    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}
