package com.example.foxfirekeep.models;


public class Expenses {
    private int id;
    private String type;
    private String month;

    private int amount;

    public Expenses(int id,String type, String month, int amount) {
        this.id = id;
        this.type = type;
        this.month = month;
        this.amount = amount;
    }

    public int getId(){
        return id;
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
