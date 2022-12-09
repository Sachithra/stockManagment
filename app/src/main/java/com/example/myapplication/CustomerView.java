package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.controller.CustomerViewAdapter;
import com.example.myapplication.db.DBHandler;
import com.example.myapplication.model.Customer;


import java.util.ArrayList;

public class CustomerView extends AppCompatActivity {
    Context con;
    ListView li2;
    ArrayList<Customer> arrayList;
    CustomerViewAdapter customerView;
    private Button button;
    private DBHandler dbHandler =new DBHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler.openDB();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);

        li2=(ListView) findViewById(R.id.listview2);
        arrayList=new ArrayList<>();
        locaDataView();

      
    }

    private void locaDataView() {
        arrayList=dbHandler.getCustomer();
        customerView=new CustomerViewAdapter(this,arrayList);
        li2.setAdapter(customerView);
        customerView.notifyDataSetChanged();

    }
}