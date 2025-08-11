public class Estudiantev2 {


    private int id;
    private String nombre;
    private String apellido;
    private String facultad;



    //constructor de la clase 
    public Estudiantev2(int id, String nombre, String apellido, String facultad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;
    }

    public int getid(){
        return id;
    }

    public void matricularCursos(int id, String[] cursos){
        String cad = "";
        for(int i = 0; i < cursos.length; i++){
            cad += cursos[i] + " ";
        }
        System.out.println("id:" + id + "cursos Martriculados:" + cad);
    }
    public String toString() {
        return "Estudiante { id:" + id +
               " nombre:" + nombre + 
               " apellido:" + apellido +  
               " facultad:" + facultad + "}";
    }
}