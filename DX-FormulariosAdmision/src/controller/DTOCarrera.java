/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Carrera;

/**
 *
 * @author ersolano
 */
public class DTOCarrera {
    private String codigo, nombre;
    private int puntajeMaximo, maximoAdmitidos;
    private String grado;
    private String codigoSede;
    private List<Carrera> lasCarreras;

    public DTOCarrera() {
    }
    
    public DTOCarrera(String codigo, String nombre, int puntajeMaximo, int maximoAdmitidos, String grado, String codigoSede) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntajeMaximo = puntajeMaximo;
        this.maximoAdmitidos = maximoAdmitidos;
        this.grado = grado;
        this.codigoSede = codigoSede;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    public void setPuntajeMaximo(int puntajeMaximo) {
        this.puntajeMaximo = puntajeMaximo;
    }

    public int getMaximoAdmitidos() {
        return maximoAdmitidos;
    }

    public void setMaximoAdmitidos(int maximoAdmitidos) {
        this.maximoAdmitidos = maximoAdmitidos;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public List<Carrera> getLasCarreras() {
        return lasCarreras;
    }

    public void setLasCarreras(List<Carrera> lasCarreras) {
        this.lasCarreras = lasCarreras;
    }
    
    
    
}
