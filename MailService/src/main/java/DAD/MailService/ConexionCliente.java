package DAD.MailService;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConexionCliente extends Thread implements Observer {

	private Socket socket;

	private ObjectInputStream entradaDatos;
	private DataOutputStream salidaDatos;

	public ConexionCliente(Socket socket) {
		this.socket = socket;

		try {

			entradaDatos = new ObjectInputStream(socket.getInputStream());
			salidaDatos = new DataOutputStream(socket.getOutputStream());

		} catch (IOException ex) {
			System.out.println("Fallo creada stream");
			ex.printStackTrace();
		}
	}

	@Override
	public void run() {

		System.out.println("Cliente Conectado");
		List<String> mensajeRecibido = new ArrayList<>();
		boolean conectado = true;

		try {

			System.out.println("Holaaa");

			while (conectado) {
				try {
					mensajeRecibido = (List<String>) entradaDatos.readObject();
					if (mensajeRecibido != null) {
						salidaDatos.writeUTF("Datos recibidos con exito");
						System.out.println(mensajeRecibido.get(0));
						System.out.println(mensajeRecibido.get(1));

						ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

						EMail mm = (EMail) context.getBean("mailMail");
						
						try {
							
							mm.sendMail("Dadmusic17@gmail.com", mensajeRecibido.get(1), "¡¡Bienvenido a EEM!!", "Hola "
									+ mensajeRecibido.get(0)
									+ "\n\nTe damos la bienvenida a Endless Electronic Music. Esperemos que disfrutes de las mejores canciones del momento.\n\nUn saludo");
							
						} catch (Exception e) {
							System.out.println("Error envio MAIL");
							e.printStackTrace();
						}
						
						salidaDatos.writeUTF("Correo Enviado Correctamente");

					}

				} catch (IOException ex) {
					System.out.println("Cliente Desconectado");
					conectado = false;

					try {
						entradaDatos.close();
						salidaDatos.close();
					} catch (IOException ex2) {
					}
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fallo creacion List");
			e.printStackTrace();
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			// Envia el mensaje al cliente
			salidaDatos.writeUTF("Datos recibidos con exitooooo");
		} catch (IOException ex) {
			System.out.println("Fallo update");
			ex.printStackTrace();
		}
	}

}
