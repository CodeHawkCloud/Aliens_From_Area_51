package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.adapters.SalesAdapter;
import com.example.foxfirekeep.adapters.StocksAdapter;
import com.example.foxfirekeep.database.DBHandler;
import com.example.foxfirekeep.models.Sales;
import com.example.foxfirekeep.models.Stocks;

import java.util.ArrayList;
import java.util.List;

public class StocksView extends AppCompatActivity {
    ImageView back;
    DBHandler dbHandler;
    List<Stocks> stockList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks_view);

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(StocksView.this,inventoryCrudMenu.class);
                startActivity(it1);
            }
        });

        ListView listView = (ListView)findViewById(R.id.stocks_list_view);

        dbHandler = new DBHandler(this);

        stockList = dbHandler.readAllStocks();

        StocksAdapter stocksAdapter = new StocksAdapter(this,R.layout.adapter_stocks_view,stockList);
        listView.setAdapter(stocksAdapter);



    }
}
