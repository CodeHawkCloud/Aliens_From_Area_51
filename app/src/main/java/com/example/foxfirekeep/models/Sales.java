package com.example.foxfirekeep.models;

//Sales class

public class Sales {

    private int sales_id;
    private String salesItem;
    private String salesBrand;
    private int salesPrice;
    private int salesQuantity;

    //constructor of the sales class
    public Sales(int sales_id, String salesItem, String salesBrand, int salesPrice, int salesQuantity){

        this.sales_id = sales_id;
        this.salesItem = salesItem;
        this.salesBrand = salesBrand;
        this.salesPrice = salesPrice;
        this.salesQuantity = salesQuantity;
    }

    //getter to get the sales id
    public int getSales_id() {
        return sales_id;
    }

    //getter to get the sales item
    public String getSalesItem() {
        return salesItem;
    }

    //getter to get the sales brand
    public String getSalesBrand() {
        return salesBrand;
    }

    //getter to get the sales price
    public int getSalesPrice() {
        return salesPrice;
    }

    //getter to get the sales quantity
    public int getSalesQuantity() {
        return salesQuantity;
    }

}
