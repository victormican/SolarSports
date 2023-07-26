package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Categorias extends AppCompatActivity {

    ImageView exit;
    ImageView imageVCategory;

    TextView textVCategory;

    ImageView home;
    ImageView search;
    ImageView register;
    ImageView category;
    ImageView userProfile;
    ImageView stadistics;
    ImageView benefits;


    TextView textViewCancha;

    TextView textViewGim;

    ImageView imageViewCancha;

    ImageView imageViewGim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        exit = findViewById(R.id.imageViewExit);

        imageVCategory = findViewById(R.id.imageViewCategory);
        textVCategory = findViewById(R.id.textViewCancha);

        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);

        textViewCancha = findViewById(R.id.textViewCancha);
        imageViewCancha = findViewById(R.id.imageViewCancha);
        textViewGim = findViewById(R.id.textViewGim);
        imageViewGim = findViewById(R.id.imageViewGim);

        Intent loginView = new Intent(this, LoginActivity.class);

        Intent CategoryView = new Intent(this, Categorias.class);

        Intent ViewRegister = new Intent(this, Registro.class);

        Intent ViewStadistic = new Intent(this, Estadisticas.class);

        Intent ViewBenefits = new Intent(this, Beneficios.class);


        Intent homeView = new Intent(this, HomeActivity.class);
        Intent searchView = new Intent(this, Buscar.class);

        Intent userProfileView = new Intent(this, UsuarioActivity.class);

        Intent CategoryCanchaView = new Intent(this, Categoria_CanchasActivity.class);

        Intent CategoryGimView = new Intent(this, Categoria_GimnasiosActivity.class );

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(loginView);
            }
        });
        imageVCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryView);
            }
        });

        textVCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryView);
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

        textViewCancha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryCanchaView);
            }
        });

        imageViewCancha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryCanchaView);
            }
        });
        textViewGim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryGimView);
            }
        });
        imageViewGim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryGimView);
            }
        });
    }
}