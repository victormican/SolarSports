package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class LoginActivity extends AppCompatActivity {
    Button login;

    TextView registrarse;

    TextView recuperar;

    EditText editTextUser, editTextPassword ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btnIngresar);
        registrarse = findViewById(R.id.textViewRegistrar);
        recuperar = findViewById(R.id.textViewRecuperarAqui);
        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);

        Intent homeView = new Intent(this, HomeActivity.class);
        Intent registrarView = new Intent(this, Registrar.class);
        Intent recuperarView = new Intent(this, Recuperar.class);
        Intent LoginView = new Intent(this, LoginActivity.class);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Verificar vacios los campos
                if(!editTextUser.getText().toString().isEmpty() &&
                        !editTextPassword.getText().toString().isEmpty())
                {
                    //Almacenar en txt
                    File file = new File(getFilesDir(),"Login.xt");
                    try {
                        FileWriter writer = new FileWriter(file,true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                        String usuarios =
                                editTextUser.getText().toString()+","+
                                        editTextPassword.getText().toString();
                        bufferedWriter.write(usuarios);
                        bufferedWriter.newLine();
                        bufferedWriter.close();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    editTextUser.setText("");
                    editTextPassword.setText("");
                    Toast.makeText(LoginActivity.this ,"Exitoso",Toast.LENGTH_LONG).show();
                    startActivity(homeView);

                }else{
                    Toast.makeText(LoginActivity.this ,"Valide que los campos no esten vacios",Toast.LENGTH_LONG).show();
                    startActivity(LoginView);
                }

            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(registrarView);
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recuperarView);
            }
        });

    }
}