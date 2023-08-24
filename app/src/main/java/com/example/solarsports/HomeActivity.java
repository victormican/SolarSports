package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.solarsports.models.UserSession;

public class HomeActivity extends AppCompatActivity {

    ImageView exit;
    ImageView imageVCategory;

    TextView textVCategory;
    ImageView imageViewRegister;
    TextView textViewRegister;
    ImageView imageViewStadistic;
    TextView textViewStadistic;
    ImageView imageViewBenefits;
    TextView textViewBenefits;

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
        setContentView(R.layout.activity_home);

        exit = findViewById(R.id.imageViewExit);

        imageVCategory = findViewById(R.id.imageViewCategory);
        textVCategory = findViewById(R.id.textViewCategory);
        imageViewRegister = findViewById(R.id.imageViewRRegistro);
        textViewRegister = findViewById(R.id.textViewRegister);
        imageViewStadistic = findViewById(R.id.imageViewStadistic);
        textViewStadistic = findViewById(R.id.textViewEstadistic);
        imageViewBenefits = findViewById(R.id.imageViewBenefits);
        textViewBenefits = findViewById(R.id.textViewBenefits);

        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);

        imageViewStadistic = findViewById(R.id.imageViewStadistic);
        textViewStadistic = findViewById(R.id.textViewEstadistic);
        imageViewBenefits = findViewById(R.id.imageViewBenefits);
        textViewBenefits = findViewById(R.id.textViewBenefits);

        Intent loginView = new Intent(this, LoginActivity.class);

        Intent CategoryView = new Intent(this, Categorias.class);

        Intent ViewRegister = new Intent(this, Registro.class);

        Intent ViewStadistic = new Intent(this, Estadisticas.class);

        Intent ViewBenefits  = new Intent(this, Beneficios.class);


        Intent homeView  =  new Intent(this, HomeActivity.class);
        Intent searchView  = new Intent(this, Buscar.class);

        Intent userProfileView  = new Intent(this, UsuarioActivity.class);




        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cierra la sesión de UserSesion
                UserSession.getInstance().logout();

                // Luego, inicia la actividad de inicio de sesión
                startActivity(loginView);
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
        imageViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewRegister);
            }
        });
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewRegister);
            }
        });
        imageViewStadistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewStadistic);
            }
        });
        textViewStadistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewStadistic);
            }
        });
        imageViewBenefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewBenefits);
            }
        });
        textViewBenefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewBenefits);
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
