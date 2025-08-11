public class Estudiantev2 {


    private int 








    //constructor de la clase 
    public Estudiante(int id, string nombre, string apellido, string facultad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultad = facultad;
    }

    public int getid(){
        return id;
    }

    public void matricularCursos(int id, string[] cursos){
        string cad = "";
        for(int i = 0; i < cursos.lenght; i++){
            cad += cursos[i] + " ";
        }
        System.out.println("id:" + id + "cursos Martriculados:" + cad);
    }
}