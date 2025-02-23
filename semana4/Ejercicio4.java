public class Ejercicio4 {
    public static void main(String[] args) {
        int tam = 10;
        int[] b = new int[tam];

        for (int i = 0; i < b.length; i++) {
            b[i] = (int) (Math.random() * (30 - 10)) + 10;
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "]=" + b[i]);
        }
        int tam2 = 10;
        int[] c = new int[tam2];
        for (int i = 0; i < c.length; i++) {
            c[i] = (int) (Math.random() * (30 - 10)) + 10;
        }
        for (int i = 0; i < c.length; i++) {
            System.out.println("c[" + i + "]=" + c[i]);
        }
        int edadMayor = b[0];
        for (int edad : b){
            if (edad > edadMayor){
                edadMayor = edad;
            }
        }
        for (int edad : c){
            if (edad > edadMayor){
                edadMayor = edad;
            }
        }
        System.out.println("La mayor edad de ambos grupos es:" + edadMayor);
    }
}
