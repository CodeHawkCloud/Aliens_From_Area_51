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

public class ExpensesAdapter extends ArrayAdapter {

    List l3 = new ArrayList<>();

    public ExpensesAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Expenses object) {
        l3.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return l3.size();
    }

    @Override
    public Object getItem(int position) {
        return l3.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        ExpensesHolder expensesHolder = new ExpensesHolder();

        if(row == null){
            LayoutInflater lf = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = lf.inflate(R.layout.activity_expenses_view,parent,false);


        }
        return row;
    }


    static class ExpensesHolder{
        TextView expenses_holder_id, expenses_holder_type, expenses_holder_month, expenses_holder_amount;
    }
}
