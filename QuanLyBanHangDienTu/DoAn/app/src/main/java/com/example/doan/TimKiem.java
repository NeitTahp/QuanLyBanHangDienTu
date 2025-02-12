package com.example.doan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TimKiem extends AppCompatActivity {
    EditText edtNhapTen;
    ImageView ivTimKiem;
    ListView lvTimKiem;
    List<SanPham> data_tk= new ArrayList<>();
    SanPham_Adapter Adapter_tk;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        setControl();
        setEvent();
    }

    private void setEvent() {

        lvTimKiem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,MuaSanPham.class);
                intent.putExtra("item",data_tk.get(position));
                startActivity(intent);
            }
        });
        ivTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (SanPham item : MainActivity.data_sp) {
                    if (item.getTenSP().toLowerCase().contains(edtNhapTen.getText().toString().toLowerCase())){
                        data_tk= new ArrayList<>();
                        data_tk.add(item);
                        break;
                    }
                }
                Adapter_tk=new SanPham_Adapter(context,R.layout.sanpham,data_tk);
                lvTimKiem.setAdapter(Adapter_tk);
            }
        });

    }
    private void setControl() {
        edtNhapTen = findViewById(R.id.edtNhapTen);
        ivTimKiem = findViewById(R.id.ivTimKiem);
        lvTimKiem = findViewById(R.id.lvTimKiem);
    }
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