package Day19;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Member {
	// 필드 [회원번호, 아이디, 비밀번호, 성명, 이메일, 포인트]
	private int no;
	private String id;
	private String passWord;
	private String name;
	private String email;
	private int point;
	static int totalno = 0; // 전체회원수 [회원탈퇴시에도 누적]
	
		// private : 현재 클래스내에서만 호출 가능. 개인정보가 들어간 것은 private
	
	
	// 생성자 -> new 생성자();
		// 1. 빈생성자	2. 풀생성자
	public Member() {}
	
	// 이 경우 풀 생성자는 회원가입때 사용하면 좋을 것 같다.
	public Member(int no, String id, String passWord, String name, String email, int point) {
		this.no = no;
		this.id = id;
		this.passWord = passWord;
		this.name = name;
		this.email = email;
		this.point = point;
	}
	// 메소드
		// 1. 회원가입 [입력받기 => 필드저장 => 객체 => 리스트 담기]
		public void signup() {
			System.out.print("아이디를 입력하세요(4~10글자이내): "); String id = ConsoleProgram.scanner.next();
			System.out.print("비밀번호를 입력하세요(5글자): "); String passWord = ConsoleProgram.scanner.next();
			System.out.print("비밀번호를 다시 입력하세요(5글자): "); String passWord2 = ConsoleProgram.scanner.next();
			System.out.print("이름를 입력하세요(2~10글자): "); String name = ConsoleProgram.scanner.next();
			System.out.print("이메일를 입력하세요: "); String email = ConsoleProgram.scanner.next();
			
			// 유효성 검사
				// 1. 중복체크 [입력한 아이디가 회원 목록 리스트에 존재하면 X]
				for(Member temp : ConsoleProgram.memberlist) {
					if(temp.id.equals(id)) {
						System.out.println("[[알림 : 가입실패]] : 동일한 아이디가 존재합니다");
						return;
					}
				}
				// 2. 비밀번호 확인
				if(!passWord.equals(passWord2)) {// 입력한 2개의 비밀번호가 다를경우
					System.out.println("[[알림 : 가입실패]] : 비밀번호가 일치하지 않습니다.");
					return;
				}
				// 3. 아이디 10글자 이내/비밀번호 5글자/성명 10글자이내 
				if(id.length()<4 || id.length()>10) {
					System.out.println("[[알림 : 가입실패]] : 아이디가 4~10글자이내가 아닙니다.");
					return;
				}
				if(passWord.length()!=5) {
					System.out.println("[[알림 : 가입실패]] : 비밀번호가 5글자가 아닙니다.");
					return;
				}
				if(name.length()<1 || name.length()>11) {
					System.out.println("[[알림 : 가입실패]] : 이름이 2~10글자이내가 아닙니다.");
					return;
				}
				// 4. 이메일형식
				if(!email.contains("@")) {
					System.out.println("[[알림 : 가입실패]] : 이메일에 @를 포함해서 입력해주세요.");
					return;
				}
			// 파일처리
			try {
			// 회원가입 성공 : 객체 => 리스트 => 파일처리
				FileUtil.fileload(0);// 로그를 불러와 총 멤버수를 최신화
				Member newMember = new Member(totalno+1, id, passWord, name, email, 0);
				ConsoleProgram.memberlist.add(newMember); // 리스트에 담기
				
				FileUtil.filesave(0, newMember.getNo());// 최신화된 총 멤버수를 로그파일에 저장
				FileUtil.filesave(1, 0);//멤버를 추가할때마다 전체 리스트의 멤버를 등록
			}catch(Exception e) {
				System.out.println("[[파일처리 오류]] : 관리자에게 문의");
			}
			System.out.println("회원가입성공!");
		}
		
		// 2. 로그인
		public Member login() {
			System.out.print("[[[ 아이디: ]]]");String id = ConsoleProgram.scanner.next();
			System.out.print("[[[ 비밀번호: ]]]");String password = ConsoleProgram.scanner.next();
			for(Member member: ConsoleProgram.memberlist) {
				if(member.id.equals(id)&&member.passWord.equals(password)) {
					System.out.println("[[ 안녕하세요 "+member.name+"님 ]]");
					return member;// 로그인된 회원정보 객체를 전달
				}
			}
			System.out.println("[[[ 동일한 회원정보가 없습니다 ]]]");
			return null;
		}
		// 3. 아이디찾기[이름과 이메일 동일한 경우 => 아이디출력]
		public void findId() {
			System.out.print("[[[ 이름: ]]]"); String name = ConsoleProgram.scanner.next();
			System.out.print("[[[ 이메일: ]]]"); String email = ConsoleProgram.scanner.next();
			for(Member member: ConsoleProgram.memberlist) {
				if(member.name.equals(name)&&member.email.equals(email)) {
					System.out.println("[[ 회원님의 아이디는 "+member.id+"입니다 ]]");
					return;
				}
			}
			System.out.println("[[[ 동일한 회원정보가 없습니다 ]]]");
		}
		// 4. 비밀번호찾기[아이디와 이멜일 동일한 경우 => 비밀번호: 메일전송]
		public void findPassword() {
			System.out.print("[[[ 아이디: ]]]"); String id = ConsoleProgram.scanner.next();
			System.out.print("[[[ 이메일: ]]]"); String email = ConsoleProgram.scanner.next();
			for(Member member: ConsoleProgram.memberlist) {
				if(member.id.equals(id)&&member.email.equals(email)) {
					System.out.println("[[ 회원님의 이메일로 비밀번호를 전송했습니다.]]");
					sendemail(1, member.email, member.passWord);// type=1 비밀번호찾기 메일전송
					return;
				}
			}
			System.out.println("[[[ 동일한 회원정보가 없습니다 ]]]");
		}
		// 5. 메일전송
		public void sendemail(int type, String toemail, String contents) {
			
			// 1. API 다운로드 [ activation.jar, mail.jar]
			// 2. 라이브러리 추가 [javase11이상 => module-info]
			String fromemail = "보내는사람이메일@naver.com";
			String frompassword = "보내는사람비번";
			
			// 설정관련 map(키, 값) 컬렉션
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp.naver.com");
			properties.put("mail.smtp.port", 587);
			properties.put("mail.smtp.auth", true);
			
			// 1. 인증처리
			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(fromemail, frompassword);
				}
			});
			
			// 2. 메일보내기
			try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromemail));// 무조건 예외처리 발생
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toemail));
			if(type ==1 ) {
				message.setSubject("java console 커뮤니티");
				message.setText("회원님의 비밀번호: "+contents);
			}
			Transport.send(message);
			}catch (Exception e) {
				System.out.println("[[ 메일전송 실패]] : 관리자에게 문의");
			}
			
		}
	// 메소드 [get, set 메소드]
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
}