package com.example.myapplication.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Customer;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class ProductViewAdaptor extends BaseAdapter {
    Context con;
    ArrayList<Product> arrayList;

    public ProductViewAdaptor(Context con, ArrayList<Product> arrayList) {
        this.con = con;
        this.arrayList = arrayList;
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
            convertView=inflater.inflate(R.layout.customlistview3,null);
            TextView t1=(TextView)convertView.findViewById(R.id.id_txt);
            TextView t2=(TextView)convertView.findViewById(R.id.name_txt);
            TextView t3=(TextView)convertView.findViewById(R.id.unit_txt);
            TextView t4=(TextView)convertView.findViewById(R.id.price_txt);




            Product product=arrayList.get(position);
            // t1.setText(customer.getCustomerId());
            t2.setText(product.getProductName());
            t3.setText(product.getProductUnits());
            t4.setText(product.getPrice());



        }
        return convertView;
    }

}
