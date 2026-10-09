package asproni_fermi_edu_it_client;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Avvio del server...");

        try (ServerSocket serverSocket = new ServerSocket(50000)) {

            System.out.println("Server in esecuzione sulla porta 50000...");
            System.out.println("In attesa di un client...");

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connesso!");

                InputStream input = socket.getInputStream();

                byte[] buffer = new byte[1024];
                int dimensioneDati = input.read(buffer);

                if (dimensioneDati != -1) {
                    String messaggio = new String(buffer, 0, dimensioneDati);
                    System.out.println("Messaggio ricevuto: " + messaggio);
                }
            }
        }
    }
}