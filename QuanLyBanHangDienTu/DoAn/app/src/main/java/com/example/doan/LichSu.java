package com.example.doan;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LichSu extends AppCompatActivity {
    TextView tvTongSP,tvTongTienDaMua;
    ListView lvLichSu;
    static List<SanPham> data_ls=new ArrayList<>();
    static SanPham_Adapter Adatter_ls;
    static int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su);
        setControl();
        setEvent();
    }

    private void setEvent() {
//        KhoiTao();
        LichSu.data_ls.addAll(MainActivity.dbThongKe.DocDL());
        Adatter_ls = new SanPham_Adapter(this, R.layout.sanpham_lichsu,data_ls);
        lvLichSu.setAdapter(Adatter_ls);

        
        n=0;
        int TongTien=0;
        for (SanPham item: data_ls){
            TongTien+=Integer.parseInt(item.giaSP);
            n++;
        }
        tvTongTienDaMua.setText(String.valueOf(TongTien));
        tvTongSP.setText(String.valueOf(n));
    }

    private void setControl() {
        tvTongSP = findViewById(R.id.tvTongSP);
        lvLichSu = findViewById(R.id.lvLichSu);
        tvTongTienDaMua= findViewById(R.id.tvTongTienDaMua);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.danhmuc_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void KhoiTao() {
        SanPham sp = new SanPham("DT01","iPhone 14 Pro Max 256GB","25200000","DT","ip14","2","2023-1-11/");
        MainActivity.dbThongKe.ThemDL(sp);
        MainActivity.dbThongKe.ThemDL(new SanPham("PC01","Máy tính Office SG Core i3 Gen 12","8100000","PC","pcgaming","3","1-1-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("LT01","ASUS ROG Strix G15 G513RC-HN038W","22490000" ,"LT","laptop","1","25-3-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("LT03","Laptop MSI Gaming GF63","14490000" ,"LT","laptop3","1","28-2-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("LT02","LG Gram 14 2022","17990000" ,"LT","laptop1","2","21-2-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("DT02","Xiaomi Redmi K50 Gaming Edition 12GB","6790000" ,"DT","xiaomi","5","7-4-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("DT03","Xiaomi Redmi Note 11T Pro 5G 8GB","4190000" ,"DT","xiaomi2","4","4-5-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("PC02","HP ProOne 440 G9 AIO i5","21990000" ,"PC","pc02","3","11-6-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("PC03","Asus ExpertCenter AIO","14190000" ,"PC","pc03","3","9-7-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("PC03","Asus ExpertCenter AIO","14190000" ,"PC","pc03","3","1-8-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("PC03","Asus ExpertCenter AIO","14190000" ,"PC","pc03","3","12-9-2023"));
        MainActivity.dbThongKe.ThemDL(new SanPham("PC03","Asus ExpertCenter AIO","14190000" ,"PC","pc03","3","15-10-2023"));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.mnBack){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}