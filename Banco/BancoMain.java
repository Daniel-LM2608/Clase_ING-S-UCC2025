import java.util.ArrayList;
import java.util.Scanner;

public class BancoMain {
    public static void main(String[] args) {
        GestorDeCuentas gestor = new GestorDeCuentas();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n===== BANCO – MENÚ PRINCIPAL =====");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Actualizar cuenta");
            System.out.println("3. Eliminar cuenta");
            System.out.println("4. Depositar");
            System.out.println("5. Retirar");
            System.out.println("6. Invertir (Ahorro)");
            System.out.println("7. Usar crédito");
            System.out.println("8. Pagar crédito");
            System.out.println("9. Aplicar intereses (Crédito)");
            System.out.println("10. Transferir dinero");
            System.out.println("11. Listar cuentas");
            System.out.println("12. Consultar saldo");
            System.out.println("13. Ver transacciones");
            System.out.println("14. Ver transacciones de cuenta");
            System.out.println("15. Obtener cuentas ordenadas por saldo (Merge Sort)");
            System.out.println("16. Obtener cuentas ordenadas por ID (Quick Sort)");
            System.out.println("17. Buscar cuenta por ID (Búsqueda Binaria)");
            System.out.println("18. Reporte de cuentas ordenadas por saldo");
            System.out.println("19. Buscar cuenta en Árbol (BST)");
            System.out.println("20. Mostrar cuentas InOrden (BST)");
            System.out.println("21. Mostrar cuentas PreOrden (BST)");
            System.out.println("22. Mostrar cuentas PostOrden (BST)");
            System.out.println("23. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    gestor.crearCuenta();
                    break;
                case 2:
                    gestor.actualizarCuenta();
                    break;
                case 3:
                    gestor.eliminarCuenta();
                    break;
                case 4:
                    gestor.depositar();
                    break;
                case 5:
                    gestor.retirar();
                    break;
                case 6:
                    gestor.invertirAhorro();
                    break;
                case 7:
                    gestor.usarCredito();
                    break;
                case 8:
                    gestor.pagarCredito();
                    break;
                case 9:
                    gestor.aplicarInteresCredito();
                    break;
                case 10:
                    gestor.transferir();
                    break;
                case 11:
                    gestor.listarCuentas();
                    break;
                case 12:
                    gestor.consultarSaldo();
                    break;
                case 13:
                    gestor.verTransacciones();
                    break;
                case 14:
                    gestor.verTransaccionesPorCuenta();
                    break;
                case 15:
                    ArrayList<Cuenta> porSaldo = gestor.obtenerCuentasOrdenadasPorSaldo();
                    System.out.println("Cuentas ordenadas por saldo (Merge Sort):");
                    for (Cuenta c : porSaldo)
                        System.out.println(c);
                    break;
                case 16:
                    ArrayList<Cuenta> porId = gestor.obtenerCuentasOrdenadasPorId();
                    System.out.println("Cuentas ordenadas por ID (Quick Sort):");
                    for (Cuenta c : porId)
                        System.out.println(c);
                    break;
                case 17:
                    System.out.print("Ingrese el ID de la cuenta a buscar (búsqueda binaria): ");
                    try {
                        int idBuscar = Integer.parseInt(sc.nextLine().trim());
                        Cuenta encontradaBin = gestor.buscarCuentaBinaria(idBuscar);
                        if (encontradaBin != null) {
                            System.out.println("✔ Cuenta encontrada:");
                            System.out.println(encontradaBin);
                        } else
                            System.out.println("✘ La cuenta no existe.");
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida.");
                    }
                    break;
                case 18:
                    gestor.reporteCuentasOrdenadas();
                    break;
                case 19:
                    try {
                        System.out.print("Ingrese el ID a buscar en el Árbol (BST): ");
                        int idBST = Integer.parseInt(sc.nextLine().trim());
                        Cuenta resultado = gestor.buscarEnBST(idBST);
                        if (resultado != null) {
                            System.out.println("✔ Cuenta encontrada en el Árbol:");
                            System.out.println(resultado);
                        } else
                            System.out.println("✘ No existe una cuenta con ese ID en el Árbol.");
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida.");
                    }
                    break;
                case 20:
                    gestor.imprimirInOrden();
                    break;
                case 21:
                    gestor.imprimirPreOrden();
                    break;
                case 22:
                    gestor.imprimirPostOrden();
                    break;
                case 23:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 23);
        sc.close();
    }
}
