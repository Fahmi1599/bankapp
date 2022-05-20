package com.example.homeapp.ui.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeapp.R;
import com.example.homeapp.ui.data.Card;
import com.example.homeapp.ui.data.Transaction;
import com.example.homeapp.ui.ui.base.BaseFragment;
import com.example.homeapp.ui.utils.CenterZoomLayoutManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {

    @BindView(R.id.rv_card)
    RecyclerView rv_card;

    ArrayList<Card> cardArrayList;

    CardListAdapter cardListAdapter;

    FragmentManager fragmentManager;

    public HomeFragment(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        init();

        return view;

    }

    private void init() {

        fragmentManager = getFragmentManager();


        addTransactionFragment();


        //Card Adapter//
        addDataCard();
        cardListAdapter = new CardListAdapter(getContext(),cardArrayList);

        rv_card.setLayoutManager(new CenterZoomLayoutManager(getContext(),CenterZoomLayoutManager.HORIZONTAL,false));
        cardArrayList = new ArrayList<Card>();
        rv_card.setAdapter(cardListAdapter);

    }

    private void addTransactionFragment() {
        FragmentTransaction transaction_home = fragmentManager.beginTransaction();
        transaction_home.add(R.id.frameTransaction, new TransactionListFragment());
        transaction_home.commit();
    }

    private void addDataCard() {
        cardArrayList = new ArrayList<>();
        cardArrayList.add(new Card("Fahmi Febriyansyah", " 1111 2222 3333 4444", "07/12","Credit Card"));
        cardArrayList.add(new Card("Fahmi Febriyansyah", " 2222 1111 3333 4444 ", "07/11", "Debet Card"));
    }



    @Override
    public void onSuccesGetDataTransaction(ArrayList<Transaction> transactions) {

    }
}