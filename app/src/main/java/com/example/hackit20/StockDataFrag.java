package com.example.hackit20;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

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
   // TextView stockdata;
    TextView price,high,low,tradeday,change,close;

    TextView  stockname;
    LineChart mChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View rootview= inflater.inflate(R.layout.fragment_stock_data, container, false);
      //  stockdata=rootview.findViewById(R.id.stockdata);
        stockname=rootview.findViewById(R.id.stockname);
        go=rootview.findViewById(R.id.go);
        price=rootview.findViewById(R.id.Price);
        high=rootview.findViewById(R.id.high);
        low=rootview.findViewById(R.id.low);
        change=rootview.findViewById(R.id.change);
        tradeday=rootview.findViewById(R.id.tradeday);
        close=rootview.findViewById(R.id.close);
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
                         String mhigh=  globalQuote.get03High();
                         high.append(mhigh);
                           String mlow= globalQuote.get04Low();
                           low.append(mlow);
                          String mprice=  globalQuote.get05Price();
                          price.append(mprice);
                            String mlatest =globalQuote.get07LatestTradingDay();
                        tradeday.append(mlatest);
                           String mprev= globalQuote.get08PreviousClose();
                           close.append(mprev);
                            String smchper=globalQuote.get10ChangePercent();
                            change.append(smchper);

                    }

                    @Override
                    public void onFailure(Call<RootCurrentData> call, Throwable t) {
                      Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                        Log.i("Dekh",t.getMessage());
                    }
                });//get data

                //graphing start


                mChart=rootview.findViewById(R.id.stockchart);
                mChart.setScaleEnabled(false);
                mChart.setDragEnabled(true);
                mChart.setBackgroundColor(Color.WHITE);
                //mChart.setLabelFor();
                ArrayList<Entry>yValues=new ArrayList<>();
int x=1;
if(name=="MSFT") {

    yValues.add(new Entry(1, 158.7800f));
    yValues.add(new Entry(2, 151.8100f));
    yValues.add(new Entry(3, 144.2600f));
    yValues.add(new Entry(4, 139.6600f));
    yValues.add(new Entry(5, 136.6100f));
    yValues.add(new Entry(6, 137.0000f));
    yValues.add(new Entry(7, 123.8500f));
    yValues.add(new Entry(8, 130.5300f));
    yValues.add(new Entry(9, 118.9500f));
    yValues.add(new Entry(10, 112.8900f));
    yValues.add(new Entry(11, 117.9400f));
    yValues.add(new Entry(12, 103.7750f));
    yValues.add(new Entry(13, 99.5500f));
    yValues.add(new Entry(14, 113.0000f));
    yValues.add(new Entry(15, 107.0500f));
}else if(name=="AAPL") {

    yValues.add(new Entry(1, 309.5100f));
    yValues.add(new Entry(2, 293.6500f));
    yValues.add(new Entry(3, 267.2500f));
    yValues.add(new Entry(4, 248.7600f));
    yValues.add(new Entry(5, 223.9700f));
    yValues.add(new Entry(6, 208.7400f));
    yValues.add(new Entry(7, 213.0400f));
    yValues.add(new Entry(8, 197.9200f));
    yValues.add(new Entry(9, 175.0700f));
    yValues.add(new Entry(10, 200.6700f));
    yValues.add(new Entry(11, 189.9500f));
    yValues.add(new Entry(12, 173.1500f));
    yValues.add(new Entry(13, 166.4400f));
    yValues.add(new Entry(14, 157.7400f));
    yValues.add(new Entry(15, 178.5800f));
}
else{
    yValues.add(new Entry(1, 104.8100f));
    yValues.add(new Entry(2, 114.3700f));
    yValues.add(new Entry(3, 112.3300f));
    yValues.add(new Entry(4, 106.0800f));
    yValues.add(new Entry(5, 98.6100f));
    yValues.add(new Entry(6, 98.8400f));
    yValues.add(new Entry(7, 93.5200f));
    yValues.add(new Entry(8, 91.2700f));
    yValues.add(new Entry(9, 93.7700f));
    yValues.add(new Entry(10, 95.0100f));
    yValues.add(new Entry(11, 85.5400f));
    yValues.add(new Entry(12, 82.2400f));
    yValues.add(new Entry(13, 73.7100f));
    yValues.add(new Entry(14, 68.0200f));
    yValues.add(new Entry(15, 72.8900f));
}


                LineDataSet set1=new LineDataSet(yValues,"Monthly Closing");
                set1.setLabel("Label");

                set1.setFillAlpha(110);
                set1.setColor(Color.BLUE);
                set1.setLineWidth(4f);
                set1.setValueTextSize(12f);
                set1.setValueTextColor(Color.RED);
                //set1.set
                ArrayList<ILineDataSet> dataSets=new ArrayList<>();
                dataSets.add(set1);

                LineData data=new LineData(dataSets);
                mChart.setData(data);
                //graphing end


            }//on click method end
        });// on click listener end


        return rootview;
    }//on create end




}//frag end
