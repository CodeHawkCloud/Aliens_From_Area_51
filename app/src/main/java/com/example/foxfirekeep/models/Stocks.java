package com.example.foxfirekeep.models;

public class Stocks {

    private int stocks_id;
    private String stocksItem;
    private String stockssupplier;
    private int stocksreorder_quantity;
    private int stocksQuantity;

    public Stocks(int stocks_id, String stocksItem, String stockssupplier, int stocksreorder_quantity, int stocksQuantity){

        this.stocks_id = stocks_id;
        this.stocksItem = stocksItem;
        this.stockssupplier = stockssupplier;
        this.stocksreorder_quantity = stocksreorder_quantity;
        this.stocksQuantity = stocksQuantity;
    }

    public int getStocks_id() {
        return stocks_id;
    }

    public String getStocksItem() {
        return stocksItem;
    }


    public String getStocksSupplier() {
        return stockssupplier;
    }

    public int getStocksReorderQuantity() {
        return stocksreorder_quantity;
    }

    public int getStocksQuantity() {
        return stocksQuantity;
    }

}
