package com.example.solarsports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.solarsports.models.EstadisticasData;
import com.example.solarsports.models.PanelSolar;
import com.example.solarsports.models.UserSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buscar extends AppCompatActivity {
    ImageView ImageViewExit;


    ImageView imageVBuscar;

    EditText editTextSearch;

    ImageView home;
    ImageView search;
    ImageView register;
    ImageView category;
    ImageView userProfile;
    ImageView stadistics;
    ImageView benefits , imageViewAtras , imageViewAdelante;


    List<PanelSolar> PanelesList;

    TableLayout tableBusquedas;

    TextView textViewPages , tvContadorRegistros2;

    int currentPage = 1;
    int RECORDS_PER_PAGE = 5;

    List<EstadisticasData> EstadisticasList;
    int startIndex, endIndex ,recordCount;

    RadioButton radioButtonRegistro;
    RadioButton radioButtonPaneles;
    RadioButton radioButtonCanchas ;
    RadioButton radioButtonGimnasios ;

    String currentUsername = UserSession.getInstance().getUsername();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        ImageViewExit = findViewById(R.id.imageViewExit);
        home = findViewById(R.id.imageViewHomeIcon);
        search = findViewById(R.id.imageViewSearchIcon);
        register = findViewById(R.id.imageViewRegisterIcon);
        category = findViewById(R.id.imageViewCategoryIcon);
        userProfile = findViewById(R.id.imageViewUserIcon);
        stadistics = findViewById(R.id.imageViewStadisticsIcon);
        benefits = findViewById(R.id.imageViewBenefitsIcon);
        tvContadorRegistros2 = findViewById(R.id.tvContadorRegistros2);

         imageVBuscar= findViewById(R.id.imageViewBuscar2);

        editTextSearch= findViewById(R.id.editTextSearch);

        tableBusquedas = findViewById(R.id.tableBusquedas);

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


        textViewPages.setVisibility(View.GONE);
        imageViewAtras.setVisibility(View.GONE);
        imageViewAdelante.setVisibility(View.GONE);
        tvContadorRegistros2.setVisibility(View.GONE);
         radioButtonRegistro = findViewById(R.id.radioButtonRegistro);
         radioButtonPaneles = findViewById(R.id.radioButtonPaneles);
         radioButtonCanchas = findViewById(R.id.radioButtonCanchas);
         radioButtonGimnasios = findViewById(R.id.radioButtonGimnasios);



        //Cargar datos de los txt (Files)
        File RegistrosFile = new File(getFilesDir(), "Registros.txt");
        File PanelesFile = new File(getFilesDir(), "Paneles.txt");

        imageVBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = editTextSearch.getText().toString().trim();
                String registros = "registros";
                String canchas = "canchas";
                String gimnasios = "gimnasios";
                String paneles = "paneles";


                if (searchTerm.isEmpty()) {
                    Toast.makeText(Buscar.this, "Ingresa un término válido de búsqueda", Toast.LENGTH_SHORT).show();
                } else if (searchTerm.equals(registros)) {
                    // Código para búsqueda de registros
                    EstadisticasList = ReadEstadisticasData(RegistrosFile);
                    startIndex = 0;
                    endIndex = Math.min(RECORDS_PER_PAGE - 1, EstadisticasList.size() - 1);
                    recordCount = EstadisticasList.size();
                    currentPage = 1; // Reset the current page to 1
                    updateUI();
                    addEstadisticasData(EstadisticasList, startIndex, endIndex);

                    // Show elements related to displaying records after a valid search
                    textViewPages.setVisibility(View.VISIBLE);
                    imageViewAtras.setVisibility(View.VISIBLE);
                    imageViewAdelante.setVisibility(View.VISIBLE);
                    tvContadorRegistros2.setVisibility(View.VISIBLE);

                    // Hide the "Atras" button on the first pag
                    if (currentPage == 1) {
                        imageViewAtras.setVisibility(View.INVISIBLE);
                    }

                     }else if (searchTerm.equals(canchas)) {


                    PanelesList = ReadPanelesData(PanelesFile);
                    startIndex = 0;
                    endIndex = Math.min(RECORDS_PER_PAGE - 1, PanelesList.size() - 1);
                    recordCount = PanelesList.size();
                    currentPage = 1; // Reset the current page to 1
                    addPanelesData(PanelesList, startIndex, endIndex);
                    // Código para búsqueda de canchas
                    performSearchCancha("Canchas");
                    // Show elements related to displaying records after a valid search
                    textViewPages.setVisibility(View.VISIBLE);
                    imageViewAtras.setVisibility(View.VISIBLE);
                    imageViewAdelante.setVisibility(View.VISIBLE);
                    tvContadorRegistros2.setVisibility(View.VISIBLE);


                    // Hide the "Atras" button on the first pag
                    if (currentPage == 1) {
                        imageViewAtras.setVisibility(View.INVISIBLE);
                    }





                } else if (searchTerm.equals(gimnasios)) {


                    PanelesList = ReadPanelesData(PanelesFile);
                    startIndex = 0;
                    endIndex = Math.min(RECORDS_PER_PAGE - 1, PanelesList.size() - 1);
                    recordCount = PanelesList.size();
                    currentPage = 1; // Reset the current page to 1
                    updateUI();
                    addPanelesData(PanelesList, startIndex, endIndex);
                    // Código para búsqueda de gimnasios
                    performSearchCancha("Gimnasios");
                    // Show elements related to displaying records after a valid search
                    textViewPages.setVisibility(View.VISIBLE);
                    imageViewAtras.setVisibility(View.VISIBLE);
                    imageViewAdelante.setVisibility(View.VISIBLE);
                    tvContadorRegistros2.setVisibility(View.VISIBLE);

                    // Hide the "Atras" button on the first pag
                    if (currentPage == 1) {
                        imageViewAtras.setVisibility(View.INVISIBLE);
                    }




                } else if (searchTerm.equals(paneles)) {
                    // Código para búsqueda de paneles
                    performSearchPanel("Paneles");

                    PanelesList = ReadPanelesData(PanelesFile);
                    startIndex = 0;
                    endIndex = Math.min(RECORDS_PER_PAGE - 1, PanelesList.size() - 1);
                    recordCount = PanelesList.size();
                    currentPage = 1; // Reset the current page to 1
                    addPanelesData(PanelesList, startIndex, endIndex);

                    // Show elements related to displaying records after a valid search
                    textViewPages.setVisibility(View.VISIBLE);
                    imageViewAtras.setVisibility(View.VISIBLE);
                    imageViewAdelante.setVisibility(View.VISIBLE);
                    tvContadorRegistros2.setVisibility(View.VISIBLE);

                    // Hide the "Atras" button on the first pag
                    if (currentPage == 1) {
                        imageViewAtras.setVisibility(View.INVISIBLE);
                    }
                } else {

                    Toast.makeText(Buscar.this, "No se encontraron resultados específicos, mostrando todos los registros", Toast.LENGTH_SHORT).show();

                }
            }
        });

        radioButtonRegistro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Código para búsqueda de registros
                    EstadisticasList = ReadEstadisticasData(RegistrosFile);
                    startIndex = 0;
                    endIndex = Math.min(RECORDS_PER_PAGE - 1, EstadisticasList.size() - 1);
                    recordCount = EstadisticasList.size();
                    currentPage = 1; // Reset the current page to 1
                    updateUI();
                    addEstadisticasData(EstadisticasList, startIndex, endIndex);

                    // Show elements related to displaying records after a valid search
                    textViewPages.setVisibility(View.VISIBLE);
                    imageViewAtras.setVisibility(View.VISIBLE);
                    imageViewAdelante.setVisibility(View.VISIBLE);
                    tvContadorRegistros2.setVisibility(View.VISIBLE);

                    // Hide the "Atras" button on the first pag
                    if (currentPage == 1) {
                        imageViewAtras.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        radioButtonPaneles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Código para búsqueda de paneles
                    performSearchPanel("Paneles");

                    PanelesList = ReadPanelesData(PanelesFile);
                    startIndex = 0;
                    endIndex = Math.min(RECORDS_PER_PAGE - 1, PanelesList.size() - 1);
                    recordCount = PanelesList.size();
                    currentPage = 1; // Reset the current page to 1
                    addPanelesData(PanelesList, startIndex, endIndex);

                    // Show elements related to displaying records after a valid search
                    textViewPages.setVisibility(View.VISIBLE);
                    imageViewAtras.setVisibility(View.VISIBLE);
                    imageViewAdelante.setVisibility(View.VISIBLE);
                    tvContadorRegistros2.setVisibility(View.VISIBLE);

                    // Hide the "Atras" button on the first pag
                    if (currentPage == 1) {
                        imageViewAtras.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        radioButtonCanchas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    PanelesList = ReadPanelesData(PanelesFile);
                    startIndex = 0;
                    endIndex = Math.min(RECORDS_PER_PAGE - 1, PanelesList.size() - 1);
                    recordCount = PanelesList.size();
                    currentPage = 1; // Reset the current page to 1
                    addPanelesData(PanelesList, startIndex, endIndex);
                    // Código para búsqueda de canchas
                    performSearchCancha("Canchas");
                    // Show elements related to displaying records after a valid search
                    textViewPages.setVisibility(View.VISIBLE);
                    imageViewAtras.setVisibility(View.VISIBLE);
                    imageViewAdelante.setVisibility(View.VISIBLE);
                    tvContadorRegistros2.setVisibility(View.VISIBLE);


                    // Hide the "Atras" button on the first pag
                    if (currentPage == 1) {
                        imageViewAtras.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        radioButtonGimnasios.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    PanelesList = ReadPanelesData(PanelesFile);
                    startIndex = 0;
                    endIndex = Math.min(RECORDS_PER_PAGE - 1, PanelesList.size() - 1);
                    recordCount = PanelesList.size();
                    currentPage = 1; // Reset the current page to 1
                    updateUI();
                    addPanelesData(PanelesList, startIndex, endIndex);
                    // Código para búsqueda de gimnasios
                    performSearchCancha("Gimnasios");
                    // Show elements related to displaying records after a valid search
                    textViewPages.setVisibility(View.VISIBLE);
                    imageViewAtras.setVisibility(View.VISIBLE);
                    imageViewAdelante.setVisibility(View.VISIBLE);
                    tvContadorRegistros2.setVisibility(View.VISIBLE);

                    // Hide the "Atras" button on the first pag
                    if (currentPage == 1) {
                        imageViewAtras.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

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

        editTextSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(searchView);
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
    }

    private List<PanelSolar> ReadPanelesData(File PanelesFile) {
        List<PanelSolar> PanelesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PanelesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Data: " + Arrays.toString(data));
                String nombrelugar = data[0];
                String nombrepanel = data[1];
                float longitud = Float.parseFloat(data[2]);
                float ancho = Float.parseFloat(data[3]);
                float potencia = Float.parseFloat(data[4]);
                float horassol = Float.parseFloat(data[5]);
                String mes = data[6];
                String usuario = data[7];
                String categoria = data[8];

                PanelSolar PanelObj = new PanelSolar(nombrelugar, nombrepanel ,longitud, horassol, ancho , potencia, mes ,usuario , categoria);
                PanelesList.add(PanelObj);
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PanelesList;
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

                EstadisticasData EstadisticasObj = new EstadisticasData(nombre, consumoKw, valorkW, mes, usuario , categoria);
                EstadisticasList.add(EstadisticasObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EstadisticasList;
    }


    private void addPanelesData(List<PanelSolar> PanelesList, int startIndex, int endIndex) {
        tableBusquedas.removeAllViews();

        addHeaderPanel();

        for (int i = startIndex; i <= endIndex; i++) {
            PanelSolar data = PanelesList.get(i);

            TableRow row = new TableRow(this);

            TextView cell1 = new TextView(this);
            cell1.setText(data.getNombreterraza());
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell1.setBackgroundResource(R.color.white);
            row.addView(cell1);



            TextView cell2 = new TextView(this);
            cell2.setText(data.getNombrelugar());
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell2.setBackgroundResource(R.color.white);
            row.addView(cell2);

            TextView cell3 = new TextView(this);
            cell3.setText(data.getCategoria());
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell3.setBackgroundResource(R.color.white);
            row.addView(cell3);

            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf(data.getUsuario()));
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setBackgroundResource(R.color.white);
            row.addView(cell4);

            tableBusquedas.addView(row);
        }
    }


    private void addEstadisticasData(List<EstadisticasData> EstadisticasList, int startIndex, int endIndex) {
        tableBusquedas.removeAllViews();

        addHeaderRegistros();

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

            TextView cell5 = new TextView(this);
            cell5.setText(data.getUsuario());
            cell5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell5.setBackgroundResource(R.color.white);
            row.addView(cell5);

            tableBusquedas.addView(row);
        }
    }
    private void addHeaderRegistros() {
        TableRow headerRow = new TableRow(this);

        // Encabezado MES
        TextView headerCell1 = new TextView(this);
        headerCell1.setText("MES");
        headerCell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell1.setTextColor(getResources().getColor(R.color.white));
        headerCell1.setBackgroundResource(R.color.blue);
        headerCell1.setLayoutParams(new TableRow.LayoutParams(
                200, // Ancho de 100dp para MES
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
                200, // Ancho de 100dp para PROMEDIO ENERGIA
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
                220, // Ancho de 100dp para MES
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
                180, // Ancho de 100dp para MES
                100 // Alto deseado para MES (en pixeles)
        ));
        headerRow.addView(headerCell4);

        TextView headerCell5 = new TextView(this);
        headerCell5.setText("USUARIO");
        headerCell5.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell5.setTextColor(getResources().getColor(R.color.white));
        headerCell5.setBackgroundResource(R.color.blue);
        headerCell5.setLayoutParams(new TableRow.LayoutParams(
                200, // Ancho de 100dp para USUARIO
                100 // Alto deseado para USUARIO (en pixeles)
        ));
        headerRow.addView(headerCell5);
        tableBusquedas.addView(headerRow);
    }

    private int getTotalPages() {
        return (int) Math.ceil((double) EstadisticasList.size() / RECORDS_PER_PAGE);
    }

    // Método para mostrar los registros en el rango específico

    private void showRecordsInRange(int startIndex, int endIndex) {
        tableBusquedas.removeAllViews();
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
        tvContadorRegistros2.setText("Registros: " + recordCount);
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


    private void updateUIForSearch(List<String[]> searchResults) {
        tableBusquedas.removeAllViews();
        addHeaderRegistros();

        for (String[] result : searchResults) {
            TableRow row = new TableRow(this);

            for (String value : result) {
                TextView cell = new TextView(this);
                cell.setText(value);
                cell.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                cell.setBackgroundResource(R.color.white);
                row.addView(cell);
            }

            tableBusquedas.addView(row);
        }
    }

    private void addHeaderPanel() {
        tableBusquedas.removeAllViews();

        TableRow headerRow = new TableRow(this);
        String[] headerValues = { "LUGAR", "NOMBRE DEL PANEL", "CATEGORÍA", "USUARIO"};

        for (String value : headerValues) {
            TextView headerCell = new TextView(this);
            headerCell.setText(value);
            headerCell.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            headerCell.setTextColor(getResources().getColor(R.color.white));
            headerCell.setBackgroundResource(R.color.blue);
            headerCell.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    100 // Altura deseada para el encabezado (en píxeles)
            ));
            headerRow.addView(headerCell);
        }

        tableBusquedas.addView(headerRow);
    }

    private void performSearchPanel(String searchTerm) {
        List<String[]> searchResults = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(getFilesDir(), "Paneles.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String nombreCanchaGimnasio = data[0];
                String nombrePanel = data[1];
                String categoria = data[8];
                String usuario = data[7];

                if (nombreCanchaGimnasio.toLowerCase().contains(searchTerm.toLowerCase())) {
                    searchResults.add(new String[]{nombreCanchaGimnasio, nombrePanel, categoria, usuario});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateUIForSearch(searchResults);
    }

    private void addHeaderCanchas(String category) {
        tableBusquedas.removeAllViews();

        TableRow headerRow = new TableRow(this);

        // Header: NOMBRE DE CATEGORÍA
        TextView headerCell1 = createHeaderCell("NOMBRE DE " + category.toUpperCase());
        headerRow.addView(headerCell1);

        // Header: CANTIDAD DE PANELES
        TextView headerCell2 = createHeaderCell("CANTIDAD PANELES");
        headerRow.addView(headerCell2);

        // Header: CATEGORÍA
        TextView headerCell3 = createHeaderCell("CATEGORÍA");
        headerRow.addView(headerCell3);

        // Header: USUARIO
        TextView headerCell4 = createHeaderCell("USUARIO");
        headerRow.addView(headerCell4);

        tableBusquedas.addView(headerRow);
    }

    private TextView createHeaderCell(String text) {
        TextView headerCell = new TextView(this);
        headerCell.setText(text);
        headerCell.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        headerCell.setTextColor(getResources().getColor(R.color.white));
        headerCell.setBackgroundResource(R.color.blue);
        headerCell.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                100 // Altura deseada para el encabezado (en píxeles)
        ));
        return headerCell;
    }



    private void performSearchCancha(String category) {
        Map<String, PanelSolar> panelCounts = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(getFilesDir(), "Paneles.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String nombreCanchaGimnasio = data[0];
                String usuario = data[7];
                String categoria = data[8];

                if (categoria.toLowerCase().contains(category.toLowerCase())) {
                    if (!panelCounts.containsKey(nombreCanchaGimnasio)) {
                        panelCounts.put(nombreCanchaGimnasio, new PanelSolar(categoria, usuario));
                    }
                    panelCounts.get(nombreCanchaGimnasio).incrementPanelCount();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateUIForSearchCancha(panelCounts, category);
    }




    private void updateUIForSearchCancha(Map<String, PanelSolar> panelInfoMap, String category) {
        tableBusquedas.removeAllViews();
        addHeaderCanchas(category);

        for (Map.Entry<String, PanelSolar> entry : panelInfoMap.entrySet()){
            String canchaGimnasio = entry.getKey();
            PanelSolar panelsolar = entry.getValue();
            int panelCount = panelsolar.getPanelCount();
            String categoria = panelsolar.getCategoria();
            String usuario = panelsolar.getUsuario();

            TableRow row = new TableRow(this);

            TextView cell1 = new TextView(this);
            cell1.setText(canchaGimnasio);
            cell1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell1.setBackgroundResource(R.color.white);
            row.addView(cell1);

            TextView cell2 = new TextView(this);
            cell2.setText(String.valueOf(panelCount));
            cell2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell2.setBackgroundResource(R.color.white);
            row.addView(cell2);

            TextView cell3 = new TextView(this);
            cell3.setText(categoria);
            cell3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell3.setBackgroundResource(R.color.white);
            row.addView(cell3);

            TextView cell4 = new TextView(this);
            cell4.setText(usuario);
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            cell4.setBackgroundResource(R.color.white);
            row.addView(cell4);


            tableBusquedas.addView(row);
        }
    }


}