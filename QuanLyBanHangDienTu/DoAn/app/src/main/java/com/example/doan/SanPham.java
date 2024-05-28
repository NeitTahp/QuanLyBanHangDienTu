package com.example.doan;

import java.io.Serializable;

public class SanPham implements Serializable {
    String maSP, tenSP, giaSP, loaiSP,hinhSP, soluongSP;
    String ngayBanSP;




    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String giaSP, String loaiSP, String hinhSP, String soluongSP, String ngayBanSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.loaiSP = loaiSP;
        this.hinhSP = hinhSP;
        this.soluongSP = soluongSP;
        this.ngayBanSP = ngayBanSP;
    }


    public String getNgayBanSP() {
        return ngayBanSP;
    }

    public void setNgayBanSP(String ngayBanSP) {
        this.ngayBanSP = ngayBanSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(String hinhSP) {
        this.hinhSP = hinhSP;
    }
    public String getSoluongSP() {
        return soluongSP;
    }
    public void setSoluongSP(String soluongSP) {
        this.soluongSP = soluongSP;
    }
}
