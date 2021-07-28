package Day08;

import java.util.Scanner;


public class Day08_2 {
	
	//main 밖에 선언하는 이유 : 모든 메서드에서 사용하기 위해[전역변수]
		// main 메소드 안에서 선언시 main에서만 사용가능[지역변수]
	
	public static Scanner scanner = new Scanner(System.in);
		// static : 정적변수, 메모리 우선할당[프로그램 시작과 동시에 메모리 할당 => 모든 프로그램 종료시 초기화]
	
	public static Board[] boardlist = new Board[100];

	//모든 코드의 시작 지점은 main
	public static void main(String[] args) {
		
		//2. 메소드 호출
		start(); // start에 static이 없으면 main메소드가 start메소드를 못읽음.
		
	}//main end
	
	
	// 1. 메소드 선언
	// 프로그램 실행 메소드화.
	// 다른 코드에서도 이 메서드를 실행할 수 있다.
	public static void start() { // 프로그램시작과 동시에 메모리 할당을 받기에 main에서 부를 수 있다.
		
		Board board = new Board(); // 필드가 null인 깡통 객체
			// 깡통객체 : 메소드 호출용
		
		while(true) {
		
			board.list(); // 1. 글 목록
			System.out.println("0.글쓰기 1.글상세보기");
			int ch = scanner.nextInt();
			if(ch==0) {
				board.write();//글쓰기
			}
			if(ch==1) {
				System.out.println("[[[ 게시물번호 입력: ]]]");
				int number = scanner.nextInt();
				board.view(number);
			}
		}
		
	} //start end
	
} // class end
