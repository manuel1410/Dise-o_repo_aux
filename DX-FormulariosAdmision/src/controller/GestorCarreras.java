/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.DAO.DAOCarrerasImpl;
import controller.DAO.DAOSedesImpl;
import java.util.List;
import model.Carrera;
import model.Sede;
import model.TGrado;

/**
 *
 * @author ersolano
 */
public class GestorCarreras {
    

    public GestorCarreras() {
        cargarSedes();
        
        //simula la existencia de N carreras previamente creadas.
        String carreras [][] = {{"IC","Ing.Computacion","560","140","BACHILLERATO","CA"},
                            {"AE","Admnistracion Empresas","500","80","LICENCIATURA","SJ"},
                            {"FI","Ing.Física","750","40","BACHILLERATO","CA"}};
        
        for (int i = 0; i < carreras.length; i++) {
            //localiza en la "tabla" de sedes la sede asociada a la carrera en registro
            Sede laSede = (Sede) DAOSedesImpl.getInstance().get(carreras[i][5]);            
            Carrera unaCarrera = new Carrera(carreras[i][0], carreras[i][1], 
                                        Integer.parseInt(carreras[i][2]), 
                                        Integer.parseInt(carreras[i][3]),
                                        TGrado.valueOf(carreras[i][4]), laSede);
            //registra una carrera en la "tabla" de carreras
            DAOCarrerasImpl.getInstance().create(unaCarrera);
        }
    }
 
    private void cargarSedes(){
        //método que simula la existencia de un juego de sedes de la institución
        DAOSedesImpl.getInstance().create(new Sede("CA", "Cartago"));
        DAOSedesImpl.getInstance().create(new Sede("SJ", "San José"));
        DAOSedesImpl.getInstance().create(new Sede("AL", "Alajuela"));
        DAOSedesImpl.getInstance().create(new Sede("LI", "Limón"));
        DAOSedesImpl.getInstance().create(new Sede("SC", "San Carlos"));
    }
    
    
    public boolean agregarCarrera(Carrera unaCarrera) {
        return DAOCarrerasImpl.getInstance().create(unaCarrera);
    }
    
    public List buscarCarreras(){
        DTOCarrera unDTO = new DTOCarrera();
        return DAOCarrerasImpl.getInstance().getAll();
    }
    public List buscarCarreras(String codigoSede){
        return DAOCarrerasImpl.getInstance().getAll(codigoSede);
    }          
    
    public Carrera buscarCarrera(String codSede, String codCarrera){
        return (Carrera) DAOCarrerasImpl.getInstance().get(codSede, codCarrera);
    }

    public Sede buscarSede(String codSede){
        return (Sede) DAOSedesImpl.getInstance().get(codSede);
    }

    public boolean modificarCarrera(Carrera laCarrera){
        return DAOCarrerasImpl.getInstance().update(laCarrera);
    }
}
