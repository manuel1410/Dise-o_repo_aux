/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author ersolano
 */
public class Carrera {
    private String codigo;
    private String nombre;
    private int puntajeAdmision;
    private int capacidadMax;
    private TGrado grado;
    private Sede laSede;

    public Carrera(String codigo, String nombre, int puntajeAdmision, int capacidadMax, TGrado grado, Sede laSede) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.puntajeAdmision = puntajeAdmision;
        this.capacidadMax = capacidadMax;
        this.grado = grado;
        this.laSede = laSede;
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

    public int getPuntajeAdmision() {
        return puntajeAdmision;
    }

    public void setPuntajeAdmision(int puntajeAdmision) {
        this.puntajeAdmision = puntajeAdmision;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public TGrado getGrado() {
        return grado;
    }

    public void setGrado(TGrado grado) {
        this.grado = grado;
    }

    public Sede getLaSede() {
        return laSede;
    }

    public void setLaSede(Sede laSede) {
        this.laSede = laSede;
    }

    @Override
    public String toString() {
        return "Carrera: " + "codigo=" + codigo + ", nombre=" + nombre + 
               ", puntajeAdmision=" + puntajeAdmision + 
               ", capacidadMax=" + capacidadMax + 
               ", grado=" + grado + 
               ", laSede=" + laSede + '\n';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carrera other = (Carrera) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.laSede.getCodigo(), other.laSede.getCodigo())) {
            return false;
        }
        return true;
    }
    
    
            
    
    
}
