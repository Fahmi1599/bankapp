package com.example.homeapp.ui.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeapp.R;
import com.example.homeapp.ui.data.Transaction;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    Context context;
    ArrayList<Transaction> transactionArrayList;

    public TransactionAdapter(Context context, ArrayList<Transaction> transactionArrayList) {
        this.context = context;
        this.transactionArrayList = transactionArrayList;
    }

    @NonNull
    @Override
    public TransactionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_transaction,parent,false);


        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.MyViewHolder holder, int position) {

        Transaction transaction = transactionArrayList.get(position);
        holder.titleTransaction.setText(transaction.getTitleTransaction());
        holder.desctiption.setText(transaction.getDescription());
        holder.date.setText(transaction.getDateTransaction());
        holder.price.setText(transaction.getPrice());

        if (transaction.getTitleTransaction().equals("Food & Beverages")){
            holder.imageView.setImageResource(R.drawable.ic_baseline_food_bank_24);
        } else if (transaction.getTitleTransaction().equals("Grocery")){
            holder.imageView.setImageResource(R.drawable.ic_baseline_local_grocery_store_24);
        } else if (transaction.getTitleTransaction().equals("Mart")){
            holder.imageView.setImageResource(R.drawable.ic_baseline_local_grocery_store_24);
        } else if (transaction.getTitleTransaction().equals("Transfer")){
            holder.imageView.setImageResource(R.drawable.ic_baseline_monetization_on_24);
        }
//        holder.imageView.setImageResource(transaction.getIconTransaction());


    }

    @Override
    public int getItemCount() {
        return (transactionArrayList != null) ? transactionArrayList.size() : 0;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView;
        TextView titleTransaction, desctiption, price, date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cv_transaction);
            titleTransaction = itemView.findViewById(R.id.titleTransaction);
            desctiption = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.tv_price);
            date = itemView.findViewById(R.id.tv_date);
            imageView = itemView.findViewById(R.id.iv_transaction);
        }
    }
}
