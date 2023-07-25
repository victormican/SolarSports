package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button login;

    TextView registrarse;

    TextView recuperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btnIngresar);
        registrarse = findViewById(R.id.textViewRegistrar);
        recuperar = findViewById(R.id.textViewRecuperar);

        Intent homeView = new Intent(this, HomeActivity.class);
        Intent registrarView = new Intent(this, Registrar.class);
        Intent recuperarView = new Intent(this, Recuperar.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(homeView);
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(registrarView);
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recuperarView);
            }
        });

    }
}