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

public class StocksAdd extends AppCompatActivity {

    ImageView back; //variable for the back button
    EditText eStocksInsertItem, eStocksInsertSupplier, eStocksInsertReorderQuantity, eStocksInsertQuantity; //variables for the edit text
    Button stocksInsertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks_insert);

        /*---------------back button [START]---------------*/

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(StocksAdd.this,inventoryCrudMenu.class);
                startActivity(it1);
            }
        });

        /*---------------back button [END]-----------------*/

        /*---------------insert crud operation 1st part [START]---------------*/

        //assigning values to the variables using the ids of the EditText
        eStocksInsertItem = findViewById(R.id.edit_stocks_insert_name);
        eStocksInsertSupplier= findViewById(R.id.edit_stocks_insert_supplier);
        eStocksInsertReorderQuantity = findViewById(R.id.edit_stocks_insert_reorder);
        eStocksInsertQuantity = findViewById(R.id.edit_stocks_insert_quantity);

        //assigning submit button
        stocksInsertButton = (Button)findViewById(R.id.button_stocks_insert_submit);

        //calling the TextWatcher function to each field
        eStocksInsertItem.addTextChangedListener(insertStocksTextWatcher);
        eStocksInsertSupplier.addTextChangedListener(insertStocksTextWatcher);
        eStocksInsertReorderQuantity.addTextChangedListener(insertStocksTextWatcher);
        eStocksInsertQuantity.addTextChangedListener(insertStocksTextWatcher);


        /*---------------insert crud operation 1st part [END]-----------------*/
    }

    /*---------------insert crud operation 2nd part [START]---------------*/

    public void onClick(View view){

        String onStocksInsertItem = eStocksInsertItem.getText().toString();
        String onStocksInsertSupplier = eStocksInsertSupplier.getText().toString();
        int onStocksInsertReorderQuantity = Integer.parseInt(eStocksInsertReorderQuantity.getText().toString());
        int onStocksInsertQuantity = Integer.parseInt(eStocksInsertQuantity.getText().toString());

        //DBHandler object created
        DBHandler dbhandler = new DBHandler(this);

        //Toast creation
        Toast t;

        //check if the insertion was successful
        if(dbhandler.addSale(onStocksInsertItem,onStocksInsertSupplier,onStocksInsertReorderQuantity,onStocksInsertQuantity)){
            //Toast message if insertion is successful
            t = Toast.makeText(getApplicationContext(),"Stocks has been added to FoxFire!", Toast.LENGTH_LONG);
            t.show();
        }
        else{
            //Toast message if insertion fails
            t = Toast.makeText(getApplicationContext(),"Stocks has not been added to FoxFire!", Toast.LENGTH_LONG);
            t.show();
        }

    }

    /*---------------insert crud operation 2nd part [END]-----------------*/

    //TextWatcher function
    private TextWatcher insertStocksTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String onStocksInsertItem = eStocksInsertItem.getText().toString().trim();
            String onSalesInsertSupplier = eStocksInsertSupplier.getText().toString().trim();
            String onStocksInsertReorderQuantity = eStocksInsertReorderQuantity.getText().toString().trim();
            String onStocksInsertQuantity = eStocksInsertQuantity.getText().toString().trim();

            stocksInsertButton.setEnabled(!onStocksInsertItem.isEmpty() && !onSalesInsertSupplier.isEmpty() && !onStocksInsertReorderQuantity.isEmpty() && !onStocksInsertQuantity.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
