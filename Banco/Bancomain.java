import java.util.Scanner;

public class Bancomain {

    public static void main(String[] args) {
        double dinero;
        Scanner entradaban = new Scanner(System.in);

        Debito debito = new Debito(0, 0, 0);
        Ahorro ahorro = new Ahorro(0, 0, 0);
        Credito credito = new Credito(0, 0, 0);

        System.out.println("Bienvenido a tu cuenta de credito ");
        System.out.println("Tu saldo actual es: "+credito.consultarSaldo());

        System.out.print("Ingresar el monto para sumar interes: ");
        dinero = entradaban.nextDouble();
        credito.sumarInteres(dinero);

        System.out.println("Solicitaste: "+dinero+" Tu saldo actual es: "+credito.consultarSaldo());


        System.out.println("Bienvenido a tu cuenta de ahorro ");
        System.out.print("Ingresar el monto de apertura: ");
        dinero = entradaban.nextDouble();
        ahorro.apertura(dinero);

        System.out.println("Ingresaste: "+dinero+" Tu saldo actual es: "+ahorro.consultarSaldo());

        System.out.print("Ingrese el monto a invertir: ");
        dinero = entradaban.nextDouble();
        ahorro.invertir(dinero);

        System.out.println("Invertiste: "+dinero+" Tu saldo actual es: "+ahorro.consultarSaldo());

        
        System.out.println("Bienvenido a tu cuenta de debito ");
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