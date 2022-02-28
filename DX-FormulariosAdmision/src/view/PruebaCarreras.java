package view;

import controller.Control;
import controller.DAO.DAOCarrerasImpl;
import controller.DAO.DAOSedesImpl;
import controller.DTOCarrera;
import model.Sede;
import model.TGrado;
import view.PruebaFormularios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ersolano
 */
public class PruebaCarreras {
 
    static DTOCarrera elDTO;
    
    public static void mostrarCarreras(){
        
        
    }
    
    public static void main(String[] args) {
        // se activa el DTO que provee el control
        elDTO = Control.getInstance().getDto();
        //se muestran las carreras previamente cargadas
        Control.getInstance().mostrarCarreras();
        System.out.println("Todas las carreras\n" + elDTO.getLasCarreras());
        
        //mostrar las carreras específicas de una sede particular: CARTAGO
        Control.getInstance().mostrarCarreras("CA");
        System.out.println("Las carreras de CA\n" + elDTO.getLasCarreras());
        
        //incorporando una nueva carrera al sistema
        System.out.println("Ingresando una nueva carrera");
        elDTO.setCodigo("AU");
        elDTO.setNombre("Arquitectura y Urbanismo");
        elDTO.setGrado("LICENCIATURA");
        elDTO.setMaximoAdmitidos(40);
        elDTO.setPuntajeMaximo(600);
        elDTO.setCodigoSede("SJ");        
        Control.getInstance().crearCarrera(elDTO);
        
        //mostrar las carreras específicas de una sede particular: SAN JOSE
        Control.getInstance().mostrarCarreras("SJ");
        System.out.println("Las carreras de SJ\n" + elDTO.getLasCarreras());
        
        Control.getInstance().consultarCarrera("SJ", "AU");
        System.out.println("La carrera consultada es "+ 
                                    elDTO.getCodigo()+ "-"+
                                    elDTO.getNombre());
        
        elDTO.setCodigoSede("CA");
        elDTO.setCodigo("IC");
        elDTO.setMaximoAdmitidos(200);
        elDTO.setPuntajeMaximo(680);
        Control.getInstance().editarCarrera(elDTO);
        Control.getInstance().editarCarrera(elDTO);
        
        
        Control.getInstance().mostrarCarreras("CA");
        System.out.println("Luego de modificar " + elDTO.getLasCarreras());
       
        
        
        //se muestran las carreras previamente cargadas
        Control.getInstance().mostrarCarreras();
        System.out.println("Todas las carreras\n" + elDTO.getLasCarreras());
    }
}
