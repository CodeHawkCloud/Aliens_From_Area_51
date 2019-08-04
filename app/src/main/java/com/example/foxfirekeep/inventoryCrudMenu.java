package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class inventoryCrudMenu extends AppCompatActivity {

     private ImageView home1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_crud_menu);

        home1 = (ImageView)findViewById(R.id.home);

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(inventoryCrudMenu.this,Main_Menu.class);
                startActivity(it1);
            }
        });
    }
}
