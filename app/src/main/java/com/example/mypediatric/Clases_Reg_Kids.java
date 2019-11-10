package com.example.mypediatric;

import android.os.Bundle;
import android.widget.Spinner;

public class Clases_Reg_Kids {

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
