
package controller;
import java.util.*;
import java.util.ArrayList;
import controller.DAO.DAOFormulariosImpl;
import controller.DAO.DAOSolicitantesImpl;
import java.time.LocalDate;
import java.util.List;
import model.Formulario;
import model.Solicitante;
import model.TEstado;
import model.Carrera;
import controller.DAO.DAOCarrerasImpl;
import controller.DTOFormulario;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


public class GestorFormularios {
    private DAOFormulariosImpl daoFormularios;
    
    private DTOFormulario dtoF;
    
    public DTOFormulario getDtoF() {
        return dtoF;
    }
    
    public GestorFormularios() {
        dtoF = new DTOFormulario();
        cargarSolicitantes();
        
        //simula la existencia de N formularios previamente creadas.
        String preFormularios [][] = {
                            {"0","ACEPTADO", "AE", "9"},
                            {"1","ACEPTADO", "IC", "3"},
                            {"2","ACEPTADO", "IC", "1"},
                            {"3","ACEPTADO", "AE", "0"},
                            {"4","ACEPTADO", "IC", "3"},
                            {"5","ACEPTADO", "FI", "8"},
                            {"6","SOLICITANTE", "IE", "2"},
                            {"7","SOLICITANTE", "IM", "5"},
                            };
        
        for (int i = 0; i < preFormularios.length; i++) {
            //localiza en la "tabla" de solicitantes el solicitante asociado al formulario en registro
            /*
            Solicitante elSolicitante = (Solicitante) DAOSolicitantesImpl.getInstance().get(preFormularios[i][?]);
            */
            Carrera laCarrera = (Carrera) DAOCarrerasImpl.getInstance().get(preFormularios[i][2]);
            Solicitante elSolicitante = (Solicitante) DAOSolicitantesImpl.getInstance().get(Integer.valueOf(preFormularios[i][3]));
            Formulario unFormulario = new Formulario(Integer.parseInt(preFormularios[i][0]),
                                                     TEstado.valueOf(preFormularios[i][1]),
                                                     laCarrera,
                                                     elSolicitante
            );
            //registra un formulario en la "tabla" de formularios
            DAOFormulariosImpl.getInstance().create(unFormulario);
        }
    }
    
    //cargarSolicitantes(): void
    private void cargarSolicitantes(){
        //método que simula la existencia de un juego de solicitantes al examen de Admision
        
        DAOSolicitantesImpl.getInstance().create(new Solicitante("Oliver", "Parker", "Fuentes", "801782463", LocalDate.of(1998, 02, 27), "ofuentesy@disennioic.cr", 32508713, "200N del Hospital Calderon Guardia, Carmen, San José", "Liceo Del Carmen", 0, false));
        DAOSolicitantesImpl.getInstance().create(new Solicitante("bbCecilia", "Ivancovich", "Tencio", "793401053", LocalDate.of(2000, 10, 05), "civancovich@disennioic.cr", 96521002, "300E del parque central, Liberia, Guanacaste", "Colegio 25 Julio", 1, false));    
        DAOSolicitantesImpl.getInstance().create(new Solicitante("yyCecilia", "Solis", "Duran", "945651023", LocalDate.of(2003, 12, 10), "esolis@disennioic.cr", 30353289, "Frente a la comandancia, Poás, Alajuela", "Liceo Bilingüe Poás", 2, true));
        DAOSolicitantesImpl.getInstance().create(new Solicitante("Su", "Ramírez", "Chang", "977238030", LocalDate.of(1999, 8, 15), "sramirez@disennioic.cr", 35410303, "500NE del peaje, Naranjo, Alajuela", "Colegio Narajo", 3, false));
        DAOSolicitantesImpl.getInstance().create(new Solicitante("yyCecilia", "Castillo", "Müller", "810259870", LocalDate.of(2002, 04, 10), "dcastillo@disennioic.cr", 92106978, "250S de la Basílica, Oriental, Cartago", "Colegio San Francisco", 4, false));
        DAOSolicitantesImpl.getInstance().create(new Solicitante("Elizabeth", "Hamilton", "Johnson", "2301484175", LocalDate.of(2003, 01, 14), "ehamilton@disennioic.cr", 91031145, "Contiguo al BCR, Uruca, San José", "Técnico Profesional de Sabana", 5, false));
        DAOSolicitantesImpl.getInstance().create(new Solicitante("Luis Fernando", "Cavani", "Céspedes", "76542046", LocalDate.of(1996, 07, 21), "lcavani@disennioic.cr", 35695101, "300NE del Fortín, Heredia", "Colegio Central de Heredia", 6, false));
        DAOSolicitantesImpl.getInstance().create(new Solicitante("Fernanda", "Watson", "Figueroa", "76120214", LocalDate.of(1999, 04, 27), "fwatson@disennioic.cr", 31587588, "2km E del cruce principal, Guápiles, Limón", "Colegio Santa Rita", 7, true));
        DAOSolicitantesImpl.getInstance().create(new Solicitante("Hiro", "Masaki", "Olsen", "9450330", LocalDate.of(2001, 10, 15), "hmasaki@disennioic.cr", 98500356, "500S de la entrada Jacó, Garabito, Puntarenas", "Jacó High School", 8, false));
        DAOSolicitantesImpl.getInstance().create(new Solicitante("Ana Priscilla", "Méndez", "Alfaro", "378900125", LocalDate.of(2000, 11, 03), "amendez@disennioic.cr", 90217533, "Contiguo a la plaza, Turrialba, Cartago", "Experimental Torre Alba", 9, true));
        
    }
    
