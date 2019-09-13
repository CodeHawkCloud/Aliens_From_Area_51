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

public class ExpensesDelete extends AppCompatActivity {
    private ImageView back;
    EditText eIdInput;
    Button deleteButton;


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
        int eId = Integer.parseInt(eIdInput.getText().toString());

        Toast toast;

        DBHandler dbHandler = new DBHandler(this);

        if(dbHandler.deleteExpenditure(eId)){
            toast = Toast.makeText(getApplicationContext(),"Expense has been deleted from FoxFire!", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            toast = Toast.makeText(getApplicationContext(),"Expense has not been deleted from FoxFire!", Toast.LENGTH_LONG);
            toast.show();
        }
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
