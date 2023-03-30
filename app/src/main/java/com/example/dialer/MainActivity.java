package com.example.dialer;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    EditText phoneNo;
    FloatingActionButton callbtn;
    Button dad;
    Button mom;

    static int PERMISSION_CODE= 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNo = findViewById(R.id.phone_number);
        callbtn = findViewById(R.id.call_button);
        dad= findViewById(R.id.dad);
        mom=findViewById(R.id.mom);

        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);

        }

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneno = phoneNo.getText().toString();
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+phoneno));
                startActivity(i);

            }
        });
        mom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNo.setText("9876543210");

            }
        });
        dad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNo.setText("1234567890");
            }
        });

    }
}