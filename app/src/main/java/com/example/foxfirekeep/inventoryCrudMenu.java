package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class inventoryCrudMenu extends AppCompatActivity {

     private ImageView home1;
     private ImageView in;
     private ImageView up;
     private ImageView del;
     private ImageView vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_crud_menu);

        home1 = (ImageView)findViewById(R.id.btnHome);
        in = (ImageView)findViewById(R.id.btnInsrt);
        up = (ImageView)findViewById(R.id.btnUpd);
        del = (ImageView)findViewById(R.id.btnDel);
        vi = (ImageView)findViewById(R.id.btnViw);

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(inventoryCrudMenu.this,Main_Menu.class);
                startActivity(it1);
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent(inventoryCrudMenu.this,StocksAdd.class);
                startActivity(it2);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3 = new Intent(inventoryCrudMenu.this,StocksUpdate.class);
                startActivity(it3);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4 = new Intent(inventoryCrudMenu.this,StocksDelete.class);
                startActivity(it4);
            }
        });

        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it5 = new Intent(inventoryCrudMenu.this,StocksView.class);
                startActivity(it5);
            }
        });
    }
}
