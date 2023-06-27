package consumer;

import funcInterfaces.Colores;

import java.util.List;
import java.util.function.Consumer;

public class runner {
    public static void main(String[] args) {

        //ASIGNACION DE UNA IMPLEMENTACION ANONIMA A UNA VARIABLE
        var sueldoNeto16 = new ImpuestoGrabavle() {
            @Override
            public double grabar(double sueldoBruto) {
                return sueldoBruto * .16;
            }
        };
        ImpuestoGrabavle sueldoNeto20 = (item)-> item*.20;

        System.out.println(" *************** usamos descuento de 16 y de 20 % a un elemento ************** ");
        System.out.println("16% a 100 de impuesto  "+sueldoNeto16.grabar(100));
        System.out.println("20% a 100 de impuesto "+sueldoNeto20.grabar(100));

        System.out.println(" *************** usamos descuento de 16 y de 20 %  a toda la lista   ************** ");

        List<Double> integerList= List.of(100.0,200.0,300.0,400.0,500.0);
        integerList.forEach(item -> sueldoNeto20.grabar(item));
        integerList.forEach(item -> sueldoNeto16.grabar(item));

        for (var item:integerList){
            System.out.println(item);
        }
        //  integerList.forEach(); espera un consumer como parametro
        integerList.forEach(item -> System.out.println(item) );
        integerList.forEach(item -> Colores.printRojo(item.toString()));


        //************************************ encadenando consumers   *******************
        System.out.println(" *************** CREAMOS consumers   ************** ");
        List<String>stringList=List.of("a","b","c");
        //***** PASO 1 CREAR VARIABLES TIPO CONSUMER CON EL CODIGO QUE QUEREMOS EJECUTAR EN ESTE CASO SOLO UN PRINTLN
        Consumer<String> soutItem = item-> System.out.println(item);    // creamos variable soutItem tipo consumer
        stringList.forEach(soutItem);       //llamada al cosumer esta linea y la siguiente son equivalemtes hacen lo mismo
        // stringList.forEach(item-> System.out.println(item));

        Consumer<String> soutItemRojo = item->Colores.printRojo(item); // 1.1 creamos variable soutItemRojo tipo consumer
        stringList.forEach(soutItemRojo);

        Consumer<String> soutItemUpper = item-> System.out.println(item.toUpperCase()); // 1.2 creamos variable soutItemUpper tipo consumer
        stringList.forEach(soutItemUpper);
        System.out.println(" *************** CREAMOS ENCADENAMIENTO cn 2 consumers   ************** ");
        //*************** CREAMOS ENCADENAMIENTO   **************
        stringList.forEach(soutItem.andThen(soutItemRojo));
        System.out.println(" *************** CREAMOS ENCADENAMIENTO cn 3 consumers   ************** ");
        //*************** CREAMOS ENCADENAMIENTO   **************
        stringList.forEach(soutItemUpper.andThen(soutItem.andThen(soutItemRojo)));
    }

    private void noHaceNada(){

//        //ASIGNACION DE UNA IMPLEMENTACION ANONIMA A UNA VARIABLE
//        var misueldo = new ImpuestoGrabavle() {
//            @Override
//            public double grabar(double ingreso) {
//                return ingreso * .16;
//            }
//        };
//        System.out.println(misueldo.grabar(100));


    }

}

