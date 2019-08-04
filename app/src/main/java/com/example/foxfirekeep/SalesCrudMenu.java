package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

        home1 = (ImageView)findViewById(R.id.home);
        in = (ImageView)findViewById(R.id.imageView18);
        up = (ImageView)findViewById(R.id.imageView25);
        del = (ImageView)findViewById(R.id.imageView22);
        vi = (ImageView)findViewById(R.id.imageView24);

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
