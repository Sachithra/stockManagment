package com.example.myapplication.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class PlaceQuantity extends BaseAdapter {

    int _counter = 0;
    private String _stringVal;

    Context con;
    ArrayList<Product>arrayList;
   public PlaceQuantity(Context con, ArrayList<Product>arrayList){
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
                    convertView=inflater.inflate(R.layout.mycustomlistview,null);
            TextView t1=(TextView)convertView.findViewById(R.id.id_txt);
            TextView t2=(TextView)convertView.findViewById(R.id.name_txt);
            TextView t3=(TextView)convertView.findViewById(R.id.id_price);
            TextView t4=(TextView)convertView.findViewById(R.id.textView1);
            TextView rs =(TextView)convertView.findViewById(R.id.textview_result);
            Button b1=(Button)convertView.findViewById(R.id.button2);
            //TextView displayInteger = (TextView)convertView.findViewById(R.id.textView1);



            Product product=arrayList.get(position);
            t1.setText(product.getProductName());
            t2.setText(product.getProductUnits());
            t3.setText(product.getPrice());


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    _counter= _counter+1;
                    Toast.makeText(con, "fdkadkd", Toast.LENGTH_SHORT).show();

                    _stringVal = Integer.toString(_counter);
                    t4.setText(_stringVal);

                    if(t3.getText().toString().length()==0){
                        t3.setText("0");
                    }
                    int price= Integer.parseInt(t3.getText().toString());
                    int sum=price;

                    int res=_counter;
                    rs.setText(String.valueOf(sum*res));

                }
            });




        }
       return convertView;
    }
}
