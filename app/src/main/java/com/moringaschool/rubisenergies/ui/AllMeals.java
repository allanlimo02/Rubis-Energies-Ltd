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
        setContentView(R.layout.activity_all_restaurants);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        String food=intent.getStringExtra("name" );

        RapidApi client= RapidClient.getClient();
        Call<RapidApiResponse> call=client.getRubisEnergies(food);

        call.enqueue(new Callback<RapidApiResponse>() {
            @Override
            public void onResponse(Call<RapidApiResponse> call, Response<RapidApiResponse> response) {
                if(response.isSuccessful()){
                    hideProgressBar();
                    mErrorTextView.setText("Your api was succsessfu;;");
                    List<Food>foodList= (List<Food>) response.body().getFood();
                    String[] foods=new String[foodList.size()];
//                    String [] measures=new String[foodList.size()];

                    for(int i=0;i<foods.length;i++){
                        foods[i]=foodList.get(i).getLabel();
                    }
//                    for(int i=0;i<measures.length;i++){
//                        Measure measure=foodList.get(i).getNutrients().get(0);
//                        measures[i]=measure.getUri();
//                    }
                    ArrayAdapter arrayAdapter=new FoodAdapter(AllMeals.this,android.R.layout.simple_list_item_1,foods);
                    allRest.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onFailure(Call<RapidApiResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();

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