public class Ejecutarvehiculo {

     public static void main(String[] args) {
        vehiculos[] V = new vehiculos[5];

        V[0] = new vehiculos ("8KD20", "SUZUKI", 2005, true); 
        V[1] = new vehiculos ("3SA23", "HONDA", 2003, true);
        V[2] = new vehiculos ("1YE18", "BMW", 2007, true);
        V[3] = new vehiculos ("9BY19", "TOYOTA", 2005, false);
        V[4] = new vehiculos ("9MO23", "FORD", 2003, false);

        System.out.println(V[0].iterarVehiculos(V));
     }
    

}