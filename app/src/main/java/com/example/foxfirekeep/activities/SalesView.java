package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.adapters.SalesAdapter;
import com.example.foxfirekeep.database.DBHandler;
import com.example.foxfirekeep.models.Sales;

import java.util.List;

public class SalesView extends AppCompatActivity {
    ImageView back;
    DBHandler dbHandler;
    List<Sales> salesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_view);

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(SalesView.this,SalesCrudMenu.class);
                startActivity(it1);
            }
        });

        ListView listView = (ListView)findViewById(R.id.sales_list_view);

        dbHandler = new DBHandler(this);

        salesList = dbHandler.readAllSales();

        //call the sales adapter class
        SalesAdapter salesAdapter = new SalesAdapter(this,R.layout.adpater_sales_view,salesList);
        listView.setAdapter(salesAdapter);



    }
}
