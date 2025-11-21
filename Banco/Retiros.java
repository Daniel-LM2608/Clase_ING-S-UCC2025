public class Retiros {
    /**
     * Ejecuta un retiro en la cuenta. Retorna true si fue exitoso.
     * Para cuentas especiales (ej. Crédito) se podrá sobrescribir comportamiento.
     */
    public static boolean ejecutar(Cuenta cuenta, double monto) {
        if (cuenta == null) return false;
        return cuenta.retirar(monto);
    }
}