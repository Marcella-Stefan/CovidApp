package bitsplease;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class Email {

	List<String> emails;

	public Email(List<String> emails) {
		this.emails = emails;
	}

	Session newSession = null;
	MimeMessage mimeMessage = null;

	public void setupServerProperties() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		newSession = Session.getDefaultInstance(properties, null);
	}

	public void sendEmail() throws MessagingException {
		String fromUser = "Informant4565@gmail.com";
		String fromUserPass = "javaproject";
		String emailHost = "smtp.gmail.com";
		Transport transport = newSession.getTransport("smtp");
		transport.connect(emailHost , fromUser, fromUserPass);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
	}

	public MimeMessage draftEmail(String emailSubject, String emailBody) 
                throws AddressException, MessagingException {

		mimeMessage = new MimeMessage(newSession);

		for (int i = 0 ; i < emails.size() ; i++) {
			mimeMessage.addRecipient(Message.RecipientType.BCC, 
                                new InternetAddress(emails.get(i)));
		}
				
		mimeMessage.setSubject(emailSubject);
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText(emailBody);
		MimeMultipart multiPart = new MimeMultipart();
		multiPart.addBodyPart(bodyPart);
		mimeMessage.setContent(multiPart);
		return mimeMessage;
	}
}
