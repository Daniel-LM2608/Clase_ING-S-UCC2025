public class libro {

    private String titulo;
    private String autor;
    private int precio;

    public libro(String titulo, String autor, int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        
    }

      // Getter del precio
    public int getPrecio() {
        return precio;
    }

    
    public String toString() {
        return "libro { titulo:" + titulo + 
               " autor:" + autor + 
               " precio:" + precio + "}";
    }   


   
      //Método para iterar el arreglo
    public String iterarLibro(libro[] L){
        String cad = "";
        for(int i = 0; i < L.length; i++){
            cad += L[i].toString() + "\n";
        }
        return cad;
    
    }
    public int totalPrecios(libro[] L){
        int total = 0;
        for(int i = 0; i < L.length; i++){
            total += L[i].getPrecio();
        }
        return total;
    }
}

