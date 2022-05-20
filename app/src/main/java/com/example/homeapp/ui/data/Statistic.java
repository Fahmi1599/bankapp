package com.example.homeapp.ui.data;

public class Statistic {

    Monthly monthly;

    public Monthly getMonthly() {
        return monthly;
    }


    public static class Monthly{

        String cardNumer;
        String TypeCard;

        public Monthly(String cardNumer, String typeCard) {
            this.cardNumer = cardNumer;
            TypeCard = typeCard;
        }

        public String getCardNumer() {
            return cardNumer;
        }

        public String getTypeCard() {
            return TypeCard;
        }
    }
}
