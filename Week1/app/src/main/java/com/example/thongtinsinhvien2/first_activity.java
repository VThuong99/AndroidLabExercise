package com.example.thongtinsinhvien2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class first_activity extends AppCompatActivity {
    Button btnphone, btnsms, btnpic, btnBackToMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        btnphone = findViewById(R.id.btnphone);
        btnsms = findViewById(R.id.btnsms);
        btnpic = findViewById(R.id.btnpic);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsintent = new Intent(first_activity.this, sms_activity.class);
                startActivity(smsintent);
            }
        });

        btnphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneintent = new Intent(first_activity.this, phone_activity.class);
                startActivity(phoneintent);
            }
        });

        btnpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picintent = new Intent(first_activity.this, chuphinh_activity.class);
                startActivity(picintent);
            }
        });

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
