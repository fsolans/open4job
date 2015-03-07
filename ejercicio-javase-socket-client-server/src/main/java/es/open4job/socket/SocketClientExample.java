package es.open4job.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientExample {

	public static void main(String[] args) throws UnknownHostException,
			IOException, ClassNotFoundException, InterruptedException {

		
		InetAddress host = InetAddress.getLocalHost();
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		for (int i = 0; i < 5; i++) {
			
			// Conectar con el servidor
			socket = new Socket(host.getHostName(), 9876);
			
			// Escribe en el canuto de salida
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("Enviando petición al socket del servidor");
			if (i == 4)
				oos.writeObject("exit");
			else
				oos.writeObject("" + i);
			
			// Lee la respuesta
			ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			System.out.println("Mensaje: " + message);
			
			// Cerramos los recursos
			ois.close();
			oos.close();
			
			Thread.sleep(100);

		}

	}

}
