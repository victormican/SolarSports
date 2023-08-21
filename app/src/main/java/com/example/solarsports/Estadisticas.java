package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.solarsports.models.Canchas;
import com.example.solarsports.models.Gimnasios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Estadisticas extends AppCompatActivity {

    ImageView ImageViewExit;


    ImageView imageVEstadisticas;

    TextView textVEstadisticas;

    ImageView home;
    ImageView search;
    ImageView register;
    ImageView category;
    ImageView userProfile;
    ImageView stadistics;
    ImageView benefits;

    TableLayout tableEstadisticas;

    TextView textViewEMes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        ImageViewExit = findViewById(R.id.imageViewExit);
        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);
        tableEstadisticas = findViewById(R.id.tableEstadisticas);

        textViewEMes = findViewById(R.id.textViewEMes);

        imageVEstadisticas = findViewById(R.id.imageViewStadistic);

        textVEstadisticas = findViewById(R.id.textViewEstadisticas);

        Intent exitView = new Intent(this, LoginActivity.class);

        Intent CategoryView = new Intent(this, Categorias.class);

        Intent ViewRegister = new Intent(this, Registro.class);

        Intent ViewStadistic = new Intent(this, Estadisticas.class);

        Intent ViewBenefits = new Intent(this, Beneficios.class);


        Intent homeView = new Intent(this, HomeActivity.class);
        Intent searchView = new Intent(this, Buscar.class);

        Intent userProfileView = new Intent(this, UsuarioActivity.class);

        //Cargar datos de los txt (Files)
        File CanchasRegistrosFile = new File(getFilesDir(), "CanchasRegistros.txt");

        List<Canchas> canchasList = readFile(CanchasRegistrosFile);

        addCanchaData(canchasList);

        File GimRegistrosFile = new File(getFilesDir(), "GimRegistros.txt");

        List<Gimnasios> GimList = readFileGim(GimRegistrosFile);
        addGimData(GimList);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeView);
            }
        });
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
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryView);
            }
        });
        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(userProfileView);
            }
        });
        stadistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewStadistic);
            }
        });
        benefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewBenefits);
            }
        });

        textVEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewStadistic);
            }
        });
        imageVEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewStadistic);
            }
        });



    }

    private List<Gimnasios> readFileGim(File gimRegistrosFile) {
        List<Gimnasios> gimList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(gimRegistrosFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String nombregim = data[0];
                float consumoKw = Float.parseFloat(data[1]);
                float valorkW = Float.parseFloat(data[2]);
                String mes = data[3];
                String usuario = data[4];
                String categoria = data[5];
                // Obtener el nombre de usuario
                Gimnasios gimObj = new Gimnasios(nombregim, consumoKw, valorkW, mes, usuario , categoria); // Pasa el nombre de usuario al constructor
                gimList.add(gimObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gimList;
    }


    private void addGimData(List<Gimnasios> GimList) {

        for (Gimnasios i:GimList) {
            TableRow row= new TableRow(this);
            TextView cell1= new TextView(this);
            cell1.setText(i.getMes());
            cell1.setWidth(80);
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            //   cell1.setPadding(10,10,10,10);
            cell1.setBackgroundResource(R.color.white);

            TextView cell2= new TextView(this);
            cell2.setText(i.getConsumo()+"");
            cell2.setWidth(90);
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            //   cell2.setPadding(10,10,10,10);
            cell2.setBackgroundResource(R.color.white);

            TextView cell3= new TextView(this);
            cell3.setText(i.getCategoria());
            cell3.setWidth(90);
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            //   cell3.setPadding(10,10,10,10);
            cell3.setBackgroundResource(R.color.white);

            TextView cell4= new TextView(this);
            cell4.setText(String.valueOf(i.getValorkw()));
            //  cell4.setPadding(10,10,10,10);
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setWidth(60);
            cell4.setBackgroundResource(R.color.white);

            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);

            tableEstadisticas.addView(row);
        }
    }

    private List<Canchas> readFile(File canchasRegistrosFile) {
        List<Canchas> canchasList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(canchasRegistrosFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String nombrecancha = data[0];
                float consumo = Float.parseFloat(data[1]);
                float preciokw = Float.parseFloat(data[2]);
                String mes = data[3];
                String usuario = data[4];
                String categoria = data[5];// Obtener el nombre de usuario
                Canchas CanchasObj = new Canchas(nombrecancha , consumo, preciokw, mes, usuario , categoria); // Pasa el nombre de usuario al constructor
                canchasList.add(CanchasObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return canchasList;
    }



    private void addCanchaData(List<Canchas> canchasList) {
        for (Canchas i : canchasList) {
            TableRow row = new TableRow(this);
            TextView cell1 = new TextView(this);
            cell1.setText(i.getMes());
            cell1.setWidth(80);
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            //   cell1.setPadding(10,10,10,10);
            cell1.setBackgroundResource(R.color.white);

            TextView cell2 = new TextView(this);
            cell2.setText(i.getConsumo() + "");
            cell2.setWidth(90);
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            //   cell2.setPadding(10,10,10,10);
            cell2.setBackgroundResource(R.color.white);

            TextView cell3 = new TextView(this);
            cell3.setText(i.getCategoria());
            cell3.setWidth(90);
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            //   cell3.setPadding(10,10,10,10);
            cell3.setBackgroundResource(R.color.white);

            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf(i.getPreciokw()));
            //  cell4.setPadding(10,10,10,10);
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setWidth(60);
            cell4.setBackgroundResource(R.color.white);

            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);


            tableEstadisticas.addView(row);
    }
    }
}
