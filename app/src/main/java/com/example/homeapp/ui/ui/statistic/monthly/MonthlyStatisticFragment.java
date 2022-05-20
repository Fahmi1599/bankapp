package com.example.homeapp.ui.ui.statistic.monthly;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.recyclerview.widget.RecyclerView;

import com.example.homeapp.R;
import com.example.homeapp.ui.data.Statistic;
import com.example.homeapp.ui.ui.base.BaseFragment;
import com.example.homeapp.ui.utils.CenterZoomLayoutManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MonthlyStatisticFragment extends BaseFragment {

    @BindView(R.id.list_card_rv)
    RecyclerView listCardRv;

    ArrayList<Statistic.Monthly> monthlyArrayList;

    MonthlyStatisticAdapter monthlyStatisticAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistic_monthly, container, false);

        ButterKnife.bind(this, view);

        init();
        return view;
}

    private void init() {

        addDataCardMonthly();
        monthlyStatisticAdapter = new MonthlyStatisticAdapter(getContext(),monthlyArrayList);
        monthlyArrayList = new ArrayList<Statistic.Monthly>();
        listCardRv.setLayoutManager(new CenterZoomLayoutManager(getContext(),CenterZoomLayoutManager.HORIZONTAL,false));
        listCardRv.setAdapter(monthlyStatisticAdapter);
    }

    private void addDataCardMonthly() {

        monthlyArrayList = new ArrayList<>();
        monthlyArrayList.add(new Statistic.Monthly("1111 2222 3333 4444", "Credit Card"));
        monthlyArrayList.add(new Statistic.Monthly("2222 1111 3333 4444","Debet Card"));

    }
}