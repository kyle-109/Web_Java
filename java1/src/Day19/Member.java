package Day19;

import java.util.Scanner;

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
		// 3. 아이디찾기
		// 4. 비밀번호찾기
		// 5. 메일전송
	
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