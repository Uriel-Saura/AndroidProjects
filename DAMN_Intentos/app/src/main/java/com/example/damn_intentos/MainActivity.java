package com.example.damn_intentos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText inputA, inputB, inputC;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar los elementos de la interfaz
        inputA = findViewById(R.id.input_a);
        inputB = findViewById(R.id.input_b);
        inputC = findViewById(R.id.input_c);
        btnCalcular = findViewById(R.id.btn_calcular);

        // Establecer el evento de clic para el botón
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados
                double a = Double.parseDouble(inputA.getText().toString());
                double b = Double.parseDouble(inputB.getText().toString());
                double c = Double.parseDouble(inputC.getText().toString());

                // Crear un Intent para iniciar la segunda actividad
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);

                // Pasar los valores de a, b y c a la siguiente actividad
                intent.putExtra("a", a);
                intent.putExtra("b", b);
                intent.putExtra("c", c);

                // Iniciar la actividad ResultadoActivity
                startActivity(intent);
            }
        });
    }
}