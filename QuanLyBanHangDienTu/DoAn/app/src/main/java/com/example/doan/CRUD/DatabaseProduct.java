package com.example.doan.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.example.doan.SanPham;

import java.util.ArrayList;
import java.util.List;

public class DatabaseProduct extends SQLiteOpenHelper {

    public DatabaseProduct(@Nullable Context context){
        super(context,"dbsanpham",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String spl ="Create table tbSanPham (masp text,tensp text, giasp text,loaisp text , hinhsp text)";
        db.execSQL(spl);
    }
    public void ThemDL(SanPham sp){
        String spl = "insert into tbSanPham values(?,?,?,?,?)";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(spl,new String[]{sp.getMaSP(),sp.getTenSP(),sp.getGiaSP(),sp.getLoaiSP(),sp.getHinhSP()});
    }
    public void XoaDL(SanPham sp){
        String spl = "delete from tbSanPham where masp=?";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(spl,new String[]{sp.getMaSP()});
    }
    public void SuaDL(SanPham sp){
        String spl = "Update tbSanPham set tensp=?,giasp=?,loaisp=?,hinhsp=? where masp=?";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(spl,new String[]{sp.getTenSP(),sp.getGiaSP(),sp.getLoaiSP(),sp.getHinhSP(),sp.getMaSP()});
    }
    public List<SanPham> DocDL(){
        List<SanPham> data = new ArrayList<>();
        String spl= "Select * from tbSanPham";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(spl,null);
        if(cursor.moveToFirst()){
            do{
                SanPham pd= new SanPham();
                pd.setMaSP(cursor.getString(0));
                pd.setTenSP(cursor.getString(1));
                pd.setGiaSP(cursor.getString(2));
                pd.setLoaiSP(cursor.getString(3));
                pd.setHinhSP(cursor.getString(4));
                data.add(pd);
            }while (cursor.moveToNext());
        }
        return  data;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}