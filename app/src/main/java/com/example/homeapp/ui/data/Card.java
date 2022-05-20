package com.example.homeapp.ui.data;

public class Card {

    String name;
    String NumberCard;
    String Date;
    String typeCard;

    public Card(String name, String numberCard, String date,String typeCard) {
        this.name = name;
        this.NumberCard = numberCard;
        this.Date = date;
        this.typeCard = typeCard;

    }

    public String getName() {
        return name;
    }

    public String getNumberCard() {
        return NumberCard;
    }

    public String getDate() {
        return Date;
    }

    public String getTypeCard() {
        return typeCard;
    }
}
