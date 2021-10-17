package com.moringaschool.rubisenergies.connection;

import static com.moringaschool.rubisenergies.Constants.RAPIDAPI_KEY;
import static com.moringaschool.rubisenergies.Constants.baseUrl;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RapidClient {
    private static Retrofit retrofit = null;

    //retrofit get method
    public static RapidApi getClient(){
        if(retrofit==null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request= chain.request().newBuilder()
                            .addHeader("rapidapi-key",RAPIDAPI_KEY)
                            .build();
                    return chain.proceed(request);
                }
            }).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RapidApi.class);
    }



}
