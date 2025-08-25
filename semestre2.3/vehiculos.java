public class vehiculos {

    private String Chasis;
    private String Marca;
    private int Modelo;
    private boolean Matricula;

    public vehiculos(String Chasis, String Marca, int Modelo, boolean Matricula) {
        this.Chasis = Chasis;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Matricula = Matricula;
    }

    
    public String toString() {
        return "Vehiculo { Chasis:" + Chasis +
               " Marca:" + Marca + 
               " Modelo:" + Modelo + 
               " Matricula:" + Matricula + "}";
    }   

   //Método para iterar el arreglo
    public String iterarVehiculos(vehiculos[] v){
        String cad = "";
        for(int i = 0; i < v.length; i++){
            cad += v[i].toString() + "\n";
        }
        return cad;
    
    }
}