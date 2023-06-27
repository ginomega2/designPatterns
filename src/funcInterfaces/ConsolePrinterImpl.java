package funcInterfaces;

////**********************     PASO 2  CREAR IMPLEMENTACION ConsolePrinterImpl *************************************
public class ConsolePrinterImpl implements Printer {
    @Override
    public void imprime(String mensaje) {
        System.out.println("console printer "+mensaje);

    }
}

