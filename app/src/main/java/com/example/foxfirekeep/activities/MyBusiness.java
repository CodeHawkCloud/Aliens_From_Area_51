package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.database.DBHandler;
import com.example.foxfirekeep.models.Expenses;
import com.example.foxfirekeep.models.Forums;
import com.example.foxfirekeep.models.Sales;
import com.example.foxfirekeep.models.Stocks;

import java.util.List;

public class MyBusiness extends AppCompatActivity {
    ImageView home1;
    DBHandler dbHandler;
    boolean clearRes;
    Toast toast;
    AlertDialog.Builder alertBuilder;
    AlertDialog alertMyBusiness;
    int totProfit;

    //variables to be used to get the total sales
    List<Sales> sales;
    Sales saleModel;
    int tempSalesPrice;
    int tempSalesQuantity;
    int tempSalesMultiply;
    int totSaleValue = 0;
    TextView salesTv;

    //variables to be used to get the total expenditure
    List<Expenses> expenses;
    Expenses expenseModel;
    int tempExpense;
    int totExpenses = 0;
    TextView expensesTv;

    //variables to be used to get the total quantity
    List<Stocks> stocks;
    Stocks stockModel;
    int tempInventoryQuantity;
    int totStocks = 0;
    TextView stocksTv;

    //variables to be used to get the comments in the forum
    List<Forums> forums;
    int commentCount = 0;
    TextView forumTv;

    //Notification variables
    private final String CHANNEL_ID = "data_reset_notification";
    private final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_business);

        home1 = (ImageView)findViewById(R.id.buton_home);

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(MyBusiness.this,Main_Menu.class);
                startActivity(it1);
            }
        });

        dbHandler = new DBHandler(this);

        /*------------------ Displaying the total sale value [start] ------------------------*/

        sales = dbHandler.readAllSales();

        if(sales.size() != 0) {
            for (int i = 0; i < sales.size(); i++) {
                saleModel = sales.get(i);
                tempSalesPrice = saleModel.getSalesPrice();
                tempSalesQuantity = saleModel.getSalesQuantity();

                tempSalesMultiply = tempSalesPrice * tempSalesQuantity;
                totSaleValue = totSaleValue + tempSalesMultiply;
            }
        }else{
            totSaleValue = 0;
        }

        salesTv = (TextView)findViewById(R.id.text_mybusiness_res_totsales);
        salesTv.setText(String.valueOf(totSaleValue));

        /*------------------ Displaying the total sale value [end] ------------------------*/

        /*------------------ Displaying the total expenditure [start] ---------------------*/

        expenses = dbHandler.readAllExpenditure();

        if(expenses.size() != 0){
            for(int i = 0; i < expenses.size(); i++){
                expenseModel = expenses.get(i);
                tempExpense = expenseModel.getAmount();

                totExpenses = totExpenses + tempExpense;
            }
        }else{
            totExpenses = 0;
        }

        expensesTv = (TextView) findViewById(R.id.text_mybusiness_res_totexpen);
        expensesTv.setText(String.valueOf(totExpenses));

        /*------------------ Displaying the total expenditure [end] -----------------------*/

        /*------------------ Displaying the total stock quantity [start] ------------------*/

        stocks = dbHandler.readAllStocks();

        if(stocks.size() != 0){
            for(int i = 0; i < stocks.size(); i++){
                stockModel = stocks.get(i);
                tempInventoryQuantity = stockModel.getStocksQuantity();
                totStocks = totStocks + tempInventoryQuantity;
            }
        }else{
            totStocks = 0;
        }

        stocksTv = (TextView)findViewById(R.id.text_mybusiness_res_totstocks);
        stocksTv.setText(String.valueOf(totStocks));

        /*------------------ Displaying the total stock quantity [end] ------------------*/

        /*------------------ Displaying the total comments [start] ----------------------*/

        forums = dbHandler.readForum();

        if(forums.size() != 0){
            commentCount = forums.size();
        }else{
            commentCount = 0;
        }

        forumTv = (TextView)findViewById(R.id.text_mybusiness_res_totcoms);
        forumTv.setText(String.valueOf(commentCount));

        /*------------------ Displaying the total comments [end] ------------------------*/

        //calculation of the total profit
        totProfit = totSaleValue - totExpenses;

        //creation of a notification
        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_event_note_black_24dp);
        builder.setContentTitle("My Business");
        builder.setContentText("You have an approximate profit of "+ String.valueOf(totProfit) +"!");
        builder.setVibrate(new long[]{0,100,200,300,400});
        builder.setLights(Color.RED, 1000, 1000);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }



    public void onClick(View view){

        //alert to make sure that the user does not accidently reset all data
        alertBuilder = new AlertDialog.Builder(this);

        //setting the title of the alert and message
        alertBuilder.setTitle("Reset all data!");
        alertBuilder.setMessage("Are you sure you want to reset FoxFireKeep?");

        //if user presses yes
        alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                clearRes = ((ActivityManager)getSystemService(ACTIVITY_SERVICE)).clearApplicationUserData();
            }
        });

        //if user presses no - do nothing
        alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        alertMyBusiness = alertBuilder.create();
        alertMyBusiness.show();

    }

    //notification if the api is greater than or equal to O
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "data_reset_notification";
            String description = "Notification for data reset";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{0,100,200,300,400});

            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
