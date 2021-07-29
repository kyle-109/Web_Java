package Day08;

import java.util.Date;
import java.util.Scanner;
import java.util.Scanner;

public class Board {
	// 게시판 클래스
	
	Scanner scanner = new Scanner(System.in);
	
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
			System.out.print("작성자 : "); String writer = scanner.nextLine();
			
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
		public void update(int number) { // 현재 메서드 외부로부터 현재 메서드로 들어오는 데이터[인수]
			//인수는 이름이 달라도 자료형은 같아야 한다.
			Scanner scanner = new Scanner(System.in);
			System.out.println("[[[ 글수정 페이지 ]]]");
			int index = findboard(number);
			if(index==-1) return;
			System.out.print("제목을 다시 입력하세오:"); Day08_2.boardlist[index].title =  scanner.nextLine();
			System.out.print("내용을 다시 입력하세요:"); Day08_2.boardlist[index].content = scanner.nextLine();

			System.out.println("[[글수정]] 완료");
		}
		// 4. 글삭제
		public void delete(int number) {
			System.out.println("[[ 해당 게시물이 삭제되었습니다 ]]");
			int index = findboard(number); // 게시물 찾기 메서드 호출
			if(index==-1) return; // 만약에 게시물이 없으면 메소드 종료
							
			// 해당 게시물번호의 객체 삭제
			Day08_2.boardlist[index] = null;
			//삭제된 게시물 뒤로 한칸씩 당기기
			for(int j = index; j<Day08_2.boardlist.length; j++) {
				// j는 삭제된 게시물 뒤 게시물들
				if(Day08_2.boardlist[j+1]!= null) {
					Day08_2.boardlist[j] = Day08_2.boardlist[j+1];
				}
				else {
					Day08_2.boardlist[j]=null;
					break;
				}
			}
		}
		// 5. 조회수증가
		public void count() {
			this.viewcount++; //조회수 증가
		}
		// 6. 글 상세페이지
		public void view(int number) { //인수, 삭제할 게시물 번호를 넣는다.
			
			Board board = null;
			
			int index = findboard(number); //게시물 찾기 메소드 호출
			if(index==-1) return; //만약에 -1이면 현재 메소드 종료
			
			//게시물 찾기 메소드
			board = Day08_2.boardlist[index]; // 찾은 게시물의 위치의 게시물 가져오기
			board.count(); // 조회수 증가 메서드 호출
			
			System.out.println("[[[ 상세페이지 ]]]");
			System.out.println(" 제목 : " +board.title);
			System.out.println(" 작성자 : "+board.writer+" 조회수 : "+board.viewcount+" 작성자 : "+board.bdate);
			System.out.println(" 내용 : " + board.content);
			System.out.println("1. 수정 2. 삭제 3. 댓글작성 4. 뒤로가기");
			Scanner scanner = new Scanner(System.in);
			int ch = scanner.nextInt();
			if(ch==1) { // 글 수정
				update(number);
				return;
			}
			if(ch==2) { // 글 삭제
				delete(number); 
				return;
			}
			if(ch==3) { // 댓글 작성
				
			}
			if(ch==4) {
				return; //메소드 종료
			}
		}
		
		//게시물번호에 해당하는 배열의 위치를 찾는 메서드
		public int findboard(int number) {
			// 반환타입 : 찾은 배열의 위치 반환
			for(int i = 0; i<Day08_2.boardlist.length; i++) {
				if(Day08_2.boardlist[i] != null && Day08_2.boardlist[i].number == number) {
							// i번째 인덱스의 배열값이 null이 아니면서 i번째 인덱스의 배열값의 게시물번호가 선택한 게시물번호와 같으면
					return i; // 찾은 게시물의 배열위치 반환
				}
			}
			System.out.println("[[오류]] 해당 게시물 번호가 없습니다..");
			return -1; // 배열 인덱스 시작은 0부터 이기에 못찾앗다는 의미
		}
			  
}
