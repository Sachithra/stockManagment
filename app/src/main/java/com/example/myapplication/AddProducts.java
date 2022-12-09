package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.controller.ProductCotroller;
import com.example.myapplication.db.DBHandler;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class AddProducts extends AppCompatActivity {
    private Button addbtn;
    private EditText idTV,nameTV,unitTV,priceTV;
    private DBHandler dbHandler =new DBHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler.openDB();
       setContentView (R.layout.activity_main_addproduct);

        addbtn=(Button) findViewById(R.id.addbtn);
        idTV=(EditText) findViewById(R.id.idTV);
        nameTV=(EditText) findViewById(R.id.nameTV);
        unitTV=(EditText) findViewById(R.id.unitTV);
        priceTV=(EditText) findViewById(R.id.priceTV);



        addbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int productId = Integer.parseInt(idTV.getText().toString());
                String productName = nameTV.getText().toString();
                String productUnits = unitTV.getText().toString();
                String productPrice = priceTV.getText().toString();
                ArrayList<Product> productsList = new ArrayList<>();

                               Product tmp = new Product();
                               tmp.setProductID(productId);
                               tmp.setProductName(productName);
                               tmp.setProductUnits(productUnits);
                               tmp.setPrice(productPrice);

                               productsList.add(tmp);

                ProductCotroller.insertProducts(AddProducts.this, productsList);
            }
            });
        }
    }

