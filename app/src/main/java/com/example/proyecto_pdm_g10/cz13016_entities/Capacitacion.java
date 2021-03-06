package com.example.proyecto_pdm_g10.cz13016_entities;

public class Capacitacion {
private Integer idCapacitacion;
private String descrip;

private float precio;

private String idLocal;

private String idAreaDip;
private String idAreaIn;
private String idCapacitador;
private Integer asistenciaTotal;

    public Integer getAsistenciaTotal() {
        return asistenciaTotal;
    }

    public void setAsistenciaTotal(Integer asistenciaTotal) {
        this.asistenciaTotal = asistenciaTotal;
    }

    public Capacitacion() {
    }

    public Capacitacion(Integer idCapacitacion, String idAreaDip) {
        this.idCapacitacion = idCapacitacion;
        this.idAreaDip = idAreaDip;
    }

    public Capacitacion(Integer idCapacitacion, String descrip, float precio, String idLocal, String idAreaDip, String idAreaIn, String idCapacitador) {
        this.idCapacitacion = idCapacitacion;
        this.descrip = descrip;
        this.precio = precio;
        this.idLocal = idLocal;
        this.idAreaDip = idAreaDip;
        this.idAreaIn = idAreaIn;
        this.idCapacitador = idCapacitador;
    }
    public Capacitacion(Integer idCapacitacion, String descrip, float precio, String idLocal, String idAreaDip, String idAreaIn, String idCapacitador, int asistenciaTotal) {
        this.idCapacitacion = idCapacitacion;
        this.descrip = descrip;
        this.precio = precio;
        this.idLocal = idLocal;
        this.idAreaDip = idAreaDip;
        this.idAreaIn = idAreaIn;
        this.idCapacitador = idCapacitador;
        this.asistenciaTotal=asistenciaTotal;
    }

    public Integer getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getIdAreaDip() {
        return idAreaDip;
    }

    public void setIdAreaDip(String idAreaDip) {
        this.idAreaDip = idAreaDip;
    }

    public String getIdAreaIn() {
        return idAreaIn;
    }

    public void setIdAreaIn(String idAreaIn) {
        this.idAreaIn = idAreaIn;
    }

    public String getIdCapacitador() {
        return idCapacitador;
    }

    public void setIdCapacitador(String idCapacitador) {
        this.idCapacitador = idCapacitador;
    }
}
