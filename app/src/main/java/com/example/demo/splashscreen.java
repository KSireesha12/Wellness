package com.example.demo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splashscreen extends AppCompatActivity {

    private static int ScreenTimer=3000;

            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setContentView(R.layout.activity_splashscreen);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent x = new Intent(splashscreen.this,login.class);
                        startActivity(x);
                        finish();
                    }

                },ScreenTimer);
            }
        }