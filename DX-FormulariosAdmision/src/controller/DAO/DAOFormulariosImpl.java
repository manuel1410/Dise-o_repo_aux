/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import model.Formulario;
import model.Carrera;
import model.Solicitante;
import model.TEstado;


public class DAOFormulariosImpl implements DAOTrasaccional{

    // instancia autorreferenciada para el uso de Singleton
    private static DAOFormulariosImpl accesoFormularios;

    // atributo de acceso controlado:
    private List<Formulario> tablaFormularios = new ArrayList<Formulario>();

    
    private DAOFormulariosImpl() {
    }        
    
    public static DAOFormulariosImpl getInstance(){
        if (accesoFormularios == null)
            accesoFormularios = new DAOFormulariosImpl();
        return accesoFormularios;
    }
    
    @Override
    public boolean create(Object obj) {
        Formulario unFormulario = (Formulario)obj;
        for (int i = 0; i < tablaFormularios.size(); i++) {
            Formulario formularioActual = tablaFormularios.get(i);
            if (formularioActual.equals(unFormulario))
                return false;   // no se puede registrar un formulario con el mismo código
        }
        return tablaFormularios.add(unFormulario);
    }

    @Override
    public boolean update(Object obj) {
        Formulario unFormulario = (Formulario)obj;
        for (int i = 0; i < tablaFormularios.size(); i++) {
            Formulario formularioActual = tablaFormularios.get(i);
            if (formularioActual.equals(unFormulario)){
                tablaFormularios.set(i, unFormulario);
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        int codigoALocalizar = (int) key;
        for (int i = 0; i < tablaFormularios.size(); i++) {
            Formulario formularioActual = tablaFormularios.get(i);
            if (formularioActual.getNum() == codigoALocalizar) {
                return formularioActual;
            }
        }
        return null;  // no apareció el formulario solicitado
    }
    public Object get(String numIdentificacion, int num) {
        for (int i = 0; i < tablaFormularios.size(); i++) {
            Formulario formularioActual = tablaFormularios.get(i);
            if ( formularioActual.getSolicitante().getNumIdentificacion().equals(numIdentificacion) && 
                 formularioActual.getNum() == num) {
                return formularioActual;
            }
        }
        return null;  // no apareció el formulario solicitado
    }

    @Override
    public List getAll() {
        return tablaFormularios;
    }

    public Formulario getAll(String numSolicitante) {
        Formulario solicitanteFormulario = new Formulario();

        for (int i = 0; i < tablaFormularios.size(); i++) {
            Formulario formularioActual = tablaFormularios.get(i);
            if (formularioActual.getSolicitante().getNumIdentificacion().equals(numSolicitante)) {
                solicitanteFormulario = formularioActual;
                break;
            }
        }
        return solicitanteFormulario;
    }
    
    public List getAll(String codigoCarrera, TEstado estado) {
        List formulariosCarreraEstado = new ArrayList<Formulario>();
        ArrayList<String> listaNombres = new ArrayList<String>();
        
            for (int i = 0; i < tablaFormularios.size(); i++) {
               Formulario formularioActual = tablaFormularios.get(i);

               
               if( formularioActual.getCarreraSolicitada().getCodigo().equals(codigoCarrera) && 
                   formularioActual.getEstado().equals(estado)) {

                   formulariosCarreraEstado.add(formularioActual);
                   listaNombres.add(formularioActual.getSolicitante().getNombre());
               }
            }
            
        return formulariosCarreraEstado;
    }
}
