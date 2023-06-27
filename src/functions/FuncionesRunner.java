package functions;

import java.util.function.Function;

public class FuncionesRunner {
    public static void main(String[] args) {
        //** fuction recibe 2 parametros <Tipoentrada, TipoSalida>
        Function<String, Integer> getTotalLetras = cadena -> cadena.length(); //el tipo de entrada es String y el de salida es Integer
        String mensaje="cuanto caracteres tengo? =";

        var longitud = getTotalLetras.apply(mensaje);
        System.out.println(mensaje+longitud);

        /// encadenar functions
        // relizaremos 2 transformaciones a un dato
        // id=123 cambiar por  {id:12345}
        //1 cambiar el simbolo "=" por ":"
        //2 agregar llaves al inicio y final
        Function<String,String> reemplazaIgual= cadena->cadena.replace("=",":");
        Function<String,String> ponerLlaves = cadena -> "{"+cadena+"}";
        Function<String,String> ponerH1 = cadena ->"<h1>"+cadena+"</h1>";


        String cadena = "id=1234";
        var resultado = reemplazaIgual
                .andThen(ponerLlaves)
                .apply(cadena);
        System.out.println(resultado);

        //**** OTRA FORMA DE HACERLO llamar a compose y com poarametro la sig funcion a encadenar

        resultado= ponerH1.compose(reemplazaIgual.compose(ponerLlaves)).apply(cadena);

        System.out.println(resultado);
        // practica crear uno para html

    }
}
