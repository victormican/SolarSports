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

import com.example.solarsports.models.User;
import com.example.solarsports.models.UserSession;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ActualizarContrasenaActivity extends AppCompatActivity {
    ImageView ImageViewBack;
    ImageView ImageViewExit;
    Button Actualizar;

    EditText editTextContrasenaAnt,editTextAContrasena ,editTextAConfirmarC , textViewUUser ,textDeleteUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_contrasena);

        Actualizar = findViewById(R.id.btnActualizar);
        ImageViewBack = findViewById(R.id.imageViewBack);
        ImageViewExit = findViewById(R.id.imageViewExit);

        editTextContrasenaAnt = findViewById(R.id.editTextContrasenaAnt);
        editTextAContrasena= findViewById(R.id.editTextAContrasena);
        editTextAConfirmarC= findViewById(R.id.editTextAConfirmarC);




        Intent ActualizarContrasenaView = new Intent(this, ActualizarContrasenaActivity.class);
        Intent backView = new Intent(this, UsuarioActivity.class);
        Intent exitView = new Intent(this, LoginActivity.class);


        // Obtener la instancia de UserSession
        UserSession userSession = UserSession.getInstance();

        // Obtener los datos del usuario
        String username = userSession.getUsername();
        String email = userSession.getEmail();


       Actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contrasenaAnterior = editTextContrasenaAnt.getText().toString();
                String nuevaContrasena = editTextAContrasena.getText().toString();
                String confirmarContrasena = editTextAConfirmarC.getText().toString();

                // Validar campos no vacíos
                if (contrasenaAnterior.isEmpty() || nuevaContrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                    Toast.makeText(ActualizarContrasenaActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show();
                    return;
                }

                if (checkPassword(contrasenaAnterior)) {
                    if (nuevaContrasena.equals(confirmarContrasena)) {
                        updatePassword(username, nuevaContrasena);

                        Toast.makeText(ActualizarContrasenaActivity.this, "Contraseña actualizada", Toast.LENGTH_LONG).show();
                        startActivity(backView);
                    } else {
                        Toast.makeText(ActualizarContrasenaActivity.this, "Valide que las contraseñas sean iguales", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(ActualizarContrasenaActivity.this, "Contraseña actual incorrecta", Toast.LENGTH_LONG).show();
                }
            }
        });



        ImageViewBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(backView);
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
// ...

    private boolean checkPassword(String contrasena) {
        String username = UserSession.getInstance().getUsername();
        File file = new File(getFilesDir(), "userData.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 4 && userData[3].equals(username) && userData[4].equals(contrasena)) {
                    return true; // La contraseña coincide
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // La contraseña no coincide
    }

    // ... (código anterior)

    private void updatePassword(String username, String nuevaContrasena) {
        List<String> lines = new ArrayList<>();
        File file = new File(getFilesDir(), "userData.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 4 && userData[3].equals(username)) {
                    lines.add(userData[0] + "," + userData[1] + "," + userData[2] + "," + userData[3] + "," + nuevaContrasena + "," + nuevaContrasena);
                } else {
                    lines.add(line);
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            writer.close();

            // Actualizar la instancia de UserSession con la nueva contraseña
            UserSession userSession = UserSession.getInstance();
            userSession.setPassword(nuevaContrasena);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}