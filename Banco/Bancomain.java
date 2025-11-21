import java.util.Scanner;

public class Bancomain {

    public static void main(String[] args) {
        double dinero;
        Scanner entradaban = new Scanner(System.in);

        Debito debito = new Debito(0, 0, 0);

        System.out.print("Ingresar el monto de apertura: ");
        dinero = entradaban.nextDouble();
        debito.apertura(dinero);

        System.out.println("Ingresaste: "+dinero+" Tu saldo actual es: "+debito.consultarSaldo());
    }
}