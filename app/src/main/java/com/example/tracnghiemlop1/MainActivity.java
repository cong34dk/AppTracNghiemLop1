package com.example.tracnghiemlop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtk, edmk, edtb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        btnLogin = findViewById(R.id.btnLogin);
        edtk = findViewById(R.id.edttaikhoan);
        edmk = findViewById(R.id.edtmatkhau);
        edtb = findViewById(R.id.edtthongbao);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lấy giá trị người dùng nhập vào, đưa ra thông báo
                if (edtk.getText().toString().equals("cong") && edmk.getText().toString().equals("123")) {
                    Intent intent = new Intent(MainActivity.this, ChonMonHoc.class);
                    startActivity(intent);

                } else
                    edtb.setText("Tài khoản hoặc mật khẩu sai");
            }
        });

    }
}