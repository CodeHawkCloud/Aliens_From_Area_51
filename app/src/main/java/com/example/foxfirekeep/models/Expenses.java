package com.example.foxfirekeep.models;


public class Expenses {

    private String type;
    private String month;

    private int amount;

    public Expenses(String type, String month, int amount) {

        this.type = type;
        this.month = month;
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

}
