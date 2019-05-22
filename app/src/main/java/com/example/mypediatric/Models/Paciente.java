package com.example.mypediatric.Models;

public class Paciente {

    private String Uid;
    private String TipoDeDocumento;
    private String NumeroDeDocumento;
    private String Nombres;
    private String Apellidos;
    private String FechaDeNacimiento;
    private String Genero;
    private String Direccion;
    private String CorreoElectronico;
    private String Contraseña;

    public Paciente() {
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getTipoDeDocumento() {
        return TipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        TipoDeDocumento = tipoDeDocumento;
    }

    public String getNumeroDeDocumento() {
        return NumeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        NumeroDeDocumento = numeroDeDocumento;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        FechaDeNacimiento = fechaDeNacimiento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    @Override
    public String toString() {
        return Nombres;
    }
}