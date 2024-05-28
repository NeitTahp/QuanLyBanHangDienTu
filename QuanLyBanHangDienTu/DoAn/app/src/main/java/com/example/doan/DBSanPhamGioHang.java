package com.example.doan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBSanPhamGioHang extends SQLiteOpenHelper {
    public DBSanPhamGioHang(@Nullable Context context){
        super(context, "dbSanPhamGioHang", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String spl="Create table tbSanPham(masp text, tensp text, giasp text, loaisp text,hinhsp text, soluongsp text)";
        sqLiteDatabase.execSQL(spl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void ThemDL(SanPham sp){
        String sql = "insert into tbSanPham values(?,?,?,?,?,?)";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql, new String[]{sp.getMaSP(), sp.getTenSP(), sp.getGiaSP(), sp.getLoaiSP(), sp.getHinhSP(), sp.getSoluongSP()});
    }
    public List<SanPham> DocDL(){
        List<SanPham> data = new ArrayList<>();
        String sql = "Select * from tbSanPham";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do{
                SanPham sp = new SanPham();
                sp.setMaSP(cursor.getString(0));
                sp.setTenSP(cursor.getString(1));
                sp.setGiaSP(cursor.getString(2));
                sp.setLoaiSP(cursor.getString(3));
                sp.setHinhSP(cursor.getString(4));
                sp.setSoluongSP(cursor.getString(5));
                data.add(sp);
            }
            while (cursor.moveToNext());
        }
        return data;
    }
    public void XoaDL(SanPham sp){
        String sql="delete from tbSanPham where masp=?";
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL(sql,new String[]{sp.getMaSP()});
    }
    public void SuaDL(SanPham sp){
        String sql="Update tbSanPham set tensp=?,giasp=?,loaisp=?,hinhsp=? where masp=? and soluongsp=?";
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL(sql,new String[]{sp.getTenSP(), sp.getGiaSP(), sp.getLoaiSP(), sp.getHinhSP(),sp.getMaSP(), sp.getSoluongSP()});
    }
}
