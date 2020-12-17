package com.dam.parcial_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainTaller extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    String talleres[] = {"Desarrollo de Aplicaciones Móviles", "Análisis y Diseño de Sistemas", "Sistemas de Información", "Sistemas Operativos", "Arquitectura de Computadoras", "Simulación de Sistemas", "Big Data"};
    String ponentes[] = {"Flor Cerdán Leon", "Ignacio Tacza Valverde", "Julio Quispe Tuesta", "Moises Cotacallapa Vilca", "Jose Diaz Pulido", "Joe Gonzalez Vasquez", "Gelber Uscuchagua Flores"};
    int images[] = {R.drawable.dam, R.drawable.ads, R.drawable.si, R.drawable.so, R.drawable.ac, R.drawable.ss, R.drawable.bd};

    ImageButton btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_taller);

        listView = findViewById(R.id.listviewpersonas);

        btnVolver = findViewById(R.id.btnvolver);
        btnVolver.setOnClickListener(this);

        MyAdapter adapter = new MyAdapter(this, talleres, ponentes, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainTaller.this, "Taller: "+talleres[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTalleres[];
        String rPonentes[];
        int rImagenes[];

        MyAdapter (Context c, String taller[], String ponente[], int imagen[]) {
            super(c, R.layout.fila, R.id.txttitulo, taller);
            this.context = c;
            this.rTalleres = taller;
            this.rPonentes = ponente;
            this.rImagenes = imagen;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View taller = layoutInflater.inflate(R.layout.fila, parent, false);
            ImageView imgFotoTaller = taller.findViewById(R.id.fototaller);
            TextView txtTitulo = taller.findViewById(R.id.txttitulo);
            TextView txtPonente = taller.findViewById(R.id.txtdescripcion);

            imgFotoTaller.setImageResource(rImagenes[position]);
            txtTitulo.setText(rTalleres[position]);
            txtPonente.setText("Ponente: "+rPonentes[position]);

            return taller;
        }
    }

    public void onClick(View v) {

        if (v.getId() == R.id.btnvolver) {

            Intent i = new Intent(MainTaller.this, MainActivity.class);
            startActivity(i);

        }

    }
}