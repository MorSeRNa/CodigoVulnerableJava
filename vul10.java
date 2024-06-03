import java.util.logging.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InfoDisclosureExample {
    private static final Logger logger = Logger.getLogger(InfoDisclosureExample.class.getName());

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter the first number (a): ");
            String a = reader.readLine();

            System.out.print("Enter the second number (b): ");
            String b = reader.readLine();

            int result = Integer.parseInt(a) / Integer.parseInt(b);
            logger.log(Level.INFO, "Dividing {0} by {1}", new Object[]{a, b});
            System.out.println("Result: " + result);
        } catch (ArithmeticException | NumberFormatException e) {
            logger.log(Level.SEVERE, "Exception occurred: ", e);
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IO Exception occurred: ", e);
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}
