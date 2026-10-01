package TinderConActividades;

import java.io.*;
import java.util.Scanner;

public class mostrarUsuarios {
    static void mostrar(String ruta) throws IOException {
        StringBuilder informacion = new StringBuilder();
        Scanner entrada = new Scanner(new FileReader(ruta));

        while (entrada.hasNext()) {
            informacion.append(entrada.nextLine()).append("\n");
        }
        System.out.println(informacion);
    }
}
