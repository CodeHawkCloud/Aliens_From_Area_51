package com.example.foxfirekeep.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.models.Sales;
import com.example.foxfirekeep.models.Stocks;

import java.util.ArrayList;
import java.util.List;

public class StocksAdapter extends ArrayAdapter<Stocks>{

    private static final String TAG = "salesListAdapter";
    private Context saContext;
    int saResource;

    public StocksAdapter(Context context, int resource, List<Stocks> objects) {
        super(context, resource, objects);
        saContext = context;
        saResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int id = getItem(position).getStocks_id();
        String item = getItem(position).getStocksItem();
        String supplier = getItem(position).getStocksSupplier();
        int reorder_quantity = getItem(position).getStocksReorderQuantity();
        int quantity = getItem(position).getStocksQuantity();

        Stocks stocks = new Stocks(id,item,supplier ,reorder_quantity,quantity);

        LayoutInflater layoutInflater = LayoutInflater.from(saContext);
        convertView = layoutInflater.inflate(saResource,parent,false);

        TextView tvId = (TextView)convertView.findViewById(R.id.adapter_stocks_view_id);
        TextView tvItem = (TextView)convertView.findViewById(R.id.adapter_stocks_view_item);
        TextView tvBrand = (TextView)convertView.findViewById(R.id.adapter_stocks_view_supplier);
        TextView tvPrice = (TextView)convertView.findViewById(R.id.adapter_stocks_view_reorder_quantity);
        TextView tvQuantity = (TextView)convertView.findViewById(R.id.adapter_sales_view_quantity);

        tvId.setText(String.valueOf(id));
        tvItem.setText(item);
        tvBrand.setText(supplier);
        tvPrice.setText(String.valueOf(reorder_quantity));
        tvQuantity.setText(String.valueOf(quantity));

        return convertView;

    }
}