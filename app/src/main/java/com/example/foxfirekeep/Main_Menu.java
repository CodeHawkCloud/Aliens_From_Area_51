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
        setContentView(R.layout.activity_main_menu);


        Button expenditureButton = (Button)findViewById(R.id.button_mainmenu_expenditure);
        Button salesButton = (Button)findViewById(R.id.button_mainmenu_sales);
        Button stocksButton = (Button)findViewById(R.id.button_mainmenu_stocks);
        Button forumButton = (Button)findViewById(R.id.button_mainmenu_forum);
        Button mybusinessButton = (Button)findViewById(R.id.button_mainmenu_mybusiness);

        expenditureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(Main_Menu.this,ExpensesCrudMenu.class);
                startActivity(it1);
            }
        });

        salesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent(Main_Menu.this,SalesCrudMenu.class);
                startActivity(it2);
            }
        });

        stocksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3 = new Intent(Main_Menu.this,inventoryCrudMenu.class);
                startActivity(it3);
            }
        });

        forumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4 = new Intent(Main_Menu.this,ForumCrudMenu.class);
                startActivity(it4);
            }
        });

        mybusinessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it5 = new Intent(Main_Menu.this,MyBusiness.class);
                startActivity(it5);
            }
        });

    }
}

