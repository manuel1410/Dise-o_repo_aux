/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Control;
import controller.DAO.DAOFormulariosImpl;
import controller.DTOCarrera;
import controller.DTOFormulario;
import java.util.ArrayList;
import model.Formulario;
import model.TEstado;
import static view.PruebaCarreras.elDTO;


/**
 *
 * @author XPC
 */
public class PruebaFormularios {
    
    static DTOFormulario elDTO;
    static DTOCarrera elDTOC;
    
    public static void mostrarFormularios(){
        
        
    }
    
    public static void main(String[] args) {
        
      elDTO = Control.getInstance().getDtoF();
        
      Control.getInstance().mostrarSolicitudes();
      System.out.println("Solicitud\n" + elDTO.getLosFormularios());
      
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("================================================");
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");
      
      
      System.out.println("Formluarios: \n" + Control.getInstance().getGestorFormulario().getSolicitudEstadoNombre("IC", TEstado.ACEPTADO));
      
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("================================================");
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");
      
      
      System.out.println("Formluarios: \n" + Control.getInstance().getGestorFormulario().getSolicitudEstadoPuntaje("IC", TEstado.ACEPTADO));
       
      
      
     // ----- Prueba Aplicacion Examen y Actualizacion Estados ----------
     
        System.out.println("---------  EXAMEN ------------");
        
        System.out.println(Control.getInstance().simularAplicacionExamen());
        
        System.out.println("........");
        
        System.out.println(Control.getInstance().procesarResultados());
        System.out.println();

        ArrayList<Formulario> todosFormularios;
        todosFormularios = (ArrayList) DAOFormulariosImpl.getInstance().getAll();
        
        
        elDTOC = Control.getInstance().getDto();
        
        Control.getInstance().mostrarCarreras();
        System.out.println("Todas las carreras\n" + elDTOC.getLasCarreras());
        
        for (int i = 0; i < todosFormularios.size(); i++) {
            
            System.out.println(todosFormularios.get(i).detallarSolicitud());
        }
      
    }
}
