package es.open4job.socket;

import java.io.*;
import java.net.*;

public class SmtpClient {

	public static void main(String[] args) {

		Socket smtpSocket = null;
		DataOutputStream os = null;
		DataInputStream is = null;

		// Conectar al servidor por el puerto SMTP (25)
		try {
			
			smtpSocket = new Socket("hostname", 25);
			os = new DataOutputStream(smtpSocket.getOutputStream());
			is = new DataInputStream(smtpSocket.getInputStream());
		
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: hostname");
		} catch (IOException e) {
			System.err
					.println("Couldn't get I/O for the connection to: hostname");
		}

		// If everything has been initialized then we want to write some data
		// to the socket we have opened a connection to on port 25
		if (smtpSocket != null && os != null && is != null) {
			
			try {
				
				// Meter en el canuto de salida el correo a enviar
				os.writeBytes("HELO\n");
				os.writeBytes("MAIL From: info@neodoo.es\n");
				os.writeBytes("RCPT To: info@neodoo.es\n");
				os.writeBytes("DATA\n");
				os.writeBytes("From: info@neodoo.es\n");
				os.writeBytes("Subject: Prueba\n");
				os.writeBytes("Hola\n"); // message body
				os.writeBytes("\n.\n");
				os.writeBytes("QUIT");
		
				// Leemos del canuto de entrada hasta recibir el "Ok"
				String respuesta;
				while ((respuesta = is.readLine()) != null) {
					System.out.println("Servidor: " + respuesta);
					if (respuesta.indexOf("Ok") != -1) {
						break;
					}
					
				}
			
				// Cerramos los recursos
				os.close();
				is.close();
				smtpSocket.close();
			
			} catch (UnknownHostException e) {
				System.err.println("Trying to connect to unknown host: " + e);
			} catch (IOException e) {
				System.err.println("IOException:  " + e);
			}
			
		}
		
	}

}
