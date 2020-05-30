package com.aa183.sinta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbnegara";
    public static final String TABLE_NAME = "tbnegara";
    public static final String COL_1 = "idnegara";
    public static final String COL_2 = "nama_negara";
    public static final String COL_3 = "presiden";
    public static final String COL_4 = "benua";
    public static final String COL_5 = "populasi";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (idnegara INTEGER PRIMARY KEY AUTOINCREMENT, nama_negara TEXT, presiden TEXT, benua TEXT, populasi INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }



    public boolean insertData(String nama_negara, String presiden, String benua, String populasi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,nama_negara);
        contentValues.put(COL_3,presiden);
        contentValues.put(COL_4,benua);
        contentValues.put(COL_5,populasi);
        long result = db.insert(TABLE_NAME, null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }

    public Cursor getId() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select idnegara from " + TABLE_NAME,null);
        return c;
    }

    public boolean updatedata(String id, String nama_negara, String presiden, String benua, String populasi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,nama_negara);
        contentValues.put(COL_3,presiden);
        contentValues.put(COL_4,benua);
        contentValues.put(COL_5,populasi);
        db.update(TABLE_NAME, contentValues, "idnegara = ?",new String[] { id });
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "idnegara = ?",new String[] {id});
    }
}
