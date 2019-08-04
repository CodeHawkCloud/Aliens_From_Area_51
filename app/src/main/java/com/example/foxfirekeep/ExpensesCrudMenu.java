package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ExpensesCrudMenu extends AppCompatActivity {
    private ImageView home1;
    private ImageView in;
    private ImageView up;
    private ImageView del;
    private ImageView vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_crud_menu);

        home1 = (ImageView)findViewById(R.id.home);
        in = (ImageView)findViewById(R.id.imageView18);
        up = (ImageView)findViewById(R.id.imageView25);
        del = (ImageView)findViewById(R.id.imageView22);
        vi = (ImageView)findViewById(R.id.imageView24);

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(ExpensesCrudMenu.this,Main_Menu.class);
                startActivity(it1);
            }
        });

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent(ExpensesCrudMenu.this,ExpensesAdd.class);
                startActivity(it2);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3 = new Intent(ExpensesCrudMenu.this,ExpensesUpdate.class);
                startActivity(it3);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4 = new Intent(ExpensesCrudMenu.this,ExpensesDelete.class);
                startActivity(it4);
            }
        });

        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it5 = new Intent(ExpensesCrudMenu.this,ExpensesView.class);
                startActivity(it5);
            }
        });
    }
}
