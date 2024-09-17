package com.example.damn_botones;

import android.os.Bundle;
import android.app.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener{

    String s, numero;
    Button jbtn1, jbtn2, jbtn3;
    TextView jview;
    EditText jtext;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.numeros);
        jtext = findViewById(R.id.edit_text);
        jbtn1 = findViewById(R.id.button1);
        jbtn2 = findViewById(R.id.button2);
        jbtn3 = findViewById(R.id.button3);
        jview = findViewById(R.id.text_view);

        jbtn1.setOnClickListener(this);
        jbtn2.setOnClickListener(this);
        jbtn3.setOnClickListener(this);
    }

    public void onClick(View v){

        if (v == jbtn1){
            numero = jtext.getText().toString();
            primo(numero);
        }
        if (v == jbtn2){
            numero = jtext.getText().toString();
            fibonacci(numero);
        }
        if (v == jbtn3){
            numero = jtext.getText().toString();
            maravilloso(numero);
        }

    }

    public void primo(String numero){
        int calculo = 0;
        calculo  = Integer.parseInt(numero);
        for (int i = 2; i <= Math.sqrt(calculo); i++) {
            if (calculo % i == 0) {
               jview.setText("El numero " + calculo + " no es primo");
            }
        }

        jview.setText("El numero " + calculo + " es primo");
    }

    private void fibonacci(String numero){
        int calculo = 0;
        calculo  = Integer.parseInt(numero);

        if (calculo <= 1) {
            jview.setText(String.valueOf(calculo));
        }

        int a = 0, b = 1, c;
        for (int i = 2; i <= calculo; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        jview.setText(String.valueOf(b));
    }

    private void maravilloso(String numero){
        s = "";
        int calculo = 0;
        calculo  = Integer.parseInt(numero);
        while (calculo != 1) {
            if (calculo % 2 == 0) {
                calculo /= 2;  // Si es par, dividir entre 2
                s = s + String.valueOf(calculo) + "\n";
            } else {
                calculo = calculo * 3 + 1;  // Si es impar, multiplicar por 3 y sumar 1
                s = s + String.valueOf(calculo) + "\n";
            }
        }

        jview.setText("Si es numero maravillso" + "\n" + s);
    }
}