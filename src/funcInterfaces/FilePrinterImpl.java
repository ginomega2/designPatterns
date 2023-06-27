package funcInterfaces;

import java.io.*;
import java.util.Scanner;

public class FilePrinterImpl implements Printer {
    @Override
    public void imprime(String mensaje) {
        File file = new File("src/hello.html");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String pagina = String.format("""
                <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
                <html>
                <head>
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    <title>Create Empleado</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
                                        
                </head>
                <body>
                                        
                <nav class="navbar bg-primary border-bottom border-bottom-dark navbar-expand-lg" data-bs-theme="dark">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="/mvc/displayEmpleados">Functional Interfaces</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="/mvc/displayEmpleados">funcion1</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/mvc/showCreate">funcion2</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">lambda1</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link disabled">lambda2</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                                        
                                        
                                        
                MENSAJE RECIBIDO: <input type="text" name="nombre" VALUE="%s"/>
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
                                        
                </body>
                </html>
                        """+
                "<h1>HOLA ESTO FUE CREADO CON UNA INTERFAZ FUNCIONAL "+mensaje+"</h1>",mensaje);

        printWriter.println(pagina);

        // once you are done writing to the file
        printWriter.flush();
        printWriter.close();

        // read example
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

    }
}