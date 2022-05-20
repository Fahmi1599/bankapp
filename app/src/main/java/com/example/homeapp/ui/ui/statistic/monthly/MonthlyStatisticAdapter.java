package com.example.homeapp.ui.ui.statistic.monthly;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeapp.R;
import com.example.homeapp.ui.data.Statistic;

import java.util.ArrayList;

public class MonthlyStatisticAdapter extends RecyclerView.Adapter<MonthlyStatisticAdapter.MyViewHolder> {

    Context context;
    ArrayList<Statistic.Monthly> monthlyArrayList;


    public MonthlyStatisticAdapter(Context context, ArrayList<Statistic.Monthly> monthlyArrayList) {
    this.context = context;
    this.monthlyArrayList = monthlyArrayList;
    }

    @NonNull
    @Override
    public MonthlyStatisticAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_monthly_card,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthlyStatisticAdapter.MyViewHolder holder, int position) {

        Statistic.Monthly monthly = monthlyArrayList.get(position);

        holder.textView.setText(monthly.getCardNumer());

        if (monthly.getTypeCard().equals("Debet Card")){
            holder.imageView.setImageResource(R.drawable.bg_card_orange);
            holder.layout.setBackgroundResource(R.color.colorAccent);
        }

    }

    @Override
    public int getItemCount() {
        return (monthlyArrayList != null) ? monthlyArrayList.size() : 0;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        LinearLayout layout;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.card_monthly);
            layout = itemView.findViewById(R.id.tag_monthly);
            textView = itemView.findViewById(R.id.numberCard_monthly);

        }
    }

}
