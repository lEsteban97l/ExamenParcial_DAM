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


public class MainReglamento extends AppCompatActivity implements View.OnClickListener{
    ImageButton btnVolver;
    String titulo[] = {"Reglamento 1", "Reglamento 2","Reglamento 3","Reglamento 4","Reglamento 5", "Reglamento 6","Reglamento 7"};
    ListView listView;
    String reglas[] = {"Tener la camara prendida ", "Registre su formulario de asistencia", "Activar el micro solo cuando el ponento lo diga", "Las preguntas se hacen al final de las expocisiones de cada ponente", "El inicio de la conferencia es a las 6:00 pm", "Asistir todas las ponencias","Ser estudiante de la UNTELS."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reglamento);

        listView = findViewById(R.id.listReglamento);

        MainReglamento.MyAdapter adapter = new MainReglamento.MyAdapter(this, titulo, reglas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainReglamento.this, "Reglamento número "+position, Toast.LENGTH_SHORT).show();
            }
        });
        btnVolver = findViewById(R.id.buton_volver);
        btnVolver.setOnClickListener(this);
    }
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rnreglamento[];
        String rreglamento[];


        MyAdapter (Context c, String numreglamento[], String reglamento[]) {
            super(c, R.layout.fila2, R.id.txttitulo, numreglamento);
            this.context = c;
            this.rnreglamento = numreglamento;
            this.rreglamento = reglamento;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View reglamento = layoutInflater.inflate(R.layout.fila2, parent, false);

            TextView txtTitulo = reglamento.findViewById(R.id.txttitulo);
            TextView txtDescripcion = reglamento.findViewById(R.id.txtdescripcion);


            txtTitulo.setText(rnreglamento[position]);
            txtDescripcion.setText(rreglamento[position]);

            return reglamento;
        }
    }





    public void onClick(View v) {

        if (v.getId() == R.id.buton_volver) {

            Intent i = new Intent(MainReglamento.this, MainActivity.class);
            startActivity(i);

        }

    }
}