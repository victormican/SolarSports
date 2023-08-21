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

public class CategoriaCanchasActivity extends AppCompatActivity {
    ImageView exit;
    ImageView imageVCategoryC;

    TextView textVCategoryC;

    ImageView home;
    ImageView search;
    ImageView register;
    ImageView category;
    ImageView userProfile;
    ImageView stadistics;
    ImageView benefits;
    Button registrar;
    ImageView back ;

    EditText editTextNombreCancha, editTextNombreTerraza , editTextLongitud ,editTextAncho , editTextPotencia ,editTextHoras , editTextMes ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_canchas);

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

        textVCategoryC= findViewById(R.id.textViewCanchas);
        imageVCategoryC = findViewById(R.id.imageViewCanchas);

        editTextNombreCancha= findViewById(R.id.editTextNombreCancha);
        editTextNombreTerraza = findViewById(R.id.editTextNombreTerraza);
        editTextLongitud = findViewById(R.id.editTextLongitud);
        editTextAncho = findViewById(R.id.editTextAncho);
        editTextPotencia = findViewById(R.id.editTextPotencia);
        editTextHoras = findViewById(R.id.editTextHoras);
        editTextMes = findViewById(R.id.editTextMes);



        Intent registrarView = new Intent(this, Categorias.class);

        Intent backView = new Intent(this, Categorias.class);

        Intent loginView = new Intent(this, LoginActivity.class);

        Intent CategoryView = new Intent(this, Categorias.class);

        Intent ViewRegister = new Intent(this, Registro.class);

        Intent ViewStadistic = new Intent(this, Estadisticas.class);

        Intent ViewBenefits = new Intent(this, Beneficios.class);


        Intent homeView = new Intent(this, HomeActivity.class);
        Intent searchView = new Intent(this, Buscar.class);

        Intent userProfileView = new Intent(this, UsuarioActivity.class);

        Intent CategoryCanchaView = new Intent(this, CategoriaCanchasActivity.class);



        registrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Verificar vacios los campos
                if(!editTextNombreCancha.getText().toString().isEmpty() &&
                        !editTextNombreTerraza.getText().toString().isEmpty()  &&
                        !editTextLongitud.getText().toString().isEmpty()  &&
                        !editTextAncho.getText().toString().isEmpty()    &&
                        !editTextPotencia.getText().toString().isEmpty()    &&
                        !editTextHoras.getText().toString().isEmpty()      &&
                        !editTextMes.getText().toString().isEmpty()
                )
                {
                    //Almacenar en txt
                    File file = new File(getFilesDir(),"PanelCanchas.txt");
                    try {
                        FileWriter writer = new FileWriter(file,true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                        String canchas =
                                editTextNombreCancha.getText().toString()+","+
                                        editTextNombreTerraza.getText().toString()+","+
                                editTextLongitud.getText().toString()+","+
                                editTextAncho.getText().toString()+","+
                                editTextPotencia.getText().toString()+","+
                                editTextHoras.getText().toString()+","+
                                editTextMes.getText().toString();
                        bufferedWriter.write(canchas);
                        bufferedWriter.newLine();
                        bufferedWriter.close();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    editTextNombreCancha.setText("");
                    editTextNombreTerraza.setText("");
                    editTextLongitud.setText("");
                    editTextAncho.setText("");
                    editTextPotencia.setText("");
                    editTextHoras.setText("");
                    editTextMes.setText("");
                    Toast.makeText(CategoriaCanchasActivity.this ,"Exitoso",Toast.LENGTH_LONG).show();
                    startActivity(CategoryView);

                }else{
                    Toast.makeText(CategoriaCanchasActivity.this ,"Valide que los campos no esten vacios",Toast.LENGTH_LONG).show();
                    startActivity(CategoryCanchaView);
                }
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
        imageVCategoryC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryCanchaView);
            }
        });

        textVCategoryC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryCanchaView);
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