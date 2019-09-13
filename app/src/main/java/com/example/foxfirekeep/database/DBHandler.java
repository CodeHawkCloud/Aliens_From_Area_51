package com.example.foxfirekeep.database;

import com.example.foxfirekeep.models.Sales;
import com.example.foxfirekeep.models.Stocks;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "foxfire.db";

    //constructor
    public DBHandler(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    //creation of the tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        /*-----------------------------------------------------------------------------------------*/

        //Sales table creation [START]
        String SALES_TABLE_CREATE = "CREATE TABLE " + DatabaseMaster.Sales.TABLE_NAME + " (" +
                                     DatabaseMaster.Sales._ID + " INTEGER PRIMARY KEY," +
                                     DatabaseMaster.Sales.COLUMN_NAME_ITEM + " TEXT," +
                                     DatabaseMaster.Sales.COLUMN_NAME_BRAND + " TEXT," +
                                     DatabaseMaster.Sales.COLUMN_NAME_PRICE + " INTEGER," +
                                     DatabaseMaster.Sales.COLUMN_NAME_QUANTITY + " INTEGER)";
        //execution of the sql statement
        db.execSQL(SALES_TABLE_CREATE);
        //Sales table creation [END]

        /*-----------------------------------------------------------------------------------------*/

        //Expenditure table creation [START]
        String Expenses_TABLE_CREATION = "CREATE TABLE " + DatabaseMaster.Expenses.TABLE_NAME + " (" +
                DatabaseMaster.Expenses._ID + " INTEGER PRIMARY KEY, " +
                DatabaseMaster.Expenses.COLUMN_NAME_TYPE + " TEXT," +
                DatabaseMaster.Expenses.COLUMN_NAME_MONTH + " TEXT," +
                DatabaseMaster.Expenses.COLUMN_NAME_AMOUNT + " INTEGER)";
        //Execution of SQL statement
        db.execSQL(Expenses_TABLE_CREATION);
        //Expenditure table  creation [END]

        /*-----------------------------------------------------------------------------------------*/

        //Stock table creation [START]

        String STOCKS_TABLE_CREATE = "CREATE TABLE " + DatabaseMaster.Stocks.TABLE_NAME + " (" +
                DatabaseMaster.Stocks._ID + " INTEGER PRIMARY KEY," +
                DatabaseMaster.Stocks.COLUMN_NAME_ITEM + " TEXT," +
                DatabaseMaster.Stocks.COLUMN_NAME_SUPPLIER + " TEXT," +
                DatabaseMaster.Stocks.COLUMN_NAME_REORDERQUANTITY + " INTEGER," +
                DatabaseMaster.Stocks.COLUMN_NAME_QUANTITY + " INTEGER)";
        //execution of the sql statement
        db.execSQL(STOCKS_TABLE_CREATE);

        //Stock table creation [END]

        /*-----------------------------------------------------------------------------------------*/

        //Forum table creation [START]

        //Forum table creation [END]

        /*-----------------------------------------------------------------------------------------*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    /*-----------------------------------------------------------------------------------------*/

    /*Sql methods of the sales component [START]*/

    //addSale() method to add a sale
    public boolean addSale(String pItemName, String pBrand, int pPrice, int pQuantity){

        //get write mode
        SQLiteDatabase db = getWritableDatabase();

        //creation of a map of values
        ContentValues values = new ContentValues();

        values.put(DatabaseMaster.Sales.COLUMN_NAME_ITEM,pItemName);
        values.put(DatabaseMaster.Sales.COLUMN_NAME_BRAND,pBrand);
        values.put(DatabaseMaster.Sales.COLUMN_NAME_PRICE,pPrice);
        values.put(DatabaseMaster.Sales.COLUMN_NAME_QUANTITY,pQuantity);

        //returns the primary key after a successful insertion
        long newID = db.insert(DatabaseMaster.Sales.TABLE_NAME,null,values);

        if(newID == -1){
            return false;
        }
        else{
            return true;
        }
    }

    //readAllSales() method to get all the sales
    public List readAllSales(){

        //get readable mode
        SQLiteDatabase db = getReadableDatabase();

        //projection
        String[] projection = {DatabaseMaster.Sales._ID,
                               DatabaseMaster.Sales.COLUMN_NAME_ITEM,
                               DatabaseMaster.Sales.COLUMN_NAME_BRAND,
                               DatabaseMaster.Sales.COLUMN_NAME_PRICE,
                               DatabaseMaster.Sales.COLUMN_NAME_QUANTITY
        };

        //database query which returns a cursor object
        Cursor cursor = db.query(
                DatabaseMaster.Sales.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );

        //list declarations
        List<Sales> salesList = new ArrayList<>();

        while(cursor.moveToNext()){

            int cId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales._ID));
            String cItemName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales.COLUMN_NAME_ITEM));
            String cBrand = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales.COLUMN_NAME_BRAND));
            int cPrice = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales.COLUMN_NAME_PRICE));
            int cQuantity = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales.COLUMN_NAME_QUANTITY));

            //add the retrieved sales information into the product class using the overloaded constructor
            Sales sales = new Sales(cId, cItemName, cBrand, cPrice, cQuantity);
            salesList.add(sales);
        }

        cursor.close();

        return salesList;
    }

    //updateSales() method to update the sales
    public boolean updateSales(int pId,String pItemName, String pBrand, int pPrice, int pQuantity){

        //get readable mode
        SQLiteDatabase db = getReadableDatabase();

        //creation of a map of values to have the new values
        ContentValues values = new ContentValues();

        values.put(DatabaseMaster.Sales.COLUMN_NAME_ITEM,pItemName);
        values.put(DatabaseMaster.Sales.COLUMN_NAME_BRAND,pBrand);
        values.put(DatabaseMaster.Sales.COLUMN_NAME_PRICE,pPrice);
        values.put(DatabaseMaster.Sales.COLUMN_NAME_QUANTITY,pQuantity);

        //selection
        String selection = DatabaseMaster.Sales._ID + " LIKE ?";
        String[] selectionArg = new String[] {String.valueOf(pId)};

        //db query to update
        int success = db.update(DatabaseMaster.Sales.TABLE_NAME,
                                values,
                                selection,
                                selectionArg
                );

        if(success == 0){
            return false;
        }
        else{
            return true;
        }
    }

    //deleteSale() method to delete the sale
    public boolean deleteSale(int pId){

        //get readable mode
        SQLiteDatabase db = getReadableDatabase();

        //selection
        String selection = DatabaseMaster.Sales._ID + " LIKE ?";

        //Argument
        String[] selectionArg = new String[]{String.valueOf(pId)};

        //query to delete a sale
        int success = db.delete(DatabaseMaster.Sales.TABLE_NAME,
                                selection,
                                selectionArg
                );

        if(success == 0){
            return false;
        }
        else{
            return true;
        }
    }

    /*Sql methods of the sales component [END]*/

    /*-----------------------------------------------------------------------------------------*/

    /*Sql methods of the expenditure component [START]*/

    //addExpenditure() method to add an expenditure
    public boolean addExpenditure(String type, String month,int amount){
        SQLiteDatabase db = getWritableDatabase();

        //creation of a map of values
        ContentValues values = new ContentValues();
        values.put(DatabaseMaster.Expenses.COLUMN_NAME_TYPE,type);
        values.put(DatabaseMaster.Expenses.COLUMN_NAME_MONTH,month);
        values.put(DatabaseMaster.Expenses.COLUMN_NAME_AMOUNT,amount);

        //returns the primary key after a successful insertion
        long ID = db.insert(DatabaseMaster.Expenses.TABLE_NAME,null,values);

        //return whether new entry entered successfully or not
        if (ID == -1)
            return false;
        else
            return true;
    }

    //readAllExpenditure() method to get all the expenses
    public List readAllExpenditure() {

        /*erase this..used to avoid the return error*/
        List l1 =new ArrayList<>();
        return l1;
    }

    //updateExpenditure() method to update the expenditure


    //deleteExpenditure() method to delete the expenditure
    public boolean deleteExpenditure(int eId){
        SQLiteDatabase db = getReadableDatabase();

        String selection = DatabaseMaster.Expenses._ID + " LIKE ?";

        String[] selectionArg = new String[]{String.valueOf(eId)};

        int success = db.delete(DatabaseMaster.Expenses.TABLE_NAME,selection,selectionArg);

        if(success == 0 )
            return false;
        else
            return true;
    }

    /*Sql methods of the expenditure component [END]*/

    /*-----------------------------------------------------------------------------------------*/

    /*Sql methods of the stock component [START]*/

    //addStock() method to add a stock



        public boolean addStocks(String pItemName, String pSupplier, int pReorder_Quantity, int pQuantity){

            //get write mode
            SQLiteDatabase db = getWritableDatabase();

            //creation of a map of values
            ContentValues values = new ContentValues();

            values.put(DatabaseMaster.Stocks.COLUMN_NAME_ITEM,pItemName);
            values.put(DatabaseMaster.Stocks.COLUMN_NAME_SUPPLIER ,pSupplier);
            values.put(DatabaseMaster.Stocks.COLUMN_NAME_REORDERQUANTITY,pReorder_Quantity);
            values.put(DatabaseMaster.Stocks.COLUMN_NAME_QUANTITY,pQuantity);

            //returns the primary key after a successful insertion
            long newID = db.insert(DatabaseMaster.Stocks.TABLE_NAME,null,values);

            if(newID == -1){
                return false;
            }
            else{
                return true;
            }
        }



    //readAllStocks() method to get all the stocks
    public List readAllStocks(){

        //get readable mode
        SQLiteDatabase db = getReadableDatabase();

        //projection
        String[] projection = {DatabaseMaster.Stocks._ID,
                DatabaseMaster.Stocks.COLUMN_NAME_ITEM,
                DatabaseMaster.Stocks.COLUMN_NAME_SUPPLIER,
                DatabaseMaster.Stocks.COLUMN_NAME_REORDERQUANTITY,
                DatabaseMaster.Stocks.COLUMN_NAME_QUANTITY
        };

        //database query which returns a cursor object
        Cursor cursor = db.query(
                DatabaseMaster.Stocks.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );

        //list declarations
        List<Stocks> stockList = new ArrayList<>();

        while(cursor.moveToNext()){

            int cId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Stocks._ID));
            String cItemName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseMaster.Stocks.COLUMN_NAME_ITEM));
            String cSupplier = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseMaster.Stocks.COLUMN_NAME_SUPPLIER));
            int cReorder_Quantity = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Stocks.COLUMN_NAME_REORDERQUANTITY));
            int cQuantity = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Stocks.COLUMN_NAME_QUANTITY));

            //add the retrieved stocks information into the product class using the overloaded constructor
            Stocks stocks = new Stocks(cId, cItemName, cSupplier, cReorder_Quantity, cQuantity);

            stockList.add(stocks);
        }

        cursor.close();

        return stockList;
    }


    //deleteStocks() method to delete the stock
    public boolean deleteStocks(int pId){

        //get readable mode
        SQLiteDatabase db = getReadableDatabase();

        //selection
        String selection = DatabaseMaster.Stocks.TABLE_NAME + " LIKE ?";

        //Argument
        String[] selectionArg = {String.valueOf(pId)};

        //query to delete a sale
        int success = db.delete(DatabaseMaster.Stocks.TABLE_NAME,
                selection,
                selectionArg
        );

        if(success == -1){
            return false;
        }
        else{
            return true;
        }
    }
    /*Sql methods of the stock component [END]*/

    /*-----------------------------------------------------------------------------------------*/

    /*Sql methods of the forum component [START]*/

    //addForum() method to add a content into the forum
    public void addForum(){

    }

    //readForum() method to get all the forum content
    public List readForum() {

        /*erase this..used to avoid the return error*/
        List l1 =new ArrayList<>();
        return l1;
    }

    //updateForum() method to update the forum
    public void updateForum(){

    }

    //deleteForum() method to delete the forum message and content
    public void deleteForum(){

    }

    /*Sql methods of the forum component [END]*/

    /*-----------------------------------------------------------------------------------------*/

    /*Sql methods of the business component [START]*/

    /*Sql methods of the business component [END]*/

    /*-----------------------------------------------------------------------------------------*/

}
