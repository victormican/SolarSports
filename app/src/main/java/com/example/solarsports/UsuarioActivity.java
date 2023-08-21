package com.example.solarsports;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.solarsports.models.UserSession;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class UsuarioActivity extends AppCompatActivity {

    ImageView ImageViewExit;
    ImageView imageVUser;
    TextView textVUser;
    ImageView home;
    ImageView search;
    ImageView register;
    ImageView category;
    ImageView userProfile;
    ImageView stadistics;
    ImageView benefits;
    ImageView ActualizarUsuario;
    ImageView imageViewChange,  imageDeleteUsuario, imageViewUser;
    TextView textEditUser, textEditContrasena, textViewUUser, textDeleteUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        // Asignación de vistas
        ImageViewExit = findViewById(R.id.imageViewExit);
        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);
        ActualizarUsuario = findViewById(R.id.imageActualizarUsuario);
        imageViewChange = findViewById(R.id.imageViewChange);
        imageDeleteUsuario = findViewById(R.id.imageDeleteUsuario);
        textEditUser = findViewById(R.id.textEditUser);
        textEditContrasena = findViewById(R.id.textEditContrasena);
        imageViewUser = findViewById(R.id.imageViewUser);
        textViewUUser = findViewById(R.id.textViewUUser);
        textDeleteUser = findViewById(R.id.textDeleteUser);

        // Intentos
        Intent ActualizarUsuarioContrasenaView = new Intent(this, ActualizarContrasenaActivity.class);
        Intent EliminarUsuarioView = new Intent(this, EliminarUsuarioActivity.class);
        Intent ActualizarUsuarioView = new Intent(this, ActualizarUsuarioActivity.class);
        Intent exitView = new Intent(this, LoginActivity.class);
        Intent CategoryView = new Intent(this, Categorias.class);
        Intent ViewRegister = new Intent(this, Registro.class);
        Intent ViewStadistic = new Intent(this, Estadisticas.class);
        Intent ViewBenefits = new Intent(this, Beneficios.class);
        Intent homeView = new Intent(this, HomeActivity.class);
        Intent searchView = new Intent(this, Buscar.class);
        Intent userProfileView = new Intent(this, UsuarioActivity.class);

        // Listeners
        ImageViewExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        imageDeleteUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });

    }
    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmación de eliminación");
        builder.setMessage("¿Está seguro de que desea eliminar su cuenta? Esta acción no se puede deshacer.");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                eliminarUsuario();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void eliminarUsuario() {
        // Obtén el nombre de usuario del usuario actual
        UserSession userSession = UserSession.getInstance();
        String username = userSession.getUsername();

        // Elimina al usuario de los datos y de la sesión
        boolean userDeleted = deleteUser(username);

        if (userDeleted) {
            // Limpia los datos de la sesión
            userSession.clearSession();

            // Redirige al usuario a la pantalla de inicio de sesión
            Intent loginView = new Intent(this, LoginActivity.class);
            startActivity(loginView);
            finish(); // Cierra la actividad actual
        } else {
            // Muestra un mensaje de error si no se pudo eliminar
            Toast.makeText(this, "Error al eliminar el usuario", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean deleteUser(String username) {
        File file = new File(getFilesDir(), "userData.txt");
        List<String> updatedLines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 4 && !userData[3].equals(username)) {
                    updatedLines.add(line);
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            writer.close();

            return true; // Usuario eliminado exitosamente
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Error al eliminar al usuario
    }
}