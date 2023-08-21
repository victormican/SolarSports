package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Recuperar extends AppCompatActivity {

    ImageView ImageViewBack;
    ImageView ImageViewExit;
    Button recuperar;

    EditText editTextUsuario, editTextEmail ,editTextNuevaContrasena , editTextNuevaConfirma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);
        recuperar = findViewById(R.id.btnRecuperar);
        ImageViewBack = findViewById(R.id.imageViewBack);
        ImageViewExit = findViewById(R.id.imageViewExit);
        editTextUsuario= findViewById(R.id.editTextUsuario);
        editTextEmail= findViewById(R.id.editTextEmail);
         editTextNuevaContrasena = findViewById(R.id.editTextNuevaContrasena);
        editTextNuevaConfirma = findViewById(R.id.editTextNuevaConfirma);

        Intent recuperarView = new Intent(this, Recuperar.class);
        Intent backView = new Intent(this, LoginActivity.class);
        Intent exitView = new Intent(this, LoginActivity.class);

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuarioRecuperar = editTextUsuario.getText().toString();
                String emailRecuperar = editTextEmail.getText().toString();
                String nuevaContrasena = editTextNuevaContrasena.getText().toString();
                String confirmaContrasena = editTextNuevaConfirma.getText().toString();

                if (!usuarioRecuperar.isEmpty() && !emailRecuperar.isEmpty() && !nuevaContrasena.isEmpty() && !confirmaContrasena.isEmpty()) {
                    if (nuevaContrasena.equals(confirmaContrasena)) {
                        // Las contraseñas coinciden, continuar con la actualización
                        File file = new File(getFilesDir(), "userData.txt");
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            String line;
                            StringBuilder fileContent = new StringBuilder();
                            boolean updated = false; // Flag para indicar si se actualizó la contraseña

                            while ((line = reader.readLine()) != null) {
                                String[] userData = line.split(",");
                                if (userData.length >= 4 && userData[3].equals(usuarioRecuperar) && userData[1].equals(emailRecuperar)) {
                                    // Validar que la contraseña actual no sea la misma que la nueva contraseña
                                    if (!userData[4].equals(nuevaContrasena)) {
                                        userData[4] = nuevaContrasena;
                                        userData[5] = confirmaContrasena;
                                        updated = true;
                                    } else {
                                        // Mostrar un mensaje de error si la contraseña actual y nueva son iguales
                                        Toast.makeText(Recuperar.this, "La contraseña actual y la nueva contraseña no pueden ser iguales", Toast.LENGTH_LONG).show();
                                    }
                                }
                                fileContent.append(String.join(",", userData)).append("\n");
                            }
                            reader.close();

                            if (updated) {
                                // Sobrescribir el archivo con los datos actualizados
                                FileWriter writer = new FileWriter(file);
                                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                                bufferedWriter.write(fileContent.toString());
                                bufferedWriter.close();

                                editTextUsuario.setText("");
                                editTextEmail.setText("");
                                editTextNuevaContrasena.setText("");
                                editTextNuevaConfirma.setText("");
                                Toast.makeText(Recuperar.this, "Contraseña recuperada y actualizada", Toast.LENGTH_LONG).show();
                                startActivity(backView);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        // Las contraseñas no coinciden, mostrar un mensaje de error
                        Toast.makeText(Recuperar.this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Recuperar.this, "Valide que los campos no estén vacíos", Toast.LENGTH_LONG).show();
                    startActivity(recuperarView);
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