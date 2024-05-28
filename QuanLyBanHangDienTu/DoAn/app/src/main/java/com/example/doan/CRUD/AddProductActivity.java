package com.example.doan.CRUD;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.doan.R;
import com.example.doan.SanPham;

import java.util.ArrayList;
import java.util.List;

public class AddProductActivity extends AppCompatActivity {
    EditText edtMaSP, edtTenSP, edtGiaSP, edtSoLuong;
    Spinner spLoaiSP,hinhsp;

    List<String> data_hsp = new ArrayList<>();

    ImageView ivHinh,ivHinh2;
    Button btnThem,btnLamMoi;
    ImageView ivBack;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_san_pham);
        setControl();
        setEvent();
    }

    private void setEvent() {


        spLoaiSP.setAdapter(MainActivity.adapter_lsp);



        btnThem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(edtMaSP.getText().length()<=0){
                    edtMaSP.setError("ban phải nhập mã");
                    edtMaSP.requestFocus();
                    return;
                }
                if(edtTenSP.getText().length()<=0){
                    edtTenSP.setError("ban phải nhập tên");
                    edtTenSP.requestFocus();
                    return;
                }
                if(edtGiaSP.getText().length()<=0){
                    edtGiaSP.setError("ban phải nhập giá");
                    edtGiaSP.requestFocus();
                    return;
                }
                if(edtSoLuong.getText().length()<=0){
                    edtSoLuong.setError("ban phải nhập số lượng");
                    edtSoLuong.requestFocus();
                    return;
                }
                SanPham product = new SanPham();
                product.setMaSP(edtMaSP.getText().toString());
                product.setTenSP(edtTenSP.getText().toString());
                product.setGiaSP(edtGiaSP.getText().toString());
                product.setSoluongSP(edtSoLuong.getText().toString());
                product.setLoaiSP(spLoaiSP.getSelectedItem().toString());
                product.setHinhSP(hinhsp.getSelectedItem().toString());
                com.example.doan.CRUD.MainActivity.data_sp.add(product);
                com.example.doan.CRUD.MainActivity.product.ThemDL(product);
                com.example.doan.CRUD.MainActivity.adapter_sp.notifyDataSetChanged();
                Toast.makeText(AddProductActivity.this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnLamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtMaSP.setText("");
                edtTenSP.setText("");
                edtGiaSP.setText("");
                edtSoLuong.setText("");
                spLoaiSP.setSelection(0);
            }
        });
        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                data_hsp= new ArrayList<>();

                    data_hsp.add("oppo");
                    data_hsp.add("iphone");
                    data_hsp.add("samsung");


                    data_hsp.add("msi");
                    data_hsp.add("dell");



                    data_hsp.add("Màn Hình 4k");
                    data_hsp.add("Màn Hình Asus");

                com.example.doan.CRUD.MainActivity.adapter_hsp = new ArrayAdapter(context, android.R.layout.simple_list_item_1,data_hsp);
                hinhsp.setAdapter(com.example.doan.CRUD.MainActivity.adapter_hsp);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        hinhsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (hinhsp.getSelectedItem().toString().equals("oppo"))
                    ivHinh2.setImageResource(R.drawable.oppo);
                if (hinhsp.getSelectedItem().toString().equals("iphone"))
                    ivHinh2.setImageResource(R.drawable.iphone);
                if (hinhsp.getSelectedItem().toString().equals("samsung"))
                    ivHinh2.setImageResource(R.drawable.samsung);
                if (hinhsp.getSelectedItem().toString().equals("Màn Hình 4k"))
                    ivHinh2.setImageResource(R.drawable.bonk);
                if (hinhsp.getSelectedItem().toString().equals("Màn Hình Asus"))
                    ivHinh2.setImageResource(R.drawable.manhinhasus);
                if (hinhsp.getSelectedItem().toString().equals("msi"))
                    ivHinh2.setImageResource(R.drawable.msi);
                if (hinhsp.getSelectedItem().toString().equals("dell"))
                    ivHinh2.setImageResource(R.drawable.dell);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void setControl() {
        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSP = findViewById(R.id.edtGiaSP);
        edtSoLuong = findViewById(R.id.edtSoLuongSP);
        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnThem = findViewById(R.id.btnThem);
        btnLamMoi = findViewById(R.id.btnLamMoi);
        ivBack = findViewById(R.id.ivBack);
        ivHinh2 = findViewById(R.id.ivHinh2);
        hinhsp = findViewById(R.id.hinhsp);
    }
}