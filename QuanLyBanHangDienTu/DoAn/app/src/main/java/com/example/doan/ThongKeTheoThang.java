package com.example.doan;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThongKeTheoThang extends AppCompatActivity {
    TextView tvThang1, tvThang2, tvThang3, tvThang4, tvThang5, tvThang6, tvThang7, tvThang8, tvThang9, tvThang10, tvThang11, tvThang12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_theo_thang);
        setControl();
        setEvent();
    }

    private void setEvent() {
        int TongTien1=0,TongTien2=0,TongTien3=0,TongTien4=0,TongTien5=0,TongTien6=0,TongTien7=0,TongTien8=0,TongTien9=0,TongTien10=0,TongTien11=0,TongTien12=0;
        for (SanPham item : LichSu.data_ls){
            String[]s=item.getNgayBanSP().split("-");
            if (s[1].equals("1")){
                TongTien1 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("2")){
                TongTien2 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("3")){
                TongTien3 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("4")){
                TongTien4 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("5")){
                TongTien5 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("6")){
                TongTien6 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("7")){
                TongTien7 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("8")){
                TongTien8 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("9")){
                TongTien9 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("10")){
                TongTien10 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("11")){
                TongTien11 += Integer.parseInt(item.getGiaSP());
            }
            if (s[1].equals("12")){
                TongTien12 += Integer.parseInt(item.getGiaSP());
            }

        }


        tvThang1.setText(String.valueOf(TongTien1));
        tvThang2.setText(String.valueOf(TongTien2));
        tvThang3.setText(String.valueOf(TongTien3));
        tvThang4.setText(String.valueOf(TongTien4));
        tvThang5.setText(String.valueOf(TongTien5));
        tvThang6.setText(String.valueOf(TongTien6));
        tvThang7.setText(String.valueOf(TongTien7));
        tvThang8.setText(String.valueOf(TongTien8));
        tvThang9.setText(String.valueOf(TongTien9));
        tvThang10.setText(String.valueOf(TongTien10));
        tvThang11.setText(String.valueOf(TongTien11));
        tvThang12.setText(String.valueOf(TongTien12));
    }

    private void setControl() {
        tvThang1=findViewById(R.id.tvTongTienThang1);
        tvThang2=findViewById(R.id.tvTongTienThang2);
        tvThang3=findViewById(R.id.tvTongTienThang3);
        tvThang4=findViewById(R.id.tvTongTienThang4);
        tvThang5=findViewById(R.id.tvTongTienThang5);
        tvThang6=findViewById(R.id.tvTongTienThang6);
        tvThang7=findViewById(R.id.tvTongTienThang7);
        tvThang8=findViewById(R.id.tvTongTienThang8);
        tvThang9=findViewById(R.id.tvTongTienThang9);
        tvThang10=findViewById(R.id.tvTongTienThang10);
        tvThang11=findViewById(R.id.tvTongTienThang11);
        tvThang12=findViewById(R.id.tvTongTienThang12);
    }
}