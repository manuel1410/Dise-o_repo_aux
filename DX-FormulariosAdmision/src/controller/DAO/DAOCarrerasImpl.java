/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO;

import java.util.ArrayList;
import java.util.List;
import model.Carrera;
import model.Sede;
import model.TGrado;

/**
 *
 * @author ersolano
 */
public class DAOCarrerasImpl implements DAOTrasaccional{

    // instancia autorreferenciada para el uso de Singleton
    private static DAOCarrerasImpl accesoCarreras;

    // atributo de acceso controlado:
    private List<Carrera> tablaCarreras = new ArrayList<Carrera>();

    
    private DAOCarrerasImpl() {
    }        
    
    public static DAOCarrerasImpl getInstance(){
        if (accesoCarreras == null)
            accesoCarreras = new DAOCarrerasImpl();
        return accesoCarreras;
    }
    
    @Override
    public boolean create(Object obj) {
        Carrera unaCarrera = (Carrera)obj;
        for (int i = 0; i < tablaCarreras.size(); i++) {
            Carrera carreraActual = tablaCarreras.get(i);
            if (carreraActual.equals(unaCarrera))
                return false;   // no se puede registrar una carrera con el mismo código
        }
        return tablaCarreras.add(unaCarrera);
    }

    @Override
    public boolean update(Object obj) {
        Carrera unaCarrera = (Carrera)obj;
        for (int i = 0; i < tablaCarreras.size(); i++) {
            Carrera carreraActual = tablaCarreras.get(i);
            if (carreraActual.equals(unaCarrera)){
                tablaCarreras.set(i, unaCarrera);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        String codigoALocalizar = (String) key;
        for (int i = 0; i < tablaCarreras.size(); i++) {
            Carrera carreraActual = tablaCarreras.get(i);
            if (carreraActual.getCodigo().equals(codigoALocalizar)) {
                return carreraActual;
            }
        }
        return null;  // no apareció la sede solicitada
    }
    public Object get(String codSede, String codCarrera) {
        for (int i = 0; i < tablaCarreras.size(); i++) {
            Carrera carreraActual = tablaCarreras.get(i);
            if ( carreraActual.getLaSede().getCodigo().equals(codSede) && 
                 carreraActual.getCodigo().equals(codCarrera)) {
                return carreraActual;
            }
        }
        return null;  // no apareció la sede solicitada
    }

    @Override
    public List getAll() {
        return tablaCarreras;
    }

    public List getAll(String codigoSede) {
        List carrerasSede = new ArrayList<Carrera>();

        for (int i = 0; i < tablaCarreras.size(); i++) {
            Carrera carreraActual = tablaCarreras.get(i);
            if (carreraActual.getLaSede().getCodigo().equals(codigoSede)) {
                carrerasSede.add(carreraActual);
            }
        }
        return carrerasSede;
    }
}
