package com.example.damn_intentos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        // Inicializar el TextView para mostrar los resultados
        txtResultado = findViewById(R.id.txt_resultado);

        // Obtener los valores pasados desde la primera actividad
        double a = getIntent().getDoubleExtra("a", 0);
        double b = getIntent().getDoubleExtra("b", 0);
        double c = getIntent().getDoubleExtra("c", 0);

        // Calcular las raíces de la ecuación de segundo grado
        double discriminante = b * b - 4 * a * c;
        String resultado;

        if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            resultado = "Raíces reales: \nRaíz 1: " + raiz1 + "\nRaíz 2: " + raiz2;
        } else if (discriminante == 0) {
            double raiz = -b / (2 * a);
            resultado = "Raíz única: " + raiz;
        } else {
            resultado = "La ecuación no tiene raíces reales.";
        }

        // Mostrar el resultado en el TextView
        txtResultado.setText(resultado);
    }
}