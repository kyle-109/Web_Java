package Day19;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleProgram {
	
	// 필드(변수, 객체, 배열 등)
		// 1. 컬렉션 프레임워크 [회원, 게시물, 댓글 목록]
		static ArrayList<Member> memberList = new ArrayList<>();
		static ArrayList<Board> boardList = new ArrayList<>();
		static ArrayList<Reply> replyList = new ArrayList<>();
		
		static int mtotalno = 0;// 전체 회원수
		static int btotalno = 0;// 전체 게시글수
		static int rtotalno = 0;// 전체 댓글수
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
			FileUtil.fileload(2);// 파일에서 게시물 불러오기
			FileUtil.fileload(4);// 파일에서 댓글 불러오기
		}catch(Exception e) {
			System.out.println("[[파일처리 오류]] : 관리자에게 문의 " + e);
		}
		System.out.println("멤버리스트길이: "+memberList.size());
		System.out.println("게시글리스트길이: "+boardList.size());
		System.out.println("댓글리스트길이: "+replyList.size());
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
						while(true) {
							// 게시물 게시물 출력 
							temp2.boardlist();
							System.out.print("[[[ 1.게시물등록 2.게시물조회 3.회원정보[수정/탈퇴] 4.로그아웃 ]]]:  ");
							scanner.nextLine();
							int ch2 = scanner.nextInt();
							if( ch2 == 1 ) { temp2.boardwrite( login ); }
							if( ch2 == 2 ) { temp2.boardview( login ); }
							if( ch2 == 3 ) {}
							if( ch2 == 4 ) { 
								System.out.println("[[[ 로그아웃 되었습니다 ]]]");
								login = null; // 로그인된정보 null 바꾸기 
								break; // 반복문 탈출
							}
						}
						
					}else {
						System.out.println(" 로그인 실패 ");
					}
				}
				if( ch == 2 ) { temp.signup(); }
				if( ch == 3 ) { temp.findId(); }
				if( ch == 4 ) { temp.findPassword(); }
				if( ch <=0  || ch >4 ) {
					System.out.println("\t[[알림 : 1,2,3,4 메뉴 중 선택 가능합니다 ]]");
				}
			}
			catch (Exception e) {
				System.out.println("\t[[알림 : 알수 없는 행동입니다 ]]");
				scanner = new Scanner(System.in);
			}
 		}
	}
}	
