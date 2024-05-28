package com.example.doan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangKy extends AppCompatActivity {
    EditText edtFirstName,edtLastName,edtTaiKhoan,edtMatKhau,edtMatKhauNhapLai;
    Button btnCreate;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtFirstName.getText().toString().equals("")){
                    edtFirstName.setError("Chưa nhập FirstName");
                    edtFirstName.requestFocus();
                    return;
                }
                if(edtLastName.getText().toString().equals("")){
                    edtLastName.setError("Chưa nhập LastName");
                    edtLastName.requestFocus();
                    return;
                }
                if(edtTaiKhoan.getText().toString().equals("")){
                    edtTaiKhoan.setError("Chưa nhập tài khoản");
                    edtTaiKhoan.requestFocus();
                    return;
                }
                if(edtMatKhau.getText().toString().equals("")){
                    edtMatKhau.setError("Chưa nhập mật khẩu");
                    edtMatKhau.requestFocus();
                    return;
                }

                if (!edtMatKhau.getText().toString().equals(edtMatKhauNhapLai.getText().toString())){
                    edtMatKhauNhapLai.setError("Mật khẩu nhập lại không giống mật khẩu bạn nhập");
                }
                else {
                    TaiKhoan tk = new TaiKhoan();
                    tk.setFirstName(edtFirstName.getText().toString());
                    tk.setLastName(edtLastName.getText().toString());
                    tk.setTaiKhoan(edtTaiKhoan.getText().toString());
                    tk.setMatKhau(edtMatKhau.getText().toString());
                    DangNhap.database_TaiKhoan.ThemDL(tk);
                    DangNhap.data_TK.add(tk);
                    Intent intent = new Intent(context, DangNhap.class);
                    startActivity(intent);
                    Toast.makeText(context, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void setControl() {
        edtFirstName=findViewById(R.id.edtFirstName);
        edtLastName=findViewById(R.id.edtLastName);
        edtTaiKhoan=findViewById(R.id.edtTaiKhoan);
        edtMatKhau=findViewById(R.id.edtMatKhau);
        edtMatKhauNhapLai=findViewById(R.id.edtMatKhauNL);
        btnCreate=findViewById(R.id.btnCreate);
    }

}