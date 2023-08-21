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

public class Recuperar extends AppCompatActivity {

    ImageView ImageViewBack;
    ImageView ImageViewExit;
    Button recuperar;

    EditText editTextUser, editTextEmail ,editTextNuevaContrasena ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);
        recuperar = findViewById(R.id.btnRecuperar);
        ImageViewBack = findViewById(R.id.imageViewBack);
        ImageViewExit = findViewById(R.id.imageViewExit);
         editTextUser= findViewById(R.id.editTextUsuario);
         editTextEmail= findViewById(R.id.editTextEmail);
         editTextNuevaContrasena = findViewById(R.id.editTextNuevaContrasena);

        Intent recuperarView = new Intent(this, Recuperar.class);
        Intent backView = new Intent(this, LoginActivity.class);
        Intent exitView = new Intent(this, LoginActivity.class);

        recuperar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Verificar vacios los campos
                if(!editTextUser.getText().toString().isEmpty() &&
                        !editTextEmail.getText().toString().isEmpty()  &&
                        !editTextNuevaContrasena.getText().toString().isEmpty())
                {
                    //Almacenar en txt
                    File file = new File(getFilesDir(),"Recuperar.txt");
                    try {
                        FileWriter writer = new FileWriter(file,true);
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                        String recuperacion =
                                editTextUser.getText().toString()+","+
                                        editTextEmail.getText().toString()+","+
                                        editTextNuevaContrasena.getText().toString();
                        bufferedWriter.write(recuperacion);
                        bufferedWriter.newLine();
                        bufferedWriter.close();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    editTextUser.setText("");
                    editTextEmail.setText("");
                    editTextNuevaContrasena.setText("");
                    Toast.makeText(Recuperar.this ,"Recuperado",Toast.LENGTH_LONG).show();
                    startActivity(backView);

                }else{
                    Toast.makeText(Recuperar.this ,"Valide que los campos no esten vacios",Toast.LENGTH_LONG).show();
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