import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GestorTareas {
    // Atributos: pila para prioridad alta, cola para espera, mapa para trazabilidad
    private Stack<tarea> Prioritaria;
    private Queue<tarea> Espera;
    private Map<String, String> Trazabilidad;


// Constructor: inicializa las estructuras
    public GestorTareas(){
        this.Prioritaria = new Stack<>();       // LIFO para prioridad 3
        this.Espera = new LinkedList<>();       // FIFO para prioridad 1 y 2
        this.Trazabilidad = new HashMap<>();     // idTarea -> estado / info

    }

    public void agregarTarea(tarea tarea){
        if(tarea.getPrioridad() == 3){
            Prioritaria.push(tarea);
        }else {
            Espera.offer(tarea);
        }
        
    }

    public tarea procesarSiguienteTarea(){
        tarea tareaProcesada;
        if(!Prioritaria.empty()){
            tareaProcesada = Prioritaria.pop();
        }else {
            if(!Espera.isEmpty()){
            tareaProcesada = Espera.poll();
        }
        else {
            return null;
        }

        Trazabilidad.put(
            tareaProcesada.getId(),
            "Completada - Prioridad:" + tareaProcesada.getPrioridad() + 
            " - Tiempo de llegada:" + tareaProcesada.getTiempoLlegada()
            );



        return tareaProcesada;

        

    }

        

        

}


