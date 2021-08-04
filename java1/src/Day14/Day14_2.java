//package Day14;
//
//import java.util.Properties;
//import java.util.Scanner;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class Day14_2 {
//	
//	// 외부 API : java mail[네이버메일기준]
//	// 메일 : SMTP : Simple Mail Transfer Protocol
//		// 프로토콜 : 통신 규약
//	
//	// 1. 메일 관련 라이브러리 다운로드
//		// 1. activation.jar
//		// 2. mail-1.4.7.jar
//	// 2. 외부 라이브러리를 현재 프로젝트에 추가
//		// 1. 현재 프로젝트 오른쪽 클릭 
//		// 2. build path => configure build path
//		// 3. 탭[메뉴]에서 Libraries => add external jars를 
//		// 4. 다운로드 받은 2개 라이브러리를 Module path에 추가
//			// 1. module-info 파일에 아래 추가
//				//현재 프로젝트에 라이브러리 추가
//				//requires activation;
//				//requires mail;
//	
//				//사용할 패키지명 설정
//				//opens 패키지명 to 라이브러리명
//				//opens Day14 to actiavtion, mail;
//		
//		// 5. 네이버 메일 설정
//			// 1. 네이버 메일설정
//			// 2. IMAP/SMTP 사용함
//			// 3. SMTP 서버명
//			// 4. SMTP 포트확인
//		// 6. 2차인증은 이걸로 해결 https://goodteacher.tistory.com/8
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("받는 사람 이메일 : "); String toemail = scanner.next(); // 공백을 못 받는다.
//		// .nextLine(): 앞에 next() 있는 경우 오류발생
//		// 대처 방법 1 : 사이에 scanner.nextLine();추가
//		scanner.nextLine();
//		System.out.println("메일 제목 : "); String title = scanner.nextLine(); // 공백을 받는다
//		System.out.println("메일 내용 : "); String contents = scanner.nextLine(); // 공백을 받는다
//		
//		sendmail(toemail, title, contents);
//}
//	public static void sendmail(String toemail, String title, String contents) {
//								//받는 사람, 제목	, 내용
//		// 1. 설정
//				String host = "smtp.gmail.com"; //메일회사 호스트명[해당 사이트내에서 확인가능]
//				String fromemail = "kjsmrs0403@gmail.com";
//				String frompassword = "password";
//				
//				
//				Properties properties = new Properties(); // 설정관련 [map 컬렉션]
//				properties.put("mail.smtp.host", host);   // host: 메일회사 호스트[통신이름]
//				properties.put("mail.smtp.prot", 587);	  // port: 메일회사 호스트 smtp port[통신번호]
//				properties.put("mail.smtp.auth", "true"); // 인증받기
//				
//				// 2. 인증
//				//Session session = Session.getDefaultInstance(properties, new Authenticator() {});
//				Session session = Session.getDefaultInstance(properties, new Authenticator() {
//					@Override
//					protected PasswordAuthentication getPasswordAuthentication() {
//						return new PasswordAuthentication(fromemail, frompassword); 
//						}
//				});
//				
//				// 3. 메일보내기
//				try {
//					MimeMessage message = new MimeMessage(session); // 메시지에 인증처리
//					message.setFrom(new InternetAddress(fromemail)); // 보내는 사람 //예외발생
//					message.addRecipient(Message.RecipientType.TO, new InternetAddress(toemail));
//					message.setSubject(title);//메일 제목
//					message.setText(contents);// 메일 내용
//					
//					Transport.send(message);
//					System.out.println("[[[메일전송 완료]]] : "+toemail);
//				}
//				catch(Exception e) {
//					System.out.println("[[[메일전송 실패]]] : "+toemail);
//				}
//				
//			}
//	}



package Day14;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Day14_2 {
	
	// �ܺ� API : java mail
	// ���� : SMTP : Simple Mail Transfer Protocol
		//  Protocol : ��� �Ծ�
	
	// 1. ���� ���� ���̺귯�� �ٿ�ε� 
		// 1. activation.jar
		// 2. mail-1.4.7.jar
	// 2. �ܺ� ���̺귯���� ���� ������Ʈ �߰� 
		// 1. ���� ������Ʈ ������Ŭ��
		// 2. build path => configure build path 
		// 3. ��[�޴�]���� libraries => add external jars
		// 4. �ٿ�ε� ���� 2�� ���̺귯�� �߰� 
			// ** jdk11 ���� �̻�
			// 1. ��[�޴�]���� libraries => modulepath���� => add external jars
			// 2.  module-info ���Ͽ� �Ʒ� �߰� 
	//				requires activation; 
	//				requires mail;
	//				
	//				//opens ���̺귯���� �������Ű���� to activation , mail;
	//					opens day05 to activation , mail;
	
		// 5. ���̹� ���� ����
				/// 1. ���̹� ���� ȯ�漳��
				// 2. POP3/IMAP ����
				// 3. IMAP/SMTP ����
				// 4. �����  => Ȯ�� 
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("받는 사람메일 : ");	String toemail = scanner.next();		// .next() : ����x 
		// .nextLine() : �տ� next() �ִ°�� ���� �߻� 
			// ��ó ���1 : ���̿� scanner.nextLine(); �߰� 
		scanner.nextLine();
		System.out.print("메일 제목 : ");		String title = scanner.nextLine();		// .nextLine() : ����o
		System.out.print("메일 내용 : ");		String contents = scanner.nextLine();	
		
		sendmail(toemail, title, contents);
		
	}
	
	public static void sendmail( String toemail , String title , String contents ) {
								// �μ� : �޴»������ , ���� , ���� 
		//1. ���� 
		String fromemail="kjsmrs0403@gmail.com";
		String frompassword = "password";
		
		Properties properties = new Properties(); 	// �������� [ map �÷��� ] 
		properties.put("mail.smtp.host", "smtp.gmail.com");		// host : ����ȸ�� ȣ��Ʈ[ ����̸�] // ����ȸ�� ȣ��Ʈ��[ �ش� ����Ʈ������ Ȯ�ΰ��� ] 
		properties.put("mail.smtp.port", 587);		// port : ����ȸ�� ȣ��Ʈ smtp port[��Ź�ȣ]
		properties.put("mail.smtp.auth", "true");	// �����ޱ� 
		
		// 2. ���� 
		//Session session = Session.getDefaultInstance( properties , new Authenticator() { } );
		Session session = Session.getDefaultInstance( properties , new Authenticator(){ 
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromemail, frompassword);
			}
		} );
		
		// 3. ���Ϻ����� 
		try {
			MimeMessage message = new MimeMessage( session ); // �޽����� ���� ó�� 
			message.setFrom( new InternetAddress( fromemail )); // �����»�� // ���ܹ߻� ������ �߻� 
			message.addRecipient( Message.RecipientType.TO , new InternetAddress(toemail ) );
			
			message.setSubject(title); // ���� ���� 
			message.setText(contents); // ���� ����
			
			Transport.send(message); // ��������
			
			System.out.println("[[[전송 성공 ]]] : " + toemail );
			
		}
		catch (Exception e) {
			System.out.println("[[[전송 실패 ]]] : " + toemail );
		}
			
	}
}



