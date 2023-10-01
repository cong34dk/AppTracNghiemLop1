package com.example.tracnghiemlop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

public class ChonMonHoc extends AppCompatActivity {
    //Khai báo các biến giao diện
    ImageButton btnToan, btnTiengViet, btnTiengAnh, btnKhoaHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_mon_hoc);

        //Ánh xạ
        btnToan = findViewById(R.id.btnToan);
        btnTiengViet = findViewById(R.id.btnTiengViet);
        btnTiengAnh = findViewById(R.id.btnTiengAnh);
        btnKhoaHoc = findViewById(R.id.btnKhoaHoc);

        //Lắng nghe sự kiên click cho các nút
        btnToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thay đổi màu nền của button khi được bấm
                btnToan.setBackgroundColor(Color.GRAY);

                // Sử dụng Handler để đặt lại màu nền sau một thời gian ngắn
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnToan.setBackgroundColor(Color.WHITE);
                    }
                }, 500);
                //Tạo đối tượng intent để giao tiếp giữa 2 activity
                //Và mở nó lên
                Intent intent = new Intent(ChonMonHoc.this, Toan.class);
                startActivity(intent);
            }
        });

        //Lắng nghe sự kiên click cho các nút
        btnTiengViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thay đổi màu nền của button khi được bấm
                btnTiengViet.setBackgroundColor(Color.GRAY);

                // Sử dụng Handler để đặt lại màu nền sau một thời gian ngắn
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnTiengViet.setBackgroundColor(Color.WHITE);
                    }
                }, 500);

                //Tạo đối tượng intent để giao tiếp giữa 2 activity
                //Và mở nó lên
                Intent intent = new Intent(ChonMonHoc.this, TiengViet.class);
                startActivity(intent);
            }
        });

        //Lắng nghe sự kiên click cho các nút
        btnTiengAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thay đổi màu nền của button khi được bấm
                btnTiengAnh.setBackgroundColor(Color.GRAY);

                // Sử dụng Handler để đặt lại màu nền sau một thời gian ngắn
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnTiengAnh.setBackgroundColor(Color.WHITE);
                    }
                }, 500);

                //Tạo đối tượng intent để giao tiếp giữa 2 activity
                //Và mở nó lên
                Intent intent = new Intent(ChonMonHoc.this, TiengAnh.class);
                startActivity(intent);
            }
        });

        //Lắng nghe sự kiên click cho các nút
        btnKhoaHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thay đổi màu nền của button khi được bấm
                btnKhoaHoc.setBackgroundColor(Color.GRAY);

                // Sử dụng Handler để đặt lại màu nền sau một thời gian ngắn
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnKhoaHoc.setBackgroundColor(Color.WHITE);
                    }
                }, 500);

                //Tạo đối tượng intent để giao tiếp giữa 2 activity
                //Và mở nó lên
                Intent intent = new Intent(ChonMonHoc.this, KhoaHoc.class);
                startActivity(intent);
            }
        });
    }
}