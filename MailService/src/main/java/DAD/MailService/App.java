package DAD.MailService;

import java.net.*;
import java.io.*;

public class App {

	public static void main(String[] args) {

		int puerto = 1234;
		int maximoConexiones = 10; // Maximo de conexiones simultaneas
		ServerSocket servidor = null;
		Socket socket = null;

		try {
			// Se crea el serverSocket
			servidor = new ServerSocket(puerto, maximoConexiones);

			while (true) {

				System.out.println("Servidor Activo");
				
				socket = servidor.accept();

				ConexionCliente cc = new ConexionCliente(socket);
				cc.start();

			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Fallo APP");
		} finally {
			try {
				socket.close();
				servidor.close();
			} catch (IOException ex) {

				ex.printStackTrace();
			}
		}
	}

}
