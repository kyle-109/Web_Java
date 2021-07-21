package Day06;

import java.util.Random;
import java.util.Scanner;

public class Day06_3 {
	public static void main(String[] args) {
		// 삼목게임[console 틱택토게임]
		// 0. 설정
		int count = 0;
		int end = 0;
		Scanner scanner = new Scanner(System.in);
		Random random = new Random(); // 랜덤 클래스를 이용한 랜덤 객체
		// 1. 게임판 정의
		String[] plate = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"};
		
		while(true) { // 무한루프 [종료조건: 승리자 나왔을 경우, 9개알이 존재했을때 무승부
			// 2. 게임판 출력
			
			for(int i = 0; i<plate.length; i++) {
				System.out.print(plate[i]);
				if(i%3==2) {
					System.out.println();
				}
			}

			//5. 승리 조건
			// 1. 가로로 이기는 수 [0 1 2], [3 4 5], [6 7 8]
			// 2. 세로로 이기는 수 [0 3 6], [1 4 7]. [2 5 8]
			// 3. 대각선으로 이기는 수 [0 4 8] [2 4 6]
			for(int i = 0; i<=6; i+=3) {
				if(plate[i].equals(plate[i+1]) && plate[i+1].equals(plate[i+2])) {
					if(plate[i].equals("[O]"))
					{
						System.out.println("사람이 이겼습니다.");
						end = -1;
						break;
					}
					if(plate[i].equals("[X]")) {
						System.out.println("컴퓨터가 이겼습니다.");
						end = -1;
						break;
					}
				}
			}
			if(end==-1) {
				break;
			}
			for(int i = 0; i<3; i++) {
				if(plate[i].equals(plate[i+3]) && plate[i+3].equals(plate[i+6])) {
					if(plate[i].equals("[O]"))
					{
						System.out.println("사람이 이겼습니다.");
						end = -1;
						break;
					}
					if(plate[i].equals("[X]")) {
						System.out.println("컴퓨터가 이겼습니다.");
						end = -1;
						break;
					}
				}
			}
			if(end==-1) {
				break;
			}
			if((plate[2].equals(plate[4]) && plate[4].equals(plate[6])) || (plate[0].equals(plate[4]) && plate[4].equals(plate[8]))) {
				if(plate[4].equals("[O]"))
				{
					System.out.println("사람이 이겼습니다.");
					break;
				}
				if(plate[4].equals("[X]")) {
					System.out.println("컴퓨터가 이겼습니다.");
					break;
				}
			}			
			
			if(count==9){
				System.out.println("무승부입니다.");
				break;
			}
			
			while(true) {
				// 3. 플레이어에게 위치 선택받아 알 두기
				System.out.print("위치 선택 : "); int index = scanner.nextInt();
				// 1. 이미 알이 존재하는 경우 다시 입력받기
				if(plate[index-1].equals("[O]")) {
					System.out.println("이미 놓인 위치입니다.");
					continue;
				}
				else{
					plate[index-1] = "[O]";
					count++;
					break;
					
				}
			}
					
			while(true) {
			//4. 컴퓨터가 난수생성해서 알두기
				int rindex = random.nextInt(9); // 0 ~ 8
					// 랜덤객체.nextInt(); int 범위내 난수 생성 +-20억.
					// 랜덤객체.nextInt(수); 0부터 넣은 수 전까지의 난수 생성
					// 랜덤객체.nextInt(수)+시작; 시작부터 수+시작전까지 난수 생성
				
				if(plate[rindex]=="[ ]") {
					plate[rindex] = "[X]";
					count++;
					break;
					
				}
				else {
					continue;
				}
			}	
		}
	}
}
