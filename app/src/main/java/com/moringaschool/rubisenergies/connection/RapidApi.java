package com.moringaschool.rubisenergies.connection;

import com.moringaschool.rubisenergies.models.RapidApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RapidApi {
    @GET("parser")
    Call<RapidApiResponse> getRubisEnergies(
            @Query("ingr") String ingr
    );
}
