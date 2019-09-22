package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.database.DBHandler;
import com.example.foxfirekeep.models.Sales;

import java.util.ArrayList;
import java.util.List;

public class SalesCrudMenu extends AppCompatActivity {
    ImageView home1;
    ImageView in;
    ImageView up;
    ImageView del;
    ImageView vi;
    DBHandler dbhandler;
    List<Sales> list;
    Toast t; //Toast creation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_crud_menu);

        home1 = (ImageView)findViewById(R.id.button_home);
        in = (ImageView)findViewById(R.id.button_crud_insert);
        up = (ImageView)findViewById(R.id.button_crud_update);
        del = (ImageView)findViewById(R.id.button_crud_delete);
        vi = (ImageView)findViewById(R.id.button_crud_view);

        dbhandler = new DBHandler(this);

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(SalesCrudMenu.this,Main_Menu.class);
                startActivity(it1);
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent(SalesCrudMenu.this,SalesInsert.class);
                startActivity(it2);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3 = new Intent(SalesCrudMenu.this,SalesUpdate.class);
                startActivity(it3);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4 = new Intent(SalesCrudMenu.this,SalesDelete.class);
                startActivity(it4);
            }
        });

        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                list = dbhandler.readAllSales();

                //check if there  is data to be viewed, if yes go to the view activity else display toast
                if(!list.isEmpty()){
                    Intent it5 = new Intent(SalesCrudMenu.this,SalesView.class);
                    startActivity(it5);
                }
                else{
                    t = Toast.makeText(getApplicationContext(),"No sales to be viewed!", Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });
    }
}
