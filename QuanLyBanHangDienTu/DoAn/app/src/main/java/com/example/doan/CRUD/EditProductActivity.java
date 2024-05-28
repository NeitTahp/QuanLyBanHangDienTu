package com.example.doan.CRUD;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan.R;

public class EditProductActivity extends AppCompatActivity {

    ListView lv_sanpham;
    ImageView ivBack,ivTim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_san_pham);
        setControl();
        setEvent();
    }

    private void setEvent() {

        lv_sanpham.setAdapter(com.example.doan.CRUD.MainActivity.adapter_sp);
        lv_sanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EditProductActivity.this, DetailProductActivity.class);
                intent.putExtra("item", MainActivity.data_sp.get(position));
                startActivity(intent);
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ivTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProductActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }


    private void setControl() {

        lv_sanpham=findViewById(R.id.lv_sanpham);
        ivBack = findViewById(R.id.ivBack);
        ivTim = findViewById(R.id.ivTim);
    }


}