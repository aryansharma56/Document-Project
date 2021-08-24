package com.example.documents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.github.dhaval2404.imagepicker.ImagePicker;

public class Add_Data extends AppCompatActivity {
    ImageView imageView;
    global g =new global();
    Button select_image,addData;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__data);
        EditText docName,description;


        imageView=findViewById(R.id.imageView);
        DbManager dbhelper =new DbManager(this);
        SQLiteDatabase db =dbhelper.getWritableDatabase();
        docName=findViewById(R.id.docName);
        description=findViewById(R.id.description);
        select_image=findViewById(R.id.select_image);
        addData=findViewById(R.id.addData);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbhelper.insertDetails(docName.getText().toString(),description.getText().toString(),g.x);
                docName.setText("");
                description.setText("");
                imageView.setVisibility(View.INVISIBLE);
                select_image.setVisibility(View.VISIBLE);


            }
        });
        select_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Add_Data.this)
                          .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)

                          .start();

            }
        });








    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri =data.getData();
        imageView.setImageURI(uri);
        g.x =uri.toString();
        select_image.setVisibility(View.INVISIBLE);


    }
}