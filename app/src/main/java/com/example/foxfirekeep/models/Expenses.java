package com.example.foxfirekeep.models;

import java.util.Date;

public class Expenses {

    private String type;
    private Date date;
    private double amount;

    public Expenses(int expenses_id, String type, Date date, double amount) {

        this.type = type;
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }


    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

}
