package Day15;

import java.util.Scanner;

public class Day15_5 {
	//무한루프 메뉴
		// 1. 음악재생 2. 영화재생
		// [조건1] 1번선택시 1초간격으로 음악재생 출력
		// [조건2] 2번선택시 1초간격으로 영화재생 출력
		// [조건3] 미리 실행중 번호를 다시 선택하면 재생종료[스레드 종료]
	public static void main(String[] args) {
		
		boolean sw = true;
		boolean vsw = true;
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1.음악재생 2.영화재생");
			int ch =scanner.nextInt();
			if(ch == 1) {
				Thread thread = new Music();
				if(sw) {
					Music.musicStop(sw);
					thread.start();
					//thread.stop(); //이름에 작대기가 들어가면 권장하지 않는다는 의미
					//stop을 사용하면 만나는 즉시 끝내버리기에 메모리 손실이 생길 수 있다. 
					sw = false; // 스위치 변수를 이용한 종료
				}
				else {
					Music.musicStop(sw);
					sw = true;
				}
			}
			
			if(ch == 2) {
				Thread thread2 = new Movie();
				if(vsw) {
					Movie.movieStop(vsw);
					thread2.start();
					vsw = false;
				}
				else {
					Movie.movieStop(vsw);
					vsw = true;
				}
			}
			
			
		}
		
	}
}
