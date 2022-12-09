package com.example.myapplication.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Customer;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class CustomerViewAdapter extends BaseAdapter {

    Context con;
    ArrayList<Customer> arrayList;
    public CustomerViewAdapter(Context con, ArrayList<Customer>arrayList){
        this.con=con;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.customlistview2,null);
            TextView t1=(TextView)convertView.findViewById(R.id.id_txt);
            TextView t2=(TextView)convertView.findViewById(R.id.name_txt);
            TextView t3=(TextView)convertView.findViewById(R.id.phone_txt);
            TextView t4=(TextView)convertView.findViewById(R.id.age_txt);




            Customer customer=arrayList.get(position);
           // t1.setText(customer.getCustomerId());
            t2.setText(customer.getCustomerName());
            t3.setText(customer.getCustomerPhone());
            t4.setText(customer.getCustomerAge());



        }
        return convertView;
    }


}
