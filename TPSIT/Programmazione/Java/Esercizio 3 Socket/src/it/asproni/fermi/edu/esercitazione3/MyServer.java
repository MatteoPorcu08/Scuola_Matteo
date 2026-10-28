package it.asproni.fermi.edu.esercitazione3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

	public static void main(String[] args) throws IOException {
		// CREO IL SERVER IN ASCOLTO SULLA PORTA 50000
				ServerSocket serverSocket = new ServerSocket(50005);
				
				System.out.println("Server in esecuzione...");
				
				// METTO IL SERVER IN ATTESA DI RICEVERE UNA CONNESSIONE
				Socket socket = serverSocket.accept();
				
				System.out.println("Client connesso!");
				
				// RECUPERO CANALE PER SCRIVERE AL CLIENT
				OutputStream out = socket.getOutputStream();
				
				// INVIO PRIMO MESSAGGIO
				String messaggio = "Sei conesso al server";
				out.write(messaggio.getBytes()); 
				
				InputStream input = socket.getInputStream();
				
				// ARRAY CHE CONTERRA' I BYTES CHE STO LEGGENDO
				byte[] buffer = new byte[1024];
				int dimensioneDati;
				
				// LEGGO PRIMO MESSAGGIO INVIATO DAL SEVER
				dimensioneDati = input.read(buffer);	
				String messaggio2 = new String(buffer, 0, dimensioneDati);
				System.out.println(messaggio2);
				
				out.close();
				socket.close();
				serverSocket.close();
		
	}
}