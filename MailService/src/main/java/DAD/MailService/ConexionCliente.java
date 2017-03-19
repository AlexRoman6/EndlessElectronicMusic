package DAD.MailService;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

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

	@SuppressWarnings("restriction")
	@Override
	public void run() {

		System.out.println("Cliente Conectado");
		List<String> mensajeRecibido = new ArrayList<>();
		boolean conectado = true;

		System.out.println("Holaaa");

		while (conectado) {
			try {
				mensajeRecibido = (List<String>) entradaDatos.readObject();

				if (mensajeRecibido != null) {

					salidaDatos.writeUTF("Datos recibidos con exito");
					System.out.println(mensajeRecibido.get(0));
					System.out.println(mensajeRecibido.get(1));

					try {

						Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
						final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

						// Get a Properties object
						Properties props = System.getProperties();
						props.setProperty("mail.smtps.host", "smtp.gmail.com");
						props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
						props.setProperty("mail.smtp.socketFactory.fallback", "false");
						props.setProperty("mail.smtp.port", "465");
						props.setProperty("mail.smtp.socketFactory.port", "465");
						props.setProperty("mail.smtps.auth", "true");

						props.put("mail.smtps.quitwait", "false");

						Session session = Session.getInstance(props, null);

						final MimeMessage msg = new MimeMessage(session);

						// -- Set the FROM and TO fields --
						msg.setFrom(new InternetAddress("Dadmusic17@gmail.com"));
						msg.setRecipients(Message.RecipientType.TO,
								InternetAddress.parse(mensajeRecibido.get(1), false));

						msg.setSubject("¡¡Bienvenido a EEM!!");
						msg.setText(
								"Hola " + mensajeRecibido.get(0)
										+ "\n\nTe damos la bienvenida a Endless Electronic Music. Esperemos que disfrutes de las mejores canciones del momento.\n\nUn saludo",
								"utf-8");
						msg.setSentDate(new Date());

						SMTPTransport t = (SMTPTransport) session.getTransport("smtps");

						t.connect("smtp.gmail.com", "Dadmusic17@gmail.com", "endless2017");
						t.sendMessage(msg, msg.getAllRecipients());
						t.close();
						conectado = false;
						try {
							entradaDatos.close();
							salidaDatos.close();
						} catch (IOException ex2) {
						}

					} catch (MessagingException ex) {
						System.out.println("Cliente Desconectado");
						conectado = false;
					}
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Fallo creacion List");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
