import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(40000);
        System.out.println("Server in ascolto sulla porta 40000...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Connessione accettata da: " + clientSocket.getInetAddress());

        InputStream input = clientSocket.getInputStream();
        
        // 1. Legge il valore grezzo (da 0 a 255)
        int valoreGrezzo = input.read();
        
        // 2. Il CAST a (byte) forza Java a reinterpretare i numeri > 127 come negativi
        byte numero = (byte) valoreGrezzo;

        // 3. Ora la verifica del segno funziona perfettamente!
        if (numero > 0) {
            System.out.println("Il numero " + numero + " è positivo");
        } else if (numero < 0) {
            System.out.println("Il numero " + numero + " è negativo");
        } else {
            System.out.println("Il numero è zero");
        }

        input.close();
        clientSocket.close();
        serverSocket.close();
    }
}