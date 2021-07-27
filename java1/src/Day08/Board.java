package Day08;

import java.util.Date;
import java.util.Scanner;

public class Board {
	// 게시판 클래스
	
	
	// 1. 필드
	
	int number; // 1. 번호
	String title; // 2. 제목
	String content; // 3. 내용
	String writer; // 4. 작성자
	String bdate; // 5. 작성일
	int viewcount; // 6. 조회수
	
	
	// 2. 생성자
		// [생성자명 == 클래스명 동일]
		// 1. 빈생성자 [ctrl + spacebar]
		public Board() {
		}
		// 2. 모든 필드를 받는 생성자 [오른쪽 클릭 => source=> generate constructor using fields]
		public Board(int number, String title, String content, String writer, String bdate, int viewcount) {
			this.number = number;
			this.title= title;
			this.content = content;
			this.writer= writer;
			this.bdate = bdate;
			this.viewcount = viewcount;
		}
		// 기타 생성자 등등
	
		
	// 3. 메소드 : 
		// 1. 글쓰기
		public void write() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("[[[ 글쓰기 페이지 ]]]");
			System.out.print("글제목 : "); String title=scanner.nextLine();
			System.out.print("글내용 : "); String content = scanner.nextLine();
			System.out.print("작성자 : "); String writer = scanner.next();
			
			// 1. 객체 생성
			int number = -1;
				// 게시물 번호 [1. 자동[DB] 2. 수동]
				for(int i = 0; i<Day08_2.boardlist.length; i++) {
					if(Day08_2.boardlist[i] == null) {
						
						// 1. 첫번째 게시물인 경우 1부터 시작
						if(i == 0) { 
							number = 1;
							break;
							}
						// 2. 첫번째 게시물이 아닌 경우는 마지막 게시물 +1
						else {
							number = Day08_2.boardlist[i-1].number+1;//마지막 게시물의 번호 + 1
							break;
						}
					}
				}
			
			Date date = new Date();
			String bdate = date.toString();
			Board board = new Board(number, title, content, writer, bdate, viewcount);
			
			// 2. 여러개 객체 저장할 메모리??(주기억장치/램) [배열, 리스트 등]
			for(int i = 0; i<Day08_2.boardlist.length; i++) {
				if(Day08_2.boardlist[i]==null) {
					Day08_2.boardlist[i]=board;
					break;
				}
			}
			
			// 3. 프로그램 종료시 저장되는 메모리(보조기억장치/하드,ssd) [파일처리, datedate]
		}
		// 2. 글목록
		public void list() {
			if(Day08_2.boardlist[0] == null) return;
			System.out.println("[[[ 커뮤니티 ]]]");
			System.out.println("번호\t제목\t작성자\t조회수\t작성일");
			
			for(int i = 0; i<Day08_2.boardlist.length; i++) {
				if(Day08_2.boardlist[i]==null) {return;}
				System.out.print(Day08_2.boardlist[i].number +"\t");
				System.out.print(Day08_2.boardlist[i].title +"\t");
				System.out.print(Day08_2.boardlist[i].writer +"\t");
				System.out.print(Day08_2.boardlist[i].viewcount +"\t");
				System.out.print(Day08_2.boardlist[i].bdate +"\t");
				System.out.println();
			}
		}	
		// 3. 글수정
		public void update() {
			System.out.println("[[[ 글수정 페이지 ]]]");
		}
		// 4. 글삭제
		public void delete() {
			
		}
		// 5. 조회수증가
		public void count() {
			
		}
		// 6. 글 상세페이지
		public void view(int ch2) { //인수
			System.out.println("[[[ 상세페이지 ]]]");
		}

}
