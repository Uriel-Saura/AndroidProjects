package com.example.damn_listas_2;
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

public class MainActivity extends Activity {
    private ListView lv;

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.listado);

        ArrayList<ListaEntrada> al = new ArrayList<ListaEntrada>();

        al.add(new ListaEntrada(R.drawable.sol,
                "SOL", "El Sol es la estrella en el centro del Sistema Solar. Es una esfera casi perfecta de plasma ardiente, y es la fuente principal de energía para la Tierra."));
        al.add(new ListaEntrada(R.drawable.mercurio,
                "MERCURIO", "Mercurio es el planeta más cercano al Sol y el más pequeño del Sistema Solar. Tiene un núcleo de hierro muy denso y prácticamente no tiene atmósfera."));
        al.add(new ListaEntrada(R.drawable.venus,
                "VENUS", "Venus es el segundo planeta del Sistema Solar y el más similar a la Tierra en tamaño, pero con una atmósfera densa y extremadamente caliente."));
        al.add(new ListaEntrada(R.drawable.tierra,
                "TIERRA", "La Tierra es el tercer planeta desde el Sol y el único conocido por albergar vida. Tiene una atmósfera rica en oxígeno y una superficie cubierta en su mayoría de agua."));
        al.add(new ListaEntrada(R.drawable.luna,
                "LUNA", "La Luna es el único satélite natural de la Tierra. Es el quinto satélite más grande del Sistema Solar y tiene una gran influencia en las mareas y en la estabilidad del eje de rotación de la Tierra."));
        al.add(new ListaEntrada(R.drawable.marte,
                "MARTE", "Marte, también conocido como el planeta rojo, es el cuarto del Sistema Solar. Tiene montañas, valles y desiertos, con signos de agua en su superficie."));
        al.add(new ListaEntrada(R.drawable.jupiter,
                "JÚPITER", "Júpiter es el planeta más grande del Sistema Solar y el quinto desde el Sol. Es un gigante gaseoso compuesto principalmente de hidrógeno y helio."));
        al.add(new ListaEntrada(R.drawable.saturno,
                "SATURNO", "Saturno es el sexto planeta desde el Sol y es conocido por su sistema de anillos impresionantes, compuestos principalmente de hielo y roca."));
        al.add(new ListaEntrada(R.drawable.urano,
                "URANO", "Urano es el séptimo planeta desde el Sol. Tiene una inclinación axial única que lo hace rotar de lado y su atmósfera está compuesta principalmente de hidrógeno, helio y metano."));
        al.add(new ListaEntrada(R.drawable.neptuno,
                "NEPTUNO", "Neptuno es el octavo y último planeta del Sistema Solar. Es un gigante helado con vientos extremadamente fuertes y una atmósfera azul debido al metano."));

        lv = (ListView) findViewById(R.id.ListView_listado);
        lv.setAdapter(new ListaAdapter(this, R.layout.activity_main, al) {
            public void onEntrada(Object o, View v) {
                if (o != null) {
                    TextView texto_superior_entrada = (TextView) v.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((ListaEntrada) o).get_textoEncima());

                    TextView texto_inferior_entrada = (TextView) v.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((ListaEntrada) o).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) v.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((ListaEntrada) o).get_idImagen());
                }
            }
        });

        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View view, int i, long l) {
                ListaEntrada le = (ListaEntrada) av.getItemAtPosition(i);
                CharSequence cs = "Seleccionado: " + le.get_textoDebajo();
                Toast t = Toast.makeText(MainActivity.this, cs, Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }
}
