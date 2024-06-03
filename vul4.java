import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ShellInjectionExample {
    public static void main(String[] args) {
        // Crear un scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter host to ping: ");
        String host = scanner.nextLine();

        // Ejecutar el comando ping usando Runtime.getRuntime().exec()
        try {
            Process process = Runtime.getRuntime().exec("ping " + host);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            PrintWriter out = new PrintWriter(System.out);
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
