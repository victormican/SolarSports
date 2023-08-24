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

import com.example.solarsports.models.UserSession;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class RegistroCanchas extends AppCompatActivity {
    ImageView ImageViewExit;


    ImageView imageVRegistrCancha;

    TextView textVRegistroCancha;

    ImageView home;
    ImageView search;
    ImageView register;
    ImageView category;
    ImageView userProfile;
    ImageView stadistics;
    ImageView benefits;

    ImageView ImageViewBack;

    Button registrar;

    EditText editTextNombreCancha , editTextConsumoKW , editTextValorKW , editTextMes ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_canchas);

        ImageViewExit = findViewById(R.id.imageViewExit);
        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);
        registrar = findViewById(R.id.btnRegistrar);
        ImageViewBack = findViewById(R.id.imageViewBack);

        imageVRegistrCancha = findViewById(R.id.imageViewRRCanchas);

        textVRegistroCancha = findViewById(R.id.textViewRRCancha);


        editTextNombreCancha= findViewById(R.id.editTextNombreCancha);
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
        Intent RegistrCanchaView = new Intent(this, RegistroCanchas.class);

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

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar campos vacíos
                if (!editTextNombreCancha.getText().toString().isEmpty() &&
                        !editTextConsumoKW.getText().toString().isEmpty() &&
                        !editTextValorKW.getText().toString().isEmpty() &&
                        !editTextMes.getText().toString().isEmpty()) {

                    // Obtener el nombre de usuario actual
                    UserSession userSession = UserSession.getInstance();
                    String username = userSession.getUsername();

                    // Almacenar en el archivo
                    File file = new File(getFilesDir(), "Registros.txt");
                    try {
                        FileWriter writer = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                        String registroCancha =
                                editTextNombreCancha.getText().toString() + "," +
                                        editTextConsumoKW.getText().toString() + "," +
                                        editTextValorKW.getText().toString() + "," +
                                        editTextMes.getText().toString() + "," +
                                        username + "," + "Canchas" ; // Agregar el nombre de usuario al registro
                        bufferedWriter.write(registroCancha);
                        bufferedWriter.newLine();
                        bufferedWriter.close();

                        // Limpiar los campos y mostrar mensaje
                        editTextNombreCancha.setText("");
                        editTextConsumoKW.setText("");
                        editTextValorKW.setText("");
                        editTextMes.setText("");
                        Toast.makeText(RegistroCanchas.this, "Registrado", Toast.LENGTH_LONG).show();
                        startActivity(registrarView);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(RegistroCanchas.this, "Valide que los campos no estén vacíos", Toast.LENGTH_LONG).show();
                    startActivity(RegistrCanchaView);
                }
            }
        });


        ImageViewBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(backView);
            }
        });
        imageVRegistrCancha.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(RegistrCanchaView);
            }
        });

        textVRegistroCancha.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(RegistrCanchaView);
            }
        });



    }
}