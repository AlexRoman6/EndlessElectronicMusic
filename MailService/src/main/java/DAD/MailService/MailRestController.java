package DAD.MailService;

import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sun.mail.smtp.SMTPTransport;


@RestController

public class MailRestController {

	@GetMapping(value = "/user/{user}/mail/{nameM}/{server}/{ext}")
	public ResponseEntity<String> getAnuncio(@PathVariable String user, @PathVariable String nameM, @PathVariable String server, @PathVariable String ext) {

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
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(nameM + "@" + server + "." + ext, false));

			msg.setSubject("¡¡Bienvenido a EEM!!");
			msg.setText(
					"Hola " + user
							+ "\n\nTe damos la bienvenida a Endless Electronic Music. Esperemos que disfrutes de las mejores canciones del momento.\n\nUn saludo",
					"utf-8");
			msg.setSentDate(new Date());

			SMTPTransport t = (SMTPTransport) session.getTransport("smtps");

			t.connect("smtp.gmail.com", "Dadmusic17@gmail.com", "endless2017");
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();

		} catch (MessagingException ex) {
			System.out.println("Cliente Desconectado");
		}

		return new ResponseEntity<>("Correo Enviado Con éxito a "+ user + ": " + nameM + "@" + server + "." + ext, HttpStatus.OK);

	}

}
