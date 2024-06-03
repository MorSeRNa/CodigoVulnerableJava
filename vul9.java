import java.nio.ByteBuffer;

public class BufferOverflowExample {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10); // Small buffer size
        String input = "This input string is too long for the buffer";
        for (char c : input.toCharArray()) {
            buffer.put((byte) c); // No bounds checking
        }
        System.out.println("Buffer contents: " + new String(buffer.array()));
    }
}
