import java.security.MessageDigest;

public class WeakHashingAlgorithm {
    public static void main(String[] args) throws Exception {
        String password = "secret";
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        System.out.println("Hashed password: " + sb.toString());
    }
}
