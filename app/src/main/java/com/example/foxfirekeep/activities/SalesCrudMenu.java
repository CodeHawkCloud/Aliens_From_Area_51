package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foxfirekeep.activities.R;

public class SalesCrudMenu extends AppCompatActivity {
    private ImageView home1;
    private ImageView in;
    private ImageView up;
    private ImageView del;
    private ImageView vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_crud_menu);

        home1 = (ImageView)findViewById(R.id.button_home);
        in = (ImageView)findViewById(R.id.button_crud_insert);
        up = (ImageView)findViewById(R.id.button_crud_update);
        del = (ImageView)findViewById(R.id.button_crud_delete);
        vi = (ImageView)findViewById(R.id.button_crud_view);

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
                Intent it5 = new Intent(SalesCrudMenu.this,SalesView.class);
                startActivity(it5);
            }
        });
    }
}
