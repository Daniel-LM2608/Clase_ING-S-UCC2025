package MiniProyecto;
 public class casillero {
 
    private int id;
    private String tamano;
    private paquete paquete;

    public casillero (int id, String tamano){
        this.id;
        this.tamano;
        this.paquete = null;
    }
    
    public boolean disponible(){
            return paquete == null;
        }

        public void asignarPaquete(Paquete p){
            if (disponible()){
                if(p.getTamano().equalsIgnoreCase(this.tamano)){
                    paquete = p;
                    System.out.println("Paquete asignado al casillero " + id);
                } else {
                    System.out.println("El paquete (" + p.getTamano()+ ") escede el tamaño del casilero (" + tamano + ")");
                }
            }
        }
    }

