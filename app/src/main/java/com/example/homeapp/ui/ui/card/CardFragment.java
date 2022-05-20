package com.example.homeapp.ui.ui.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.homeapp.R;
import com.example.homeapp.ui.ui.base.BaseFragment;

import butterknife.ButterKnife;

public class CardFragment extends BaseFragment {


    public CardFragment(){
        //to construct
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        ButterKnife.bind(this, view);

        init();

        return view;
    }

    private void init() {
    }
}