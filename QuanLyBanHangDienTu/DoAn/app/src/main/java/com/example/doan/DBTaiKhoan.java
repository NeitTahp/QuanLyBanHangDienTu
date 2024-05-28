package com.example.doan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBTaiKhoan extends SQLiteOpenHelper {
    public DBTaiKhoan(@Nullable Context context){ super(context, "dbTaiKhoan", null, 1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="Create table tbTaiKhoan(firstname text,lastname text,taikhoan text,matkhau text)";
        db.execSQL(sql);
    }
    public void ThemDL(TaiKhoan tk){
        String sql = "insert into tbTaiKhoan values(?,?,?,?)";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql, new String[]{tk.getFirstName(), tk.getLastName(),tk.getTaiKhoan(), tk.getMatKhau()});
    }
    public List<TaiKhoan> DocDL(){
        List<TaiKhoan> data = new ArrayList<>();
        String sql = "Select * from tbTaiKhoan";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do{
                TaiKhoan tk = new TaiKhoan();
                tk.setFirstName(cursor.getString(0));
                tk.setLastName(cursor.getString(1));
                tk.setTaiKhoan(cursor.getString(2));
                tk.setMatKhau(cursor.getString(3));

                data.add(tk);
            }
            while (cursor.moveToNext());
        }
        return data;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
