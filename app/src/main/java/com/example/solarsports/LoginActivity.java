package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.solarsports.models.UserSession;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
                {Log.i("EditText",editTextUser.getText().toString()+"-"+
                        editTextPassword.getText().toString());
                    if(checkUser(editTextUser.getText().toString(),
                            editTextPassword.getText().toString())){

                        UserSession userSession = UserSession.getInstance();
                        userSession.setUsername(editTextUser.getText().toString());

                        Toast.makeText(LoginActivity.this ,"Exitoso",Toast.LENGTH_LONG).show();
                        startActivity(homeView);
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "Los datos son incorrectos",Toast.LENGTH_LONG).show();
                    }
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

    public boolean checkUser(String user, String pass){
        //user --> email, username, phone
        File file = new File(getFilesDir(),"userData.txt");
        try {
            BufferedReader reader= new BufferedReader(new FileReader(file));
            String line;
            while ((line=reader.readLine())!=null){
                String[] userData= line.split(",");
                String email= userData[1];
                String username= userData[2];
                String phone= userData[3];
                String password= userData[4];

                Log.i("Parametros entrada", user+"-"+pass);
                Log.i("File", email+"-"+username+"-"+phone+
                        "-"+password);

                if((email.equals(user)||username.equals(user)||
                        phone.equals(user))&& password.equals(pass)){
                    Log.i("Check", "True");
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }
}