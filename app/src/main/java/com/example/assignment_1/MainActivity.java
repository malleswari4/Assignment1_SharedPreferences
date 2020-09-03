package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.assignment_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    String name,roll,phone,email,pass,branch,year,gender,lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        sp=getSharedPreferences("mydata",MODE_PRIVATE);
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor=sp.edit();
                name=binding.et1.getText().toString();
                roll=binding.et2.getText().toString();
                email=binding.et3.getText().toString();
                phone=binding.et4.getText().toString();
                pass=binding.et4.getText().toString();
                branch=binding.spinner1.getSelectedItem().toString();
                year=binding.spinner2.getSelectedItem().toString();
                //Reading Gender
                if (binding.rb1.isChecked())
                {
                    gender="Male";
                }
                else
                {
                    gender="Female";
                }
                //Reading data from checkboxes
                StringBuilder builder=new StringBuilder();
                if (binding.cb1.isChecked())
                {
                    builder.append("English \n");
                }
                if (binding.cb2.isChecked())
                {
                    builder.append("Hindi \n");
                }
                if (binding.cb3.isChecked())
                {
                    builder.append("Telugu");
                }
                lang=builder.toString();
                editor.putString("uname",name);
                editor.putString("uroll",roll);
                editor.putString("uemail",email);
                editor.putString("uphone",phone);
                editor.putString("upass",pass);
                editor.putString("ubranch",branch);
                editor.putString("uyear",year);
                editor.putString("ugender",gender);
                editor.putString("languages",lang);
                editor.commit();
                Toast.makeText(MainActivity.this, "Data submitted", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,DataActivity.class);
                startActivity(intent);
            }
        });
    }
}