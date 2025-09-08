package MiniProyecto;

 public class casillero {
 
    private int id;
    private String tamano;
    private paquete paquete;

    public casillero(int id, String tamano) {
        this.id = id;
        this.tamano = tamano;
        this.paquete = null;
    }
    
    public boolean disponible(){
            return paquete == null;
        }

        public void asignarPaquete(paquete p){//Paquete = la clase (como decir int, String, Libro, etc.).
                                              //p = el parámetro/variable que recibes en ese método.
            if (disponible()){
                if(p.getTamano().equalsIgnoreCase(this.tamano)){//equalsIgnoreCase sirve para comparar 2 cadenas ignorando mayuscula o minuscula
                    paquete = p;
                    System.out.println("Paquete asignado al casillero " + id);
                } else {
                    System.out.println("El paquete (" + p.getTamano()+ ") escede el tamaño del casilero (" + tamano + ")");
                }
            } else {
                System.out.println("Casillero ocupado.");

            }
        }

        public void vaciarCasillero(){
            if(disponible()){
                System.out.println("Casillero " + id + " libre");
            } else {
                System.out.println("Paquete retirado" + id + ":" + paquete.toString());
                paquete = null;
            }
        }

        public String getInfo(){
            if (disponible()){
                return "casillero " + id + "(" + tamano + ") Disponible";
            } else {
                 return "casillero " + id + "(" + tamano + ")" + paquete.toString();
            }
        }

        public boolean tamanoCorrecto(String tamano){
            return this.tamano.equalsIgnoreCase(tamano);

        }

        public boolean isOcupado(){
            return !disponible();
        }

        public int getId(){
            return id;
        }

        public String getTamano(){
            return tamano;
        }
    }