    //registrarFormulario(in unFormulario:Formulario): boolean
    public boolean registrarFormulario(Formulario unFormulario) {
        return DAOFormulariosImpl.getInstance().create(unFormulario);
    }
    
//aplicarSimulacionRegistrar(): boolean
    public boolean aplicarSimulacion(){
        
        ArrayList<Formulario> todosFormularios;
        todosFormularios = (ArrayList) DAOFormulariosImpl.getInstance().getAll();
        //Aqui estan todos los formularios
        
        //Para cada formulario, crea una nota aleatoria y la asigna como puntaje
        //obtenido
        for (int i = 0; i < todosFormularios.size(); i++) {
            todosFormularios.get(i).setPuntajeObtenido(notaPseudoaleatoria());
        }
        
        return true;
    }
    
    // Privada: Solo la utiliza la simulacion del Examen, para generar aleatorios
    // principalmente cercanos a 600
    private int notaPseudoaleatoria(){
        
        double lambda= 600; //Media de poisson
        double L = Math.exp(lambda*-1);
        double k= 0, p = 1.0;
        double randomP = 0;
        
        while (p>L){
            k += 1;
            p = p * ThreadLocalRandom.current().nextDouble();
        }
        
        randomP = k-1;      //Este seria un resultado de poisson, cercano a 600
        
        /*
        Ajustar agregando o restando al de poisson
        un aleatorio entre 0 - 100 puntos
        
        Asi, la mayoria de las notas se encontraran entre 500-700 puntos
        */
        
        int ajuste = (int) Math.floor(ThreadLocalRandom.current().nextDouble()*100);
        
        //50porciento de que lo sume o de que lo reste
        if (ThreadLocalRandom.current().nextDouble()>0.5){
            ajuste *= -1;
        }
        
        //Poisson le hace el ajuste
        return (int) randomP + ajuste;
    }
    
    //actualizarEstados(): boolean
    public boolean actualizarEstados(){
        
        int cupoDisponible;         //Alamacenara el cupo aun disponible, que es facilitado por otro metodo
        ArrayList<Formulario> todosFormularios;
        todosFormularios = (ArrayList) DAOFormulariosImpl.getInstance().getAll();
        
        /*
        Para cada formulario, obtiene la carrera, revisa cuanto cupo le queda, y manda
        a hacer la evaluacion interna del formulario
        */
        for (int i = 0; i < todosFormularios.size(); i++) {
            cupoDisponible = cupoDisponibleCarrera(todosFormularios.get(i).getCarreraSolicitada()); //Me dice cuanto cupo queda en la carrera
            todosFormularios.get(i).actualizarEstadoSolicitud(cupoDisponible);
        }
        
        /*
        for (int i = 0; i < todosFormularios.size(); i++) {     //PARA REVISAR -imprime-
            System.out.println(todosFormularios.get(i).detallarSolicitud()); 
        }
        */

        return true;
    }
    
    private int cupoDisponibleCarrera(Carrera pCarrera){
        ArrayList<Formulario> todosFormularios;
        todosFormularios = (ArrayList) DAOFormulariosImpl.getInstance().getAll();
        
        //Ordena todos los formularios, de mayor a menor por nota
        //expresion lambda, misma funcion que el metodo estatico de abajo
        todosFormularios.sort((f1, f2) -> f2.getPuntajeObtenido()-f1.getPuntajeObtenido());
        int cupoDisponible = pCarrera.getCapacidadMax();
        
        
        for (int i = 0; i < todosFormularios.size(); i++) {
            if (todosFormularios.get(i).getCarreraSolicitada().equals(pCarrera)&&todosFormularios.get(i).getEstado()==TEstado.ACEPTADO){
               System.out.println("El Cupo de "+pCarrera.getNombre()+" va por "+cupoDisponible);
               cupoDisponible--;    //Si este formulario, es de la carrera y esta admitido, entonces resto 1 al contador de cupo
            
            }
        }
        System.out.println("Y quedo en: "+cupoDisponible);
        return cupoDisponible;
    }
    
