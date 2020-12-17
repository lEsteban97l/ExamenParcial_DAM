package com.dam.parcial_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainInscripcion extends AppCompatActivity {

    Button buttonRVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inscripcion);

        buttonRVolver = findViewById(R.id.buttonR);
        buttonRVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainInscripcion.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}