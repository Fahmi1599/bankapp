package com.example.homeapp.ui.ui.home;

import com.example.homeapp.ui.data.Transaction;

import java.util.ArrayList;

public interface HomeFragmentContract {

    interface View{

        void onSuccesGetDataTransaction(ArrayList<Transaction> transactions);
    }
}
