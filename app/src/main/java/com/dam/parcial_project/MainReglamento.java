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
    String talleres[] = {"1. Tener la camara prendida ", "2. Registre su formulario de asistencia", "3. Activar el micro solo cuando el ponento lo diga", "4. Las preguntas se hacen al final de las expocisiones de cada ponente", "5. El inicio de la conferencia es a las 6:00 pm", "6. Asistir todas las ponencias","7. Ser estudiante de la UNTELS."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_reglamento);
        btnVolver = findViewById(R.id.buton_volver);
        btnVolver.setOnClickListener(this);
    }
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTalleres[];
        String rPonentes[];


        MyAdapter (Context c, String taller[], String ponente[]) {
            super(c, R.layout.fila2, R.id.txttitulo, taller);
            this.context = c;
            this.rTalleres = taller;
            this.rPonentes = ponente;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View taller = layoutInflater.inflate(R.layout.fila2, parent, false);

            TextView txtTitulo = taller.findViewById(R.id.txttitulo);
            TextView txtPonente = taller.findViewById(R.id.txtdescripcion);


            txtTitulo.setText(rTalleres[position]);
            txtPonente.setText("Ponente: "+rPonentes[position]);

            return taller;
        }
    }





    public void onClick(View v) {

        if (v.getId() == R.id.buton_volver) {

            Intent i = new Intent(MainReglamento.this, MainActivity.class);
            startActivity(i);

        }

    }
}