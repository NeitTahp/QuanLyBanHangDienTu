package com.example.doan.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class databaseloai extends SQLiteOpenHelper {

    public databaseloai(@Nullable Context context){
        super(context,"dbLoaiSanPham",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String spl ="Create table tbLoaiSanPham (loaisp text)";
        db.execSQL(spl);
    }
    public void ThemLoaiDL(String sp){
        String spl = "insert into tbLoaiSanPham values(?)";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(spl,new String[]{sp});
    }
    public void XoaLoaiDL(String sp){
        String spl = "delete from tbLoaiSanPham where loaisp=?";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(spl,new String[]{sp});
    }
    public void SuaDL(String sp){
        String spl = "Update tbLoaiSanPham set loaisp=? where loaisp=?";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(spl,new String[]{sp,sp});
    }
public List<String> DocLoaiDL(){
    List<String> data = new ArrayList<>();
    String spl= "Select * from tbLoaiSanPham";
    SQLiteDatabase sqLiteDatabase =getReadableDatabase();
    Cursor cursor = sqLiteDatabase.rawQuery(spl,null);
    if(cursor.moveToFirst()){
        do{

            data.add(cursor.getString(0));
        }while (cursor.moveToNext());
    }
    return  data;
}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}