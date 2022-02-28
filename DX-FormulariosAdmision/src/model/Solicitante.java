/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 *
 * @author Andres
 */
public class Solicitante {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String numIdentificacion;
    private LocalDate fechaNacimiento;
    private int edad;
    private String correo;
    private int numTelefono;
    private String direccion;
    private String secundaria;
    private int numSolicitante;
    private boolean conAdecuacion;

    public Solicitante() {
    }

    public Solicitante(String nombre, String apellido1, String apellido2, String numIdentificacion, LocalDate fechaNacimiento, String correo, int numTelefono, String direccion, String secundaria, int numSolicitante, boolean conAdecuacion) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.numIdentificacion = numIdentificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.numTelefono = numTelefono;
        this.direccion = direccion;
        this.secundaria = secundaria;
        this.numSolicitante = numSolicitante;
        this.conAdecuacion = conAdecuacion;
    }
    
    
    /**
     * calcularEdad
     * 
     * Usando la fecha de nacimiento del solicitante y la fecha actual
     * realiza el calculo de la edad cumplida
     * 
     * @return int
     */
    public void calcularEdad(){ //CAMBIO A VOID Y A LOCALDATE
        
        LocalDate nacimiento = this.fechaNacimiento;
        LocalDate ahora = LocalDate.now();
        
        this.edad = Period.between(nacimiento, ahora).getYears();
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSecundaria() {
        return secundaria;
    }

    public void setSecundaria(String secundaria) {
        this.secundaria = secundaria;
    }

    public int getNumSolicitante() {
        return numSolicitante;
    }

    public void setNumSolicitante(int numSolicitante) {
        this.numSolicitante = numSolicitante;
    }

    public boolean isConAdecuacion() {
        return conAdecuacion;
    }

    public void setConAdecuacion(boolean conAdecuacion) {
        this.conAdecuacion = conAdecuacion;
    }

    @Override
    public String toString() {
        return "Solicitante{" + "nombre=" + nombre + ", apellido1=" + apellido1
                + ", apellido2=" + apellido2 + ", numIdentificacion=" + numIdentificacion
                + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad
                + ", correo=" + correo + ", numTelefono=" + numTelefono
                + ", direccion=" + direccion + ", secundaria=" + secundaria
                + ", numSolicitante=" + numSolicitante + ", conAdecuacion=" + conAdecuacion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.numIdentificacion);
        hash = 23 * hash + this.numSolicitante;
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
        final Solicitante other = (Solicitante) obj;
        if (this.numSolicitante != other.numSolicitante) {
            return false;
        }
        if (!Objects.equals(this.numIdentificacion, other.numIdentificacion)) {
            return false;
        }
        return true;
    }
    
    
    
}
