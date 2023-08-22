package com.sodabazapplication;

import com.sodabazapplication.Services.Endpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit;
    private static final String url = "http://192.168.100.11:8080/";
    public static Retrofit getRetrofitInstance(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
       return retrofit;
    }
    public static Endpoints getEndpoints(){
        return getRetrofitInstance().create(Endpoints.class);
    }
}
