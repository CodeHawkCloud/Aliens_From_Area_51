package com.example.foxfirekeep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ExpensesUpdate extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_update);

        back = (ImageView)findViewById(R.id.imageView17);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(ExpensesUpdate.this,ExpensesCrudMenu.class);
                startActivity(it1);
            }
        });
    }
}
