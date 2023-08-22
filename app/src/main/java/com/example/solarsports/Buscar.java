package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Buscar extends AppCompatActivity {
    ImageView ImageViewExit;


    ImageView imageVBuscar;

    TextView textVBuscar;

    ImageView home;
    ImageView search;
    ImageView register;
    ImageView category;
    ImageView userProfile;
    ImageView stadistics;
    ImageView benefits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        ImageViewExit = findViewById(R.id.imageViewExit);
        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);

         imageVBuscar= findViewById(R.id.imageViewBuscar);

        textVBuscar= findViewById(R.id.textViewBuscar);

        Intent exitView = new Intent(this, LoginActivity.class);

        Intent CategoryView = new Intent(this, Categorias.class);

        Intent ViewRegister = new Intent(this, Registro.class);

        Intent ViewStadistic = new Intent(this, Estadisticas.class);

        Intent ViewBenefits = new Intent(this, Beneficios.class);


        Intent homeView = new Intent(this, HomeActivity.class);
        Intent searchView = new Intent(this, Buscar.class);

        Intent userProfileView = new Intent(this, UsuarioActivity.class);

        imageVBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(searchView);
            }
        });

        textVBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(searchView);
            }
        });
                ImageViewExit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(exitView);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeView);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(searchView);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewRegister);
            }
        });
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryView);
            }
        });
        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(userProfileView);
            }
        });
        stadistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewStadistic);
            }
        });
        benefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewBenefits);
            }
        });
    }
}