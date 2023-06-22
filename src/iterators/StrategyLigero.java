package iterators;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyLigero {


    ///***************  USO DE STRATEGY CON LAMBDAS
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        ///******************* USO TRADICIONAL PARA RESOLVER EL PROBLEMA   ******************
        ///*************** SACAMOS EL TOTAL DE LOS VALORES
        System.out.println(totalValues(numbers));       //** funcion normal recibe objeto como parametro y devuelve valor
        System.out.println(totalNumeroPares(numbers));
        System.out.println(totalNumerosImpares(numbers));

        //***********   USO DE HIGH ORDER FUNCTION ES UNA FUNCION QUE RECIBE OTRA FUNCION COMO PARAMTRO Y DEVUELVE UNA FUNCION
        System.out.println(totalValuesHighOrder(numbers, e->true));
        System.out.println(totalValuesHighOrder(numbers, e-> e%2==0));
        System.out.println(totalValuesHighOrder(numbers, e-> e%2!=0));

        //*******   USO DE HIGH ORDER FUNCTION CON METODH REFERENCE
        System.out.println(totalValuesHighOrder(numbers, StrategyLigero::Todos));
        System.out.println(totalValuesHighOrder(numbers, StrategyLigero::Pares));
        System.out.println(totalValuesHighOrder(numbers, StrategyLigero::Impares));
        ///*** EJERCICIOS CREAR

    }

    private static int totalValuesHighOrder(List<Integer> numbers,Predicate<Integer> selector) {

        //***** USO NORMAL
        int total=0;
        for(int numero:numbers){
            if(selector.test(numero))
                total+=numero;
        }
        return total;

        //***** USO CON STREAMS
//        return numbers.stream()
//                .filter(selector)
//                .reduce(0,Integer::sum);
    }

    private static int totalNumerosImpares(List<Integer> numbers) {
        int total=0;
        for(int indice=0;indice<numbers.size();indice++){
            if(numbers.get(indice)%2!=0)
                total+=numbers.get(indice);
        }
        return total;
    }

    private static int totalNumeroPares(List<Integer> numbers) {
        int total=0;
        for(int indice=0;indice<numbers.size();indice++){
            if(numbers.get(indice)%2==0)
                total+=numbers.get(indice);
        }
        return total;
    }

    private static int totalValues(List<Integer> numbers) {  ///////***************   USAMOS ESTRATEGIA DE SUMAR TODO
        int total=0;
        for(int indice=0;indice<numbers.size();indice++){
            total+=numbers.get(indice);
        }
        return total;
    }


    ////***********************  ESTRATEGIAS USADAS EN  **************************
    private static boolean Todos(Integer e) {
        return true;
    }

    private static boolean Pares(Integer e) {
        return e % 2 == 0;
    }

    private static boolean Impares(Integer e) {
        return e % 2 != 0;
    }
}
