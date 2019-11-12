package com.example.mypediatric.Models;

public class Kids {
    private String Uid;
    private String NombresK;
    private String ApellidosK;
    private String GenK;
    private String EdadK;
    private String RHK;
    private String PesoK;
    private String EstaturaK;

    public Kids() {
    }

    public String getUid() {
        return Uid;
    }
    public void setUid(String uid) {
        Uid = uid;
    }

    public String getNombresK() {
        return NombresK;
    }
    public void setNombresK(String Nombres) {
        NombresK = Nombres;
    }

    public String getApellidosK() {
        return ApellidosK;
    }
    public void setApellidosK(String Apellidos) {ApellidosK = Apellidos;    }

    public String getGenK() {
        return GenK ;
    }
    public void setGenK(String Genero) {
        GenK = Genero;
    }

    public String getEdadK() {
        return EdadK;
    }
    public void setEdadK(String Edad) {EdadK = Edad; }

    public String getRHK() {
        return RHK;
    }
    public void setRHK(String RH) {RHK = RH; }

    public String getPesoK() { return PesoK; }
    public void setPesoK(String Peso) { PesoK = Peso; }

    public String getEstaturaK() {
        return EstaturaK;
    }
    public void setEstaturaK(String Estatura) { EstaturaK = Estatura; }

    @Override
    public String toString() {
        return NombresK;
    }
}

