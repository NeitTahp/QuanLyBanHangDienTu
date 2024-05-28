package com.example.doan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SanPham_Adapter extends ArrayAdapter {
    Context context;
    int resource;
    List<SanPham> data;
    public SanPham_Adapter(@NonNull Context context, int resource, @NonNull List<SanPham> data) {
        super(context, resource, data);
        this.context=context;
        this.resource=resource;
        this.data=data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource,null);
        TextView tvTenSP=convertView.findViewById(R.id.tvTenSP);
        TextView tvGiaSP=convertView.findViewById(R.id.tvGiaSP);
        TextView tvSoLuong = convertView.findViewById(R.id.tvSoLuong);
        TextView tvNgayBanSP = convertView.findViewById(R.id.tvNgayBanSP);
        ImageView ivHinh=convertView.findViewById(R.id.ivHinh);
        SanPham sanPham = data.get(position);
        tvTenSP.setText(sanPham.getTenSP());
        tvGiaSP.setText(sanPham.getGiaSP());
        tvSoLuong.setText(sanPham.getSoluongSP());
        tvNgayBanSP.setText(sanPham.getNgayBanSP());
        if (sanPham.getHinhSP().equals("ip14")){
            ivHinh.setImageResource(R.drawable.ip14);
        }
        if (sanPham.getHinhSP().equals("pcgaming")){
            ivHinh.setImageResource(R.drawable.pcgaming);
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
        return convertView;
    }
}
