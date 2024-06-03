import java.sql.*;
import java.util.Scanner;

public class SQLInjectionExample {
    public static void main(String[] args) {
        // Crear un scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        // Conectar a la base de datos SQLite y ejecutar la consulta
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:example.db");
             Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM users WHERE id = " + userId;
            ResultSet rs = stmt.executeQuery(query);

            // Imprimir los resultados
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name") + ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
