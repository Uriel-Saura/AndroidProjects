package com.example.grafico;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button IdBtnBuscar, IdBtnConectar, IdBtnLed1on, IdBtnLed1off, IdBtnLed2on,
            IdBtnLed2off, IdBtnDesconectar;
    Spinner IdDisEncontrados;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        IdBtnBuscar = findViewById(R.id.IdBtnBuscar);
        IdBtnConectar = findViewById(R.id.IdBtnConectar);
        IdBtnLed1on = findViewById(R.id.IdBtnLed1on);
        IdBtnLed1off = findViewById(R.id.IdBtnLed1off);
        IdBtnLed2on = findViewById(R.id.IdBtnLed2on);
        IdBtnLed2off = findViewById(R.id.IdBtnLed2off);
        IdBtnDesconectar = findViewById(R.id.IdBtnDesconectar);
        IdDisEncontrados = findViewById(R.id.IdDisEncontrados);
        IdBtnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // acciones
            }
        });
        ArrayList <String> datos = new ArrayList<>();
        for (int i = 1; i<10 ; i++){
            datos.add("Nombre: " + i );
            System.out.println(datos.get(i-1));
        }
        Spinner spinn = (Spinner) IdDisEncontrados;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        spinn.setAdapter(adapter);
        IdBtnConectar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // acciones
            }
        });
        IdBtnLed1on.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getBaseContext(), "Se digitó el botón Led1 ON",
                        Toast.LENGTH_SHORT).show(); }
        });
        IdBtnLed1off.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // acciones
            }
        });
        IdBtnLed2on.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // acciones
            }
        });
        IdBtnLed2off.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // acciones
            }
        });
        IdBtnDesconectar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // acciones
            }
        });
    }
}

