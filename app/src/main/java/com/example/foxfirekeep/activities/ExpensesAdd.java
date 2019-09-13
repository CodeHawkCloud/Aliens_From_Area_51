package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foxfirekeep.database.DBHandler;
import com.example.foxfirekeep.models.Expenses;


//import com.example.foxfirekeep.activities.R;

public class ExpensesAdd extends AppCompatActivity {
    String type;
    String month;
    double amount;

    EditText typeInput;
    EditText monthInput;
    EditText amountInput;

    Button addExpenseButton;

    Expenses expense = new Expenses(type,month,amount);
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
        monthInput = (EditText) findViewById(R.id.edit_expenses_insert_date);
        amountInput = (EditText) findViewById(R.id.edit_expenses_insert_amount);

        addExpenseButton = (Button)findViewById(R.id.button_expenses_insert_submit);

        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick(view);
            }
        });
    }

    public void onClick(View view){
        type = typeInput.getText().toString();
        month = monthInput.getText().toString();
        amount = Double.parseDouble(amountInput.getText().toString());

        DBHandler dbHandler = new DBHandler(this);

        Toast toast;

        if (dbHandler.addExpenditure(type,month,amount)){
            toast = Toast.makeText(getApplicationContext(),"New Expenditure Added", Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            toast = Toast.makeText(getApplicationContext(),"Expenditure has not been Added", Toast.LENGTH_LONG);
            toast.show();
        }

     }
}
