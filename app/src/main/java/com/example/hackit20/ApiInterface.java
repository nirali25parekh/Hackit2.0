package com.example.hackit20;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=MSFT&apikey=VOQKYG861T96VWER
// Your dedicated access key is: VOQKYG861T96VWER.
//https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=MSFT&apikey=demo
   @GET("/query")
    Call<RootCurrentData> getCurrentData(
            @Query("function") String function,
           @Query ("symbol") String symbol,
           @Query("apikey")  String apikey
   );
}
//http://ws.audioscrobbler.com/ base url

    //method=artist.search&artist=selena&api_key=ca2ce4bd011365f7253c207a6bb93f80&format=json
//    @GET("/2.0/")
//    Call<ArtistSearchPOJO> getArtistSearchResponse (
//            @Query("method") String method,
//            @Query("artist") String k,
//            @Query("api_key") String key,
//            @Query("format") String format
//    );