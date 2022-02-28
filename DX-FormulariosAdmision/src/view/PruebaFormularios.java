/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Control;
import controller.DTOFormulario;
import model.TEstado;


/**
 *
 * @author XPC
 */
public class PruebaFormularios {
    
    static DTOFormulario elDTO;
    
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
        
    }
}
