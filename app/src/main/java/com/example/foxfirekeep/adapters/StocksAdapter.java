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

public class StocksAdapter extends ArrayAdapter{

    //list variable l1 declared
    List l2 = new ArrayList<>();

    //constructor
    public StocksAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Stocks object) {
        l2.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return l2.size();
    }

    @Override
    public Object getItem(int position) {
        return l2.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        StocksHolder stocksHolder = new StocksHolder();

        if(row == null) {
            LayoutInflater lf = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = lf.inflate(R.layout.activity_stocks_view, parent, false);

            stocksHolder.stocks_holder_id = (TextView)row.findViewById(R.id.text_stocks_view_col_name_id);
            stocksHolder.stocks_holder_item = (TextView)row.findViewById(R.id.text_stocks_view_col_name_item);
            stocksHolder.stocks_holder_supplier= (TextView)row.findViewById(R.id.text_stocks_view_col_name_supplier);
            stocksHolder.stocks_holder_reorder_quantity = (TextView)row.findViewById(R.id.text_stocks_view_col_name_reorder_quantity);
            stocksHolder.stocks_holder_quantity = (TextView)row.findViewById(R.id.text_stocks_view_col_name_quantity);
            row.setTag(stocksHolder);
        }
        else{
            stocksHolder = (StocksHolder) row.getTag();
        }

        Stocks stocks = (Stocks)getItem(position);
        stocksHolder.stocks_holder_id.setText(Integer.toString(stocks.getStocks_id()));
        stocksHolder.stocks_holder_item.setText(stocks.getStocksItem().toString());
        stocksHolder.stocks_holder_supplier.setText(stocks.getStocksSupplier().toString());
        stocksHolder.stocks_holder_reorder_quantity.setText(Integer.toString(stocks.getStocksReorderQuantity()));
        stocksHolder.stocks_holder_quantity.setText(Integer.toString(stocks.getStocksQuantity()));

        return row;
    }


    static class StocksHolder{
        TextView stocks_holder_id, stocks_holder_item, stocks_holder_supplier, stocks_holder_reorder_quantity, stocks_holder_quantity;
    }
}
