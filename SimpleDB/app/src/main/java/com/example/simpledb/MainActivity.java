package com.example.simpledb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentOperations studentDBOperations;
    ListView studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentDBOperations = new StudentOperations(this);
        studentDBOperations.open();

        studentList = findViewById(R.id.studentList);
        List values = studentDBOperations.getAllStudents();
        //create adapter list
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);
        studentList.setAdapter(adapter);
    }


    public void addStudent(View view) {
        ArrayAdapter adapter = (ArrayAdapter) studentList.getAdapter();
        EditText editTextStudentName = findViewById(R.id.editTextStudentName);
        Student student = studentDBOperations.addStudent(editTextStudentName.getText().toString());
        adapter.add(student);
        editTextStudentName.setText("");
    }

    public void deleteFirstStudent(View view) {
        ArrayAdapter adapter = (ArrayAdapter) studentList.getAdapter();
        Student student = null;

        //Verify list > 0
        if(studentList.getAdapter().getCount() > 0) {
            //get item for remove
            student = (Student) studentList.getAdapter().getItem(0);
            //remove base
            studentDBOperations.deletedStudent(student);
            adapter.remove(student);
        } else {
            Toast.makeText(this, "Lista vazia", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentDBOperations.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        studentDBOperations.close();
    }
}