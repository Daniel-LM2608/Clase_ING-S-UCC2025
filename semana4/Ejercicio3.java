public class Ejercicio3 {
    public static void main(String[] args) {

        int tam = 10;
        int[] b = new int[tam];

        for (int i = 0; i < b.length; i++) {
            b[i] = (int) (Math.random() * (30 - 10)) + 10;
        }

        // mostrar los elementos del arreglo
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "]=" + b[i]);
        }
        int sumaPares = 0;
        int sumaImpares = 0;
        for (int numero : b) {
            if (numero % 2 == 0) {
                sumaPares += numero;
            } else {
                sumaImpares += numero;
            }
        }
        System.out.println("Suma de los números pares: " + sumaPares);
        System.out.println("Suma de los números impares: " + sumaImpares);
    }
}