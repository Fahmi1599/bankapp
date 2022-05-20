package com.example.homeapp.ui.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.method.HideReturnsTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeapp.R;
import com.example.homeapp.ui.data.Card;

import java.util.ArrayList;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.MyViewHolder>  {

    Context context;
    ArrayList<Card> cardArrayList;

    private boolean hideNumber = true;

    public CardListAdapter(Context context, ArrayList<Card> cardArrayList) {
        this.context = context;
        this.cardArrayList = cardArrayList;
    }

    @NonNull
    @Override
    public CardListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_card_user,parent,false);

        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull CardListAdapter.MyViewHolder holder, int position) {

        Card card = cardArrayList.get(position);

        holder.cardNumber.setText(card.getNumberCard());
        holder.cardName.setText(card.getName());
        holder.cardDate.setText(card.getDate());

        if (cardArrayList.get(position).getTypeCard().equals("Debet Card")){
            holder.cardColour.setBackgroundResource(R.drawable.bg_card_orange);
            holder.tv_Card.setTextColor(Color.WHITE);
        }


        holder.showNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hideNumber){
                    holder.showNumber.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    holder.cardNumber.setText("**** **** **** ****");
                    hideNumber = false;
                } else {
                    holder.showNumber.setImageResource(R.drawable.ic_baseline_visibility_24);
                    holder.cardNumber.setText(card.getNumberCard());
                    hideNumber = true;
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return (cardArrayList != null) ? cardArrayList.size() : 0;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView cardNumber,cardName,cardDate, tv_Card;
        LinearLayout cardColour;
        ImageView showNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardNumber = itemView.findViewById(R.id.numberCard);
            cardName = itemView.findViewById(R.id.nameUser);
            cardDate = itemView.findViewById(R.id.dateExpired);
            cardColour = itemView.findViewById(R.id.card_colour);
            tv_Card = itemView.findViewById(R.id.tv_card);
            showNumber = itemView.findViewById(R.id.visibilityNumber);
        }
    }
}
