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
public class EliminarUsuarioActivity extends AppCompatActivity {
    ImageView ImageViewBack;
    ImageView ImageViewExit;
    Button btnEliminarUser;

    EditText editTextNombre ,editTextEmail , editTextTelefono ,editTextUsuario,editTextContrasena ,editTextConfirmarC ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_usuario);


        btnEliminarUser = findViewById(R.id.btnEliminarUser);
        ImageViewBack = findViewById(R.id.imageViewBack);
        ImageViewExit = findViewById(R.id.imageViewExit);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUsuario= findViewById(R.id.editTextUsuario);
        editTextContrasena= findViewById(R.id.editTextContrasena);
        editTextConfirmarC= findViewById(R.id.editTextConfirmarC);

        Intent ActualizarView = new Intent(this, ActualizarUsuarioActivity.class);
        Intent backView = new Intent(this, UsuarioActivity.class);
        Intent exitView = new Intent(this, LoginActivity.class);


        btnEliminarUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Verificar vacios los campos
                if (!editTextNombre.getText().toString().isEmpty() &&
                        !editTextEmail.getText().toString().isEmpty() &&
                        !editTextTelefono.getText().toString().isEmpty()&&
                        !editTextUsuario.getText().toString().isEmpty()&&
                        !editTextContrasena.getText().toString().isEmpty()&&
                        !editTextConfirmarC.getText().toString().isEmpty()


                ) {
                    //Almacenar en txt
                    File file = new File(getFilesDir(), "Actualizar.txt");
                    try {
                        FileWriter writer = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                        String actualizacion =
                                editTextNombre.getText().toString() + "," +
                                        editTextEmail.getText().toString() + "," +
                                        editTextTelefono.getText().toString()+ "," +
                                        editTextUsuario.getText().toString()+ "," +
                                        editTextContrasena.getText().toString()+ "," +
                                        editTextConfirmarC.getText().toString()

                                ;



                        bufferedWriter.write(actualizacion);
                        bufferedWriter.newLine();
                        bufferedWriter.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    editTextNombre.setText("");
                    editTextEmail.setText("");
                    editTextTelefono.setText("");
                    editTextUsuario.setText("");
                    editTextContrasena.setText("");
                    editTextConfirmarC.setText("");
                    Toast.makeText(EliminarUsuarioActivity.this, "Registrado", Toast.LENGTH_LONG).show();
                    startActivity(backView);

                } else {
                    Toast.makeText(EliminarUsuarioActivity.this, "Valide que los campos no esten vacios", Toast.LENGTH_LONG).show();
                    startActivity(ActualizarView);
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
}