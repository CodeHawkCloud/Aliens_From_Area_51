package com.example.foxfirekeep.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.models.Expenses;

import java.util.ArrayList;
import java.util.List;

public class ExpensesAdapter extends ArrayAdapter<Expenses> {

    private static final String TAG = "expensesListAdapter";
    private Context exContext;
    int exResources;

    public ExpensesAdapter(Context context,int resource,List<Expenses> objects){
        super(context, resource, objects);
        exContext = context;
        exResources = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        int id = getItem(position).getId();
        String type = getItem(position).getType();
        String month = getItem(position).getMonth();
        int amount = getItem(position).getAmount();

        Expenses expenses = new Expenses(id,type,month,amount);

        LayoutInflater layoutInflater = LayoutInflater.from(exContext);
        convertView = layoutInflater.inflate(exResources,parent,false);

        TextView tvID = (TextView)convertView.findViewById(R.id.adapter_expenses_view_id);
        TextView tvType = (TextView)convertView.findViewById(R.id.adapter_expenses_view_type);
        TextView tvMonth = (TextView)convertView.findViewById(R.id.adapter_expenses_view_month);
        TextView tvAmount = (TextView)convertView.findViewById(R.id.adapter_expenses_view_amount);

        tvID.setText(String.valueOf(id));
        tvType.setText(type);
        tvMonth.setText(month);
        tvAmount.setText(String.valueOf(amount));

        return convertView;
    }
}
