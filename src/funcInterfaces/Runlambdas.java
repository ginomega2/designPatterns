package funcInterfaces;


public class Runlambdas {
    static String guion="-";
    String guionDeInstancia="--";

    public Runlambdas(String mensaje) {
    }

    public Runlambdas() {
    }

    public static void show() {        ////*****  PASO 3  CREAR metodo para llamar a saludar new ConsolePrinterImpl *************************************

        ///***************    HACER CUATRO IPLEMENTACIONES CON LA INTERFAZ PRITER(pasos 5 al 8)
        saludar(new ConsolePrinterImpl()); //**  PASO 5 LLAMADA CON IMPLEMENTACION ConsolePrinterImpl
        saludar(new Printer() {     //**  PASO 6 LLAMADA CON imple anonima
            @Override
            public void imprime(String mensaje) {
                System.out.println("printer anonima" +mensaje);
            }
        });

        //java infiere el tipo de dato mensaje como String porque lo checa contra alguna signatura (formato de llamada) con las interfaces funcionales
        saludar(mensaje -> System.out.println("printer lambda"+mensaje));   //**  PASO 7 LLAMADA CON lambda
        saludar(Runlambdas::print);   //**  PASO 8 convertir en method reference ponerse
        // con el cursos en .out. presionar Alt+Enter y seleccionar Extract to method reference


        //*** TAMBIEN PODEMOS USARLA COMO INA VARIABLE
        //**  PASO 9 ASIGNAR UNA IMPLEMENTACION CONCRETA A UNA VARIABLE
        Printer printer = new ConsolePrinterImpl();
        printer.imprime("implementacion concreta asignada a una variable");
        //**** PASO 10 se puede usar la variable creada printer  y enviarla como parametro
        saludar(printer);

        //***** PASO 11   TAMBIEN PODEMOS ASIGNAR UNA LAMBDA  A UNA VARIABLE
        Printer printerLambda =  mensaje -> System.out.println(mensaje);
        printerLambda.imprime("implementacion con una lambda guradada en una variable");
        saludar(printerLambda); // usamos la variable con lambda en la llamada al metodo

        // **** PASO 12  USO DE OTRAS VARIABLE DENTRO DE UNA LAMBDA variables locales sufijo y prefijo
        String prefijo="<h1>";
        String sufijo="</h1>";
        saludar(mensaje -> System.out.println(prefijo+mensaje+sufijo)); ///***** usamos estilo html <H1>

        // **** PASO 13  USO DE OTRAS VARIABLE estaticas  DENTRO DE UNA LAMBDA
        //     String gion="-";  la pondresmo como static al inicio de la clase
        saludar(mensaje -> System.out.println(guion+mensaje));


        // **** PASO 15 creacion de method reference
        //      Clase/Objeto::metodo  (sin parentesis)
        saludar(System.out::println);//      Clase/Objeto::metodo  (sin parentesis)
        saludar(mensaje -> System.out.println("convertir esto a method reference en la siguiente linea "+mensaje));
        saludar(Runlambdas::print2);    //metodo creado en este mismo objeto
        saludar(mensaje -> print2("print lambda a un metodo de esta clase print2"));
        // **** PASO 16 USAR OBJETOS Y METODOS DE OTRAS CLASES OJO CREAR CLASE Colores
        saludar(mensaje -> Colores.printRojo("en color desde lambda"+mensaje));
        saludar(Colores::printRojo);


        // **** PASO 17 crear metodo de instacia printDeInstancia(String mensaje) EJEMPLO LLAMADA CON UNA INSTANCIA
        Runlambdas demoInstancia= new Runlambdas();
        saludar(mensaje -> demoInstancia.printDeInstancia(mensaje)); /// con lambadas
        saludar(demoInstancia::printDeInstancia);   //con method reference

        //***** PASO 18 COMO llamar y PASAR UN VALOR AL CONTRUCTOR  CREAR UN CONSTRUCTOR PARA ESTA CLASE
        saludar(mensaje -> new Runlambdas("mensaje desde contrctor"));
        saludar(Runlambdas::new);


        //***** IMPRIMIR EN ARCHIVO
        var archivo = new FilePrinterImpl();
        archivo.imprime("esto se va al archivo");
//        saludar(archivo);




    }

    public void printDeInstancia(String mensaje){
        System.out.println(" print de instancia "+mensaje);
    }

    private static void print2(String mensaje) {
        System.out.println("printer con referencia a metodo" + mensaje);
    }

    // **** PASO 14  USO DE OTRAS VARIABLE de instancia  DENTRO DE UNA LAMBDA
    public void showDeInstancia(){
        //     String gion="--";  la pondresmo como miembro de instancia de la clase solo puede ser usado con un new
        saludar(mensaje -> System.out.println(this.guionDeInstancia+mensaje+" instancia creada con new"));


    }

    public static void saludar(Printer printer) {  ////*****     PASO 4  CREAR metodo para llamar a saludar new ConsolePrinterImpl *************************************
        printer.imprime(" saludar ");
    }


    public static void print(String mensaje) {
        System.out.println("printer method reference runner::print" + mensaje);
    }
}
