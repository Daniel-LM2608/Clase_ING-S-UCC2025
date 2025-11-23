import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GestorDeCuentas {
    // BST interno por ID
    private NodoBST raiz;

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
    // Cola para demostrar uso de estructuras auxiliares (procesamiento diferido de
    // transacciones)
    private Queue<Transaccion> colaTransacciones;
    private Scanner sc;

    public GestorDeCuentas() {
        cuentas = new ArrayList<>();
        transacciones = new ArrayList<>();
        colaTransacciones = new LinkedList<>();
        sc = new Scanner(System.in);
        raiz = null;
    }

    // ----------------------- MÉTODOS AUXILIARES -----------------------
    public Cuenta buscarCuenta(int id) {
        for (Cuenta c : cuentas) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    private boolean idExiste(int id) {
        return buscarCuenta(id) != null;
    }

    // ----------------------- OPERACIONES BÁSICAS -----------------------
    public void crearCuenta() {
        try {
            System.out.println("Seleccione tipo de cuenta:");
            System.out.println("1. Ahorro");
            System.out.println("2. Débito");
            System.out.println("3. Crédito");
            System.out.print("Opción: ");
            int opc = Integer.parseInt(sc.nextLine().trim());

            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            if (idExiste(id)) {
                System.out.println("Ese ID ya existe. Cancelando creación.");
                return;
            }

            System.out.print("Monto de apertura (>=0): ");
            double apertura = Double.parseDouble(sc.nextLine().trim());
            if (apertura < 0) {
                System.out.println("Monto inválido.");
                return;
            }

            Cuenta nueva = null;
            switch (opc) {
                case 1:
                    nueva = new Ahorro(id, apertura);
                    break;
                case 2:
                    nueva = new Debito(id, apertura);
                    break;
                case 3:
                    // Para crédito iniciamos sin deuda
                    nueva = new Credito(id, 0);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    return;
            }

            cuentas.add(nueva);
            raiz = insertarBST(raiz, nueva);

            Transaccion transApertura = new Transaccion(id, "Apertura", apertura);
            transacciones.add(transApertura);
            colaTransacciones.add(transApertura);
            procesarColaTransacciones();

            System.out.println("Cuenta creada exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Operación cancelada.");
        }
    }

    public void depositar() {
        try {
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Monto a depositar: ");
            double monto = Double.parseDouble(sc.nextLine().trim());
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
            Transaccion trans = new Transaccion(id, "Depósito", monto);
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();
            System.out.println("Depósito exitoso.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    public void retirar() {
        try {
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Monto a retirar: ");
            double monto = Double.parseDouble(sc.nextLine().trim());
            Cuenta c = buscarCuenta(id);
            if (c == null || !(c instanceof Debito)) {
                System.out.println("Solo cuentas débito pueden retirar.");
                return;
            }
            if (monto <= 0) {
                System.out.println("Monto inválido.");
                return;
            }
            if (!((Debito) c).retirar(monto)) {
                System.out.println("Saldo insuficiente.");
                return;
            }
            Transaccion trans = new Transaccion(id, "Retiro", monto);
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();
            System.out.println("Retiro exitoso.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    public void invertirAhorro() {
        try {
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Monto a invertir: ");
            double monto = Double.parseDouble(sc.nextLine().trim());
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
            Transaccion trans = new Transaccion(id, "Inversión", monto);
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();
            System.out.println("Inversión realizada exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    public void usarCredito() {
        try {
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Monto a usar de crédito: ");
            double monto = Double.parseDouble(sc.nextLine().trim());
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
            Transaccion trans = new Transaccion(id, "Uso de crédito", monto);
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();
            System.out.println("Crédito utilizado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    public void pagarCredito() {
        try {
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Monto a pagar: ");
            double monto = Double.parseDouble(sc.nextLine().trim());
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
            Transaccion trans = new Transaccion(id, "Pago de crédito", monto);
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();
            System.out.println("Pago de crédito exitoso.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    public void aplicarInteresCredito() {
        try {
            System.out.print("ID de la cuenta de crédito: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Cuenta c = buscarCuenta(id);
            if (c == null || !(c instanceof Credito)) {
                System.out.println("Cuenta de crédito no encontrada.");
                return;
            }
            ((Credito) c).aplicarInteres();
            Transaccion trans = new Transaccion(id, "Aplicar interés", 0);
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();
            System.out.println("Interés aplicado correctamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    public void transferir() {
        try {
            System.out.print("ID cuenta origen (débito): ");
            int idOrigen = Integer.parseInt(sc.nextLine().trim());
            System.out.print("ID cuenta destino: ");
            int idDestino = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Monto a transferir: ");
            double monto = Double.parseDouble(sc.nextLine().trim());
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
            if (monto <= 0) {
                System.out.println("Monto inválido.");
                return;
            }
            if (!((Debito) origen).retirar(monto)) {
                System.out.println("Saldo insuficiente.");
                return;
            }
            destino.apertura(monto);
            Transaccion trans = new Transaccion(idOrigen, "Transferencia a " + idDestino, monto);
            transacciones.add(trans);
            colaTransacciones.add(trans);
            procesarColaTransacciones();
            System.out.println("Transferencia realizada exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
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
        try {
            System.out.print("ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Cuenta c = buscarCuenta(id);
            if (c == null) {
                System.out.println("Cuenta no encontrada.");
                return;
            }
            System.out.println("Saldo actual: " + c.consultarSaldo());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
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

    public void verTransaccionesPorCuenta() {
        try {
            System.out.print("Ingrese el ID de la cuenta: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            boolean hay = false;
            System.out.println("\n=== TRANSACCIONES DE LA CUENTA " + id + " ===");
            for (Transaccion t : transacciones) {
                if (t.getIdCuenta() == id) {
                    System.out.println(t);
                    hay = true;
                }
            }
            if (!hay) {
                System.out.println("No hay transacciones registradas para esta cuenta.");
            }
            System.out.println("===========================================\n");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- ORDENAMIENTO (no modifican lista original)
    // -----------------------
    public ArrayList<Cuenta> obtenerCuentasOrdenadasPorSaldo() {
        ArrayList<Cuenta> copia = new ArrayList<>(cuentas);
        if (copia.size() <= 1)
            return copia;
        return mergeSortPorSaldo(copia);
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

    public ArrayList<Cuenta> obtenerCuentasOrdenadasPorId() {
        ArrayList<Cuenta> copia = new ArrayList<>(cuentas);
        if (copia.size() <= 1)
            return copia;
        quickSort(copia, 0, copia.size() - 1);
        return copia;
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

    // ----------------------- BÚSQUEDA BINARIA (usa copia ordenada)
    // -----------------------
    public Cuenta buscarCuentaBinaria(int id) {
        ArrayList<Cuenta> ordenadas = obtenerCuentasOrdenadasPorId();
        int inicio = 0;
        int fin = ordenadas.size() - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            Cuenta cuenta = ordenadas.get(medio);
            if (cuenta.getId() == id)
                return cuenta;
            else if (cuenta.getId() < id)
                inicio = medio + 1;
            else
                fin = medio - 1;
        }
        return null;
    }

    // ----------------------- REPORTE ORDENADO -----------------------
    public void reporteCuentasOrdenadas() {
        ArrayList<Cuenta> ordenadas = obtenerCuentasOrdenadasPorSaldo();
        System.out.println("\n=== REPORTE DE CUENTAS ORDENADAS POR SALDO ===");
        for (Cuenta c : ordenadas) {
            System.out.println("ID: " + c.getId() + " | Saldo: " + c.getMontoActual());
        }
        System.out.println("==============================================\n");
    }

    // ----------------------- ACTUALIZAR / ELIMINAR -----------------------
    public void actualizarCuenta() {
        try {
            System.out.print("ID de la cuenta que desea actualizar: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Cuenta c = buscarCuenta(id);
            if (c == null) {
                System.out.println("Cuenta no encontrada.");
                return;
            }
            System.out.println("\n¿Qué desea actualizar?");
            System.out.println("1. Cambiar ID");
            System.out.println("2. Cambiar tipo de cuenta");
            System.out.print("Opción: ");
            int opc = Integer.parseInt(sc.nextLine().trim());
            switch (opc) {
                case 1:
                    System.out.print("Nuevo ID: ");
                    int nuevoId = Integer.parseInt(sc.nextLine().trim());
                    if (nuevoId == id) {
                        System.out.println("El ID es igual al anterior. Nada que hacer.");
                        return;
                    }
                    if (idExiste(nuevoId)) {
                        System.out.println("Ese ID ya está en uso.");
                        return;
                    }
                    // actualizar: quitar nodo viejo del BST, actualizar id y volver a insertar
                    raiz = eliminarNodoBST(raiz, id);
                    c.setId(nuevoId);
                    raiz = insertarBST(raiz, c);
                    System.out.println("ID actualizado correctamente.");
                    break;
                case 2:
                    System.out.println("Seleccione nuevo tipo:");
                    System.out.println("1. Ahorro");
                    System.out.println("2. Débito");
                    System.out.println("3. Crédito");
                    System.out.print("Opción: ");
                    int nuevoTipo = Integer.parseInt(sc.nextLine().trim());
                    Cuenta nueva = null;
                    double saldoActual = c.getMontoActual();
                    int currentId = c.getId();
                    if (nuevoTipo == 1)
                        nueva = new Ahorro(currentId, saldoActual);
                    else if (nuevoTipo == 2)
                        nueva = new Debito(currentId, saldoActual);
                    else if (nuevoTipo == 3) {
                        // Convierte a crédito: comenzamos sin deuda (se puede ajustar según
                        // requerimiento)
                        nueva = new Credito(currentId, 0);
                    } else {
                        System.out.println("Opción inválida.");
                        return;
                    }
                    // Reemplazar en la lista y en el BST
                    int index = cuentas.indexOf(c);
                    if (index >= 0) {
                        cuentas.set(index, nueva);
                        raiz = eliminarNodoBST(raiz, currentId);
                        raiz = insertarBST(raiz, nueva);
                        System.out.println("Tipo de cuenta actualizado correctamente.");
                    } else {
                        System.out.println("Error al actualizar: cuenta no encontrada en la lista.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    public void eliminarCuenta() {
        try {
            System.out.print("ID de la cuenta a eliminar: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Cuenta c = buscarCuenta(id);
            if (c == null) {
                System.out.println("Cuenta no encontrada.");
                return;
            }
            // verificar que la cuenta está en cero
            if (c instanceof Credito) {
                if (c.getMontoActual() < 0) {
                    System.out.println("No se puede eliminar. La cuenta de crédito aún tiene deuda.");
                    return;
                }
            } else {
                if (c.getMontoActual() != 0) {
                    System.out.println("No se puede eliminar. La cuenta tiene saldo disponible.");
                    return;
                }
            }
            // eliminar de lista
            cuentas.remove(c);
            // eliminar del BST
            raiz = eliminarNodoBST(raiz, id);
            // eliminar transacciones asociadas
            transacciones.removeIf(t -> t.getIdCuenta() == id);
            System.out.println("Cuenta eliminada exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    // ----------------------- BST (inserción, búsqueda, eliminación, recorridos)
    // -----------------------
    private NodoBST insertarBST(NodoBST nodo, Cuenta cuenta) {
        if (nodo == null)
            return new NodoBST(cuenta);
        if (cuenta.getId() < nodo.cuenta.getId())
            nodo.izquierda = insertarBST(nodo.izquierda, cuenta);
        else if (cuenta.getId() > nodo.cuenta.getId())
            nodo.derecha = insertarBST(nodo.derecha, cuenta);
        return nodo;
    }

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

    // Eliminación estándar de un nodo por id
    private NodoBST eliminarNodoBST(NodoBST nodo, int id) {
        if (nodo == null)
            return null;
        if (id < nodo.cuenta.getId())
            nodo.izquierda = eliminarNodoBST(nodo.izquierda, id);
        else if (id > nodo.cuenta.getId())
            nodo.derecha = eliminarNodoBST(nodo.derecha, id);
        else {
            // encontrado
            if (nodo.izquierda == null)
                return nodo.derecha;
            else if (nodo.derecha == null)
                return nodo.izquierda;
            else {
                // dos hijos: reemplazar por el sucesor mínimo
                NodoBST sucesor = minValueNode(nodo.derecha);
                nodo.cuenta = sucesor.cuenta;
                nodo.derecha = eliminarNodoBST(nodo.derecha, sucesor.cuenta.getId());
            }
        }
        return nodo;
    }

    private NodoBST minValueNode(NodoBST node) {
        NodoBST current = node;
        while (current.izquierda != null)
            current = current.izquierda;
        return current;
    }

    // Recorridos
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

    // ----------------------- Cola de transacciones (demostración de cola/pila)
    // -----------------------
    private void procesarColaTransacciones() {
        // en este ejemplo procesamos inmediatamente—solo para mostrar uso de Queue
        while (!colaTransacciones.isEmpty()) {
            Transaccion t = colaTransacciones.poll();
            // ejemplo de uso: registrar en consola que fue procesada
            System.out.println("Procesada: " + t);
            // aquí podrías también escribir en un log o enviarla a una base de datos
        }
    }
}