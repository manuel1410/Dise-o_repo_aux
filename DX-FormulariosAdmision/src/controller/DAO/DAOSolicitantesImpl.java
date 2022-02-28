/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO;

import java.util.ArrayList;
import java.util.List;
import model.Solicitante;


public class DAOSolicitantesImpl implements DAOTrasaccional {
    
    private static DAOSolicitantesImpl accesoSolicitantes;

    private List<Solicitante> tablaSolicitantes = new ArrayList<Solicitante>();

    private DAOSolicitantesImpl() {
    }
    
    public static DAOSolicitantesImpl getInstance(){
        if (accesoSolicitantes == null)
            accesoSolicitantes = new DAOSolicitantesImpl();
        return accesoSolicitantes;
    }
    
    @Override
    public boolean create(Object obj) {
        Solicitante unSolicitante = (Solicitante)obj;
        for (int i = 0; i < tablaSolicitantes.size(); i++) {
            Solicitante solicitanteActual = tablaSolicitantes.get(i);
            if (solicitanteActual.equals(unSolicitante))
                return false;   // no se puede registrar un solicitante con el mismo código
        }
        return tablaSolicitantes.add(unSolicitante);
    }

    @Override
    public boolean update(Object obj) {
        Solicitante unSolicitante = (Solicitante)obj;
        for (int i = 0; i < tablaSolicitantes.size(); i++) {
            Solicitante solicitanteActual = tablaSolicitantes.get(i);
            if (solicitanteActual.equals(unSolicitante)){
                tablaSolicitantes.set(i, unSolicitante);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        int codigoALocalizar = (int) key;
        for (int i = 0; i < tablaSolicitantes.size(); i++) {
            Solicitante solicitanteActual = tablaSolicitantes.get(i);
            if (solicitanteActual.getNumSolicitante() == codigoALocalizar)
                return solicitanteActual;
            
        }
        return null;  // no apareció el solicitante solicitado
    }

    @Override
    public List getAll() {
        return tablaSolicitantes;
    }
    
}
