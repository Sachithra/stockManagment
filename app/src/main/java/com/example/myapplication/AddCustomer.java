package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.controller.CustomerController;
import com.example.myapplication.db.DBHandler;
import com.example.myapplication.model.Customer;

import java.util.ArrayList;

public class AddCustomer extends AppCompatActivity {
private Button cus_add;
private EditText cusidTV,cusnameTV,cusphoneTV,cusageTV;
    private DBHandler dbHandler =new DBHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler.openDB();
        setContentView(R.layout.activity_main2);

        cus_add=(Button)findViewById(R.id.cus_add);
        cusidTV=(EditText) findViewById(R.id.cusidTV);
        cusnameTV=(EditText)findViewById(R.id.cusnameTV);
        cusphoneTV=(EditText) findViewById(R.id.cusphoneTV);
        cusageTV=(EditText) findViewById(R.id.cusageTV);

        cus_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cusID = Integer.parseInt(cusidTV.getText().toString());
                String cusName=cusnameTV.getText().toString();
                String cusPhone=cusphoneTV.getText().toString();
                String cusAge=cusageTV.getText().toString();

                ArrayList<Customer> customerArrayList = new ArrayList<>();


                        Customer tmp = new Customer();
                        tmp.setCustomerId(cusID);
                        tmp.setCustomerName(cusName);
                        tmp.setCustomerPhone(cusPhone);
                        tmp.setCustomerAge(cusAge);

                        customerArrayList.add(tmp);

                CustomerController.insertCustomer(AddCustomer.this, customerArrayList);


            }
        });
    }
}