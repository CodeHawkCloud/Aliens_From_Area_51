package com.example.foxfirekeep.models;

public class Sales {

    private int sales_id;
    private String salesItem;
    private String salesBrand;
    private int salesPrice;
    private int salesQuantity;

    public Sales(int sales_id, String salesItem, String salesBrand, int salesPrice, int salesQuantity){

        this.sales_id = sales_id;
        this.salesItem = salesItem;
        this.salesBrand = salesBrand;
        this.salesPrice = salesPrice;
        this.salesQuantity = salesQuantity;
    }

    public int getSales_id() {
        return sales_id;
    }

    public String getSalesItem() {
        return salesItem;
    }


    public String getSalesBrand() {
        return salesBrand;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

}
