package com.example.doan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DangNhap extends AppCompatActivity {
    EditText edtTaiKhoan,edtMatKhau;
    Button btnLogin,btnQuenMK,btnSignUp;
    Context context = this;
    static List<TaiKhoan> data_TK=new ArrayList<>();
    static DBTaiKhoan database_TaiKhoan;
    int ketqua=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        setControl();
        setEvent();
    }

    private void setEvent() {
        database_TaiKhoan=new DBTaiKhoan(this);
        data_TK.addAll(database_TaiKhoan.DocDL());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua=-1;
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
                if (edtTaiKhoan.getText().toString().equals("admin")&&edtMatKhau.getText().toString().equals("123")){
                    Intent intent = new Intent(context, com.example.doan.CRUD.MainActivity.class);
                    startActivity(intent);
                    return;
                }
                for (TaiKhoan item :data_TK){
                    if (item.getTaiKhoan().equals(edtTaiKhoan.getText().toString())&&item.getMatKhau().equals(edtMatKhau.getText().toString())){
                        ketqua=1;
                    }
                }
                if (ketqua==1){
                    Intent intent=new Intent(context, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(context, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DangKy.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        edtTaiKhoan=findViewById(R.id.edtTaiKhoan);
        edtMatKhau=findViewById(R.id.edtMatKhau);
        btnLogin=findViewById(R.id.btnLogin);
        btnQuenMK=findViewById(R.id.btnQuenMK);
        btnSignUp=findViewById(R.id.btnSignUp);
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