package com.example.myapplication.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.example.myapplication.model.Customer;
import com.example.myapplication.model.Product;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class DBHandler {


    private Context con;
    private SQLiteDatabaseHelper dcon;
    private SQLiteDatabase db;

    public DBHandler(Context con) {
        this.con=con;
    }

    public DBHandler openDB() {
        this.dcon=new SQLiteDatabaseHelper(con);
        this.db=dcon.getWritableDatabase();
        return this;
    }

    public static void performExecute(@NotNull SQLiteDatabase database, @NotNull String sql, Object[] parameters) throws SQLException {
        SQLiteStatement compiledStatement = getCompiledStatement(database, sql, parameters);
        compiledStatement.execute();
    }

    public static long performExecuteInsert(@NotNull SQLiteDatabase database, @NotNull String sql, Object[] parameters) throws SQLException {
        SQLiteStatement compiledStatement = getCompiledStatement(database, sql, parameters);
        return compiledStatement.executeInsert();
    }
    public static long performExecuteInsert2(@NotNull SQLiteDatabase database, @NotNull String sql, Object[] parameters) throws SQLException {
        SQLiteStatement compiledStatement = getCompiledStatement(database, sql, parameters);
        return compiledStatement.executeInsert();
    }

    public static boolean performExecuteUpdateDelete(@NotNull SQLiteDatabase database, @NotNull String sql, Object[] parameters) throws SQLException {
        SQLiteStatement compiledStatement = getCompiledStatement(database, sql, parameters);
        return compiledStatement.executeUpdateDelete() > 0;
    }

    public static void performExecute(@NotNull SQLiteStatement sqLiteStatement, Object[] parameters) throws SQLException {
        SQLiteStatement compiledStatement = bindParameters(sqLiteStatement, parameters);
        compiledStatement.execute();
    }

    public static long performExecuteInsert(@NotNull SQLiteStatement sqLiteStatement, Object[] parameters) throws SQLException {
        SQLiteStatement compiledStatement = bindParameters(sqLiteStatement, parameters);
        return compiledStatement.executeInsert();
    }
    public static long performExecuteInsert2(@NotNull SQLiteStatement sqLiteStatement, Object[] parameters) throws SQLException {
        SQLiteStatement compiledStatement = bindParameters(sqLiteStatement, parameters);
        return compiledStatement.executeInsert();
    }

    public static boolean performExecuteUpdateDelete(@NotNull SQLiteStatement sqLiteStatement, Object[] parameters) throws SQLException {
        SQLiteStatement compiledStatement = bindParameters(sqLiteStatement, parameters);
        return compiledStatement.executeUpdateDelete() > 0;
    }

    public static Cursor performRawQuery(@NotNull SQLiteDatabase database, @NotNull String sql, Object[] parameters) {
        return database.rawQuery(sql, convertToStringArray(parameters));
    }

    private static SQLiteStatement getCompiledStatement(@NotNull SQLiteDatabase database, @NotNull String sql, Object[] parameters) throws SQLException {
        SQLiteStatement sqLiteStatement = database.compileStatement(sql);
        String[] stringParameters = convertToStringArray(parameters);
        if (stringParameters != null) {
            sqLiteStatement.bindAllArgsAsStrings(stringParameters);
        }
        return sqLiteStatement;
    }

    private static SQLiteStatement bindParameters(@NotNull SQLiteStatement sqLiteStatement, Object[] parameters) {
        String[] stringParameters = convertToStringArray(parameters);
        if (stringParameters != null) {
            sqLiteStatement.bindAllArgsAsStrings(stringParameters);
        }
        return sqLiteStatement;
    }

    @Nullable
    private static String[] convertToStringArray(Object[] parameters) {
        if (parameters == null) {
            return null;
        }
        final int PARAMETERS_LENGTH = parameters.length;
        if (PARAMETERS_LENGTH == 0) {
            return null;
        }
        String[] stringParameters = new String[PARAMETERS_LENGTH];
        for (int i = 0; i < PARAMETERS_LENGTH; i++) {
            stringParameters[i] = String.valueOf(parameters[i]);
        }
        return stringParameters;
    }
    public ArrayList<Product>getAllData(){
        ArrayList<Product>arrayList=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT productName,productPrice,productUnit FROM PRODUCT",null);
        while (cursor.moveToNext()){

            String name=cursor.getString(0);
            String unit=cursor.getString(1);
            String price=cursor.getString(2);
            Product product=new Product(name,unit,price);

            arrayList.add(product);

        }
        return arrayList;
    }

    public ArrayList<Customer>getCustomer(){
        ArrayList<Customer>arrayList=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT * FROM CUSTOMERS",null);
        while (cursor.moveToNext()){
            //int id=cursor.getInt(0);
            int id= Integer.parseInt(cursor.getString(0));
            String name=cursor.getString(1);
            String phone=cursor.getString(2);
            String age=cursor.getString(3);
            Customer customer=new Customer(id,name,phone,age);

            arrayList.add(customer);

        }
        return arrayList;
    }
    public ArrayList<Product>getProduct(){
        ArrayList<Product>arrayList=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT * FROM PRODUCT",null);
        while (cursor.moveToNext()){
            //int id=cursor.getInt(0);
            int id= Integer.parseInt(cursor.getString(0));
            String name=cursor.getString(1);
            String unit=cursor.getString(2);
            String price=cursor.getString(3);
            Product product=new Product(id,name,unit,price);

            arrayList.add(product);

        }
        return arrayList;
    }
}


