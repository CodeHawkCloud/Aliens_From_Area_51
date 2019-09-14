package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.database.DBHandler;

public class ExpensesUpdate extends AppCompatActivity {
    private ImageView back;
    EditText updateID,updateType,updateMonth,updateAmount;
    Button expensesUpdateButton ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_update);

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(ExpensesUpdate.this,ExpensesCrudMenu.class);
                startActivity(it1);
            }
        });

        updateID = findViewById(R.id.edit_expenses_update_id);
        updateType = findViewById(R.id.edit_expenses_update_type);
        updateMonth = findViewById(R.id.edit_expenses_update_month);
        updateAmount = findViewById(R.id.edit_expenses_update_amount);

        expensesUpdateButton = findViewById(R.id.button_expenses_update_update);

        updateID.addTextChangedListener(updateExpensesTextWatcher);
        updateType.addTextChangedListener(updateExpensesTextWatcher);
        updateMonth.addTextChangedListener(updateExpensesTextWatcher);
        updateAmount.addTextChangedListener(updateExpensesTextWatcher);

    }

    public void onClick(View view){

        int exp_ID = Integer.parseInt(updateID.getText().toString());
        String exp_Type = updateType.getText().toString();
        String exp_Month = updateMonth.getText().toString();
        int exp_Amount = Integer.parseInt(updateAmount.getText().toString());

        DBHandler dbHandler = new DBHandler(this);

        Toast toast;

        if(dbHandler.updateExpenses(exp_ID,exp_Type,exp_Month,exp_Amount)){
            toast = Toast.makeText(getApplicationContext(),"Expense Updated!",Toast.LENGTH_LONG);
            toast.show();

            Intent complete  = new Intent(ExpensesUpdate.this, ExpensesCrudMenu.class);
            startActivity(complete);
        }
        else {
            toast = Toast.makeText(getApplicationContext(),"Expense NOT Updated!",Toast.LENGTH_LONG);
            toast.show();
        }
    }

   private TextWatcher updateExpensesTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String onExpenseUpdateID = updateID.getText().toString().trim();
            String onExpenseUpdateType = updateType.getText().toString().trim();
            String onExpenseUpdateMonth = updateMonth.getText().toString().trim();
            String onExpenseUpdateAmount = updateAmount.getText().toString().trim();

            expensesUpdateButton.setEnabled(!onExpenseUpdateID.isEmpty() && !onExpenseUpdateType.isEmpty() && !onExpenseUpdateMonth.isEmpty() && !onExpenseUpdateAmount.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
