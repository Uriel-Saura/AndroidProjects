package com.example.damn_listas_11;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private Button btnAgregar;
    private ListView listViewNombres;
    private ArrayList<String> listaNombres;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciar los elementos del layout
        editTextNombre = findViewById(R.id.editTextNombre);
        btnAgregar = findViewById(R.id.btnAgregar);
        listViewNombres = findViewById(R.id.listViewNombres);

        // Inicializar la lista y el adaptador
        listaNombres = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNombres);

        // Asignar el adaptador al ListView
        listViewNombres.setAdapter(adapter);

        // Configurar el botón para agregar nombres
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString().trim();
                if (!nombre.isEmpty()) {
                    // Agregar el nombre a la lista y notificar al adaptador
                    listaNombres.add(nombre);
                    adapter.notifyDataSetChanged();
                    // Limpiar el campo de texto
                    editTextNombre.setText("");
                }
            }
        });
    }
}