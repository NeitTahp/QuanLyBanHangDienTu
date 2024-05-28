package com.example.doan.CRUD;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan.R;

public class CRUDloaisanpham extends AppCompatActivity {

    EditText edtLoaiSP;
    Button btnThem,btnXoa,btnSua,btnThoat;


    ListView lvloaisp1;



   int index=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudloaisanpham);
        setControl();
        setEvent();
    }

    private void setEvent() {
        lvloaisp1.setAdapter(com.example.doan.CRUD.MainActivity.adapter_lsp);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.doan.CRUD.MainActivity.data_lsp.add(edtLoaiSP.getText().toString());
                com.example.doan.CRUD.MainActivity.loaiproduct.ThemLoaiDL(edtLoaiSP.getText().toString());
                com.example.doan.CRUD.MainActivity.adapter_lsp.notifyDataSetChanged();
            }

        });

        lvloaisp1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
               edtLoaiSP.setText(com.example.doan.CRUD.MainActivity.data_lsp.get(i));
               index=i;
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.doan.CRUD.MainActivity.data_lsp.remove(index);
                com.example.doan.CRUD.MainActivity.adapter_lsp.notifyDataSetChanged();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=edtLoaiSP.getText().toString();
                for (String s: com.example.doan.CRUD.MainActivity.data_lsp
                     ) {
                    if(com.example.doan.CRUD.MainActivity.data_lsp.get(index).equals(a)){
                        s=a;
                    }
                }


                MainActivity.adapter_lsp.notifyDataSetChanged();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setControl() {
        edtLoaiSP = findViewById(R.id.edtLoaiSP);

        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        lvloaisp1 = findViewById(R.id.lvDanhSachLoaiSanPham);


    }

}