package TinderConActividades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        String ruta;

        boolean existe = false;
        do {
            System.out.println("Nombre del fichero: ");
            ruta = entrada.nextLine() + ".txt";
            File file = new File(ruta);

            if (!file.exists()) {
                FileWriter fileWriter = new FileWriter(ruta);
                System.out.println("Fichero creado");
                existe = true;
            } else {
                System.out.println("Fichero ya exixstente.");
                existe = true;
            }
        } while (!existe);

        int opcion;
        do {
            System.out.println("========== Menu Principal ==========\n");
            System.out.println("1. Añadir usuario\n");
            System.out.println("2. Mostrar usuarios introducidos\n");
            System.out.println("3. Generar fichero de concordancia\n");
            System.out.println("4. Salir");
            System.out.println("==============================\nSeleccione una opción:");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> new añadirUsuarios().annadirUsuarios(ruta);
                case 2 -> mostrarUsuarios.mostrar(ruta);
                case 3 -> generarConcordancia.generar(ruta);
            }
        } while (opcion != 4);

    }
}
