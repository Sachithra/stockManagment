package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.controller.PlaceQuantity;
import com.example.myapplication.db.DBHandler;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class PlaceOrder extends AppCompatActivity {
  ListView li;
  ArrayList<Product> arrayList;
  PlaceQuantity myAdappter;
  private Button button;


    private DBHandler dbHandler =new DBHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler.openDB();
        setContentView(R.layout.activity_order);
        li=(ListView) findViewById(R.id.listview);
        button=(Button)findViewById(R.id.button);
        arrayList=new ArrayList<>();
        locaDataView();


button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(PlaceOrder.this, CompleteOrder.class);
        startActivity(intent);
    }
});
    }
    private void locaDataView(){
        arrayList=dbHandler.getAllData();
        myAdappter=new PlaceQuantity(this,arrayList);
        li.setAdapter(myAdappter);
        myAdappter.notifyDataSetChanged();
    }



}