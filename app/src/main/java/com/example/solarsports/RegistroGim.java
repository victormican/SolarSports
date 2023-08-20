package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class RegistroGim extends AppCompatActivity {
    ImageView Exit;


    ImageView imageVRegistroG;

    TextView textVRegistroG;

    ImageView home;
    ImageView search;
    ImageView register;
    ImageView category;
    ImageView userProfile;
    ImageView stadistics;
    ImageView benefits;

    ImageView Back;

    Button registrar;

    EditText editTextNombreGim , editTextConsumoKW , editTextValorKW , editTextMes ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_gim);

        Exit = findViewById(R.id.imageViewExit);
        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);
        registrar  = findViewById(R.id.btnRegistrar);
        Back = findViewById(R.id.imageViewBack);
        imageVRegistroG= findViewById(R.id.imageViewRRGimnasios);
        textVRegistroG= findViewById(R.id.textViewRRGim);

        editTextNombreGim= findViewById(R.id.editTextNombreGim);
        editTextConsumoKW= findViewById(R.id.editTextConsumoKW);
        editTextValorKW= findViewById(R.id.editTextValorKW);
        editTextMes = findViewById(R.id.editTextMes);

        Intent exitView = new Intent(this, LoginActivity.class);

        Intent CategoryView = new Intent(this, Categorias.class);

        Intent ViewRegister = new Intent(this, Registro.class);

        Intent ViewStadistic = new Intent(this, Estadisticas.class);

        Intent ViewBenefits = new Intent(this, Beneficios.class);


        Intent homeView = new Intent(this, HomeActivity.class);
        Intent searchView = new Intent(this, Buscar.class);

        Intent userProfileView = new Intent(this, UsuarioActivity.class);

        Intent registrarView = new Intent(this, Registro.class);
        Intent backView = new Intent(this, Registro.class);
        Intent RegistroGView = new Intent(this, RegistroGim.class);

        Exit.setOnClickListener(new View.OnClickListener() {

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

        registrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Verificar vacios los campos
                if(!editTextNombreGim.getText().toString().isEmpty() &&
                        !editTextConsumoKW.getText().toString().isEmpty()  &&
                        !editTextValorKW.getText().toString().isEmpty()  &&
                        !editTextMes.getText().toString().isEmpty())
                {
                    //Almacenar en txt
                    File file = new File(getFilesDir(),"CanchasRegistos.xt");
                    try {
                        FileWriter writer = new FileWriter(file,true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                        String registrocancha =
                                editTextNombreGim.getText().toString()+","+
                                        editTextConsumoKW.getText().toString()+","+
                                        editTextValorKW.getText().toString()+","+
                                        editTextMes.getText().toString();
                        bufferedWriter.write(registrocancha);
                        bufferedWriter.newLine();
                        bufferedWriter.close();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    editTextNombreGim.setText("");
                    editTextConsumoKW.setText("");
                    editTextValorKW.setText("");
                    editTextMes.setText("");

                }else{
                    Toast.makeText(RegistroGim.this ,"Valide que los campos no esten vacios",Toast.LENGTH_LONG).show();
                }
                startActivity(registrarView);
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(backView);
            }
        });
        textVRegistroG.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(RegistroGView);
            }
        });

        imageVRegistroG.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(RegistroGView);
            }
        });

    }
}