package iterators;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static iterators.PuedeDarPremio.premiar;
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

        Persona persona2 = new Persona(1,"kkk",2.0);


        ///********  USO DE INTERFAZ FUNCIONAL  CON ONTERNAL ITERATORS
        personaList.forEach( persona -> PuedeDarPremio.premiar(persona));
        personaList.forEach(System.out::println);


        ///********  USO DE INTERFAZ FUNCIONAL  ethod reference
        personaList.forEach(PuedeDarPremio::premiar);
        personaList.forEach(System.out::println);
        personaList.forEach(persona -> new PuedeDarPremioImpl().premiar(persona));
        personaList.forEach(System.out::println);

        personaList.forEach(persona -> premiar(persona));
        personaList.forEach(System.out::println);

        personaList.forEach(dalePremio());
        personaList.forEach(System.out::println);



        personaList.forEach(System.out::println);


    }

    private static Consumer<Persona> dalePremio() {
        return persona -> premiar(persona);
    }


}
