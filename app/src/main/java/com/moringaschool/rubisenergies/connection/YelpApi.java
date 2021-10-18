package com.moringaschool.rubisenergies.connection;

import com.moringaschool.rubisenergies.models.YelpEventSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpApi {
    @GET("events/")
    Call<YelpEventSearchResponse> getRubisEnergies(
            @Query("location=") String location);
}
