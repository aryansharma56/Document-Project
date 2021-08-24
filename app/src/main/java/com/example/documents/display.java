package com.example.documents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ListView listView;
        listView=findViewById(R.id.listView);
        DbManager db =new DbManager(this);
        ArrayList arrayList =db.getDocs();
        ArrayAdapter arrayAdapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int arg = position+1;
                Intent intent = new Intent(display.this,specifc.class);
                intent.putExtra("id",arg);
                startActivity(intent);

            }
        });
    }
}