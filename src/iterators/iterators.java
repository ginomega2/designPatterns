package iterators;

import java.util.Arrays;
import java.util.List;

public class iterators {
    public static void main(String[] args) {
        ///*********** USO DE EXTERNAL ITERATORS   *****************
        List <Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        ///**************programacion imperativa
        for(int indice = 0 ; indice<numbers.size();indice++){//** usamos indice para recorrer la lista  aka --- external iterator
            System.out.println("elemento :"+numbers.get(indice));

        }

        for (int number : numbers) { ///********* external iterator
            System.out.println("elemento"+number);
        }

        //**************** INTERNAL ITERATOR   ******************
        numbers.forEach(numero -> System.out.println("internal iterator"+numero));
        List<Persona> personaList = Arrays.asList(
                new Persona(1,"pedro",100),
                new Persona(2,"pedro2",100),
                new Persona(3,"pedro3",100),
                new Persona(4,"pedro4",100),
                new Persona(5,"pedro5",100)

                );

        ///********  USO DE INTERFAZ FUNCIONAL  CON ONTERNAL ITERATORS
        personaList.forEach(persona -> new PuedeDarPremioImpl(persona).premiar());
        personaList.forEach(persona -> System.out.println(persona));

        //**** EJERCICIO CREAR EXPRESIONES LAMBDA CON INTERFACES FUNCIONALES
        //****  SACAR LOS IMPUESTOS Y EL SUELDO NETO BRUTO DE UNA PERSONA CON LAMBDAS





    }
}
