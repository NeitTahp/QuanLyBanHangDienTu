package com.example.doan.CRUD;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import com.example.doan.DBSanPham;
import com.example.doan.R;
import com.example.doan.SanPham;
import com.example.doan.SanPham_Adapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSach;
    static List<SanPham> data_sp = new ArrayList<>();
    List<SanPham> data_pl = new ArrayList<>();
    static List<String> data_lsp = new ArrayList<>();
    static ArrayAdapter adapter_lsp,adapter_hsp;
    static SanPham_Adapter adapter_sp;
    static SanPham_Adapter adapter_dienthoai;
    static SanPham_Adapter adapter_laptop;
    static SanPham_Adapter adapter_manhinh;
    Button btndienthoai,btnlaptop,btnmanhinh,btnall;
    Context context = this;
    static DBSanPham product;
    static databaseloai loaiproduct;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        setControl();
        setEvent();
    }

        private void setEvent() {
            loaiproduct = new databaseloai(this);
//            KhoiTao();
            data_lsp=new ArrayList<>();
            data_lsp.addAll(loaiproduct.DocLoaiDL());
            adapter_lsp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lsp);
        product = new DBSanPham(this);
        data_sp=new ArrayList<>();
        data_sp.addAll(product.DocDL());
//            loaiproduct = new databaseloai(this);
//            data_pl.addAll(loaiproduct.DocLoaiDL());
        //KhoiTao();
        adapter_sp = new SanPham_Adapter(context,R.layout.sanpham_item_layout,data_sp);
        lvDanhSach.setAdapter(adapter_sp);
        btndienthoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_pl = new ArrayList<>();
               for (SanPham item: data_sp){
                   if(item.getLoaiSP().equals("Điện Thoại")){
                       data_pl.add(item);
                   }
               }
               adapter_dienthoai = new SanPham_Adapter(context,R.layout.sanpham_item_layout,data_pl);
               lvDanhSach.setAdapter(adapter_dienthoai);
            }
        });
        btnlaptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_pl = new ArrayList<>();
                for (SanPham item: data_sp){
                    if(item.getLoaiSP().equals("LapTop")){
                        data_pl.add(item);
                    }
                }
                adapter_laptop = new SanPham_Adapter(context,R.layout.sanpham_item_layout,data_pl);
                lvDanhSach.setAdapter(adapter_laptop);
            }
        });
        btnmanhinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_pl = new ArrayList<>();
                for (SanPham item: data_sp){
                    if(item.getLoaiSP().equals("Màn Hình")){
                        data_pl.add(item);
                    }
                }
                adapter_manhinh = new SanPham_Adapter(context,R.layout.sanpham_item_layout,data_pl);
                lvDanhSach.setAdapter(adapter_manhinh);
            }
        });
        btnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter_sp = new SanPham_Adapter(context,R.layout.sanpham_item_layout,data_sp);
                lvDanhSach.setAdapter(adapter_sp);
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.mnThemsp){
                    Intent intent = new Intent(context, AddProductActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId()==R.id.mnXoasp){
                    Intent intent = new Intent(context, DeleteActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId()==R.id.mnSuasp){
                    Intent intent = new Intent(context, EditProductActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId()==R.id.mnCRUDlsp){
                    Intent intent = new Intent(context, CRUDloaisanpham.class);
                    startActivity(intent);
                }


                drawerLayout.closeDrawers();
                return false;
            }
        });
}

    private void KhoiTao() {
        loaiproduct.ThemLoaiDL("Điện Thoại");
        loaiproduct.ThemLoaiDL("LapTop");
        loaiproduct.ThemLoaiDL("Màn Hình");
//        data_sp.add(new Product("dt1","oppo2f","28000000","Điện Thoại","oppo"));
//        data_sp.add(new Product("lt1","Máy Tính Gamming Msi","23000000","LapTop","msi"));
//        data_sp.add(new Product("mh1","Màn Hình 4k","4300000","Màn Hình","Màn Hình 4k"));

    }
    private void setControl() {
        lvDanhSach = findViewById(R.id.lvDanhSach2);
        btndienthoai = findViewById(R.id.btndienthoai);
        btnlaptop = findViewById(R.id.btnlaptop);
        btnmanhinh = findViewById(R.id.btnmanhinh);
        btnall = findViewById(R.id.btnall);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navView);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}