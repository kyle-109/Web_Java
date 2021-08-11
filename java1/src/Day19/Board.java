package Day19;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Board {
	
	// 필드
		public static int bno = 0;// 1. 게시물번호
		private String btitle;// 2. 제목
		private String bcontents;// 3. 내용
		private String bwriter;// 4. 작성자
		private String bdate;// 5. 작성일
		private int bcount;// 6. 조회수
		
		Scanner scanner = new Scanner(System.in);
		
	// 생성자
		public Board() {
			
		}

		public Board(int bno, String btitle, String bcontents, String bwriter, String bdate, int bcount) {
			super();
			this.bno = bno;
			this.btitle = btitle;
			this.bcontents = bcontents;
			this.bwriter = bwriter;
			this.bdate = bdate;
			this.bcount = bcount;
		}
		// 메소드
			// 1. 게시판메뉴 [모든 게시물 출력]
		public void boardlist(Member login) {
			while(true) {
				System.out.println("[[[1.게시물등록 2.게시물조회 3.회원정보[수정/탈퇴] 4.로그아웃 ]]]");
				int ch = scanner.nextInt();
				if(ch == 1) {boardwrite(login);}
				if(ch == 2) {}
				if(ch == 3) {}
				if(ch == 4) {
					System.out.println("[[[ 로그아웃 되었습니다 ]]]");
					return;
				}
			}
		}
			
			// 3. 개별 게시물 출력 메소드
		public void boardview() {
			
		}
		
			// 4. 게시물 등록 메소드
		public void boardwrite(Member login) {
			scanner.nextLine();// 문제점 보완
			System.out.println("[[ 제목 : ]]"); String btitle = scanner.nextLine();
			System.out.println("[[ 내용 : ]]"); String bcontents = scanner.nextLine();
			
			String bwriter=login.getId(); // 로그인된 아이디
			// 1. 현재날짜/시간 클래스
			Date date = new Date();
			// 2. 형식변환 클래스
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm");
			String bdate =simpleDateFormat.format(date);
			// 객체
			try {
				FileUtil.fileload(3);
			}
			catch(Exception e) {
				
			}
			Board board = new Board(bno+1, btitle, bcontents, bwriter, bdate, 0);
			ConsoleProgram.boardList.add(board);
			// 파일처리
			try {
			FileUtil.filesave(3, board.getBno());
			FileUtil.filesave(2, 0);
			}
			catch(Exception e) {
				
			}
			System.out.println("[[ 게시물 등록 완료 ]]");
		}
			// 5. 게시물 조회수 증가 메소드
			// 6. 게시물 수정 메소드
			// 7. 게시물 삭제 메소드
		
		
		public int getBno() {
			return bno;
		}

		public void setBno(int bno) {
			this.bno = bno;
		}

		public String getBtitle() {
			return btitle;
		}

		public void setBtitle(String btitle) {
			this.btitle = btitle;
		}

		public String getBcontents() {
			return bcontents;
		}

		public void setBcontents(String bcontents) {
			this.bcontents = bcontents;
		}

		public String getBwriter() {
			return bwriter;
		}

		public void setBwriter(String bwriter) {
			this.bwriter = bwriter;
		}

		public String getBdate() {
			return bdate;
		}

		public void setBdate(String bdate) {
			this.bdate = bdate;
		}

		public int getBcount() {
			return bcount;
		}

		public void setBcount(int bcount) {
			this.bcount = bcount;
		}
		
		
		
}
