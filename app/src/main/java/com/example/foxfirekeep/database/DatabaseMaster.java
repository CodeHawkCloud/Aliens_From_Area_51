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

}
