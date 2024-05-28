package com.example.doan;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class GioHang extends AppCompatActivity {
    ListView lvGioHang;
    TextView tvTongTien;
    Button btnThanhToan;
    int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        setControl();
        setEvent();
    }

    private void setEvent() {
        int TongTien=0;

        lvGioHang.setAdapter(MuaSanPham.Adapter_gh);
        for (SanPham item: MuaSanPham.data_gh){
            TongTien+=Integer.parseInt(item.giaSP);
        }
        tvTongTien.setText(String.valueOf(TongTien));
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                for (SanPham item : MuaSanPham.data_gh){
                    item.setNgayBanSP(String.valueOf(java.time.LocalDate.now()));
                    MainActivity.dbThongKe.ThemDL(item);
                    LichSu.n++;
                }
                for (SanPham item : MuaSanPham.data_gh){
                    MuaSanPham.dbSanPhamGioHang.XoaDL(item);
                }
                for (int i = MuaSanPham.Adapter_gh.getCount()-1; i >=0 ; i--) {
                    MuaSanPham.data_gh.remove(MuaSanPham.data_gh.get(i));

                }


                MuaSanPham.Adapter_gh.notifyDataSetChanged();
                finish();
                Toast.makeText(GioHang.this, "Thanh toán thành công", Toast.LENGTH_SHORT).show();
            }
        });
        lvGioHang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                if(MuaSanPham.data_gh.get(position).getSoluongSP().equals("1")){
                    MainActivity.data_sp.add(MuaSanPham.data_gh.get(position));
                    MainActivity.dbSanPham.ThemDL(MuaSanPham.data_gh.get(position));
                    MainActivity.Adapter_sp.notifyDataSetChanged();
                }
                else {
                    for(SanPham item : MainActivity.data_sp){
                        if (item.getMaSP().equals(MuaSanPham.data_gh.get(position).getMaSP())){
                            item.setSoluongSP(String.valueOf(Integer.parseInt(item.getSoluongSP())+1));
                            MainActivity.dbSanPham.SuaDL(item);
                            MainActivity.Adapter_sp.notifyDataSetChanged();
                        }
                    }
                }

                for(SanPham item : MuaSanPham.data_gh){
                    if (item.getMaSP().equals(MuaSanPham.data_gh.get(position).getMaSP())){
                        n++;
                    }
                }
                MuaSanPham.dbSanPhamGioHang.XoaDL(MuaSanPham.data_gh.get(position));
                if (n>=2){
                    for (int i = 1; i < n; i++) {
                        MuaSanPham.dbSanPhamGioHang.ThemDL(MuaSanPham.data_gh.get(position));
                    }
                }

                MuaSanPham.data_gh.remove(MuaSanPham.data_gh.get(position));

                MuaSanPham.Adapter_gh.notifyDataSetChanged();
                int TongTien=0;
                for (SanPham item: MuaSanPham.data_gh){
                    TongTien+=Integer.parseInt(item.giaSP);
                }
                tvTongTien.setText(String.valueOf(TongTien));
                Toast.makeText(GioHang.this, "Xóa sản phẩm ra khỏi giỏ hàng thành công", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    private void setControl() {
        lvGioHang=findViewById(R.id.lvGioHang);
        tvTongTien=findViewById(R.id.tvTongTien);
        btnThanhToan=findViewById(R.id.btnThanhToan);
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