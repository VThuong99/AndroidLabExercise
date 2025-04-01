package com.example.thongtinsinhvien2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtHoTen, edtMSSV, edtLop, edtKeHoach;
    private RadioGroup radioGroupNam;
    private CheckBox checkMTHTN, checkDienTu, checkVienThong;
    private Button btnGuiThongTin, btnDaPhuongTien;

    private static final int REQUEST_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        edtHoTen = findViewById(R.id.edtHoTen);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtLop = findViewById(R.id.edtLop);
        edtKeHoach = findViewById(R.id.edtKeHoach);
        radioGroupNam = findViewById(R.id.radioGroupNam);
        checkMTHTN = findViewById(R.id.checkMTHTN);
        checkDienTu = findViewById(R.id.checkDienTu);
        checkVienThong = findViewById(R.id.checkVienThong);
        btnGuiThongTin = findViewById(R.id.btnGuiThongTin);
        btnDaPhuongTien = findViewById(R.id.btnDaPhuongTien);

        // Xử lý khi nhấn nút Gửi thông tin
        btnGuiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    String thongTin = createInfoString();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("thongTin", thongTin);
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });

        // Xử lý khi nhấn nút Đa phương tiện
        btnDaPhuongTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, first_activity.class);
                startActivity(intent);
            }
        });
    }

    // Xử lý kết quả trả về từ SecondActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == 88) {
                // Toast.makeText(this, "Đã quay lại từ màn hình thông tin", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Kiểm tra
    private boolean validateInput() {
        if (edtHoTen.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập Họ và tên", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtMSSV.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập MSSV", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtLop.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập Lớp", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (radioGroupNam.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Vui lòng chọn Năm học", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!checkMTHTN.isChecked() && !checkDienTu.isChecked() && !checkVienThong.isChecked()) {
            Toast.makeText(this, "Vui lòng chọn ít nhất một Chuyên ngành", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (edtKeHoach.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập Kế hoạch phát triển bản thân", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private String createInfoString() {
        StringBuilder info = new StringBuilder();

        info.append("HỌ VÀ TÊN: ").append(edtHoTen.getText().toString().trim()).append("\n");
        info.append("MSSV: ").append(edtMSSV.getText().toString().trim()).append("\n");
        info.append("LỚP: ").append(edtLop.getText().toString().trim()).append("\n\n");

        info.append("SINH VIÊN NĂM: ");
        int radioId = radioGroupNam.getCheckedRadioButtonId();
        if (radioId == R.id.radioNam1) {
            info.append("Năm 1");
        } else if (radioId == R.id.radioNam2) {
            info.append("Năm 2");
        } else if (radioId == R.id.radioNam3) {
            info.append("Năm 3");
        } else if (radioId == R.id.radioNam4) {
            info.append("Năm 4");
        }
        info.append("\n");

        info.append("CHUYÊN NGÀNH: ");
        boolean firstChecked = true;
        if (checkMTHTN.isChecked()) {
            info.append("Máy tính & HTN");
            firstChecked = false;
        }
        if (checkDienTu.isChecked()) {
            if (!firstChecked) {
                info.append(", ");
            }
            info.append("Điện tử");
            firstChecked = false;
        }
        if (checkVienThong.isChecked()) {
            if (!firstChecked) {
                info.append(", ");
            }
            info.append("Viễn thông");
        }
        info.append("\n\n");

        info.append("KẾ HOẠCH PHÁT TRIỂN BẢN THÂN:\n");
        info.append(edtKeHoach.getText().toString().trim());

        return info.toString();
    }
}
