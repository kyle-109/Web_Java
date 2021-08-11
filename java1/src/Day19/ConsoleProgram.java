package Day19;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleProgram {
	
	// 필드(변수, 객체, 배열 등)
		// 1. 컬렉션 프레임워크 [회원, 게시물, 댓글 목록]
		static ArrayList<Member> memberlist = new ArrayList<>();
		static ArrayList<Board> boardList = new ArrayList<>();
		// 2. 입력객체
		static Scanner scanner = new Scanner(System.in);
			// System.in[키보드] -----> (스트림)바이트 ---> 바이트 scanner 클래스 객체에 저장
				// .next() : 객체에 저장된 바이트를 String으로 변환해서 가져오기
				// .nextInt() : 객체에 저장된 바이트를 Int로 변환해서 가져오기
		
	// 생성자
		
	// 메소드
		// 1. Start : 프로그램의 시작
	// 프로그램내 파일들 간의 다른 패키지에서 호출할 것이면 public
	void programStart() {// 접근제한자 없으면 default, start 시작
		try {//파일에서 회원불러오기
		FileUtil.fileload(1);// 프로그램을 시작하면 먼저 파일에서 회원불러오기
		}catch(Exception e) {
			System.out.println("[[파일처리 오류]] : 관리자에게 문의" + e);
		}
		while(true) {//while 시작
			System.out.println("\n[[[ 회원제 커뮤니티 ]]]");
			System.out.print("[[[ 1.로그인 2.회원가입 3.아이디찾기 4.비밀번호찾기 ]]]: ");
			//입출력은 예외처리가 많이 생긴다. 외부에서 들어오는 것은 예외처리해야 한다고 생각하면 된다.
			try {// 만약에 숫자가 아닌 문자를 입력했을 경우 예외처리
				int ch = scanner.nextInt();
				Member temp = new Member();// 회원용 메소드 호출용, 깡통을 만든것이라 메모리를 크게 차지하지 않는다.
				Board temp2 = new Board();
				if(ch == 1) {// 로그인선택 시작
					Member login = temp.login(); // 로그인성공시 객체반환, 실패시 null 반환
					if(login!=null) {// 게시판 메뉴 호출[인수: login]
						System.out.println("게시판");
						// 게시판 호출 성공
						temp2.boardlist(login);
						login = null;
					}// 게시판 메뉴 호출
					System.out.println("로그인 실패");
				}// 로그인선택 끝
				
				if(ch == 2) {// 회원가입선택 시작
					temp.signup();
				}// 회원가입선택 끝
				
				if(ch == 3) {// 아이디찾기 시작
					
				}// 아이디찾기 끝
				
				if(ch == 4) {// 비밀번호찾기 시작
					
				}// 비밀번호찾기 끝
				
				if(ch <0 || ch>4) {
					System.out.println("[[알림: 1,2,3,4 중 하나를 선택하세요]]");
				}
				
			}
			catch(Exception e) {
				System.out.println("[[알림 : 번호만 입력하세요]]");
				scanner = new Scanner(System.in); // 이걸 안하면 기존값을 계속 불러오게 되기에 기존 값 초기화해야 한다.
			}
		}//while 끝
		
	}// start 끝
	
}