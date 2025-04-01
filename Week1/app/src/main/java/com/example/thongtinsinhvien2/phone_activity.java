package com.example.thongtinsinhvien2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class phone_activity extends AppCompatActivity {
    EditText edtcall;
    ImageButton imgcall;
    Button btnback;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_layout);
        edtcall = findViewById(R.id.edtcall);
        imgcall = findViewById(R.id.imgcall);
        btnback = findViewById(R.id.btnback1);
        imgcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callintent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+edtcall.getText().toString()));
                if (ActivityCompat.checkSelfPermission(phone_activity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(phone_activity.this, new
                            String[]{android.Manifest.permission.CALL_PHONE},1);
                    return;
                }
                startActivity(callintent);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
            }
        }

