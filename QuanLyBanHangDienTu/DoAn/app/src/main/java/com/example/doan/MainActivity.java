package com.example.doan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSach;
    static List<SanPham> data_sp=new ArrayList<>();
    static SanPham_Adapter Adapter_sp;
    static DBSanPham dbSanPham;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    static DBThongKe dbThongKe;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        dbThongKe = new DBThongKe(this);

        dbSanPham = new DBSanPham(this);
        MuaSanPham.dbSanPhamGioHang = new DBSanPhamGioHang(this);
        MuaSanPham.data_gh=new ArrayList<>();
        MuaSanPham.data_gh.addAll(MuaSanPham.dbSanPhamGioHang.DocDL());
        MuaSanPham.Adapter_gh=new SanPham_Adapter(this,R.layout.sanpham_giohang,MuaSanPham.data_gh);
//        KhoiTao();
        data_sp=new ArrayList<>();
        data_sp.addAll(dbSanPham.DocDL());
        Adapter_sp=new SanPham_Adapter(this, R.layout.sanpham,data_sp);
        lvDanhSach.setAdapter(Adapter_sp);
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MuaSanPham.class);
                intent.putExtra("item",data_sp.get(position));
                startActivity(intent);
            }
        });

        //Navigation
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if (item.getItemId()==R.id.mnThongKe){
                    Intent intent = new Intent(context, ThongKeTheoThang.class);
                    startActivity(intent);
                }
                if (item.getItemId()==R.id.mnTheLoai){
                    Intent intent = new Intent(context, DanhMuc.class);
                    startActivity(intent);
                }
                if (item.getItemId()==R.id.mnLichSu){
                    Intent intent = new Intent(context, LichSu.class);
                    startActivity(intent);
                }
                if (item.getItemId()==R.id.mnDoHang){
                    Intent intent = new Intent(context, GioHang.class);
                    startActivity(intent);
                }
                if (item.getItemId()==R.id.mnTimKiem){
                    Intent intent = new Intent(context, TimKiem.class);
                    startActivity(intent);
                }
                if (fragment!=null){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContent,fragment).commit();
                }
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    private void KhoiTao() {
        SanPham sp = new SanPham("DT01","iPhone 14 Pro Max 256GB","25200000","DT","ip14","2","11/1/2023");
        dbSanPham.ThemDL(sp);
        dbSanPham.ThemDL(new SanPham("PC01","Máy tính Office SG Core i3 Gen 12","8100000","PC","pcgaming","3","11/1/2023"));
        dbSanPham.ThemDL(new SanPham("LT01","ASUS ROG Strix G15 G513RC-HN038W","22490000" ,"LT","laptop","1","11/1/2023"));
        dbSanPham.ThemDL(new SanPham("LT03","Laptop MSI Gaming GF63","14490000" ,"LT","laptop3","1","11/1/2023"));
        dbSanPham.ThemDL(new SanPham("LT02","LG Gram 14 2022","17990000" ,"LT","laptop1","2","11/1/2023"));
        dbSanPham.ThemDL(new SanPham("DT02","Xiaomi Redmi K50 Gaming Edition 12GB","6790000" ,"DT","xiaomi","5","11/1/2023"));
        dbSanPham.ThemDL(new SanPham("DT03","Xiaomi Redmi Note 11T Pro 5G 8GB","4190000" ,"DT","xiaomi2","4","11/1/2023"));
        dbSanPham.ThemDL(new SanPham("PC02","HP ProOne 440 G9 AIO i5","21990000" ,"PC","pc02","3","11/1/2023"));
        dbSanPham.ThemDL(new SanPham("PC03","Asus ExpertCenter AIO","14190000" ,"PC","pc03","3","11/1/2023"));
    }

    private void setControl() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navView);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.sanpham_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}