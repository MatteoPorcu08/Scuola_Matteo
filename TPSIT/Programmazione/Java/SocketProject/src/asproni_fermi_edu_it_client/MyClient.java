package asproni_fermi_edu_it_client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 9000);
		
		OutputStream out = socket.getOutputStream();
		
		
		String messaggio = "ciao";
		
		out.write(messaggio.getBytes());
	
		
		out.close();
		socket.close();
	}
}
