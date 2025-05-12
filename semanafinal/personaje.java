import java.util.Random;

public class Personaje {
    private String nombre;
    private int puntosDeVida;
    protected final int MAX_DANO = 30;
    protected final int MIN_DANO = 10;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100; // Todos comienzan con 100 puntos de vida
    }
     // Método para calcular el daño base, accesible solo para las subclases
    protected int calcularDanoBase() {
        Random rand = new Random();
        return rand.nextInt((MAX_DANO - MIN_DANO) + 1) + MIN_DANO;
    }

    public void atacar(Personaje oponente) {
       
        int DanoBase = calcularDanoBase();
        oponente.recibirDano(DanoBase);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() +
                           " causando " + dano + " puntos de daño.");
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
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
}
