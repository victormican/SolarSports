package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Registrar extends AppCompatActivity {

    ImageView ImageViewBack;
    ImageView ImageViewExit;
    Button registrar;

    EditText editTextNombre, editEmail, editTextTelefono, editTextUsuario, editTextTextPassword, editTextTextPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        registrar = findViewById(R.id.btnRegistrar);
        ImageViewBack = findViewById(R.id.imageViewBack);
        ImageViewExit = findViewById(R.id.imageViewExit);
        editTextNombre = findViewById(R.id.editTextNombre);
        editEmail = findViewById(R.id.editEmail);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);


        Intent registrarView = new Intent(this, Registrar.class);
        Intent backView = new Intent(this, LoginActivity.class);
        Intent exitView = new Intent(this, LoginActivity.class);

        registrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Verificar vacios los campos
                if (!editTextNombre.getText().toString().isEmpty() &&
                        !editEmail.getText().toString().isEmpty() &&
                        !editTextTelefono.getText().toString().isEmpty()&&
                        !editTextUsuario.getText().toString().isEmpty()&&
                        !editTextTextPassword.getText().toString().isEmpty()&&
                        !editTextTextPassword2.getText().toString().isEmpty()


                ) {
                    //Almacenar en txt
                    File file = new File(getFilesDir(), "Registrar.txt");
                    try {
                        FileWriter writer = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                        String registro =
                                editTextNombre.getText().toString() + "," +
                                        editEmail.getText().toString() + "," +
                                        editTextTelefono.getText().toString()+ "," +
                                        editTextUsuario.getText().toString()+ "," +
                                        editTextTextPassword.getText().toString()+ "," +
                                        editTextTextPassword2.getText().toString()

                                ;



                        bufferedWriter.write(registro);
                        bufferedWriter.newLine();
                        bufferedWriter.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    editTextNombre.setText("");
                    editEmail.setText("");
                    editTextTelefono.setText("");
                    editTextUsuario.setText("");
                    editTextTextPassword.setText("");
                    editTextTextPassword2.setText("");
                    Toast.makeText(Registrar.this, "Registrado", Toast.LENGTH_LONG).show();
                    startActivity(backView);

                } else {
                    Toast.makeText(Registrar.this, "Valide que los campos no esten vacios", Toast.LENGTH_LONG).show();
                    startActivity(registrarView);
                }

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