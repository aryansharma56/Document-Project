package com.example.documents;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DbManager extends SQLiteOpenHelper {
    public DbManager(Context context) {
        super(context,"data.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DOCUMENTS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT,image TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS DOCUMENTS");
        onCreate(db);

    }
    public boolean insertDetails(String name,String description,String image)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("name",name);
        cv.put("description",description);
        cv.put("image",image);
        db.insert("DOCUMENTS",null,cv);

        return true;


    }
    public ArrayList<String> getDocs() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from DOCUMENTS", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("name")));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getData() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res =  db.rawQuery( "select * from DOCUMENTS where id="+id+"", null );
//        String s =res.getString(res.getColumnIndex("description"));
//        return s;
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from DOCUMENTS", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("description")));
            res.moveToNext();
        }
        return array_list;

    }
    public ArrayList<String> getimg() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from DOCUMENTS", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex("image")));
            res.moveToNext();
        }
        return array_list;
    }
    public boolean Delete(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete("DOCUMENTS", id +  "=" + id, null) > 0;
    }
}
