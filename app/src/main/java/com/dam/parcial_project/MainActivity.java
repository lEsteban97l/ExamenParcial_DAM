package com.dam.parcial_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnIncripcion, btnTaller, btnReglamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIncripcion = findViewById(R.id.buttonInscripcion);
        btnTaller = findViewById(R.id.buttonTaller);
        btnReglamento = findViewById(R.id.buttonReglamento);

        btnIncripcion.setOnClickListener(this);
        btnTaller.setOnClickListener(this);
        btnReglamento.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //IR A OTRA ACTIVIDAD POR MEDIO DE UN BOTON
        if (v.getId() == R.id.buttonInscripcion) {
            Intent i = new Intent(MainActivity.this, MainInscripcion.class);
            startActivity(i);
        }

        if (v.getId() == R.id.buttonTaller) {
            Intent i = new Intent(MainActivity.this, MainTaller.class);
            startActivity(i);
        }

        if (v.getId() == R.id.buttonReglamento) {
            Intent i = new Intent(MainActivity.this, MainReglamento.class);
            startActivity(i);
        }
    }
}