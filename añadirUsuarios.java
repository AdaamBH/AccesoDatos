package TinderConActividades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class añadirUsuarios {
    static void annadirUsuarios(String ruta) throws IOException {
        Scanner entrada = new Scanner(System.in);

        int ultimoId = obtenerId(ruta);
        int nuevoId = ultimoId+1;
        System.out.println("El id de usuario es " + nuevoId);

        System.out.println("Escriba la lista de aficiones, separada por espacios");
        String lista = entrada.nextLine();

        FileWriter fileWriter = new FileWriter(ruta, true);
        fileWriter.write("\nU" + nuevoId + " " + lista);
        System.out.println("Usuario y lista de aficiones añadida\n");
        fileWriter.close();
    }

    public static int obtenerId(String ruta) throws IOException {
        Scanner fichero = new Scanner(new File(ruta));

        int ultimoID = 99;

        while (fichero.hasNext()) {
            String lineas = fichero.nextLine();

            String[] palabras = lineas.split(" ");
            String idConLetra = palabras[0];

            int id = Integer.parseInt(idConLetra.substring(1));
            if (id > ultimoID) {
                ultimoID = id;
            }
        }
        return ultimoID;
    }
}
