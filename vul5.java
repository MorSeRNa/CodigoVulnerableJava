import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LackOfAccessControlExample {
    public static void main(String[] args) {
        // Crear un BufferedReader para leer la entrada del usuario desde la consola
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the file name: ");

        try {
            String fileName = consoleReader.readLine();
            String currentDir = System.getProperty("user.dir");
            File file = new File(currentDir + "/ZAP_2.14.0/" + fileName);

            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
