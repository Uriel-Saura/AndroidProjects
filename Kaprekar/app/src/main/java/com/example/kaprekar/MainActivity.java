package com.example.kaprekar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvResultado;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.et_input);
        tvResultado = findViewById(R.id.tv_resultado);
        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString();

                if (input.length() == 4) {
                    int n = Integer.parseInt(input);
                    iterarNumeros(n);
                } else {
                    tvResultado.setText("Por favor ingresa un número válido de 4 dígitos.");
                    tvResultado.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void iterarNumeros(int n) {
        ArrayList<Integer> resultadosPrevios = new ArrayList<>();
        StringBuilder resultados = new StringBuilder();
        int iteraciones = 0;

        while (!resultadosPrevios.contains(n)) {
            resultadosPrevios.add(n);
            iteraciones++;

            // Obtener la lista de dígitos del número n
            ArrayList<Integer> digitos = obtenerDigitos(n);

            // Ordenar los dígitos en orden ascendente
            Collections.sort(digitos);
            int numAscendente = obtenerNumero(digitos);

            // Ordenar los dígitos en orden descendente
            Collections.sort(digitos, Collections.reverseOrder());
            int numDescendente = obtenerNumero(digitos);

            // Calcular la resta
            int resta = numDescendente - numAscendente;

            // Mostrar la operación actual
            resultados.append("Iteración ").append(iteraciones).append(": ")
                    .append(numDescendente).append(" - ")
                    .append(numAscendente).append(" = ").append(resta).append("\n");

            // Actualizar n con el valor de la resta
            n = resta;
        }

        resultados.append("\nTotal de iteraciones: ").append(iteraciones);
        tvResultado.setText(resultados.toString());
        tvResultado.setVisibility(View.VISIBLE);
    }

    private ArrayList<Integer> obtenerDigitos(int n) {
        ArrayList<Integer> digitos = new ArrayList<>();
        while (n > 0) {
            digitos.add(n % 10);
            n /= 10;
        }
        return digitos;
    }

    private int obtenerNumero(ArrayList<Integer> digitos) {
        int numero = 0;
        for (int digito : digitos) {
            numero = numero * 10 + digito;
        }
        return numero;
    }
}