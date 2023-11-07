package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.PackageInfoCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.net.URI;
import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    TextView contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = findViewById(R.id.contador);
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, 14930);
        }
           else {
            new CountDownTimer(5200,1000){

                @Override
                public void onTick(long l) {
                    contador.setText(""+l/1000);
                }

                @Override
                public void onFinish() {

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);

                }
            }.start();
        }

    }

     @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 14930) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            } else {
                new CountDownTimer(5200,1000){

                    @Override
                    public void onTick(long l) {
                        contador.setText(""+l/1000);
                    }

                    @Override
                    public void onFinish() {

                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);

                    }
                }.start();
            }
        }
    }

}

