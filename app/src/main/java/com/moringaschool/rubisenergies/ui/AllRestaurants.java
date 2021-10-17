package com.moringaschool.rubisenergies.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.moringaschool.rubisenergies.R;
import com.moringaschool.rubisenergies.connection.RapidApi;
import com.moringaschool.rubisenergies.connection.RapidClient;
import com.moringaschool.rubisenergies.models.Food;
import com.moringaschool.rubisenergies.models.Measure;
import com.moringaschool.rubisenergies.models.RapidApiResponse;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllRestaurants extends AppCompatActivity {
    @BindView(R.id.allRest) ListView allRest;
    @BindView(R.id.welcome) TextView mUsername;


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
                    List<Food>foodList= (List<Food>) response.body().getFood();
                    String[] foods=new String[foodList.size()];
                    String [] measures=new String[foodList.size()];

                    for(int i=0;i<foods.length;i++){
                        foods[i]=foodList.get(i).getLabel();
                    }
//                    for(int i=0;i<measures.length;i++){
//                        Measure measure=foodList.get(i).getNutrients().get(1);
//                        measures[i]=measure.getUri();
//                    }
//                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,foods);
//                    allRest.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<RapidApiResponse> call, Throwable t) {

            }
        });




    }

}