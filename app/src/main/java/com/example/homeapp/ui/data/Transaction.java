package com.example.homeapp.ui.data;

public class Transaction {

    String titleTransaction;
    String description;
    String price;
    String dateTransaction;

    public Transaction(String titleTransaction, String description, String price, String dateTransaction) {
        this.titleTransaction = titleTransaction;
        this.description = description;
        this.price = price;
        this.dateTransaction = dateTransaction;
    }

    public String getTitleTransaction() {
        return titleTransaction;
    }



    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }
}
