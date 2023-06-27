package funcInterfaces;

import java.io.IOException;

@FunctionalInterface
////**********************     PASO 1  CREAR INTERFA FUNCIONAL *************************************
public interface Printer {
    void imprime(String mensaje) ;
}

////**********************     PASO 2  CREAR IMPLEMENTACION ConsolePrinterImpl *************************************