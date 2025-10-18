public class tarea {

    private String id;
    private String descripcion;
    private int prioridad;
    private long tiempoLlegada;

    public tarea(String id, String descripcion, int prioridad, long tiempoLlegada ){

    this.id = id;
    this.descripcion = descripcion;
    this.prioridad = prioridad;
    this.tiempoLlegada= tiempoLlegada;
    }

    @Override
    public String toString() { 

        return "Tarea" + 
                "id ="+ id + 
                "Descripcion = " + descripcion +
                "Prioridad =" + prioridad +
                "Tiempo de llegada =" + tiempoLlegada +
                "}";

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public int getPrioridad(){
        return prioridad;
    }

    public void setPrioridad(int prioridad){
        this.prioridad = prioridad;
    }

    public long getTiempoLlegada(){
        return tiempoLlegada;
    }

    public void setTiempoLlegada(long tiempollegada){
        this.tiempoLlegada = tiempollegada;
    }



}