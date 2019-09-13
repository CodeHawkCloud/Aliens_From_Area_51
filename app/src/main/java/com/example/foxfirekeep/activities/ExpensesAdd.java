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

import com.example.foxfirekeep.database.DBHandler;

public class ExpensesAdd extends AppCompatActivity {
    EditText typeInput,amountInput,monthInput;
    Button addExpenseButton;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_insert);

        /*---------------back button [START]---------------*/
        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(ExpensesAdd.this,ExpensesCrudMenu.class);
                startActivity(it1);
            }
        });
        /*---------------back button [END]-----------------*/


        /*---------------insert operation 1st part [START]---------------*/

        //getting values entered
        typeInput = findViewById(R.id.edit_expenses_insert_type);
        monthInput = findViewById(R.id.edit_expenses_insert_month);
        amountInput = findViewById(R.id.edit_expenses_insert_amount);

        //assigning insert button
        addExpenseButton = (Button)findViewById(R.id.button_expenses_insert_submit);

        //calling the TextWatcher function to each field
        typeInput.addTextChangedListener(insertExpensesTextWatcher);
        monthInput.addTextChangedListener(insertExpensesTextWatcher);
        amountInput.addTextChangedListener(insertExpensesTextWatcher);

        /*---------------insert operation 1st part [END]-----------------*/
    }

    /*---------------insert operation 2nd part [START]-----------------*/

    public void onClick(View view){
        String type = typeInput.getText().toString();
        String month = monthInput.getText().toString();
        int amount = Integer.parseInt(amountInput.getText().toString());


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

     };

    /*---------------insert operation 2nd part [END]-----------------*/

    private TextWatcher insertExpensesTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String onExpenseType = typeInput.getText().toString().trim();
            String onExpenseMonth = monthInput.getText().toString().trim();
            String onExpenseAmount = amountInput.getText().toString().trim();

            addExpenseButton.setEnabled(!onExpenseType.isEmpty() && !onExpenseMonth.isEmpty() && !onExpenseAmount.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
