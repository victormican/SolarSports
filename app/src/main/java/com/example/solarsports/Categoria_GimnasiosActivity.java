package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Categoria_GimnasiosActivity extends AppCompatActivity {
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


    TextView textViewGim;

    Button registrar;
    ImageView imageViewGim;
    ImageView back ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_gimnasios);

        exit = findViewById(R.id.imageViewExit);

        registrar = findViewById(R.id.btnRegistrar);
        back = findViewById(R.id.imageViewBack);
        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);

        textViewGim = findViewById(R.id.textViewGim);
        imageViewGim = findViewById(R.id.imageViewGim);

        Intent registrarView = new Intent(this, Categoria_CanchasActivity.class);

        Intent backView = new Intent(this, Categoria_CanchasActivity.class);

        Intent loginView = new Intent(this, LoginActivity.class);

        Intent CategoryView = new Intent(this, Categorias.class);

        Intent ViewRegister = new Intent(this, Registro.class);

        Intent ViewStadistic = new Intent(this, Estadisticas.class);

        Intent ViewBenefits = new Intent(this, Beneficios.class);


        Intent homeView = new Intent(this, HomeActivity.class);
        Intent searchView = new Intent(this, Buscar.class);

        Intent userProfileView = new Intent(this, UsuarioActivity.class);

        Intent CategoryGimView = new Intent(this, Categoria_GimnasiosActivity.class);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registrarView);
            }


        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backView);
            }


        });

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
