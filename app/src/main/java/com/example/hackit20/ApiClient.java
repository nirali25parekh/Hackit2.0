package com.example.hackit20;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=MSFT&apikey=demo
    static Retrofit retrofit;
    public static final String BASE_URL = "https://www.alphavantage.co";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