    /*
    
    public static Comparator<Formulario> ordenando = new Comparator<Formulario>(){
        public int compare(Formulario f1, Formulario f2){
            return f2.getPuntajeObtenido()-f1.getPuntajeObtenido();
        }
    };
    */   
    
    //getSolicitudes(): Collection<Formulario>
    public List getSolicitudes(){
        /*
        DTOFormulario unDTO = new DTOFormulario();
        */
        return DAOFormulariosImpl.getInstance().getAll();
    }
    
    //getSolicitudEstadoNombre(pCarrera:Carrera, pEstado:Estado_Solicitud, pAscedente:boolean): Collection<Formulario>
    public List getSolicitudEstadoNombre(String codCarrera, TEstado estado) {
        List listaFormularios =  DAOFormulariosImpl.getInstance().getAll(codCarrera, estado);
        ArrayList<String> listaNombres = new ArrayList<String>();
        for(int i = 0; i < listaFormularios.size(); i++){
            
            Formulario formularioActual = (Formulario) listaFormularios.get(i);
            String nombre = formularioActual.getSolicitante().getNombre();
            String apellido1 = formularioActual.getSolicitante().getApellido1();
            String apellido2 = formularioActual.getSolicitante().getApellido2();
            String nombreCompleto = nombre + apellido1 + apellido2;
            listaNombres.add(nombreCompleto);   
        }
        
        Collections.sort(listaNombres);
        List nuevaListaFormularios = new ArrayList<Formulario>();
        int j = 0;
        int h = 0;
        while (j < listaNombres.size()){
            
            String nombreActual = listaNombres.get(j);
            
            Formulario formularioActual = (Formulario) listaFormularios.get(h);
            
            String nombreFormularioActual = formularioActual.getSolicitante().getNombre();
            String apellido1FormularioActual = formularioActual.getSolicitante().getApellido1();
            String apellido1FormularioActual2 = formularioActual.getSolicitante().getApellido2();
            String nombreCompletoFormularioActual = nombreFormularioActual + apellido1FormularioActual + apellido1FormularioActual2;
            
            if(nombreCompletoFormularioActual.equals(nombreActual)) {
                nuevaListaFormularios.add(formularioActual);
                j++;
                h = 0;
            }
            else {
                h++;
            }
            
        }

        return nuevaListaFormularios;
    }

    
    //getSolicitudEstadoPuntaje(pCarrera:Carrera, pEstado:Estado_Solicitud, pAscedente:boolean): Collection<Formulario>
    public List getSolicitudEstadoPuntaje(String codCarrera, TEstado estado) {
       
        List listaFormularios =  DAOFormulariosImpl.getInstance().getAll(codCarrera, estado);
        ArrayList<Integer> listaPuntajes = new ArrayList<Integer>();
        ArrayList<String> listaNombres = new ArrayList<String>();
        for(int i = 0; i < listaFormularios.size(); i++){
            
            Formulario formularioActual = (Formulario) listaFormularios.get(i);
            listaPuntajes.add(formularioActual.getPuntajeObtenido());
        }
        
        Collections.sort(listaPuntajes, Collections.reverseOrder());

        List nuevaListaFormularios = new ArrayList<Formulario>();
        int j = 0;
        int h = 0;
        int puntajeAnterior = -1;

        while (j < listaPuntajes.size()){
            
            int puntajeActual = listaPuntajes.get(j);
            
            Formulario formularioActual = (Formulario) listaFormularios.get(h);
            
            
                if(formularioActual.getPuntajeObtenido() == puntajeActual) {
                    
                    if(nuevaListaFormularios.contains(formularioActual)){
                        h++;
                        continue;
                    }
                    else{
                        nuevaListaFormularios.add(formularioActual);
                        puntajeAnterior = puntajeActual;
                        j++;
                        h = 0;
                    }
                }
                else {
                    h++;
                }
            
        }

        return nuevaListaFormularios;

    }
    
    
    //cantSolicitudesEstadoCarreraSede(pEstado:Estado_Solicitud, pCarrera:Carrera, pSede:Sede): int
    
    //getDetalleFormulario(in pNum:int): Formulario
}