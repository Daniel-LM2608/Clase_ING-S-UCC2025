import java.text.SimpleDateFormat;
import java.util.Date;
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
    public GestorTareas() {
        this.Prioritaria = new Stack<>();        // LIFO para prioridad 3
        this.Espera = new LinkedList<>();        // FIFO para prioridad 1 y 2
        this.Trazabilidad = new HashMap<>();     // idTarea -> estado / info
    }

    // Agregar tarea según prioridad
    public void agregarTarea(tarea tarea) {
        if (tarea.getPrioridad() == 3) {
            Prioritaria.push(tarea);
        } else {
            Espera.offer(tarea);
        }
    }

    // Procesar la siguiente tarea (primero las prioritarias)
    public tarea procesarSiguienteTarea() {
        tarea tareaProcesada;

        if (!Prioritaria.empty()) {
            tareaProcesada = Prioritaria.pop();
        } else if (!Espera.isEmpty()) {
            tareaProcesada = Espera.poll();
        } else {
            return null;
        }
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = formato.format(new Date(tareaProcesada.getTiempoLlegada()));

        // Registrar la tarea procesada en el mapa de trazabilidad
        Trazabilidad.put(
            tareaProcesada.getId(),
            "Completada - Prioridad: " + tareaProcesada.getPrioridad() +
            " - Tiempo de llegada: " + fechaFormateada
        );

        return tareaProcesada;
    }

    // Mostrar todas las tareas procesadas
    public void mostrarTrazabilidad() {
        System.out.println("Registro de trazabilidad:");
        if (Trazabilidad.isEmpty()) {
            System.out.println("No hay tareas procesadas.");
        } else {
            for (Map.Entry<String, String> entrada : Trazabilidad.entrySet()) {
                System.out.println("ID: " + entrada.getKey() + " - " + entrada.getValue());
            }
        }
    }

    // Consultar el estado de una tarea según su ID
    public String consultarEstadoTarea(String idTarea) {

        // 1️⃣ Buscar en el registro de completadas
        if (Trazabilidad.containsKey(idTarea)) {
            return "Tarea completada";
        }

        // 2️⃣ Buscar en la pila de prioridad (pendiente)
        for (tarea t : Prioritaria) {
            if (t.getId().equals(idTarea)) {
                return "Tarea pendiente (alta prioridad)";
            }
        }

        // 3️⃣ Buscar en la cola de espera
        for (tarea t : Espera) {
            if (t.getId().equals(idTarea)) {
                return "Tarea en espera";
            }
        }

        // 4️⃣ Si no está en ninguna estructura
        return "ID no encontrado";
    }
}


        

        




