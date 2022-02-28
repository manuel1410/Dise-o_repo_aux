/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Formulario;

/**
 *
 * @author jarod
 */
public class DTOFormulario {
    private String codigo;
    private int num;
    private String estado;
    private String codigoCarrera;
    private int puntajeObtenido;
    private int solicitante;
    private List<Formulario> losFormularios;
    
    public DTOFormulario() {

    }

    public DTOFormulario(String codigo, int num, String estado, String codigoCarrera, int puntajeObtenido, int solicitante, ArrayList<Formulario> losFormularios) {
        this.codigo = codigo;
        this.num = num;
        this.estado = estado;
        this.codigoCarrera = codigoCarrera;
        this.puntajeObtenido = puntajeObtenido;
        this.solicitante = solicitante;
        this.losFormularios = losFormularios;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNum() {
        return num;
    }

    public String getEstado() {
        return estado;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public int getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public int getSolicitante() {
        return solicitante;
    }

    public List<Formulario> getLosFormularios() {
        return losFormularios;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public void setPuntajeObtenido(int puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public void setSolicitante(int solicitante) {
        this.solicitante = solicitante;
    }

    public void setLosFormularios(List<Formulario> losFormularios) {
        this.losFormularios = losFormularios;
    }

    @Override
    public String toString() {
        return "DTOFormulario{" + "codigo=" + codigo + ", num=" + num + ", estado=" + estado + ", codigoCarrera=" + codigoCarrera + ", puntajeObtenido=" + puntajeObtenido + ", solicitante=" + solicitante + ", losFormularios=" + losFormularios + '}';
    }
    
    
    
    
}
