import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeCuentas {

    private NodoBST raiz;

    // Clase interna del nodo del árbol
    class NodoBST {
        Cuenta cuenta;
        NodoBST izquierda;
        NodoBST derecha;

        public NodoBST(Cuenta cuenta) {
            this.cuenta = cuenta;
        }
    }

    private ArrayList<Cuenta> cuentas;
    private ArrayList<Transaccion> transacciones;
    private Scanner sc;

    public GestorDeCuentas() {
        cuentas = new ArrayList<>();
        transacciones = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public Cuenta buscarCuenta(int id) {
        for (Cuenta c : cuentas) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    public void crearCuenta() {
        System.out.println("Seleccione tipo de cuenta:");
        System.out.println("1. Ahorro");
        System.out.println("2. Débito");
        System.out.println("3. Crédito");
        System.out.print("Opción: ");
        int opc = sc.nextInt();

        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();

        System.out.print("Monto de apertura (>=0): ");
        double apertura = sc.nextDouble();

        Cuenta nueva = null;

        switch (opc) {
            case 1:
                nueva = new Ahorro(id, apertura);
                break;
            case 2:
                nueva = new Debito(id, apertura);
                break;
            case 3:
                nueva = new Credito(id, apertura);
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        cuentas.add(nueva);
        raiz = insertarBST(raiz, nueva);
        transacciones.add(new Transaccion(id, "Apertura", apertura));
        System.out.println("Cuenta creada exitosamente.");
    }

    public void depositar() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a depositar: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }

        c.apertura(monto);
        transacciones.add(new Transaccion(id, "Depósito", monto));
        System.out.println("Depósito exitoso.");
    }

    public void retirar() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a retirar: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Debito)) {
            System.out.println("Solo cuentas débito pueden retirar.");
            return;
        }
        if (monto <= 0 || c.consultarSaldo() < monto) {
            System.out.println("Monto inválido o saldo insuficiente.");
            return;
        }

        ((Debito) c).retirar(monto);
        transacciones.add(new Transaccion(id, "Retiro", monto));
        System.out.println("Retiro exitoso.");
    }

    public void invertirAhorro() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a invertir: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Ahorro)) {
            System.out.println("Cuenta de ahorro no encontrada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }

        ((Ahorro) c).invertir(monto);
        transacciones.add(new Transaccion(id, "Inversión", monto));
        System.out.println("Inversión realizada exitosamente.");
    }

    public void usarCredito() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a usar de crédito: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Credito)) {
            System.out.println("Cuenta de crédito no encontrada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }

        ((Credito) c).usarCredito(monto);
        transacciones.add(new Transaccion(id, "Uso de crédito", monto));
        System.out.println("Crédito utilizado exitosamente.");
    }

    public void pagarCredito() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();
        System.out.print("Monto a pagar: ");
        double monto = sc.nextDouble();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Credito)) {
            System.out.println("Cuenta de crédito no encontrada.");
            return;
        }
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }

        ((Credito) c).pagar(monto);
        transacciones.add(new Transaccion(id, "Pago de crédito", monto));
        System.out.println("Pago de crédito exitoso.");
    }

    public void aplicarInteresCredito() {
        System.out.print("ID de la cuenta de crédito: ");
        int id = sc.nextInt();

        Cuenta c = buscarCuenta(id);
        if (c == null || !(c instanceof Credito)) {
            System.out.println("Cuenta de crédito no encontrada.");
            return;
        }

        ((Credito) c).aplicarInteres();
        transacciones.add(new Transaccion(id, "Aplicar interés", 0));
        System.out.println("Interés aplicado correctamente.");
    }

    public void transferir() {
        System.out.print("ID cuenta origen (débito): ");
        int idOrigen = sc.nextInt();
        System.out.print("ID cuenta destino: ");
        int idDestino = sc.nextInt();
        System.out.print("Monto a transferir: ");
        double monto = sc.nextDouble();

        Cuenta origen = buscarCuenta(idOrigen);
        Cuenta destino = buscarCuenta(idDestino);

        if (origen == null || destino == null) {
            System.out.println("Alguna de las cuentas no existe.");
            return;
        }
        if (!(origen instanceof Debito)) {
            System.out.println("Solo cuentas débito pueden transferir.");
            return;
        }
        if (monto <= 0 || origen.consultarSaldo() < monto) {
            System.out.println("Monto inválido o saldo insuficiente.");
            return;
        }

        ((Debito) origen).retirar(monto);
        destino.apertura(monto);
        transacciones.add(new Transaccion(idOrigen, "Transferencia a " + idDestino, monto));
        System.out.println("Transferencia realizada exitosamente.");
    }

    public void listarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
            return;
        }
        for (Cuenta c : cuentas) {
            System.out.println(c);
        }
    }

    public void consultarSaldo() {
        System.out.print("ID de la cuenta: ");
        int id = sc.nextInt();

        Cuenta c = buscarCuenta(id);
        if (c == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.println("Saldo actual: " + c.consultarSaldo());
    }

    public void verTransacciones() {
        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
            return;
        }
        for (Transaccion t : transacciones) {
            System.out.println(t);
        }
    }
    // ===============================================================
    // ========== ORDENAMIENTO DE CUENTAS POR SALDO (MERGE SORT) =====
    // ===============================================================

    public void ordenarCuentasPorSaldo() {
        if (cuentas.size() <= 1)
            return;
        cuentas = mergeSortPorSaldo(cuentas);
    }

    private ArrayList<Cuenta> mergeSortPorSaldo(ArrayList<Cuenta> lista) {
        if (lista.size() <= 1)
            return lista;

        int mitad = lista.size() / 2;

        ArrayList<Cuenta> izquierda = new ArrayList<>(lista.subList(0, mitad));
        ArrayList<Cuenta> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        izquierda = mergeSortPorSaldo(izquierda);
        derecha = mergeSortPorSaldo(derecha);

        return merge(izquierda, derecha);
    }

    private ArrayList<Cuenta> merge(ArrayList<Cuenta> izq, ArrayList<Cuenta> der) {
        ArrayList<Cuenta> resultado = new ArrayList<>();

        int i = 0, j = 0;

        while (i < izq.size() && j < der.size()) {
            if (izq.get(i).getMontoActual() <= der.get(j).getMontoActual()) {
                resultado.add(izq.get(i));
                i++;
            } else {
                resultado.add(der.get(j));
                j++;
            }
        }

        while (i < izq.size()) {
            resultado.add(izq.get(i));
            i++;
        }

        while (j < der.size()) {
            resultado.add(der.get(j));
            j++;
        }

        return resultado;
    }

    // ===============================================================
    // ========== ORDENAMIENTO POR ID (QUICK SORT) ====================
    // ===============================================================

    public void ordenarCuentasPorId() {
        if (cuentas.size() <= 1)
            return;
        quickSort(cuentas, 0, cuentas.size() - 1);
    }

    private void quickSort(ArrayList<Cuenta> lista, int low, int high) {
        if (low < high) {
            int pi = partition(lista, low, high);

            quickSort(lista, low, pi - 1);
            quickSort(lista, pi + 1, high);
        }
    }

    private int partition(ArrayList<Cuenta> lista, int low, int high) {
        int pivot = lista.get(high).getId();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (lista.get(j).getId() <= pivot) {
                i++;
                Cuenta temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
            }
        }

        Cuenta temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);

        return i + 1;
    }

    // ===============================================================
    // ========== BÚSQUEDA BINARIA POR ID =============================
    // ===============================================================

    public Cuenta buscarCuentaBinaria(int id) {
        ordenarCuentasPorId(); // debe estar ordenada para funcionar

        int inicio = 0;
        int fin = cuentas.size() - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Cuenta cuenta = cuentas.get(medio);

            if (cuenta.getId() == id) {
                return cuenta;
            } else if (cuenta.getId() < id) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return null;
    }

    // ===============================================================
    // ========== REPORTE ORDENADO ===================================
    // ===============================================================

    public void reporteCuentasOrdenadas() {
        ordenarCuentasPorSaldo();

        System.out.println("\n=== REPORTE DE CUENTAS ORDENADAS POR SALDO ===");

        for (Cuenta c : cuentas) {
            System.out.println("ID: " + c.getId() + " | Saldo: " + c.getMontoActual());
        }

        System.out.println("==============================================\n");
    }

    public void actualizarCuenta() {
        System.out.print("ID de la cuenta que desea actualizar: ");
        int id = sc.nextInt();

        Cuenta c = buscarCuenta(id);

        if (c == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.println("\n¿Qué desea actualizar?");
        System.out.println("1. Cambiar ID");
        System.out.println("2. Cambiar tipo de cuenta");
        System.out.print("Opción: ");
        int opc = sc.nextInt();

        switch (opc) {
            case 1:
                System.out.print("Nuevo ID: ");
                int nuevoId = sc.nextInt();

                // verificar ID repetido
                if (buscarCuenta(nuevoId) != null) {
                    System.out.println("Ese ID ya está en uso.");
                    return;
                }

                c.setId(nuevoId);
                System.out.println("ID actualizado correctamente.");
                break;

            case 2:
                System.out.println("Seleccione nuevo tipo:");
                System.out.println("1. Ahorro");
                System.out.println("2. Débito");
                System.out.println("3. Crédito");
                System.out.print("Opción: ");
                int nuevoTipo = sc.nextInt();

                Cuenta nueva = null;

                if (nuevoTipo == 1)
                    nueva = new Ahorro(c.getId(), c.getMontoActual());
                else if (nuevoTipo == 2)
                    nueva = new Debito(c.getId(), c.getMontoActual());
                else if (nuevoTipo == 3)
                    nueva = new Credito(c.getId(), 0); // créditos no usan saldo
                else {
                    System.out.println("Opción inválida.");
                    return;
                }

                // remplazar cuenta en la lista
                cuentas.set(cuentas.indexOf(c), nueva);

                System.out.println("Tipo de cuenta actualizado correctamente.");
                break;

            default:
                System.out.println("Opción inválida.");
        }
    }

    public void eliminarCuenta() {
        System.out.print("ID de la cuenta a eliminar: ");
        int id = sc.nextInt();

        Cuenta c = buscarCuenta(id);

        if (c == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        // verificar que la cuenta está en cero
        if (c instanceof Credito) {
            if (c.getMontoActual() != 0) {
                System.out.println("No se puede eliminar. La cuenta de crédito aún tiene deuda.");
                return;
            }
        } else {
            if (c.getMontoActual() != 0) {
                System.out.println("No se puede eliminar. La cuenta tiene saldo disponible.");
                return;
            }
        }

        cuentas.remove(c);
        System.out.println("Cuenta eliminada exitosamente.");
    }

    // ===============================================================
    // ========== ARBOL BINARIO DE BUSQUEDA (BST) ====================
    // ===============================================================

    // Inserción en árbol
    private NodoBST insertarBST(NodoBST nodo, Cuenta cuenta) {
        if (nodo == null)
            return new NodoBST(cuenta);

        if (cuenta.getId() < nodo.cuenta.getId()) {
            nodo.izquierda = insertarBST(nodo.izquierda, cuenta);
        } else if (cuenta.getId() > nodo.cuenta.getId()) {
            nodo.derecha = insertarBST(nodo.derecha, cuenta);
        }

        return nodo;
    }

    // Búsqueda en BST
    public Cuenta buscarEnBST(int id) {
        return buscarBSTRec(raiz, id);
    }

    private Cuenta buscarBSTRec(NodoBST nodo, int id) {
        if (nodo == null)
            return null;

        if (id == nodo.cuenta.getId())
            return nodo.cuenta;

        if (id < nodo.cuenta.getId())
            return buscarBSTRec(nodo.izquierda, id);
        else
            return buscarBSTRec(nodo.derecha, id);
    }

    // Recorridos del árbol
    public void imprimirInOrden() {
        System.out.println("=== Recorrido InOrden ===");
        inOrden(raiz);
    }

    private void inOrden(NodoBST nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda);
            System.out.println(nodo.cuenta);
            inOrden(nodo.derecha);
        }
    }

    public void imprimirPreOrden() {
        System.out.println("=== Recorrido PreOrden ===");
        preOrden(raiz);
    }

    private void preOrden(NodoBST nodo) {
        if (nodo != null) {
            System.out.println(nodo.cuenta);
            preOrden(nodo.izquierda);
            preOrden(nodo.derecha);
        }
    }

    public void imprimirPostOrden() {
        System.out.println("=== Recorrido PostOrden ===");
        postOrden(raiz);
    }

    private void postOrden(NodoBST nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierda);
            postOrden(nodo.derecha);
            System.out.println(nodo.cuenta);
        }
    }

}
