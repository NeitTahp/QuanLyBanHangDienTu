package com.example.doan;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MuaSanPham extends AppCompatActivity {

    ImageView ivHinh;
    TextView tvTenSP,tvGiaSP,tvSoLuong;
    Button btnMuaSP,btnGioHang;
    SanPham sanPham;
    static List<SanPham> data_gh=new ArrayList<>();
    static SanPham_Adapter Adapter_gh;
    static DBSanPhamGioHang dbSanPhamGioHang;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodienmuasanpham);
        setControl();
        setEvent();
    }

    private void setEvent() {
        dbSanPhamGioHang = new DBSanPhamGioHang(this);
        sanPham = (SanPham) getIntent().getSerializableExtra("item");
        tvTenSP.setText(sanPham.getTenSP());
        tvGiaSP.setText(sanPham.getGiaSP());
        tvSoLuong.setText(sanPham.getSoluongSP());

        if (sanPham.getHinhSP().equals("pcgaming")){
            ivHinh.setImageResource(R.drawable.pcgaming);

        }
        if (sanPham.getHinhSP().equals("ip14")){
            ivHinh.setImageResource(R.drawable.ip14);
        }

        if (sanPham.getHinhSP().equals("laptop")){
            ivHinh.setImageResource(R.drawable.laptop);
        }
        if (sanPham.getHinhSP().equals("laptop1")){
            ivHinh.setImageResource(R.drawable.laptop1);
        }
        if (sanPham.getHinhSP().equals("laptop3")){
            ivHinh.setImageResource(R.drawable.laptop3);
        }
        if (sanPham.getHinhSP().equals("pc02")){
            ivHinh.setImageResource(R.drawable.pc02);
        }
        if (sanPham.getHinhSP().equals("pc03")){
            ivHinh.setImageResource(R.drawable.pc03);
        }
        if (sanPham.getHinhSP().equals("xiaomi")){
            ivHinh.setImageResource(R.drawable.xiaomi);
        }
        if (sanPham.getHinhSP().equals("xiaomi2")){
            ivHinh.setImageResource(R.drawable.xiaomi2);
        }
        if (sanPham.getLoaiSP().equals("Điện Thoại"))
            ivHinh.setImageResource(R.drawable.loaidienthoai);
        if (sanPham.getLoaiSP().equals("LapTop"))
            ivHinh.setImageResource(R.drawable.loailaptop);
        if (sanPham.getLoaiSP().equals("Màn Hình"))
            ivHinh.setImageResource(R.drawable.loaimanhinh);
        if (sanPham.getHinhSP().equals("oppo"))
            ivHinh.setImageResource(R.drawable.oppo);
        if (sanPham.getHinhSP().equals("iphone"))
            ivHinh.setImageResource(R.drawable.iphone);
        if (sanPham.getHinhSP().equals("samsung"))
            ivHinh.setImageResource(R.drawable.samsung);
        if (sanPham.getHinhSP().equals("Màn Hình 4k"))
            ivHinh.setImageResource(R.drawable.bonk);
        if (sanPham.getHinhSP().equals("Màn Hình Asus"))
            ivHinh.setImageResource(R.drawable.manhinhasus);
        if (sanPham.getHinhSP().equals("msi"))
            ivHinh.setImageResource(R.drawable.msi);
        if (sanPham.getHinhSP().equals("dell"))
            ivHinh.setImageResource(R.drawable.dell);
        btnMuaSP.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                for (SanPham item: MainActivity.data_sp){
                    if (item.getMaSP().equals(sanPham.getMaSP())){
                        if(item.getSoluongSP().equals("1")){
                            MainActivity.dbSanPham.XoaDL(item);
                            MainActivity.data_sp.remove(item);
                            item.setNgayBanSP(String.valueOf(java.time.LocalDate.now()));
                            MainActivity.dbThongKe.ThemDL(item);
                            LichSu.n++;
                            MainActivity.Adapter_sp.notifyDataSetChanged();
                            Toast.makeText(MuaSanPham.this, "Mua thành công", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            item.setSoluongSP(String.valueOf(Integer.parseInt(item.getSoluongSP())-1));
                            MainActivity.dbSanPham.SuaDL(item);
                            MainActivity.Adapter_sp.notifyDataSetChanged();
                            item.setNgayBanSP(String.valueOf(java.time.LocalDate.now()));
                            MainActivity.dbThongKe.ThemDL(item);
                            LichSu.n++;
                            Toast.makeText(MuaSanPham.this, "Mua thành công", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }
                finish();
            }
        });
        btnGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (SanPham item: MainActivity.data_sp){
                    if (item.getMaSP().equals(sanPham.getMaSP())){
                        if(item.getSoluongSP().equals("1")){
                            MainActivity.data_sp.remove(item);
                            MainActivity.dbSanPham.XoaDL(item);

                            MainActivity.Adapter_sp.notifyDataSetChanged();
                            Toast.makeText(MuaSanPham.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        else {
                            item.setSoluongSP(String.valueOf(Integer.parseInt(item.getSoluongSP())-1));
                            MainActivity.dbSanPham.SuaDL(item);
                            MainActivity.Adapter_sp.notifyDataSetChanged();
                            Toast.makeText(MuaSanPham.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }
                dbSanPhamGioHang.ThemDL(sanPham);
                data_gh.add(sanPham);
                finish();
            }
        });
    }

    private void setControl() {
        ivHinh = findViewById(R.id.ivHinh);
        tvTenSP = findViewById(R.id.tvTenSP);
        tvGiaSP = findViewById(R.id.tvGiaSP);
        tvSoLuong = findViewById(R.id.tvSoLuong);
        btnMuaSP = findViewById(R.id.btnMuaSP);
        btnGioHang = findViewById(R.id.btnGioHang);
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