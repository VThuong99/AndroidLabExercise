package com.example.thongtinsinhvien2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tvThongTin;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Ánh xạ
        tvThongTin = findViewById(R.id.tvThongTin);
        btnBack = findViewById(R.id.btnBack);

        tvThongTin.setMovementMethod(new ScrollingMovementMethod());
        // Lấy thông tin
        Intent intent = getIntent();
        String thongTin = intent.getStringExtra("thongTin");

        // Hiển thị thông tin
        tvThongTin.setText(thongTin);

        // Xử lý sự kiện khi nhấn nút
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                setResult(88, resultIntent);
                finish();
            }
        });
    }
}
