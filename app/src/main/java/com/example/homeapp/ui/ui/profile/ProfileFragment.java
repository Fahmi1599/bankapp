package com.example.homeapp.ui.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.example.homeapp.R;
import com.example.homeapp.ui.ui.base.BaseFragment;

import butterknife.ButterKnife;

public class ProfileFragment extends BaseFragment {

    FragmentManager fragmentManager;

    public ProfileFragment(){
        //to Cosntruct
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ButterKnife.bind(this, view);

        init();

        return view;
    }

    private void init() {
    }
}
