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

public class SalesAdapter extends ArrayAdapter{

    //list variable l1 declared
    List l1 = new ArrayList<>();

    //constructor
    public SalesAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Sales object) {
        l1.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return l1.size();
    }

    @Override
    public Object getItem(int position) {
        return l1.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        SalesHolder salesHolder = new SalesHolder();

        if(row == null) {
            LayoutInflater lf = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = lf.inflate(R.layout.activity_sales_view, parent, false);

            salesHolder.sales_holder_id = (TextView)row.findViewById(R.id.text_sales_view_col_name_id);
            salesHolder.sales_holder_item = (TextView)row.findViewById(R.id.text_sales_view_col_name_item);
            salesHolder.sales_holder_brand = (TextView)row.findViewById(R.id.text_sales_view_col_name_brand);
            salesHolder.sales_holder_price = (TextView)row.findViewById(R.id.text_sales_view_col_name_price);
            salesHolder.sales_holder_quantity = (TextView)row.findViewById(R.id.text_sales_view_col_name_quantity);
            row.setTag(salesHolder);
        }
        else{
            salesHolder = (SalesHolder) row.getTag();
        }

        Sales sales = (Sales)getItem(position);
        salesHolder.sales_holder_id.setText(Integer.toString(sales.getSales_id()));
        salesHolder.sales_holder_item.setText(sales.getSalesItem().toString());
        salesHolder.sales_holder_brand.setText(sales.getSalesBrand().toString());
        salesHolder.sales_holder_price.setText(Integer.toString(sales.getSalesPrice()));
        salesHolder.sales_holder_quantity.setText(Integer.toString(sales.getSalesQuantity()));

        return row;
    }


    static class SalesHolder{
        TextView sales_holder_id, sales_holder_item, sales_holder_brand, sales_holder_price, sales_holder_quantity;
    }
}
