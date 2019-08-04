package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);


        Button b1 = (Button)findViewById(R.id.buttonExpen);
        Button b2 = (Button)findViewById(R.id.buttonSale);
        Button b3 = (Button)findViewById(R.id.button_inventory_main);
        Button b4 = (Button)findViewById(R.id.buttonForum);
        Button b5 = (Button)findViewById(R.id.buttonBusi);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(Main_Menu.this,ExpensesCrudMenu.class);
                startActivity(it1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent(Main_Menu.this,SalesCrudMenu.class);
                startActivity(it2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3 = new Intent(Main_Menu.this,inventoryCrudMenu.class);
                startActivity(it3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4 = new Intent(Main_Menu.this,ForumCrudMenu.class);
                startActivity(it4);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it5 = new Intent(Main_Menu.this,MyBusiness.class);
                startActivity(it5);
            }
        });

    }
}

