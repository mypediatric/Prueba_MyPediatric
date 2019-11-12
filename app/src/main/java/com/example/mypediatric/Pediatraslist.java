package com.example.mypediatric;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Pediatraslist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pediatraslist);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public static class Clases_Reg_Kids {

        public static Object child;
        String nombres;
        String apellidos;
        String peso;
        String estatura;
        String genero;
        String RH;
        String edad;

        public Clases_Reg_Kids(String nombres, String apellidos, String peso, String estatura, String genero, String RH, String edad) {
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.peso = peso;
            this.estatura = estatura;
            this.genero = genero;
            this.RH = RH;
            this.edad = edad;
        }

        public String getNombres() {
            return nombres;
        }

        public String getApellidos() {
            return apellidos;
        }

        public String getPeso() {
            return peso;
        }

        public String getEstatura() {
            return estatura;
        }

        public String getGenero() {
            return genero;
        }

        public String getRH() {
            return RH;
        }

        public String getEdad() {
            return edad;
        }
    }
}
