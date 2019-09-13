package com.example.foxfirekeep.database;

import android.provider.BaseColumns;

public class DatabaseMaster {

    //default constructor
    private DatabaseMaster(){}

    //inner class-Sales table
    public static class Sales implements BaseColumns{
        public static final String TABLE_NAME = "sales";
        public static final String COLUMN_NAME_ITEM = "item";
        public static final String COLUMN_NAME_BRAND = "brand";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
    }

    //inner class-Stock table
    public static class Stocks implements BaseColumns{
        public static final String TABLE_NAME = "stocks";
        public static final String COLUMN_NAME_ITEM = "item";
        public static final String COLUMN_NAME_SUPPLIER = "supplier";
        public static final String COLUMN_NAME_REORDERQUANTITY = "reorder_quantity";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
    }

    //inner class-Expenses table
    public static class Expenses implements BaseColumns{
        public static final String TABLE_NAME = "expenses";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_MONTH = "month";
        public static final String COLUMN_NAME_AMOUNT = "amount";
    }
}
