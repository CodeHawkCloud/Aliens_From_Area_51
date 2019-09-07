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

public class SalesInsert extends AppCompatActivity {

    ImageView back; //variable for the back button
    EditText eSalesInsertItem, eSalesInsertBrand, eSalesInsertPrice, eSalesInsertQuantity; //variables for the edit text
    Button salesInsertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_insert);

        /*---------------back button [START]---------------*/

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(SalesInsert.this,SalesCrudMenu.class);
                startActivity(it1);
            }
        });

        /*---------------back button [END]-----------------*/

        /*---------------insert crud operation 1st part [START]---------------*/

        //assigning values to the variables using the ids of the EditText
        eSalesInsertItem = findViewById(R.id.edit_sales_insert_item);
        eSalesInsertBrand= findViewById(R.id.edit_sales_insert_brand);
        eSalesInsertPrice = findViewById(R.id.edit_sales_insert_price);
        eSalesInsertQuantity = findViewById(R.id.edit_sales_insert_quantity);

        //assigning submit button
        salesInsertButton = (Button)findViewById(R.id.button_sales_insert_submit);

        //calling the TextWatcher function to each field
        eSalesInsertItem.addTextChangedListener(insertSalesTextWatcher);
        eSalesInsertBrand.addTextChangedListener(insertSalesTextWatcher);
        eSalesInsertPrice.addTextChangedListener(insertSalesTextWatcher);
        eSalesInsertQuantity.addTextChangedListener(insertSalesTextWatcher);


        /*---------------insert crud operation 1st part [END]-----------------*/
    }

        /*---------------insert crud operation 2nd part [START]---------------*/

    public void onClick(View view){

        String onSalesInsertItem = eSalesInsertItem.getText().toString();
        String onSalesInsertBrand = eSalesInsertBrand.getText().toString();
        int onSalesInsertPrice = Integer.parseInt(eSalesInsertPrice.getText().toString());
        int onSalesInsertQuantity = Integer.parseInt(eSalesInsertQuantity.getText().toString());

        //DBHandler object created
        DBHandler dbhandler = new DBHandler(this);

        //Toast creation
        Toast t;

        //check if the insertion was successful
        if(dbhandler.addSale(onSalesInsertItem,onSalesInsertBrand,onSalesInsertPrice,onSalesInsertQuantity)){
            //Toast message if insertion is successful
            t = Toast.makeText(getApplicationContext(),"Sale has been added to FoxFire!", Toast.LENGTH_LONG);
            t.show();
        }
        else{
            //Toast message if insertion fails
            t = Toast.makeText(getApplicationContext(),"Sale has not been added to FoxFire!", Toast.LENGTH_LONG);
            t.show();
        }

    }

        /*---------------insert crud operation 2nd part [END]-----------------*/

    //TextWatcher function
    private TextWatcher insertSalesTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String onSalesInsertItem = eSalesInsertItem.getText().toString().trim();
            String onSalesInsertBrand = eSalesInsertBrand.getText().toString().trim();
            int onSalesInsertPrice = Integer.parseInt(eSalesInsertPrice.getText().toString().trim());
            int onSalesInsertQuantity = Integer.parseInt(eSalesInsertQuantity.getText().toString().trim());

            salesInsertButton.setEnabled(!onSalesInsertItem.isEmpty() && !onSalesInsertBrand.isEmpty() && onSalesInsertPrice>0 && onSalesInsertQuantity >0);

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
