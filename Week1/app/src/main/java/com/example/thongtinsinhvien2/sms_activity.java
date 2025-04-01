package com.example.thongtinsinhvien2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class sms_activity extends AppCompatActivity {
    ImageButton imgsms;
    EditText edtphone;
    EditText edtMessage;
    Button btnback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms_layout);

        imgsms = findViewById(R.id.imgsms);
        edtphone = findViewById(R.id.edtphone);
        edtMessage = findViewById(R.id.edtMessage); // Ánh xạ EditText nội dung tin nhắn
        btnback = findViewById(R.id.btnback);

        imgsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edtphone.getText().toString();
                String messageContent = edtMessage.getText().toString();

                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumber));
                smsIntent.putExtra("sms_body", messageContent);

                startActivity(smsIntent);
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
