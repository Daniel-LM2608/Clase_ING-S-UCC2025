package MiniProyecto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class paquete {

     private String destinatario;
     private String tamano;
     private String fechaIngreso;

     public paquete (String destinatario, String tamano){
        this.destinatario = destinatario;
        this.tamano = tamano;
        this.fechaIngreso = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
     
    public String getDestinatario(){
        return destinatario;
    }
    public String getTamano(){
        return tamano;
    }
    public String getFechaIngreso(){
        return fechaIngreso;
    }
      public String toString() {
        return "paquete { Destinatario:" + destinatario + 
               " Tamaño:" + tamano + 
               " Fecha De Ingreso:" + fechaIngreso + "}";
    }   
    

}
