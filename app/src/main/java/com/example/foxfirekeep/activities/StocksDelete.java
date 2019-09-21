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

public class StocksDelete extends AppCompatActivity {
    ImageView back;
    EditText eStocksDeleteId;
    Button stocksDeleteButton;
    DBHandler dbHandler;
    AlertDialog.Builder alertBuilderStockDelete;
    AlertDialog alertStockDelete;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks_delete);

        /*---------------back button [START]---------------*/

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(StocksDelete.this,inventoryCrudMenu.class);
                startActivity(it1);
            }
        });

        /*---------------back button [END]-----------------*/

        /*---------------insert crud operation 1st part [START]---------------*/

        //assigning id value to the variables using the ids of the EditText
        eStocksDeleteId = findViewById(R.id.edit_stocks_delete_name);

        //assigning delete button
        stocksDeleteButton = (Button)findViewById(R.id.button_stocks_delete_delete);

        //calling the TextWatcher function to the id field
        eStocksDeleteId.addTextChangedListener(deleteSalesTextWatcher);

        /*---------------insert crud operation 1st part [END]-----------------*/
    }

    /*---------------insert crud operation 2nd part [START]---------------*/
    public void onClick(View view){

        dbHandler = new DBHandler(this);

        //alert to make sure that the user does not accidently reset all data
        alertBuilderStockDelete = new AlertDialog.Builder(this);

        //setting the title of the alert and message
        alertBuilderStockDelete.setTitle("Delete Inventory!");
        alertBuilderStockDelete.setMessage("Are you sure you want to delete stock " + eStocksDeleteId.getText().toString() + " ?");

        //if user presses yes
        alertBuilderStockDelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                int onStocksDeleteId = Integer.parseInt(eStocksDeleteId.getText().toString());

                //check if the insertion was successful
                if(dbHandler.deleteStocks(onStocksDeleteId)){
                    //Toast message if deletion is successful
                    toast = Toast.makeText(getApplicationContext(),"Stock has been deleted from FoxFire!", Toast.LENGTH_LONG);
                    toast.show();

                    Intent success  = new Intent(StocksDelete.this, inventoryCrudMenu.class);
                    startActivity(success);
                }
                else{
                    //Toast message if insertion fails
                    toast = Toast.makeText(getApplicationContext(),"Stock deletion failed!", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

        //if user presses no - do nothing
        alertBuilderStockDelete.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        alertStockDelete = alertBuilderStockDelete.create();
        alertStockDelete.show();
    }

    /*---------------insert crud operation 2nd part [END]-----------------*/

    //TextWatcher function
    private TextWatcher deleteSalesTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String onSalesDeleteId = eStocksDeleteId.getText().toString().trim();

            stocksDeleteButton.setEnabled(!onSalesDeleteId.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
