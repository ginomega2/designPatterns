package predicates;

import java.util.function.Predicate;

//**** LOS PREDICATES SE USAN COMUNMENTE PARA FILTRAR DATOS
public class PredicatesRunner {
    public static void main(String[] args) {
        Predicate<String> masDe5=cadena->cadena.length()>5;
        String cuatro="1234";
        String seis="123456";

        if(masDe5.test(cuatro)){
            System.out.println(cuatro+ " tiene mas de 5 valido");
        }else {
            System.out.println(cuatro+ " no tiene mas de 5");
        }

        if(masDe5.test(seis)){
            System.out.println(seis+ " tiene mas de 5 valido");
        }else {
            System.out.println(seis+ " no tiene mas de 5");
        }

        Predicate<String> llaveApertura = s -> s.startsWith("{");
        Predicate<String> llaveCierre = s -> s.endsWith("}");
        String cadena="{id:12345}";

        if (llaveApertura.and(llaveCierre).test(cadena)){
            System.out.println("correcto abre y cierra con {} llaves  "+cadena);
        }
        cadena="{id:12345";
        if (llaveApertura.or(llaveCierre).test(cadena)){
            System.out.println("correcto tiene por lo menos una llave   "+cadena);
        }

        cadena="id:12345}";
        if (llaveApertura.negate().and(llaveCierre).test(cadena)){
            System.out.println(" no tiene llave apertura y si tiene de cierre  "+cadena);
        }

        Predicate<String> tieneLlaveAperturayCierre= llaveApertura.and(llaveCierre);

        cadena="{cadena dentro de llaves}";
        if(tieneLlaveAperturayCierre.test(cadena)){
            System.out.println("uso combinado de llaves apertura y cierre "+cadena);
        }

        Predicate<String> tienePorLoMenosUnaLlave= llaveApertura.or(llaveCierre);

        cadena="Esta cadena cuenta con solo una llave}";
        if(tienePorLoMenosUnaLlave.test(cadena)){
            System.out.println("cadena tiene por lo menos una llave de apertura o de cierre: "+cadena);
        }





    }
}
