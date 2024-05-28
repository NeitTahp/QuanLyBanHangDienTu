package com.example.doan;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    String firstName,lastName,taiKhoan,matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String firstName, String lastName, String taiKhoan, String matKhau) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
