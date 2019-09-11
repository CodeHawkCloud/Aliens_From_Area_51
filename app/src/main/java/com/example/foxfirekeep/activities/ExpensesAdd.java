package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.example.foxfirekeep.models.Expenses;

import java.util.Date;

//import com.example.foxfirekeep.activities.R;

public class ExpensesAdd extends AppCompatActivity {
    String type;
    Date date;
    double amount;

    EditText typeInput;
    EditText dateInput;
    EditText amountInput;

    Expenses expense ;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_insert);

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(ExpensesAdd.this,ExpensesCrudMenu.class);
                startActivity(it1);
            }
        });

        typeInput = (EditText) findViewById(R.id.edit_expenses_insert_type);
        dateInput = (EditText) findViewById(R.id.edit_expenses_insert_date);
        amountInput = (EditText) findViewById(R.id.edit_expenses_insert_amount);
    }

    public void onClick(View view){
       // type = findViewById(R.id.edit_expenses_insert_type).;
    }

    public void addExpense(){
        expense = new Expenses(this.type,this.date,this.amount);
    }
}
