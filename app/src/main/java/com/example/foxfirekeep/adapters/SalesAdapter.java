package com.example.foxfirekeep.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.models.Sales;

import java.util.ArrayList;
import java.util.List;

public class SalesAdapter extends ArrayAdapter<Sales>{

     private static final String TAG = "salesListAdapter";
     private Context saContext;
     int saResource;

    public SalesAdapter(Context context, int resource, List<Sales> objects) {
        super(context, resource, objects);
        saContext = context;
        saResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int id = getItem(position).getSales_id();
        String item = getItem(position).getSalesItem();
        String brand = getItem(position).getSalesBrand();
        int price = getItem(position).getSalesPrice();
        int quantity = getItem(position).getSalesQuantity();

        Sales sales = new Sales(id,item,brand,price,quantity);

        LayoutInflater layoutInflater = LayoutInflater.from(saContext);
        convertView = layoutInflater.inflate(saResource,parent,false);

        TextView tvId = (TextView)convertView.findViewById(R.id.adapter_sales_view_id);
        TextView tvItem = (TextView)convertView.findViewById(R.id.adapter_sales_view_item);
        TextView tvBrand = (TextView)convertView.findViewById(R.id.adapter_sales_view_brand);
        TextView tvPrice = (TextView)convertView.findViewById(R.id.adapter_sales_view_price);
        TextView tvQuantity = (TextView)convertView.findViewById(R.id.adapter_sales_view_quantity);

        tvId.setText(String.valueOf(id));
        tvItem.setText(item);
        tvBrand.setText(brand);
        tvPrice.setText(String.valueOf(price));
        tvQuantity.setText(String.valueOf(quantity));

        return convertView;

    }
}