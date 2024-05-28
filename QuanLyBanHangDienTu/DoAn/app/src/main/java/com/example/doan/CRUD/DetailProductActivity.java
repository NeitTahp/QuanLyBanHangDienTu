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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.doan.R;
import com.example.doan.SanPham;

import java.util.ArrayList;
import java.util.List;

public class DetailProductActivity extends AppCompatActivity {
    EditText edtTenSP, edtGiaSP, edtSoLuong;
    Spinner spLoaiSP,hinhsp;
    List<String> data_lsp = new ArrayList<>();
    List<String> data_hsp = new ArrayList<>();
    ArrayAdapter adapter_lsp,adapter_hsp;
    ImageView ivHinh,ivHinh2;
    Button btnSua;
    TextView tvMaSP;
    SanPham product;
    ImageView ivBack;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_suasanpham);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        product = (SanPham) getIntent().getSerializableExtra("item");
        adapter_lsp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_lsp);
        spLoaiSP.setAdapter(adapter_lsp);
        adapter_hsp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,data_hsp);
        hinhsp.setAdapter(adapter_hsp);
        tvMaSP.setText(product.getMaSP());
        edtTenSP.setText(product.getTenSP());
        edtGiaSP.setText(product.getGiaSP());
        edtSoLuong.setText(product.getSoluongSP());
        if (product.getLoaiSP().equals("Điện Thoại"))
            spLoaiSP.setSelection(0);
        if (product.getLoaiSP().equals("LapTop"))
            spLoaiSP.setSelection(1);
        if (product.getLoaiSP().equals("Màn Hình"))
            spLoaiSP.setSelection(2);
        if (product.getHinhSP().equals("oppo"))
            hinhsp.setSelection(0);
        if (product.getHinhSP().equals("Màn Hình 4k"))
            hinhsp.setSelection(1);
        if (product.getHinhSP().equals("msi"))
            hinhsp.setSelection(2);

        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                data_hsp= new ArrayList<>();
                if (spLoaiSP.getSelectedItem().toString().equals("Điện Thoại"))
                {
                    data_hsp.add("oppo");
                    data_hsp.add("iphone");
                    data_hsp.add("samsung");
                }
                if (spLoaiSP.getSelectedItem().toString().equals("LapTop")){
                    data_hsp.add("msi");
                    data_hsp.add("dell");
                }

                if (spLoaiSP.getSelectedItem().toString().equals("Màn Hình")){
                    data_hsp.add("Màn Hình 4k");
                    data_hsp.add("Màn Hình Asus");
                }
                adapter_hsp = new ArrayAdapter(context, android.R.layout.simple_list_item_1,data_hsp);
                hinhsp.setAdapter(adapter_hsp);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (SanPham item: com.example.doan.CRUD.MainActivity.data_sp) {
                    if (item.getMaSP().equals(product.getMaSP()))
                    {
                        item.setTenSP(edtTenSP.getText().toString());
                        item.setGiaSP(edtGiaSP.getText().toString());
                        item.setSoluongSP(edtSoLuong.getText().toString());
                        item.setLoaiSP(spLoaiSP.getSelectedItem().toString());
                        item.setHinhSP(hinhsp.getSelectedItem().toString());
                        com.example.doan.CRUD.MainActivity.product.SuaDL(item);
                        MainActivity.adapter_sp.notifyDataSetChanged();
                        Toast.makeText(DetailProductActivity.this, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                        break;
                    }

                }
                onBackPressed();
            }
        });
    }

    private void KhoiTao() {
        data_lsp.add("Điện Thoại");
        data_lsp.add("LapTop");
        data_lsp.add("Màn Hình");
        data_hsp.add("oppo");
        data_hsp.add("Màn Hình 4k");
        data_hsp.add("msi");
    }

    private void setControl() {
        tvMaSP = findViewById(R.id.tvMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtGiaSP = findViewById(R.id.edtGiaSP);
        edtSoLuong=findViewById(R.id.edtSoLuongSP);
        spLoaiSP = findViewById(R.id.spLoaiSP);
        ivHinh = findViewById(R.id.ivHinh);
        btnSua = findViewById(R.id.btnSua);
        ivBack = findViewById(R.id.ivBack);
        ivHinh2 = findViewById(R.id.ivHinh2);
        hinhsp = findViewById(R.id.hinhsp);
    }
}