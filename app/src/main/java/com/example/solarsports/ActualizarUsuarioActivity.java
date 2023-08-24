package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.solarsports.models.UserSession;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ActualizarUsuarioActivity extends AppCompatActivity {

    ImageView ImageViewBack;
    ImageView ImageViewExit;
    Button Actualizar;

    EditText editTextNombre, editTextEmail, editTextTelefono, editTextUsuario, editTextAContrasena, editTextAConfirmarC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_usuario);

        Actualizar = findViewById(R.id.btnActualizar);
        ImageViewBack = findViewById(R.id.imageViewBack);
        ImageViewExit = findViewById(R.id.imageViewExit);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextUsuario = findViewById(R.id.editTextUsuario);

        Intent ActualizarView = new Intent(this, ActualizarUsuarioActivity.class);
        Intent backView = new Intent(this, UsuarioActivity.class);
        Intent exitView = new Intent(this, LoginActivity.class);


        // Obtener la instancia de UserSession
        UserSession userSession = UserSession.getInstance();

        // Obtener los datos del usuario
        String username = userSession.getUsername();
        String email = userSession.getEmail();

        cargarDatosUsuario(username);

        Actualizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Verificar campos no vacíos
                if (!editTextNombre.getText().toString().isEmpty() &&
                        !editTextEmail.getText().toString().isEmpty() &&
                        !editTextTelefono.getText().toString().isEmpty() &&
                        !editTextUsuario.getText().toString().isEmpty()) {

                    // Actualizar la información en el archivo userData.txt
                    actualizarDatosUsuario(username,
                            editTextNombre.getText().toString(),
                            editTextEmail.getText().toString(),
                            editTextTelefono.getText().toString(),
                            editTextUsuario.getText().toString()
                    );

                    // Notificar al usuario y regresar a la vista anterior
                    Toast.makeText(ActualizarUsuarioActivity.this, "Información actualizada", Toast.LENGTH_LONG).show();
                    startActivity(backView);
                } else {
                    Toast.makeText(ActualizarUsuarioActivity.this, "Valide que los campos no estén vacíos", Toast.LENGTH_LONG).show();
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

                // Cierra la sesión de UserSesion
                UserSession.getInstance().logout();
                startActivity(exitView);
            }
        });
    }

    private void cargarDatosUsuario(String usuario) {
        File file = new File(getFilesDir(), "userData.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 4 && userData[3].equals(usuario)) {
                    editTextNombre.setText(userData[0]);
                    editTextEmail.setText(userData[1]);
                    editTextTelefono.setText(userData[2]);
                    editTextUsuario.setText(userData[3]);
                    // No asignes la contraseña en un campo de edición de texto por seguridad
                    // Puedes proporcionar un botón para cambiar la contraseña en otro lugar
                    break; // Terminar el bucle después de encontrar los datos del usuario
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // ...

    private void actualizarDatosUsuario(String username, String nombre,
                                        String email, String telefono, String usuario) {
        List<String> lines = new ArrayList<>();
        File file = new File(getFilesDir(), "userData.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 4 && userData[3].equals(username)) {
                    lines.add(nombre + "," + email + "," + telefono + "," + usuario + "," + userData[4] + "," + userData[5]);
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

            // Actualizar los valores en UserSession
            UserSession userSession = UserSession.getInstance();
            userSession.setUsername(usuario);
            userSession.setEmail(email);
            userSession.setPhoneNumber(telefono);
            userSession.setName(nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



