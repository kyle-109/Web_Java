package Day07;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day07_로또판별기 {
	// 로또판별기[1차원]
		// 1. 사용자가 1~45 사이의 숫자를 6개 입력받기
			// 1. 중복값 없음 2. 1~45사이만 가능
		// 2. 추첨번호 난수생성 1~45 사이의 숫자 6개 생성
	
		// 3. 두 배열의 동일한 수 체크
	public static void main(String[] args) {
		int[] playerArr = new int[6];
		int[] win = new int[6];
		
		
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i<6; i++) {
			System.out.print((i+1)+"번째 숫자를 입력하세요 : ");
			playerArr[i] = scanner.nextInt();
			if(playerArr[i]<1 || playerArr[i]>45) {
				System.out.println("범위를 벗어난 수를 입력했습니다.");
				i--;
				continue;
			}
			if(i>0) {
				for(int j =0; j<i; j++) {
					if(playerArr[i]==playerArr[j]) {
						System.out.println("중복된 수를 입력했습니다.");
						i--;
						break;
					}
				}
				continue; 
			}	
		}
		for(int i = 0; i<6; i++) {
			System.out.print(playerArr[i]+" ");
		}
		// 2. 추첨번호 난수생성 1~45 사이의 숫자 6개 생성
		System.out.println("\n랜덤번호 생성");
		Random random = new Random();
		for(int i = 0; i<6;i++) {
			win[i]= random.nextInt(45)+1;
			if(i>0) {
				for(int j =0; j<i; j++) {
					if(win[i]==win[j]) {
						i--;
						break;
					}
				}
				continue; 
			}
		}
		
		for(int i = 0; i<6; i++) {
			System.out.print(win[i]+" ");
		}
		
		// 3. 두 배열의 동일한 수 체크
		Arrays.sort(playerArr);
		Arrays.sort(win);
		int count = 0;
		for(int i = 0; i<6; i++) {
			for(int j = 0; j<6; j++) {
				if(playerArr[i]==win[j]) {
					count++;
				}
				if(playerArr[i]<win[j]) {
					break;
				}
			}
		}
		System.out.println("\n당첨갯수는 "+count);
		
		//과제: 2차원으로 변경
			// 1. 게임수 입력받기
			// 2. 입력받은 게임수만큼 번호 선택
				// 만약에 게임수 3 입력시
					// 1게임: 1 2 3 4 5 6
					// 2게임: 1 2 35 7 8 9 
					// 3게임: 9 20 35 24 31 21
			// 3. 게임당 당첨갯수 출력(정답은 동일한걸로)
	}
		
}
	
	

