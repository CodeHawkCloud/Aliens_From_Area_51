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

public class SalesUpdate extends AppCompatActivity {

    ImageView back;//variable for the back button
    EditText eSalesUpdateId, eSalesUpdateItem, eSalesUpdateBrand, eSalesUpdatePrice, eSalesUpdateQuantity; //variables for the edit text
    Button salesUpdateButton;
    Toast t;//Toast
    DBHandler dbhandler;//DBHandler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_update);

        /*---------------back button [START]---------------*/
        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(SalesUpdate.this,SalesCrudMenu.class);
                startActivity(it1);
            }
        });
        /*---------------back button [END]-----------------*/

        /*---------------update crud operation 1st part [START]---------------*/

        //assigning values to the variables using the ids of the EditText
        eSalesUpdateId = findViewById(R.id.edit_sales_update_id);
        eSalesUpdateItem = findViewById(R.id.edit_sales_update_item);
        eSalesUpdateBrand = findViewById(R.id.edit_sales_update_brand);
        eSalesUpdatePrice = findViewById(R.id.edit_sales_update_price);
        eSalesUpdateQuantity = findViewById(R.id.edit_sales_update_quantity);

        //assigning submit button
        salesUpdateButton = (Button)findViewById(R.id.button_sales_update_update);

        //calling the TextWatcher function to each field
        eSalesUpdateId.addTextChangedListener(updateSalesTextWatcher);
        eSalesUpdateItem.addTextChangedListener(updateSalesTextWatcher);
        eSalesUpdateBrand.addTextChangedListener(updateSalesTextWatcher);
        eSalesUpdatePrice.addTextChangedListener(updateSalesTextWatcher);
        eSalesUpdateQuantity.addTextChangedListener(updateSalesTextWatcher);

        /*---------------update crud operation 1st part [END]-----------------*/
    }

        /*---------------insert crud operation 2nd part [START]---------------*/
    public void onClick(View view){

        int onSalesUpdateId = Integer.parseInt(eSalesUpdateId.getText().toString());
        String onSalesUpdatetItem = eSalesUpdateItem.getText().toString();
        String onSalesUpdateBrand = eSalesUpdateBrand.getText().toString();
        int onSalesUpdatePrice = Integer.parseInt(eSalesUpdatePrice.getText().toString());
        int onSalesUpdateQuantity = Integer.parseInt(eSalesUpdateQuantity.getText().toString());

        //DBHandler object created
        dbhandler = new DBHandler(this);

        //check if the insertion was successful
        if(dbhandler.updateSales(onSalesUpdateId,onSalesUpdatetItem,onSalesUpdateBrand,onSalesUpdatePrice,onSalesUpdateQuantity)){
            //Toast message if insertion is successful
            t = Toast.makeText(getApplicationContext(),"Sale has been updated successfully!", Toast.LENGTH_LONG);
            t.show();

            Intent crudIntent  = new Intent(SalesUpdate.this, SalesCrudMenu.class);
            startActivity(crudIntent);
        }
        else{
            //Toast message if insertion fails
            t = Toast.makeText(getApplicationContext(),"Sale failed to be updated!", Toast.LENGTH_LONG);
            t.show();
        }
    }
        /*---------------insert crud operation 2nd part [END]-----------------*/

    //TextWatcher function
    private TextWatcher updateSalesTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String onSalesUpdateId = eSalesUpdateId.getText().toString().trim();
            String onSalesUpdateItem = eSalesUpdateItem.getText().toString().trim();
            String onSalesUpdateBrand = eSalesUpdateBrand.getText().toString().trim();
            String onSalesUpdatePrice = eSalesUpdatePrice.getText().toString().trim();
            String onSalesUpdateQuantity = eSalesUpdateQuantity.getText().toString().trim();

            salesUpdateButton.setEnabled(!onSalesUpdateId.isEmpty() && !onSalesUpdateItem.isEmpty() && !onSalesUpdateBrand.isEmpty() && !onSalesUpdatePrice.isEmpty() && !onSalesUpdateQuantity.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
