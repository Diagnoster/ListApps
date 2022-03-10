package com.example.simpledb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //create database
            SQLiteDatabase db = openOrCreateDatabase("contacts.db", MODE_PRIVATE, null);

            //create table if not exist
            db.execSQL("CREATE TABLE IF NOT EXISTS contacts (name VARCHAR, age INT(3))");

            //insert values
            db.execSQL("INSERT INTO contacts(name, age) VALUES ('James', 26)");
            db.execSQL("INSERT INTO contacts(name, age) VALUES ('Isabela', 24)");

            //update values
            db.execSQL("UPDATE  contacts SET age = 20 WHERE name = 'James'");

            //delete values
            db.execSQL("DELETE FROM contacts WHERE name = 'Isabela'");

            //recovery values
            Cursor cursor = db.rawQuery("SELECT name, age FROM contacts", null);

            //table indices
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");

            //travel cursor
            // use log class for print in logCat terminal
            cursor.moveToFirst();
            while(cursor != null) {
                Log.i("RESULTADO - nome : ", cursor.getString(nameIndex));
                Log.i("RESULTADO - idade : ", cursor.getString(ageIndex));
                cursor.moveToNext();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}