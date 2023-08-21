package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.solarsports.models.User;

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

    EditText editTextNombre ,editTextEmail , editTextTelefono ,editTextUsuario,editTextContrasena ,editTextConfirmarC ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_contrasena);

        Actualizar = findViewById(R.id.btnActualizar);
        ImageViewBack = findViewById(R.id.imageViewBack);
        ImageViewExit = findViewById(R.id.imageViewExit);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefono= findViewById(R.id.editTextTelefono);
        editTextUsuario= findViewById(R.id.editTextUsuario);
        editTextContrasena= findViewById(R.id.editTextContrasena);
        editTextConfirmarC= findViewById(R.id.editTextConfirmarC);

        Intent ActualizarView = new Intent(this, ActualizarUsuarioActivity.class);
        Intent backView = new Intent(this, UsuarioActivity.class);
        Intent exitView = new Intent(this, LoginActivity.class);


        Actualizar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Verificar vacios los campos
                if (!editTextNombre.getText().toString().isEmpty() &&
                        !editTextEmail.getText().toString().isEmpty() &&
                        !editTextTelefono.getText().toString().isEmpty() &&
                        !editTextUsuario.getText().toString().isEmpty() &&
                        !editTextContrasena.getText().toString().isEmpty() &&
                        !editTextConfirmarC.getText().toString().isEmpty()
                ) {

                    if (editTextContrasena.getText().toString().equals(editTextConfirmarC.getText().toString())) {

                        if (checkUser(editTextEmail.getText().toString(),
                                editTextUsuario.getText().toString())){
                            Toast.makeText(getApplicationContext(),"Este usuario ya esta registrado",Toast.LENGTH_LONG).show();
                        }else{
                            User user = new User(editTextNombre.getText().toString(), editTextEmail.getText().toString(),
                                    editTextTelefono.getText().toString(),
                                    editTextUsuario.getText().toString(),
                                    editTextContrasena.getText().toString(),
                                    editTextConfirmarC.getText().toString()
                            );
                            saveUser(user);
                            Toast.makeText(ActualizarContrasenaActivity.this, "Registrado", Toast.LENGTH_LONG).show();
                            startActivity(backView);
                        }
                    } else {
                        Toast.makeText(ActualizarContrasenaActivity.this, "Valide que las contraseñas sean iguales", Toast.LENGTH_LONG).show();

                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Valide que los campos no esten vacios",Toast.LENGTH_LONG).show();
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

    public void saveUser(User user) {
        File file = new File(getFilesDir(), "userData.txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(user.getName() + "," + user.getEmail() + "," + user.getUsername() + "," + user.getPhone() + "," + user.getPassword()+ "," + user.getPassword2());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String email, String username){
        File file= new File(getFilesDir(),"userData.txt");
        try {
            FileReader reader= new FileReader(file);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String line;
            List<String> emailList= new ArrayList<>();
            List<String> usernameList= new ArrayList<>();

            while ((line=bufferedReader.readLine())!=null){
                String [] data= line.split(",");
                emailList.add(data[1]);
                usernameList.add(data[2]);
            }
            bufferedReader.close();

            return emailList.contains(email) ||
                    usernameList.contains(username);

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}