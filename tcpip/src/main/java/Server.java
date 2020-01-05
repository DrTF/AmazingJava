import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
