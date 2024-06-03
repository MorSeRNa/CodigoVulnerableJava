public class ExposeStackTraceExample {
    public static void main(String[] args) {
        try {
            // Simular un error
            throw new Exception("An error occurred");
        } catch (Exception e) {
            e.printStackTrace(System.out); // Exponer la traza de la pila en la consola
        }
    }
}
