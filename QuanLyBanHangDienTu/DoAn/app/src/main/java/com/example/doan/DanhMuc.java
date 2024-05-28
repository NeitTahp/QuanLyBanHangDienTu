package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DanhMuc extends AppCompatActivity {
    Button btnPC, btnDienThoai, btnLaptop;
    ListView lvDanhMuc;

    static List<SanPham> data_dm=new ArrayList<>();
    static SanPham_Adapter Adapter_dm;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc);
        setControl();
        setEvent();
    }

    private void setEvent() {
        lvDanhMuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,MuaSanPham.class);
                intent.putExtra("item",data_dm.get(position));
                startActivity(intent);
            }
        });
        btnPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_dm=new ArrayList<>();
                for (SanPham item : MainActivity.data_sp){
                    if (item.getLoaiSP().equals("PC")){
                        data_dm.add(item);
                    }
                }
                Adapter_dm=new SanPham_Adapter(context,R.layout.sanpham,data_dm);
                lvDanhMuc.setAdapter(Adapter_dm);
            }
        });
        btnLaptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_dm=new ArrayList<>();
                for (SanPham item : MainActivity.data_sp){
                    if (item.getLoaiSP().equals("LT")){
                        data_dm.add(item);
                    }
                }
                Adapter_dm=new SanPham_Adapter(context,R.layout.sanpham,data_dm);
                lvDanhMuc.setAdapter(Adapter_dm);
            }
        });
        btnDienThoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_dm=new ArrayList<>();
                for (SanPham item : MainActivity.data_sp){
                    if (item.getLoaiSP().equals("DT")){
                        data_dm.add(item);
                    }
                }
                Adapter_dm=new SanPham_Adapter(context,R.layout.sanpham,data_dm);
                lvDanhMuc.setAdapter(Adapter_dm);
            }
        });
    }



    private void setControl() {
        lvDanhMuc = findViewById(R.id.lvDanhMuc);
        btnPC = findViewById(R.id.btnPC);
        btnDienThoai = findViewById(R.id.btnDienThoai);
        btnLaptop = findViewById(R.id.btnLaptop);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.danhmuc_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.mnBack){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}