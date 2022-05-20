package com.example.homeapp.ui.ui.statistic.weekly;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeapp.R;
import com.example.homeapp.ui.ui.base.BaseFragment;

import butterknife.ButterKnife;

public class WeeklyStatisticFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_statistic_weekly, container, false);

        ButterKnife.bind(this, view);



        return view;
    }
}
