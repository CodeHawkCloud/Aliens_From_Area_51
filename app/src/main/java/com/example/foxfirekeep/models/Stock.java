package com.example.foxfirekeep.models;

public class Stock {

    private int stock_id;
    private String stockItem;
    private String stocksupplier;
    private int stockreorder_quantity;
    private int stockQuantity;

    public Stock(int stock_id, String stockItem, String stocksupplier, int stockreorder_quantity, int stockQuantity){

        this.stock_id = stock_id;
        this.stockItem = stockItem;
        this.stocksupplier = stocksupplier;
        this.stockreorder_quantity = stockreorder_quantity;
        this.stockQuantity = stockQuantity;
    }

    public int getSales_id() {
        return stock_id;
    }

    public String getSalesItem() {
        return stockItem;
    }


    public String getSalesBrand() {
        return stocksupplier;
    }

    public int getSalesPrice() {
        return stockreorder_quantity;
    }

    public int getSalesQuantity() {
        return stockQuantity;
    }

}
