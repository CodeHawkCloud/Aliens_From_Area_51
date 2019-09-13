package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.adapters.ExpensesAdapter;
import com.example.foxfirekeep.database.DBHandler;
import com.example.foxfirekeep.models.Expenses;

import java.util.List;

public class ExpensesView extends AppCompatActivity {
    private ImageView back;

    DBHandler dbHandler;
    List<Expenses> expensesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_view);

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(ExpensesView.this,ExpensesCrudMenu.class);
                startActivity(it1);
            }
        });

        ListView listView = (ListView) findViewById(R.id.expenses_list_view);

        dbHandler = new DBHandler(this);
        expensesList = dbHandler.readAllExpenditure();

        ExpensesAdapter expensesAdapter = new ExpensesAdapter(this,R.layout.adapter_expenses_view,expensesList);
        listView.setAdapter(expensesAdapter);

    }
}
