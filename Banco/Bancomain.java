import java.util.Scanner;

public class Bancomain {

    public static void main(String[] args) {
        double dinero;
        Scanner entradaban = new Scanner(System.in);

        Debito debito = new Debito(0, 0, 0);
        Ahorro ahorro = new Ahorro(0, 0, 0);
        Credito credito = new Credito(0, -200, 0);

        System.out.print("Ingresar el monto de apertura: ");
        dinero = entradaban.nextDouble();
        debito.apertura(dinero);

        System.out.println("Ingresaste: "+dinero+" Tu saldo actual es: "+debito.consultarSaldo());

        System.out.print("Ingrese el monto a retirar: ");
        dinero = entradaban.nextDouble();
        debito.retirar(dinero);

        System.out.println("retiraste: "+dinero+" Tu saldo actual es: "+debito.consultarSaldo());
    }
}