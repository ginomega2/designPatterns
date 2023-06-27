package funcInterfaces;

////**********************     PASO 2  CREAR IMPLEMENTACION ConsolePrinterImpl *************************************
public class ConsolePrinterImpl implements Printer {
    @Override
    public void print(String mensaje) {
        System.out.println("console printer "+mensaje);

    }
}

