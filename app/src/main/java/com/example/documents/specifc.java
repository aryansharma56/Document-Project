package com.example.documents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class specifc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specifc);
        TextView textView,textView3;
        ImageView imageView;
        FloatingActionButton fab;
        fab = findViewById(R.id.floatingActionButton);

        Intent intent =getIntent();
        int val = intent.getIntExtra("id",0);
        DbManager db =new DbManager(this);
        ArrayList<String> desc = db.getData();
        ArrayList<String> img =db.getimg();
        ArrayList<String> name=db.getDocs();
        textView3=findViewById(R.id.textView3);
        textView =findViewById(R.id.textView2);
        textView.setText(desc.get(val-1));
        textView3.setText(name.get(val-1));
        Uri uri = Uri.parse(img.get(val-1));
        imageView =findViewById(R.id.imageView2);
        imageView.setImageURI(uri);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(specifc.this,display.class);
//                db.Delete(val);
                startActivity(intent1);
            }
        });


    }
}