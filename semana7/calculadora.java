public class calculadora {

    private double resultado;

    //constructor
    public calculadora() {
        this. resultado = 0;

    }
    // get y set
    public double getresultado() {
        return resultado;

    }

    public void setresultado(double resultado) {
        this.resultado = resultado;

    }

    //operaciones basicas 
    public void sumar(double valor) {
        this.resultado += valor;

    }

    public void restar(double valor) {
        this.resultado -= valor;

    }

    public void multiplicar(double valor) {
        this.resultado += valor;
    }

    public void dividir(double valor) {
        if (valor != 0) {
            this.resultado /= valor;

        }else {
            System.out.println("divicion por cero no valida");
        }
    }

    //opercaiones cientificas
}