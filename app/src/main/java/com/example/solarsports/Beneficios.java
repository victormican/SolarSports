package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.solarsports.models.UserSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beneficios extends AppCompatActivity {
    ImageView ImageViewExit;


    ImageView imageVBeneficios;

    TextView textVBeneficios , textViewConsejos;

    ImageView home;
    ImageView search;
    ImageView register;
    ImageView category;
    ImageView userProfile;
    ImageView stadistics;
    ImageView benefits, imageViewNew , imageViewNube2;

    List<String> adviceList = new ArrayList<>();
    int currentAdviceIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficios);

        ImageViewExit = findViewById(R.id.imageViewExit);
        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);
        imageViewNew = findViewById(R.id.imageViewNew);
        imageViewNube2= findViewById(R.id.imageViewNube2);
        imageVBeneficios= findViewById(R.id.imageViewBeneficios);

         textVBeneficios= findViewById(R.id.textViewBBeneficios);

         textViewConsejos= findViewById(R.id.textViewConsejos2);


        Intent exitView = new Intent(this, LoginActivity.class);

        Intent CategoryView = new Intent(this, Categorias.class);

        Intent ViewRegister = new Intent(this, Registro.class);

        Intent ViewStadistic = new Intent(this, Estadisticas.class);

        Intent ViewBenefits = new Intent(this, Beneficios.class);


        Intent homeView = new Intent(this, HomeActivity.class);
        Intent searchView = new Intent(this, Buscar.class);

        Intent userProfileView = new Intent(this, UsuarioActivity.class);


        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open("Beneficios.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        adviceList = readAdviceFromStream(inputStream);

        //List<String> adviceList = readAdviceFromAssets("Beneficios.txt");

        imageViewNube2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAdvice();
                Toast.makeText(Beneficios.this ,"Nuevo consejo",Toast.LENGTH_LONG).show();
            }
        });
        ImageViewExit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Cierra la sesión de UserSesion
                UserSession.getInstance().logout();
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
        imageViewNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAdvice();
                Toast.makeText(Beneficios.this ,"Nuevo consejo",Toast.LENGTH_LONG).show();
            }
        });

        imageVBeneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewBenefits);
            }
        });

        textVBeneficios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewBenefits);
            }
        });

        textViewConsejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


    public List<String> readAdviceFromStream(InputStream inputStream) {
        List<String> adviceList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                adviceList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adviceList;
    }
    private void updateAdvice() {
        if (!adviceList.isEmpty()) {
            currentAdviceIndex = (currentAdviceIndex + 1) % adviceList.size();
            String consejo = adviceList.get(currentAdviceIndex);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textViewConsejos.setText(consejo);
                }
            });
        }
    }


    public List<String> readAdviceFromAssets(String fileName) {
        List<String> adviceList = new ArrayList<>();
        AssetManager assetManager = getAssets();

        try (InputStream inputStream = assetManager.open(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = br.readLine()) != null) {
                adviceList.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return adviceList;
    }


}