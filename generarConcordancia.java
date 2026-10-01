package TinderConActividades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Scanner;

public class generarConcordancia {
    static void generar(String ruta) throws IOException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Número mínimo de aficiones comunes:");
        int minimo = entrada.nextInt();

        ArrayList<Usuario> usuarios = obtenerUsuarios(ruta);
        FileWriter fichero = new FileWriter("concordancias.txt");

        int parejas = 0;
        for (int i = 0; i < usuarios.size(); i++) {

            for (int j = i + 1; j < usuarios.size(); j++) {
                Usuario usuario1 = usuarios.get(i);
                Usuario usuario2 = usuarios.get(j);

                ArrayList<String> comunes = (ArrayList<String>) aficionesComunes(usuario1, usuario2);
                if (comunes.size() >= minimo) {

                    fichero.write(usuario1.id + " ");
                    fichero.write(usuario2.id + " ");

                    for (String aficion : comunes) {
                        fichero.write(aficion + " ");
                    }
                    fichero.write("\n");

                    parejas++;
                }
            }
        }
        System.out.println("Se han encontrado " + parejas + " parejas.");
    }


    static ArrayList<Usuario> obtenerUsuarios(String ruta) throws IOException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        Scanner fichero = new Scanner(new File(ruta));

        while (fichero.hasNextLine()) {

            String linea = fichero.nextLine();
            String[] datos = linea.split(" ");
            String id = datos[0];

            String[] aficiones = new String[datos.length - 1];

            for (int i = 1; i < datos.length; i++) {
                aficiones[i - 1] = datos[i];
            }

            Usuario usuario = new Usuario(id, aficiones);
            usuarios.add(usuario);
        }
        return usuarios;
    }


    static AbstractList<String> aficionesComunes(Usuario usuario1, Usuario usuario2) {
        ArrayList<String> comunes = new ArrayList<>();

        for (int i = 0; i < usuario1.aficiones.length; i++) {
            for (int j = 0; j < usuario2.aficiones.length; j++) {
                if (usuario1.aficiones[i].equals(usuario2.aficiones[j])) {
                    comunes.add(usuario1.aficiones[i]);
                }
            }
        }
        return comunes;
    }
}