import java.util.Random;

public class Personaje {
    private String nombre;
    private int puntosDeVida;
    protected final int MAX_DANO = 30;
    protected final int MIN_DANO = 10;
    private int defensa; // Atributo para la defensa

    public Personaje(String nombre, int defensa) {
        this.nombre = nombre;
        this.puntosDeVida = 100; // Todos comienzan con 100 puntos de vida
        this.defensa = defensa;

    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    // Método para calcular el daño base, accesible solo para las subclases
    protected int calcularDanoBase() {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
        System.out.println("Daño base generado: " + dano);
        return dano;
    }

    public void atacar(Personaje oponente) {

        int DanoBase = calcularDanoBase();
        oponente.recibirDano(DanoBase);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() +
                " causando " + DanoBase + " puntos de daño.");
    }

    public void recibirDano(int dano) {
        int danoReducido = dano - this.defensa;
        // Aseguramos que el daño no sea negativo
        if (danoReducido < 0) {
            danoReducido = 0;
        }

        this.puntosDeVida = Math.max(0, this.puntosDeVida - danoReducido);
        // asegurar que los puntos de vida no bajen de 0, sin necesidad de usar un if.

        System.out.println(
                this.nombre + " recibe " + danoReducido + " puntos de daño tras aplicar su defensa de " + this.defensa);

        if (this.puntosDeVida == 0) {
            System.out.println(this.nombre + " ha sido derrotado.");
        }
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }

    public String toString() {
        return nombre + " (HP: " + puntosDeVida + ", DEF: " + defensa + ")";
    }
}
