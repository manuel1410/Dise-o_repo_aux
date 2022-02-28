/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 *
 * @author Andres
 */
public class Formulario {
    private int num;
    private TEstado estado;
    private Carrera carreraSolicitada;
    private int puntajeObtenido = 0;
    private Solicitante solicitante;

    public Formulario() {
    }

    public Formulario(int num, TEstado estado, Carrera carreraSolicitada, Solicitante solicitante) {
        this.num = num;
        this.estado = estado;
        this.carreraSolicitada = carreraSolicitada;
        this.solicitante = solicitante;
    }
    
    public Formulario(int num, TEstado estado, Carrera carreraSolicitada, Solicitante solicitante, int puntajeObtenido) {
        this.num = num;
        this.estado = estado;
        this.carreraSolicitada = carreraSolicitada;
        this.solicitante = solicitante;
        this.puntajeObtenido = puntajeObtenido;
    }
    
    
    /**
     * verificarCompletitud
     * Formulario completo en todos los campos
     * 
     * @return Boolean
     */
    public Boolean verificarCompletitud(){
        /*
        if (this.num==null){
            return false;
        }
        */
        if (this.estado==null){
            return false;
        }
        if (this.carreraSolicitada==null){
            return false;
        }
        if (this.solicitante==null){
            return false;
        }
        return true;
    }
    
    /**
     * detallarSolicitud
     * presenta los datos mas importantes en texto
     * @return 
     */
    public String detallarSolicitud(){
        return "Número formulario: " + num + ", estado: " + estado +
                ", carreraSolicitada: " + carreraSolicitada.getNombre() + ", puntajeObtenido: " + puntajeObtenido + 
                ", solicitante: " + solicitante.getNombre() + " " + solicitante.getApellido1() + " " + solicitante.getApellido2() +
                " con identificación: "+solicitante.getNumIdentificacion();
    }
    
        /**
     * calcularEstadoSolicitud
     * Utilizando la informacion de la carrera y nota del estudiante
     * define si esta ADMITIDO; RECHAZADO; EN_ESPERA
     * 
     * Recibe como parametro el cupoDisponible en la carrera en concurso
     * 
     * @param pCupoDisponible
     * 
     * @return 
     */
    public TEstado actualizarEstadoSolicitud(int pCupoDisponible){
        int ptsAdm = this.getCarreraSolicitada().getPuntajeAdmision();
        
        if (this.getPuntajeObtenido() < ptsAdm){
            this.setEstado(TEstado.RECHAZADO);
            return TEstado.RECHAZADO;
        }else{
            if (pCupoDisponible<1){
                this.setEstado(TEstado.EN_ESPERA);
                return TEstado.EN_ESPERA;
            }else{
                this.setEstado(TEstado.ACEPTADO);
                return TEstado.ACEPTADO;
            }    
        }
    }
    

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public TEstado getEstado() {
        return estado;
    }

    public void setEstado(TEstado estado) {
        this.estado = estado;
    }

    public Carrera getCarreraSolicitada() {
        return carreraSolicitada;
    }

    public void setCarreraSolicitada(Carrera carreraSolicitada) {
        this.carreraSolicitada = carreraSolicitada;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    @Override
    public String toString() {
        return "Formulario{" + "num=" + num + ", estado=" + estado + ", carreraSolicitada=" + carreraSolicitada + ", puntajeObtenido=" + puntajeObtenido + ", solicitante=" + solicitante + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.carreraSolicitada);
        hash = 71 * hash + Objects.hashCode(this.solicitante);
        return hash;
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
        final Formulario other = (Formulario) obj;
        if (!Objects.equals(this.carreraSolicitada, other.carreraSolicitada)) {
            return false;
        }
        if (!Objects.equals(this.solicitante, other.solicitante)) {
            return false;
        }
        return true;
    }
    
    
    
}
