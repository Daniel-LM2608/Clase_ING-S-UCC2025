import java.util.ArrayList;

public class GestorDeCuentas {

    private ArrayList<Cuenta> cuentas;
    private int generadorID = 1; // Para asignar IDs únicos

    public GestorDeCuentas() {
        cuentas = new ArrayList<>();
    }

    // Crear una cuenta nueva
    public Cuenta crearCuenta(String tipo, double montoInicial) {

        Cuenta nueva = null;

        int idAsignado = generadorID; 
        generadorID++; 

        switch (tipo.toLowerCase()) {
            case "ahorro":
                nueva = new Ahorro(idAsignado, montoInicial, 0);
                break;
            case "debito":
                nueva = new Debito(idAsignado, montoInicial, 0);
                break;
            case "credito":
                nueva = new Credito(idAsignado, montoInicial, 0);
                break;
            default:
                System.out.println("Tipo de cuenta inválido.");
                return null;
        }

        cuentas.add(nueva);
        System.out.println("Cuenta creada con éxito. ID asignado: " + idAsignado);
        return nueva;
    }

    // Cuántas cuentas existen
    public int totalCuentas() {
        return cuentas.size();
    }
}

