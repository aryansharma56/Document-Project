package com.example.documents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button,button2;
        TextView textView;
//        ListView listView;
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        textView.setText("Welcome to our app");
//        listView=findViewById(R.id.listView);
//        DbManager db =new DbManager(this);
//        ArrayList arrayList =db.getDocs();
//        ArrayAdapter arrayAdapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
//        listView.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Add_Data.class);
                startActivity(intent);
            }


        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,display.class);
                startActivity(intent);
            }
        });



    }
}