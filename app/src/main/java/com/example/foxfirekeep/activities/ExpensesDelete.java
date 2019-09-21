package com.example.foxfirekeep.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class ExpensesDelete extends AppCompatActivity {
    private ImageView back;
    EditText eIdInput;
    Button deleteButton;
    AlertDialog.Builder alertBuilderExpenseDelete;
    AlertDialog alertExpenseDelete;
    Toast toast;
    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_delete);

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(ExpensesDelete.this,ExpensesCrudMenu.class);
                startActivity(it1);
            }
        });

        eIdInput = findViewById(R.id.edit_expenses_delete_id);

        deleteButton = (Button)findViewById(R.id.button_expenses_delete_delete);

        eIdInput.addTextChangedListener(deleteExpenseTextWatcher);
    }

    public void onClick(View view){

        dbHandler = new DBHandler(this);

        //alert to make sure that the user does not accidently reset all data
        alertBuilderExpenseDelete = new AlertDialog.Builder(this);

        //setting the title of the alert and message
        alertBuilderExpenseDelete.setTitle("Delete Expenditure!");
        alertBuilderExpenseDelete.setMessage("Are you sure you want to delete expenditure " + eIdInput.getText().toString() + " ?");

        //if user presses yes
        alertBuilderExpenseDelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                int eId = Integer.parseInt(eIdInput.getText().toString());

                if(dbHandler.deleteExpenditure(eId)){
                    toast = Toast.makeText(getApplicationContext(),"Expense has been deleted from FoxFire!", Toast.LENGTH_LONG);
                    toast.show();

                    Intent complete = new Intent(ExpensesDelete.this,ExpensesCrudMenu.class);
                    startActivity(complete);
                }
                else {
                    toast = Toast.makeText(getApplicationContext(),"No such Expense has been made", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

        //if user presses no - do nothing
        alertBuilderExpenseDelete.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        alertExpenseDelete = alertBuilderExpenseDelete.create();
        alertExpenseDelete.show();

    }

    //Text watcher method implementation
    private TextWatcher deleteExpenseTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String onExpenseDeleteId = eIdInput.getText().toString().trim();

            deleteButton.setEnabled(!onExpenseDeleteId.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
