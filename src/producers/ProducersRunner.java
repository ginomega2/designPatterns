package producers;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProducersRunner {
    public static void main(String[] args) {
        Supplier<Double> darAleatorio = ()->Math.random();
        var aleatorio=darAleatorio.get();
        System.out.println("aleatorio con supplier "+aleatorio);

        Supplier<Double> impuesto16 = ()-> 0.16;
        Supplier<Double> impuesto20 = ()-> 0.20;

        var sueldo=100;
        System.out.println(sueldo*impuesto16.get());
        System.out.println(sueldo*impuesto20.get());

        List<Double> doubleList = List.of(100.0,200.0,300.0,400.0);
        doubleList.forEach(item-> System.out.println(item+" con 16% = "+(item*impuesto16.get())));
        doubleList.forEach(sueldoNeto(impuesto20));

    }

    private static Consumer<Double> sueldoNeto(Supplier<Double> impuesto20) {
        return item -> System.out.println(item+"con 20%  = "+ (item * impuesto20.get()));
    }

}
