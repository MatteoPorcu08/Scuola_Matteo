package asproni_fermi_edu_it_client;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.net.UnknownHostException;

public class MyClientSocket {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.3.57", 50000), 5000);
        System.out.println("Connected to server: " + socket.getInetAddress());
        OutputStream out = socket.getOutputStream();
        out.write("Ciao Sono Matteo".getBytes());
        out.flush();
        socket.close();
    }
}