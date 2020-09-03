package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        view=findViewById(R.id.tv1);
        SharedPreferences sp=getApplicationContext().getSharedPreferences("mydata", Context.MODE_PRIVATE);
        String name=sp.getString("uname","");
        String roll=sp.getString("uroll","");
        String phone=sp.getString("uphone","");
        String email=sp.getString("uemail","");
        String pass=sp.getString("upass","");
        String branch=sp.getString("ubranch","");
        String year=sp.getString("uyear","");
        String gender=sp.getString("ugender","");
        String lang=sp.getString("languages","");
        view.setText(name+"\n"+roll+"\n"+phone+"\n"+email+"\n"+pass+"\n"+branch+"\n"+year+"\n"+gender+"\n"+lang);
    }
}