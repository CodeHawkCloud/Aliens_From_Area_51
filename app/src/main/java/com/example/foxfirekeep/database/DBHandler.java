package com.example.foxfirekeep.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
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

        //Expenditure table  creation [END]

        /*-----------------------------------------------------------------------------------------*/

        //Stock table creation [START]

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
    public void addSale(String pItemName, String pBrand, int pPrice, int pQuantity){

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
        List salesList = new ArrayList();

        while(cursor.moveToNext()){
            int cId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales._ID));
            String cItemName = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales.COLUMN_NAME_ITEM));
            String cBrand = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales.COLUMN_NAME_BRAND));
            int cPrice = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales.COLUMN_NAME_PRICE));
            int cQuantity = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Sales.COLUMN_NAME_QUANTITY));

            //add the retrieved sales information into the list
            salesList.add(cId);
            salesList.add(cItemName);
            salesList.add(cBrand);
            salesList.add(cPrice);
            salesList.add(cQuantity);

        }

        cursor.close();

        return salesList;
    }

    //updateSales() method to update the sales
    public void updateSales(int pId,String pItemName, String pBrand, int pPrice, int pQuantity){

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
        String[] selectionArg = {String.valueOf(pId)};

        //db query to update
        int success = db.update(DatabaseMaster.Sales.TABLE_NAME,
                                values,
                                selection,
                                selectionArg
                );
    }

    //deleteSale() method to delete the sale
    public void deleteSale(int pId){

        //get readable mode
        SQLiteDatabase db = getReadableDatabase();

        //selection
        String selection = DatabaseMaster.Sales.TABLE_NAME + " LIKE ?";

        //Argument
        String[] selectionArg = {String.valueOf(pId)};

        //query to delete a sale
        int success = db.delete(DatabaseMaster.Sales.TABLE_NAME,
                                selection,
                                selectionArg
                );
    }

    /*Sql methods of the sales component [END]*/

    /*-----------------------------------------------------------------------------------------*/

    /*Sql methods of the expenditure component [START]*/

    //addExpenditure() method to add an expenditure
    public void addExpenditure(){

    }

    //readAllExpenditure() method to get all the expenses
    public List readAllExpenditure() {

        /*erase this..used to avoid the return error*/
        List l1 =new ArrayList<>();
        return l1;
    }

    //updateExpenditure() method to update the expenditure
    public void updateExpenditure(){

    }

    //deleteExpenditure() method to delete the expenditure
    public void deleteExpenditure(){

    }

    /*Sql methods of the expenditure component [END]*/

    /*-----------------------------------------------------------------------------------------*/

    /*Sql methods of the stock component [START]*/

    //addStock() method to add a stock
    public void addStock(){

    }

    //readAllStocks() method to get all the stocks
    public List readAlSstocks() {

        /*erase this..used to avoid the return error*/
        List l1 =new ArrayList<>();
        return l1;
    }

    //updateExpenditure() method to update the expenditure
    public void updatestock(){

    }

    //deleteStock() method to delete the stock
    public void deleteStock(){

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
