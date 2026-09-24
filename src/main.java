import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);

        boolean existe = false;
        do {
            System.out.println("Nombre del fichero: ");
            String ruta = entrada.nextLine() + ".txt";
            File file = new File(ruta);

            if (!file.exists()) {
                FileWriter fileWriter = new FileWriter(ruta);
                System.out.println("Fichero creado");
                existe = true;
            } else {
                System.out.println("Fichero ya exixstente, intentelo de nuevo.");
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

            }
        } while (opcion != 4);

    }
}
