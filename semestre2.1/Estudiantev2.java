public class Estudiantev2 {

    private int id;
    private String nombre;
    private String apellido;
    private String facultad;
    private String[] cursos; // nuevo atributo

    // constructor de la clase
    public Estudiantev2(int id, String nombre, String apellido, String facultad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;

    }

    public int getid() {
        return id;
    }

    public String getFacultad() {
        return facultad;
    }

    public String[] getCursos() {
        return cursos;
    }

    // 🔹 1. Método matricularCursos
    public void matricularCursos(int id, String[] cursos) {
        this.cursos = cursos; // guardamos los cursos
        String cad = "";
        f
        }or (int i = 0; i < cursos.length; i++) {
            cad += cursos[i] + " ";
        System.out.println("id:" + id + " → cursos matriculados: " + cad);
    }

    // 🔹 2. Método contar estudiantes por facultad
    public static void contarEstudiantesPorFacultad(Estudiantev2[] est) {
        int contadorIng = 0, contadorPsi = 0, contadorDer = 0;
        for (Estudiantev2 e : est) {
            if (e != null) {
                if (e.getFacultad().equalsIgnoreCase("Ingenieria"))
                    contadorIng++;
                else if (e.getFacultad().equalsIgnoreCase("Psicologia"))
                    contadorPsi++;
                else if (e.getFacultad().equalsIgnoreCase("Derecho"))
                    contadorDer++;
            }
        }
        System.out.println("Estudiantes en Ingenieria: " + contadorIng);
        System.out.println("Estudiantes en Psicologia: " + contadorPsi);
        System.out.println("Estudiantes en Derecho: " + contadorDer);
    }

    // 🔹 3. Método contar estudiantes por curso (con repeticiones)
    public static void contarEstudiantesPorCurso(Estudiantev2[] est) {
        for (int i = 0; i < est.length; i++) {
            if (est[i] != null && est[i].getCursos() != null) {
                for (String curso : est[i].getCursos()) {
                    int contador = 0;
                    for (int j = 0; j < est.length; j++) {
                        if (est[j] != null && est[j].getCursos() != null) {
                            for (String c : est[j].getCursos()) {
                                if (curso.equals(c)) {
                                    contador++;
                                }
                            }
                        }
                    }
                    System.out.println(curso + " → " + contador);
                }
            }
        }
    }

    public String toString() {
        return "Estudiante { id:" + id +
                " nombre:" + nombre +
                " apellido:" + apellido +
                " facultad:" + facultad + "}";
    }
}