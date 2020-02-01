package com.example.hackit20;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class StockDataFrag extends Fragment {


    public StockDataFrag() {
        // Required empty public constructor
    }
    Button go;
    TextView stockdata;
    TextView  stockname;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_stock_data, container, false);
        stockdata=rootview.findViewById(R.id.stockdata);
        stockname=rootview.findViewById(R.id.stockname);
        go=rootview.findViewById(R.id.go);
// https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=MSFT&apikey=VOQKYG861T96VWER
        String response=" ";
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String response=" ";
                String name=stockname.getText().toString();
                ApiInterface apiService=ApiClient.getRetrofitInstance().create(ApiInterface.class);
                apiService.getCurrentData("GLOBAL_QUOTE",name,"VOQKYG861T96VWER").enqueue(new Callback<RootCurrentData>() {
                    @Override
                    public void onResponse(Call<RootCurrentData> call,
                            Response<RootCurrentData> response) {

                     GlobalQuote globalQuote=   response.body().getGlobalQuote();
                         String high=  globalQuote.get03High();
                           String low= globalQuote.get04Low();
                          String price=  globalQuote.get05Price();
                            String latest =globalQuote.get07LatestTradingDay();
                         //   globalQuote.get06Volume();
                           // globalQuote.get08PreviousClose();
                            //globalQuote.get09Change();
                            //globalQuote.get10ChangePercent();
                     stockdata.setText(high);
                     stockdata.append(low);
                     stockdata.append(price);
                     stockdata.append(latest);
                    }

                    @Override
                    public void onFailure(Call<RootCurrentData> call, Throwable t) {
                      Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                        Log.i("Dekh",t.getMessage());
                    }
                });



            }
        });


        return rootview;
    }

}
