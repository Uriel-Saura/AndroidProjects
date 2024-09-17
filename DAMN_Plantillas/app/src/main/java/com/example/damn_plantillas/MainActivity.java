package com.example.damn_plantillas;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    public String[] estados = {"CDMX", "Coahuila", "Guerrero", "Hidalgo",
            "Oaxaca", "Tamaulipas", "Veracruz", "Yucatán"};

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> Adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item, estados);

        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(Adapter);
        grid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
        TextView seleccion = findViewById(R.id.seleccion);
        seleccion.setText(estados[posicion]);
    }
}
