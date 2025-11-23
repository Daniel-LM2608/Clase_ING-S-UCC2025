// Clase abstracta Cuenta
// Representa la estructura general de una cuenta bancaria.
// Sirve como clase base para diferentes tipos de cuentas (Ahorros, Corriente, Crédito, etc.).
// Define atributos y métodos comunes, pero deja algunos métodos abstractos
// para que cada tipo de cuenta los implemente según sus reglas.

public abstract class Cuenta {

    private int id;              // Identificador único de la cuenta
    protected double montoActual; // Saldo actual de la cuenta (puede ser negativo si es de crédito)

    // Constructor
    // Recibe un ID y un monto de apertura inicial.
    public Cuenta(int id, double apertura) {
        this.id = id;
        this.montoActual = apertura; // Establece el saldo inicial
    }

    // Getter: obtiene el ID de la cuenta
    public int getId() {
        return id;
    }

    // Setter: permite cambiar el ID de la cuenta
    public void setId(int id) {
        this.id = id;
    }

    // Getter: obtiene el saldo actual
    public double getMontoActual() {
        return montoActual;
    }

    // Setter: modifica el saldo actual
    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }

    // Método abstracto: apertura o ingreso de dinero
    // Cada tipo de cuenta decidirá cómo se maneja un depósito.
    public abstract void apertura(double monto);

    // Método abstracto: devuelve el saldo disponible
    // Las cuentas de crédito podrían devolver un saldo negativo.
    public abstract double consultarSaldo();

    // Método abstracto: representación textual de la cuenta
    // Cada subclase lo implementa con su propio estilo.
    @Override
    public abstract String toString();
}