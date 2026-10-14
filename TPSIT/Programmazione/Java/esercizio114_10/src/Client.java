import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 50000);
        OutputStream output = socket.getOutputStream();

        int numero = -5;
        
        output.write(numero); // Invia il singolo byte

        output.close();
        socket.close();
    }
}