package es.open4job.socket;

import java.io.*;
import java.net.*;

public class HelloServer {

	public static void main(String args[]) {

		ServerSocket echoServer = null;
		String line;
		DataInputStream is;
		PrintStream os;
		Socket clientSocket = null;

		// Abrir un socket de servidor en el puerto 9999
		try {
			echoServer = new ServerSocket(9999);
		} catch (IOException e) {
			System.out.println(e);
		}

		// Creamos un objeto socket para escuchar y aceptar conexiones
		try {
			
			clientSocket = echoServer.accept();
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			while (true) {
				line = is.readLine();
				os.println(line);
			}
			
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}