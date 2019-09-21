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

public class SalesDelete extends AppCompatActivity {
    ImageView back; //variable for the back button
    EditText eSalesDeleteId; //variable for the edit text
    Button salesDeleteButton;

    DBHandler dbhandler;//DBHandler object
    AlertDialog.Builder alertBuilderSaleDelete;
    AlertDialog alertSaleDelete;
    Toast t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_delete);

        /*---------------back button [START]---------------*/

        back = (ImageView)findViewById(R.id.button_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1 = new Intent(SalesDelete.this,SalesCrudMenu.class);
                startActivity(it1);
            }
        });

        /*---------------back button [END]-----------------*/

        /*---------------insert crud operation 1st part [START]---------------*/

        //assigning id value to the variables using the ids of the EditText
        eSalesDeleteId = findViewById(R.id.edit_sales_delete_id);

        //assigning delete button
        salesDeleteButton = (Button)findViewById(R.id.button_sales_delete_delete);

        //calling the TextWatcher function to the id field
        eSalesDeleteId.addTextChangedListener(deleteSalesTextWatcher);

        /*---------------insert crud operation 1st part [END]-----------------*/
    }

        /*---------------insert crud operation 2nd part [START]---------------*/
    public void onClick(View view){

        dbhandler = new DBHandler(this);

        //alert to make sure that the user does not accidently reset all data
        alertBuilderSaleDelete = new AlertDialog.Builder(this);

        //setting the title of the alert and message
        alertBuilderSaleDelete.setTitle("Delete Sale!");
        alertBuilderSaleDelete.setMessage("Are you sure you want to delete sale " + eSalesDeleteId.getText().toString() + " ?");

        //if user presses yes
        alertBuilderSaleDelete.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                int onSalesDeleteId = Integer.parseInt(eSalesDeleteId.getText().toString());

                //check if the insertion was successful
                if(dbhandler.deleteSale(onSalesDeleteId)){
                    //Toast message if deletion is successful
                    t = Toast.makeText(getApplicationContext(),"Sale has been deleted from FoxFire!", Toast.LENGTH_LONG);
                    t.show();

                    Intent crudIntent  = new Intent(SalesDelete.this, SalesCrudMenu.class);
                    startActivity(crudIntent);
                }
                else{
                    //Toast message if insertion fails
                    t = Toast.makeText(getApplicationContext(),"Sale deletion failed!", Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });

        //if user presses no - do nothing
        alertBuilderSaleDelete.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        alertSaleDelete = alertBuilderSaleDelete.create();
        alertSaleDelete.show();


    }

        /*---------------insert crud operation 2nd part [END]-----------------*/

    //TextWatcher function
    private TextWatcher deleteSalesTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String onSalesDeleteId = eSalesDeleteId.getText().toString().trim();

            salesDeleteButton.setEnabled(!onSalesDeleteId.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
