import java.util.Random;

public class InsecureRandomnessExample {
    public static void main(String[] args) {
        // Crear una instancia de Random
        Random random = new Random();
        
        // Generar un token aleatorio
        int token = random.nextInt(999999);
        
        // Mostrar el token en la consola
        System.out.println("Your security token is: " + token);
    }
}
