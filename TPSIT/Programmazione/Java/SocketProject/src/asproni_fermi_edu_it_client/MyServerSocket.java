package asproni_fermi_edu_it_client;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

    public MyServerSocket(int port) throws IOException {
        public static void main(String[] args) {
        ServerSocket server = new ServerSocket(50000);
        System.out.println("Server started on port " + port);
        Socket clientSocket = server.accept();
        System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
        InputStream input = clientSocket.getInputStream();
        byte[] dati = new byte[1024];
        int bytesRead = input.read(dati);
        String message = new String(dati, 0, bytesRead);
        System.out.println("Received message: " + message);
        server.close();
    }
}
}