package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.controller.CustomerViewAdapter;
import com.example.myapplication.controller.ProductViewAdaptor;
import com.example.myapplication.db.DBHandler;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class ViewProducs extends AppCompatActivity {
    ListView li3;
    ArrayList<Product> arrayList;
    ProductViewAdaptor pv;
    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler.openDB();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_producs);

        li3 = (ListView) findViewById(R.id.listview3);
        arrayList = new ArrayList<>();
        localDataView();
    }

    private void localDataView() {

        arrayList = dbHandler.getProduct();
        pv = new ProductViewAdaptor(this, arrayList);
        li3.setAdapter(pv);
        pv.notifyDataSetChanged();
    }
}