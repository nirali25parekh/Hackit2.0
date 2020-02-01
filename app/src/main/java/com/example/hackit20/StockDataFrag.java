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
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    LineChart mChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View rootview= inflater.inflate(R.layout.fragment_stock_data, container, false);
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
                });//get data

                //graphing start


                mChart=rootview.findViewById(R.id.stockchart);
                mChart.setScaleEnabled(false);
                mChart.setDragEnabled(true);
                ArrayList<Entry>yValues=new ArrayList<>();
int x=1;
if(x==1) {

    yValues.add(new Entry(1, 170.2300f));
    yValues.add(new Entry(2, 157.7000f));
    yValues.add(new Entry(3, 151.3800f));
    yValues.add(new Entry(4, 143.3700f));
    yValues.add(new Entry(5, 139.0300f));
    yValues.add(new Entry(6, 137.8600f));
    yValues.add(new Entry(7, 136.2700f));
    yValues.add(new Entry(8, 133.9600f));
    yValues.add(new Entry(9, 123.6800f));
    yValues.add(new Entry(10, 130.6000f));
    yValues.add(new Entry(11, 117.9400f));
    yValues.add(new Entry(12, 112.0300f));
    yValues.add(new Entry(13, 104.4300f));
    yValues.add(new Entry(14, 101.5700f));
    yValues.add(new Entry(15, 110.8900f));
}else {
    yValues.add(new Entry(1, 106.8100f));
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


                LineDataSet set1=new LineDataSet(yValues,"DS!");

                set1.setFillAlpha(110);
                set1.setColor(Color.RED);
                set1.setLineWidth(3f);
                set1.setValueTextSize(10f);
                set1.setValueTextColor(Color.GREEN);

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
