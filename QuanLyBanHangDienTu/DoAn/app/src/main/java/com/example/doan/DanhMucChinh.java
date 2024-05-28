package com.example.doan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DanhMucChinh extends AppCompatActivity {
    Button btnTheLoai,btnLichSu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc_chinh);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnLichSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhMucChinh.this, LichSu.class);
                startActivity(intent);
            }
        });
        btnTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DanhMucChinh.this, ThongKeTheoThang.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        btnLichSu=findViewById(R.id.btnLichSu);
        btnTheLoai=findViewById(R.id.btnTheLoai);
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