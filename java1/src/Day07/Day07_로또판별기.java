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
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇 번 예측할지 입력하세요 : "); int game = scanner.nextInt();
		int[][] playerArr = new int[game][6]; 
		int[] win = new int[6];
		
		for(int t = 0; t<game; t++) {
			System.out.println((t+1)+"번째 예측입니다");
			for(int i = 0; i<6; i++) {
				System.out.print((i+1)+"번째 숫자를 입력하세요 : ");
				playerArr[t][i] = scanner.nextInt();
				if(playerArr[t][i]<1 || playerArr[t][i]>45) {
					System.out.println("범위를 벗어난 수를 입력했습니다.");
					i--;
					continue;
				}
				if(i>0) {
					for(int j =0; j<i; j++) {
						if(playerArr[t][i]==playerArr[t][j]) {
							System.out.println("중복된 수를 입력했습니다.");
							i--;
							break;
						}
					}
					continue; 
				}	
			}
			for(int i = 0; i<6; i++) {
				System.out.print(playerArr[t][i]+" ");
			}
			System.out.println();
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
		for(int i=0; i<game; i++) {
			Arrays.sort(playerArr[i]);
		}
		Arrays.sort(win);
		int[] count = {0,0,0};
		for(int t =0; t<game; t++) {
			for(int i = 0; i<6; i++) {
				for(int j = 0; j<6; j++) {
					if(playerArr[t][i]==win[j]) {
						count[t]++;
					}
					if(playerArr[t][i]<win[j]) {
						break;
					}
				}
			}
		}
		System.out.println();
		for(int i=0; i<game; i++) {
			System.out.println("당첨갯수는 "+count[i]);
		}
	}
}
		

	
	

