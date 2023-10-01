package com.example.tracnghiemlop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KetQua extends AppCompatActivity {
    //Khai báo các biến giao diện
    TextView tvHienThiMon, tvHienThiDiem;
    Button btnTrangChu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);

        //Ánh xạ
        tvHienThiDiem = findViewById(R.id.tvHienThiDiem);
        tvHienThiMon = findViewById(R.id.tvHienThiMon);
        btnTrangChu = findViewById(R.id.btnTrangChu);
        //Lấy intent gọi Activity này
        Intent callerIntent = getIntent();
        //Có intent rồi thì lấy Bundle dựa vào keyName
        Bundle getData = callerIntent.getBundleExtra("myData");
        //Có bundle rồi thì lấy các thông số dữ liệu
        String tenMon = getData.getString("tenMon");
        String tinhDiem = getData.getString("tinhDiem");
        //Hiển thị tên môn
        tvHienThiMon.setText("" + tenMon);
        tvHienThiDiem.setText("Điểm số: " + tinhDiem);

        //Handle khi bấm vào nút trang chủ
        btnTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KetQua.this, ChonMonHoc.class);
                startActivity(intent);
            }
        });

    }
}