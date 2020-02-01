package com.example.hackit20;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment implements com.example.hackit20.TutorialItemsAdapter.OnRecyclerItemClick {

    private RecyclerView recyclerView;
    private com.example.hackit20.TutorialItemsAdapter tutsAdapter;
    private List<com.example.hackit20.TutorialItemsModel> mList;

    private String[] head = {"Share market basics",
            "Demat and Trading Accounts",
            "Types of Stocks to Invest in Share Market",
            "Key Financial Instruments Traded in Stock Market",
            "Share market tips",
            "25 Stock Market Terms a beginner should know"};

    private String[] desc = {"Ever wondered what are shares and share markets all about? ",
            "what you have to do to invest in the share market? Tap to find more.",
            "The first step is learning to distinguish different types of investments and this article will help you with just that!  ",
            "Shares/ Equity , Mutual Funds, Bonds, Derivatives. What all are the ways one can invest for the future? ",
            "Here’s a list of best share market tips we recommend:",
            "an elementary guide for the beginners to help them understand the basic key terms used in the share market"};

    private String[] time = {"1.                     ", "2.                       ", "3.                      ", "4.                     ", "5.                     ", "6.                     "};

    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView = view.findViewById(R.id.recycler_categories);

        mList = new ArrayList<>();
        for (int i = 0; i < head.length; i++) {
            com.example.hackit20.TutorialItemsModel tutsModel = new com.example.hackit20.TutorialItemsModel();
            tutsModel.setHead(head[i]);
            tutsModel.setDesc(desc[i]);
            tutsModel.setTime(time[i]);
            //if you want to use icons for different categories you can use the following line :
            //notesModel.setView(PASS ICONS HERE LIKE WORK, PERSONAL, ETC);
            mList.add(tutsModel);
        }
        tutsAdapter = new com.example.hackit20.TutorialItemsAdapter(mList, getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(tutsAdapter);

        tutsAdapter.setOnRecyclerItemClick(this);
        return view;
    }

    @Override
    public void onClick(int pos) {
        //Toast.makeText(getContext(), "Pos is : " + pos, Toast.LENGTH_SHORT).show();
        String url;

        switch(pos)
        {
            case 0:
                url = "https://www.karvyonline.com/knowledge-center/beginner/share-market/share-market-and-share-trading-investment-tips";
            break;

            case 1:
                url = "https://www.karvyonline.com/knowledge-center/beginner/share-market/difference-between-demat-and-trading-account";
                break;
            case 2:
                url = "https://economictimes.indiatimes.com/markets/stocks/news/peter-lynchs-5-types-of-stocks-how-to-make-money-in-them/articleshow/70655615.cms?from=mdr";
                break;
            case 3:
                url = "https://www.investopedia.com/articles/basics/11/3-s-simple-investing.asp";
                break;
            case 4:
                url = "https://www.karvyonline.com/knowledge-center/beginner/share-market/share-market-and-share-trading-investment-tips";
                break;
            case 5:
                url = "https://www.elearnmarkets.com/blog/stock-market-terms-a-beginner-should-know/?gclid=Cj0KCQiAvc_xBRCYARIsAC5QT9nyx_-eKVItdCpx0CFH-lCu7BIbK7oYOdyIEDrE39UdA8c0MRNPB0oaAhxdEALw_wcB";
                break;
            default:
                url = "https://www.computerhope.com/jargon/u/url.htm";
                break;

        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}