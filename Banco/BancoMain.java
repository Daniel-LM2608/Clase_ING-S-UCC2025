import java.util.ArrayList;
import java.util.Scanner;

// Clase principal del sistema bancario
public class BancoMain {
    public static void main(String[] args) {
        GestorDeCuentas gestor = new GestorDeCuentas(); // Crea un objeto que gestiona todas las cuentas
        Scanner sc = new Scanner(System.in); // Scanner para leer entrada del usuario
        int opcion; // Variable para almacenar la opción seleccionada

        // Bucle principal del menú, se repite hasta que el usuario seleccione salir
        // (23)
        do {
            // Mostrar menú principal
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

            // Leer la opción del usuario y validar que sea un número
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = -1; // Si no es un número válido, asignar valor inválido
            }

            // Procesar la opción seleccionada con un switch
            switch (opcion) {
                case 1:
                    gestor.crearCuenta(); // Llama al método para crear cuenta
                    break;
                case 2:
                    gestor.actualizarCuenta(); // Llama al método para actualizar datos de cuenta
                    break;
                case 3:
                    gestor.eliminarCuenta(); // Llama al método para eliminar cuenta
                    break;
                case 4:
                    gestor.depositar(); // Llama al método para depositar dinero
                    break;
                case 5:
                    gestor.retirar(); // Llama al método para retirar dinero
                    break;
                case 6:
                    gestor.invertirAhorro(); // Llama al método para invertir en cuentas de ahorro
                    break;
                case 7:
                    gestor.usarCredito(); // Llama al método para usar crédito
                    break;
                case 8:
                    gestor.pagarCredito(); // Llama al método para pagar crédito
                    break;
                case 9:
                    gestor.aplicarInteresCredito(); // Aplica interés a las cuentas de crédito
                    break;
                case 10:
                    gestor.transferir(); // Llama al método para transferir dinero entre cuentas
                    break;
                case 11:
                    gestor.listarCuentas(); // Muestra todas las cuentas existentes
                    break;
                case 12:
                    gestor.consultarSaldo(); // Permite consultar el saldo de una cuenta
                    break;
                case 13:
                    gestor.verTransacciones(); // Muestra todas las transacciones realizadas
                    break;
                case 14:
                    gestor.verTransaccionesPorCuenta(); // Muestra transacciones de una cuenta específica
                    break;
                case 15:
                    // Obtener cuentas ordenadas por saldo usando Merge Sort
                    ArrayList<Cuenta> porSaldo = gestor.obtenerCuentasOrdenadasPorSaldo();
                    System.out.println("Cuentas ordenadas por saldo (Merge Sort):");
                    for (Cuenta c : porSaldo)
                        System.out.println(c);
                    break;
                case 16:
                    // Obtener cuentas ordenadas por ID usando Quick Sort
                    ArrayList<Cuenta> porId = gestor.obtenerCuentasOrdenadasPorId();
                    System.out.println("Cuentas ordenadas por ID (Quick Sort):");
                    for (Cuenta c : porId)
                        System.out.println(c);
                    break;
                case 17:
                    // Búsqueda binaria de cuenta por ID
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
                    gestor.reporteCuentasOrdenadas(); // Genera un reporte de cuentas ordenadas por saldo
                    break;
                case 19:
                    // Búsqueda de cuenta en un Árbol BST por ID
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
                    gestor.imprimirInOrden(); // Imprime las cuentas del BST en InOrden
                    break;
                case 21:
                    gestor.imprimirPreOrden(); // Imprime las cuentas del BST en PreOrden
                    break;
                case 22:
                    gestor.imprimirPostOrden(); // Imprime las cuentas del BST en PostOrden
                    break;
                case 23:
                    System.out.println("Saliendo del sistema..."); // Mensaje de salida
                    break;
                default:
                    System.out.println("Opción inválida."); // Manejo de opción no válida
                    break;
            }

        } while (opcion != 23); // Repetir hasta que el usuario seleccione salir
        sc.close(); // Cerrar el Scanner al finalizar
    }
}
