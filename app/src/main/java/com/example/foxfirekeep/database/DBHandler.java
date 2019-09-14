package com.example.foxfirekeep.database;

import com.example.foxfirekeep.models.Expenses;
import com.example.foxfirekeep.models.Sales;
import com.example.foxfirekeep.models.Stocks;
import com.example.foxfirekeep.models.Forums;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLData;
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



        //Forums table creation [START]
        String Forums_TABLE_CREATE = "CREATE TABLE " + DatabaseMaster.Forums.TABLE_NAME + " (" +
                DatabaseMaster.Forums.COLUMN_NAME_ID + "  INTEGER PRIMARY KEY," +
                DatabaseMaster.Forums.COLUMN_NAME_USERNAME + " TEXT," +
                DatabaseMaster.Forums.COLUMN_NAME_ROLE + " TEXT," +
                DatabaseMaster.Forums.COLUMN_NAME_COMMENT + " TEXT)";
        //execution of the sql statement
        db.execSQL(Forums_TABLE_CREATE);
        //Formus table creation [END]

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
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {DatabaseMaster.Expenses._ID,
                                DatabaseMaster.Expenses.COLUMN_NAME_TYPE,
                                DatabaseMaster.Expenses.COLUMN_NAME_MONTH,
                                DatabaseMaster.Expenses.COLUMN_NAME_AMOUNT
        };

        Cursor cursor = db.query(
                DatabaseMaster.Expenses.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<Expenses> expensesList = new ArrayList<>();

        while(cursor.moveToNext()){
            int cId = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Expenses._ID));
            String cType = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseMaster.Expenses.COLUMN_NAME_TYPE));
            String cMonth = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseMaster.Expenses.COLUMN_NAME_MONTH));
            int cAmount = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseMaster.Expenses.COLUMN_NAME_AMOUNT));

            Expenses expense = new Expenses(cId,cType,cMonth,cAmount);
            expensesList.add(expense);
        }

        cursor.close();

        return  expensesList;
    }

    //updateExpenditure() method to update the expenditure
    public boolean updateExpenses(int eId,String type,String month, int amount){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues value = new ContentValues();
        value.put(DatabaseMaster.Expenses.COLUMN_NAME_TYPE,type);
        value.put(DatabaseMaster.Expenses.COLUMN_NAME_MONTH,month);
        value.put(DatabaseMaster.Expenses.COLUMN_NAME_AMOUNT,amount);

        String selection = DatabaseMaster.Expenses._ID + " LIKE ?";
        String [] selectionArg = new String[]{String.valueOf(eId)};

        int success = db.update(DatabaseMaster.Expenses.TABLE_NAME,
                                value,
                                selection,
                                selectionArg
            );

        if (success == 0)
            return false;
        else
            return true;
    }

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

    //updateStocks() method to update the stocks
    public boolean updateStocks(int pId,String pItemName, String pSupplier, int pReorder_Quantity, int pQuantity){

        //get readable mode
        SQLiteDatabase db = getReadableDatabase();

        //creation of a map of values to have the new values
        ContentValues values = new ContentValues();

        values.put(DatabaseMaster.Stocks.COLUMN_NAME_ITEM,pItemName);
        values.put(DatabaseMaster.Stocks.COLUMN_NAME_SUPPLIER,pSupplier);
        values.put(DatabaseMaster.Stocks.COLUMN_NAME_REORDERQUANTITY,pReorder_Quantity);
        values.put(DatabaseMaster.Stocks.COLUMN_NAME_QUANTITY,pQuantity);

        //selection
        String selection = DatabaseMaster.Stocks._ID + " LIKE ?";
        String[] selectionArg = new String[] {String.valueOf(pId)};

        //db query to update
        int success = db.update(DatabaseMaster.Stocks.TABLE_NAME,
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



    //deleteStocks() method to delete the stock
    public boolean deleteStocks(int pId){

        //get readable mode
        SQLiteDatabase db = getReadableDatabase();

        //selection
        String selection = DatabaseMaster.Stocks._ID + " LIKE ?";

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
    public boolean addForum(int fid, String fusername, String frole, String fcomment){

        //get write mode
        SQLiteDatabase db = getWritableDatabase();

        //creation of a map of values
        ContentValues values = new ContentValues();

        values.put(DatabaseMaster.Forums.COLUMN_NAME_ID,fid);
        values.put(DatabaseMaster.Forums.COLUMN_NAME_USERNAME,fusername);
        values.put(DatabaseMaster.Forums.COLUMN_NAME_ROLE,frole);
        values.put(DatabaseMaster.Forums.COLUMN_NAME_COMMENT,fcomment);

        //returns the primary key after a successful insertion
        long newID = db.insert(DatabaseMaster.Forums.TABLE_NAME,null,values);

        if(newID == -1){
            return false;
        }
        else{
            return true;
        }
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
