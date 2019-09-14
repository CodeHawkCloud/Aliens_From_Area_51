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

public class StocksDelete extends AppCompatActivity {
    ImageView back; //variable for the back button
    EditText eStocksDeleteId; //variable for the edit text
    Button stocksDeleteButton;

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

        int onStocksDeleteId = Integer.parseInt(eStocksDeleteId.getText().toString());

        //DBHandler object created
        DBHandler dbhandler = new DBHandler(this);

        //Toast creation
        Toast t;

        //check if the insertion was successful
        if(dbhandler.deleteStocks(onStocksDeleteId)){
            //Toast message if deletion is successful
            t = Toast.makeText(getApplicationContext(),"Stock has been deleted from FoxFire!", Toast.LENGTH_LONG);
            t.show();

            Intent success  = new Intent(StocksDelete.this, inventoryCrudMenu.class);
            startActivity(success);
        }
        else{
            //Toast message if insertion fails
            t = Toast.makeText(getApplicationContext(),"Stock deletion failed!", Toast.LENGTH_LONG);
            t.show();
        }
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
