/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionModelo;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Ryzen 5
 */
public class EnviarGuia {

    public EnviarGuia() throws MessagingException {
        realizarEnvioGuia();
    }

    public void realizarEnvioGuia() throws MessagingException {
        Properties props = propiedadEnvio();
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);

        MimeMessage message = crearMensaje(session);

        Transport t = session.getTransport("smtp");
        t.connect("yepesmolina23@gmail.com", "bailando124");
        t.sendMessage(message, message.getAllRecipients());
        t.close();

    }

    public Properties propiedadEnvio() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "yepesmolina23@gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        return props;
    }

    public MimeMessage crearMensaje(Session session) throws MessagingException {
        BodyPart texto = new MimeBodyPart();
        texto.setText("Texto del mensaje");

        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource("c:/hola.txt")));
        adjunto.setFileName("hola.txt");

        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
        multiParte.addBodyPart(adjunto);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("mayra.yepes@correounivalle.edu.co"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("mayra.yepes@correounivalle.edu.co"));
        message.setSubject("Hola");
        message.setContent(multiParte);
        return message;
    }

    public static boolean validaEmail(String correo) {
        boolean bandera = false;
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        if (mather.find() == true) {
            bandera = true;
        }
        return bandera;
    }

}
