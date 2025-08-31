public class ejecutarlibro {
    public static void main(String[] args) {
        libro[] L = new libro[5];

        L[0] = new libro ("libro1", "autor1", 100); 
        L[1] = new libro ("libro2", "autor2", 90); 
        L[2] = new libro ("libro3", "autor3", 50); 
        L[3] = new libro ("libro4", "autor4", 100); 
        L[4] = new libro ("libro5", "autor5", 67); 

        System.out.println(L[0].iterarLibro(L));
        System.out.println("Precio total de todos los libros: "  + L[0].totalPrecios(L));
     }
}
                     