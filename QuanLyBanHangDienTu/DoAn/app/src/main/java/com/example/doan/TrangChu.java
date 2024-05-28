//package com.example.doan;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.doan.CRUD.MainActivity;
//
//public class TrangChu extends AppCompatActivity {
//
//    Button btnCRUD,btnMuaBan;
//    Context context= this;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_trang_chu);
//        setControl();
//        setEvent();
//    }
//
//    private void setEvent() {
//        btnCRUD.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(context, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        btnMuaBan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(context, com.example.doan.MainActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    private void setControl() {
//        btnCRUD = findViewById(R.id.btnCRUD);
//        btnMuaBan = findViewById(R.id.btnMuaBanSP);
//    }
//
//}