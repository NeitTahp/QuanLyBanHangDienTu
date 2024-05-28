package com.example.doan.CRUD;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan.R;

public class DeleteActivity extends AppCompatActivity {
    ListView lv_sanpham;
    ImageView ivBack;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xoa_san_pham);
        setControl();
        setEvent();
    }

    private void setEvent() {
        lv_sanpham.setAdapter(com.example.doan.CRUD.MainActivity.adapter_sp);
        lv_sanpham.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                com.example.doan.CRUD.MainActivity.product.XoaDL(com.example.doan.CRUD.MainActivity.data_sp.get(position));
                com.example.doan.CRUD.MainActivity.data_sp.remove(position);
                Toast.makeText(DeleteActivity.this, "Xóa Sản Phẩm Thành Công", Toast.LENGTH_SHORT).show();
                MainActivity.adapter_sp.notifyDataSetChanged();

//
return false;
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setControl() {
        lv_sanpham= findViewById(R.id.lv_sanpham);
        ivBack = findViewById(R.id.ivBack);
    }
}