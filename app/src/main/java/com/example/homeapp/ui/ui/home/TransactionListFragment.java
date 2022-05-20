package com.example.homeapp.ui.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeapp.R;
import com.example.homeapp.ui.data.Transaction;
import com.example.homeapp.ui.ui.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransactionListFragment extends BaseFragment implements HomeFragmentContract.View {

   @BindView(R.id.rv_transaction_home)
   RecyclerView transactionHome_rv;

    ArrayList<Transaction> transactionArrayList;

    TransactionAdapter transactionAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_transactionlist, container, false);

        ButterKnife.bind(this, view);

        init();

        return view;

    }

    private void init() {
        addDataTransaction();
        transactionAdapter = new TransactionAdapter(getContext(),transactionArrayList);

        transactionHome_rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        transactionArrayList = new ArrayList<Transaction>();
        transactionHome_rv.setAdapter(transactionAdapter);

    }

    private void addDataTransaction() {
        transactionArrayList = new ArrayList<>();
        transactionArrayList.add(new Transaction("Food & Beverages","Martabak Keju","-50 k","9 Oct"));
        transactionArrayList.add(new Transaction("Grocery","Perlengkapan Bulanan","-1 jt","10 Oct"));
        transactionArrayList.add(new Transaction("Mart","Peralatan Mandi","-100 k","11 Oct"));
        transactionArrayList.add(new Transaction("Transfer","Uang Jajan Adik", "-3 jt","12 Oct"));
    }

    @Override
    public void onSuccesGetDataTransaction(ArrayList<Transaction> transactions) {
        hideKeyboard();

        transactionArrayList = transactions;


        transactionHome_rv.setAdapter(new TransactionAdapter(getContext(),transactions));
    }
}
