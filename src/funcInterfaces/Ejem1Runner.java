package funcInterfaces;

@FunctionalInterface
 interface MiInterfazFuncional {
    int aplicar(int a, int b);
}
public class Ejem1Runner {
    public static void main(String[] args) {
        MiInterfazFuncional miFuncion = ((a, b) -> a+b);
        System.out.println(miFuncion.aplicar(10,20));
        miFuncion=(a, b) -> a*b;
        System.out.println(miFuncion.aplicar(10,20));

    }
}
