import java.util.Scanner;

public class BancoMain {

    public static void main(String[] args) {

        GestorDeCuentas gestor = new GestorDeCuentas();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n===== BANCO – MENÚ PRINCIPAL =====");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Invertir (Ahorro)");
            System.out.println("5. Usar crédito");
            System.out.println("6. Pagar crédito");
            System.out.println("7. Aplicar intereses (Crédito)");
            System.out.println("8. Transferir dinero");
            System.out.println("9. Listar cuentas");
            System.out.println("10. Consultar saldo");
            System.out.println("11. Ver transacciones");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: gestor.crearCuenta(); break;
                case 2: gestor.depositar(); break;
                case 3: gestor.retirar(); break;
                case 4: gestor.invertirAhorro(); break;
                case 5: gestor.usarCredito(); break;
                case 6: gestor.pagarCredito(); break;
                case 7: gestor.aplicarInteresCredito(); break;
                case 8: gestor.transferir(); break;
                case 9: gestor.listarCuentas(); break;
                case 10: gestor.consultarSaldo(); break;
                case 11: gestor.verTransacciones(); break;
                case 12: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción inválida."); break;
            }

        } while (opcion != 12);

        sc.close();
    }
}
