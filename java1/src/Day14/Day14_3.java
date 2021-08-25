package Day14;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Day14_3 {
	public static void main(String args[]) {
		sendMail();
	}

/**
* SendMail
*/
	public static void sendMail() {
		
		// 이메일 객체생성하기
		Properties props = System.getProperties();
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.ssl.enable", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.transport.protocol", "smtp");
		final String username = "kjsmrs0403@gmail.com";//
		final String password = "비밀번호";

		try{
		    Session session = Session.getDefaultInstance(props, 
		    new Authenticator(){
		    protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(username, password);
		}});

		//메세지 설정
		Message msg = new MimeMessage(session);

		//보내는사람 받는사람 설정
		msg.setFrom(new InternetAddress("kjsmrs0403@gmail.com"));
		msg.setRecipients(Message.RecipientType.TO, 
							InternetAddress.parse("mrs0403@naver.com",false));
		msg.setSubject("제목입니다");
		msg.setText("\n내용입니다");
		msg.setSentDate(new Date());
		Transport.send(msg);
		System.out.println("발신성공!");

		}catch (MessagingException error){ 
			System.out.println("에러가 발생했습니다: " + error);
		}
		
	}
}