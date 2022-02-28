/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO;

import java.util.ArrayList;
import java.util.List;
import model.Sede;

/**
 *
 * @author ersolano
 */
public class DAOSedesImpl implements DAOTrasaccional {
    
    private static DAOSedesImpl accesoSedes;

    private List<Sede> tablaSedes = new ArrayList<Sede>();

    private DAOSedesImpl() {
    }
    
    public static DAOSedesImpl getInstance(){
        if (accesoSedes == null)
            accesoSedes = new DAOSedesImpl();
        return accesoSedes;
    }
    
    @Override
    public boolean create(Object obj) {
        Sede unaSede = (Sede)obj;
        for (int i = 0; i < tablaSedes.size(); i++) {
            Sede sedeActual = tablaSedes.get(i);
            if (sedeActual.equals(unaSede))
                return false;   // no se puede registrar una sede con el mismo código
        }
        return tablaSedes.add(unaSede);
    }

    @Override
    public boolean update(Object obj) {
        Sede unaSede = (Sede)obj;
        for (int i = 0; i < tablaSedes.size(); i++) {
            Sede sedeActual = tablaSedes.get(i);
            if (sedeActual.equals(unaSede)){
                tablaSedes.set(i, unaSede);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        String codigoALocalizar = (String) key;
        for (int i = 0; i < tablaSedes.size(); i++) {
            Sede sedeActual = tablaSedes.get(i);
            if (sedeActual.getCodigo().equals(codigoALocalizar))
                return sedeActual;
        }
        return null;  // no apareció la sede solicitada
    }

    @Override
    public List getAll() {
        return tablaSedes;
    }
    
}
