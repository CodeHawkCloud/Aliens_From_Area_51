package com.example.foxfirekeep.models;

import java.util.Date;

public class Expenses {

    private String type;
    private String month;

    private double amount;

    public Expenses(String type, String month, double amount) {

        this.type = type;
        this.month = month;
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

}
