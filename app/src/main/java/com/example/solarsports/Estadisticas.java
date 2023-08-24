package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.solarsports.models.EstadisticasData;
import com.example.solarsports.models.UserSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
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
    ImageView benefits , imageViewAtras , imageViewAdelante;

    TableLayout tableEstadisticas;

    TextView textViewEMes, textViewPages;

    TextView tvContadorRegistros;

    int currentPage = 1;
    int RECORDS_PER_PAGE = 5;

    List<EstadisticasData> EstadisticasList;
    int startIndex, endIndex ,recordCount;

    String currentUsername = UserSession.getInstance().getUsername();

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

        tvContadorRegistros = findViewById(R.id.tvContadorRegistros);
        textViewPages = findViewById(R.id.textViewPages);

        imageViewAtras = findViewById(R.id.imageViewAtras);

    imageViewAdelante = findViewById(R.id.imageViewAdelante);


        Intent exitView = new Intent(this, LoginActivity.class);

        Intent CategoryView = new Intent(this, Categorias.class);

        Intent ViewRegister = new Intent(this, Registro.class);

        Intent ViewStadistic = new Intent(this, Estadisticas.class);

        Intent ViewBenefits = new Intent(this, Beneficios.class);


        Intent homeView = new Intent(this, HomeActivity.class);
        Intent searchView = new Intent(this, Buscar.class);

        Intent userProfileView = new Intent(this, UsuarioActivity.class);

        imageViewAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousPage();
            }
        });

        imageViewAdelante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextPage();
            }
        });

        //Cargar datos de los txt (Files)
        File RegistrosFile = new File(getFilesDir(), "Registros.txt");

        EstadisticasList = ReadEstadisticasData(RegistrosFile);

        // Calcula los índices de inicio y final para la página actual
        startIndex = 0;
        endIndex = Math.min(RECORDS_PER_PAGE - 1, EstadisticasList.size() - 1);
        recordCount = EstadisticasList.size();
        updateUI();

        addEstadisticasData(EstadisticasList, startIndex, endIndex);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeView);
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

    private List<EstadisticasData> ReadEstadisticasData(File RegistrosFile) {
        List<EstadisticasData> EstadisticasList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(RegistrosFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Data: " + Arrays.toString(data));
                String nombre = data[0];
                float consumoKw = Float.parseFloat(data[1]);
                float valorkW = Float.parseFloat(data[2]);
                String mes = data[3];
                String usuario = data[4];
                String categoria = data[5];
                // Verifica si el nombre de usuario coincide con el usuario actual
                if (usuario.equals(currentUsername)) {
                    EstadisticasData EstadisticasObj = new EstadisticasData(nombre, consumoKw, valorkW, mes, usuario , categoria);
                    EstadisticasList.add(EstadisticasObj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EstadisticasList;
    }



    private void addEstadisticasData(List<EstadisticasData> EstadisticasList, int startIndex, int endIndex) {
        tableEstadisticas.removeAllViews();

        addHeader();

        for (int i = startIndex; i <= endIndex; i++) {
            EstadisticasData data = EstadisticasList.get(i);

            TableRow row = new TableRow(this);

            TextView cell1 = new TextView(this);
            cell1.setText(data.getMes());
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell1.setBackgroundResource(R.color.white);
            row.addView(cell1);



            TextView cell2 = new TextView(this);
            cell2.setText(data.getConsumo() + "");
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell2.setBackgroundResource(R.color.white);
            row.addView(cell2);

            TextView cell3 = new TextView(this);
            cell3.setText(data.getCategoria());
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell3.setBackgroundResource(R.color.white);
            row.addView(cell3);

            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf(data.getValorkW()));
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setBackgroundResource(R.color.white);
            row.addView(cell4);

            tableEstadisticas.addView(row);
        }
    }
    private void addHeader() {
        TableRow headerRow = new TableRow(this);

        // Encabezado MES
        TextView headerCell1 = new TextView(this);
        headerCell1.setText("MES");
        headerCell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell1.setTextColor(getResources().getColor(R.color.white));
        headerCell1.setBackgroundResource(R.color.blue);
        headerCell1.setLayoutParams(new TableRow.LayoutParams(
                250, // Ancho de 100dp para MES
                100 // Alto deseado para MES (en pixeles)
        ));
        headerRow.addView(headerCell1);

        // Encabezado PROMEDIO ENERGIA
        TextView headerCell2 = new TextView(this);
        headerCell2.setText("PROMEDIO ENERGIA");
        headerCell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell2.setTextColor(getResources().getColor(R.color.white));
        headerCell2.setBackgroundResource(R.color.blue);
        headerCell2.setLayoutParams(new TableRow.LayoutParams(
                250, // Ancho de 100dp para PROMEDIO ENERGIA
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        headerRow.addView(headerCell2);

        // Encabezado CATEGORIA
        TextView headerCell3 = new TextView(this);
        headerCell3.setText("CATEGORIA");
        headerCell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell3.setTextColor(getResources().getColor(R.color.white));
        headerCell3.setBackgroundResource(R.color.blue);
        headerCell3.setLayoutParams(new TableRow.LayoutParams(
                300, // Ancho de 100dp para MES
                100 // Alto deseado para MES (en pixeles)
        ));
        headerRow.addView(headerCell3);

        // Encabezado AHORRO
        TextView headerCell4 = new TextView(this);
        headerCell4.setText("AHORRO");
        headerCell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell4.setTextColor(getResources().getColor(R.color.white));
        headerCell4.setBackgroundResource(R.color.blue);
        headerCell4.setLayoutParams(new TableRow.LayoutParams(
                300, // Ancho de 100dp para MES
                100 // Alto deseado para MES (en pixeles)
        ));
        headerRow.addView(headerCell4);

        tableEstadisticas.addView(headerRow);
    }

    private void addHeader2() {
        TableRow headerRow = new TableRow(this);


        TextView headerCell1 = new TextView(this);
        headerCell1.setText("MES");
        headerCell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell1.setTextColor(getResources().getColor(R.color.white)); // Cambia el color del texto a blanco
        headerCell1.setBackgroundResource(R.color.blue); // Cambia esto al color de fondo deseado
        headerRow.addView(headerCell1);

        TextView headerCell2 = new TextView(this);
        headerCell2.setText("PROMEDIO ENERGIA");
        headerCell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell1.setTextColor(getResources().getColor(R.color.white)); // Cambia el color del texto a blanco
        headerCell1.setBackgroundResource(R.color.blue);
        headerRow.addView(headerCell2);

        TextView headerCell3 = new TextView(this);
        headerCell3.setText("CATEGORIA");
        headerCell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell1.setTextColor(getResources().getColor(R.color.white)); // Cambia el color del texto a blanco
        headerCell1.setBackgroundResource(R.color.blue);
        headerRow.addView(headerCell3);

        TextView headerCell4 = new TextView(this);
        headerCell4.setText("AHORRO");
        headerCell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell1.setTextColor(getResources().getColor(R.color.white)); // Cambia el color del texto a blanco
        headerCell1.setBackgroundResource(R.color.blue);
        headerRow.addView(headerCell4);

        tableEstadisticas.addView(headerRow);
    }

    private int getTotalPages() {
        return (int) Math.ceil((double) EstadisticasList.size() / RECORDS_PER_PAGE);
    }

    // Método para mostrar los registros en el rango específico

    private void showRecordsInRange(int startIndex, int endIndex) {
        tableEstadisticas.removeAllViews();
        addEstadisticasData(EstadisticasList, startIndex, endIndex);
    }

    // Método para mostrar la página anterior
    private void showPreviousPage() {
        if (currentPage > 1) {
            currentPage--;
            startIndex -= RECORDS_PER_PAGE;
            endIndex = startIndex + RECORDS_PER_PAGE - 1;
            updateUI();
            addEstadisticasData(EstadisticasList, startIndex, endIndex);
        }
    }

    private void showNextPage() {
        if (currentPage < getTotalPages()) {
            currentPage++;
            startIndex = endIndex + 1;
            endIndex = Math.min(startIndex + RECORDS_PER_PAGE - 1, EstadisticasList.size() - 1);
            updateUI();
            addEstadisticasData(EstadisticasList, startIndex, endIndex);
        }
    }

    private void updateUI() {
        showRecordsInRange(startIndex, endIndex);
        tvContadorRegistros.setText("Registros: " + recordCount);
        textViewPages.setText("Página " + currentPage);

        // Manage button visibility based on page number
        imageViewAtras.setVisibility(View.VISIBLE);
        imageViewAdelante.setVisibility(View.VISIBLE);

        if (currentPage == 1) {
            imageViewAtras.setVisibility(View.INVISIBLE);
        }

        if (currentPage == getTotalPages()) {
            // Adjust endIndex for the last page to show the remaining records
            endIndex = EstadisticasList.size() - 1;
            imageViewAdelante.setVisibility(View.INVISIBLE);
        }
    }

}