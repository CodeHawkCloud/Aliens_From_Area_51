package com.example.foxfirekeep.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.models.Sales;

import java.util.List;

//SalesAdapter class to convert the sales data into view item
public class SalesAdapter extends ArrayAdapter<Sales>{

    private Context saContext;
    int saResource;

    //constructor
    public SalesAdapter(Context context, int resource, List<Sales> objects) {
        super(context, resource, objects);
        saContext = context;
        saResource = resource;
    }

    //called each time an item becomes visible in the list view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the data in the particular position
        int id = getItem(position).getSales_id();
        String item = getItem(position).getSalesItem();
        String brand = getItem(position).getSalesBrand();
        int price = getItem(position).getSalesPrice();
        int quantity = getItem(position).getSalesQuantity();

        //initiate the xml file
        LayoutInflater layoutInflater = LayoutInflater.from(saContext);
        //inflate the SalesView xml and stores it in the convertView
        convertView = layoutInflater.inflate(saResource,parent,false);

        //get the views and give them names
        TextView tvId = (TextView)convertView.findViewById(R.id.adapter_sales_view_id);
        TextView tvItem = (TextView)convertView.findViewById(R.id.adapter_sales_view_item);
        TextView tvBrand = (TextView)convertView.findViewById(R.id.adapter_sales_view_brand);
        TextView tvPrice = (TextView)convertView.findViewById(R.id.adapter_sales_view_price);
        TextView tvQuantity = (TextView)convertView.findViewById(R.id.adapter_sales_view_quantity);

        //set the value to to the textviews
        tvId.setText(String.valueOf(id));
        tvItem.setText(item);
        tvBrand.setText(brand);
        tvPrice.setText(String.valueOf(price));
        tvQuantity.setText(String.valueOf(quantity));

        //returns the converted data as a view
        return convertView;

    }
}