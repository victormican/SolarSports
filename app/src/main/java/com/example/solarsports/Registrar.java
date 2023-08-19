package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Registrar extends AppCompatActivity {

    ImageView ImageViewBack;
    ImageView ImageViewExit;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

    registrar = findViewById(R.id.btnRegistrar);
    ImageViewBack = findViewById(R.id.imageViewBack);
    ImageViewExit = findViewById(R.id.imageViewExit);
    Intent registrarView = new Intent(this, LoginActivity.class);
    Intent backView = new Intent(this, LoginActivity.class);
    Intent exitView = new Intent(this, LoginActivity.class);

        registrar.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            startActivity(registrarView);
        }
    });

        ImageViewBack.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            startActivity(backView);
        }
    });

        ImageViewExit.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            startActivity(exitView);
        }
    });
    }

}