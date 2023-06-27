package funcInterfaces;

//*** PASO 16 CREAR OBJETO COLORES
public class Colores {
    public static final String RESET = "\u001B[0m";
    //***************   COLOR DE LETRA   ********************************
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static void printRojo(String mensaje){
        System.out.println(ROJO+mensaje+RESET);
    }
}
