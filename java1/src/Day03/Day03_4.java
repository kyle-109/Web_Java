package Day03;

import java.util.Scanner;

public class Day03_4 {
	public static void main(String[] args) {
		
		// 컴퓨터[0,1] : 기계어
		// 제어문 : if [논리제어], switch[데이터 제어]
			// 목적: 경우의 수에 따른 코드 처리
			// if: true, false만 제어 가능
				// 형태 : if(논리) 실행문;
				// 형태2 : if(논리) 실행문[true];
						  //else 실행문[false];
				// 형태3 : 실행문이 2줄 이상이면 {} 묶음 처리
						//if(논리1){
						//  실행문1;
						//  실행문2;
						//}
				// 형태4 : 경우의 수가 다수일 경우에는
				// if(논리1) ~ 
				// else if(논리2) ~ 
				// else if(논리3) ~
				// else ~
		//예제1) true이면 실행문 실행
		if(3>1) System.out.println("3이 1보다 크다.");
		
		//예제2) false이면 실행문 실행X
		if(3>5) System.out.println("3이 5보다 크다.");
		
		//예제3)
		if(3>5) System.out.println("3이 5보다 크다.");
		else System.out.println("5가 3보다 크다.");
	
		//예제4)
		if(3>2) {
			System.out.println("true이면 실행되는 자리");
			System.out.println("3이 2보다 크다");
		}
		else {
			System.out.println("true이면 실행되는 자리");
			System.out.println("2가 3보다 크다");
		}
		
		//예5) 다중 조건
		if(3>5) System.out.println("3이 5보다 크다");
		else if(3>4) System.out.println("3이 4보다 크다");
		else if(3>3) System.out.println("3이 3보다 크다");
		else if(3>2) System.out.println("3이 2보다 크다");
		else System.out.println("true가 없다.");
		
		//예6) 하나의 점수를 입력받아 80점 이상이면 합격출력 아니면 탈락
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력하세요"); int score = scanner.nextInt();
		if(score>=80)
		{
			System.out.println("합격입니다.");
		}
		else
		{
			System.out.println("탈락입니다.");
		}
		
		//예7) 하나의 점수를 입력받아 
			//90점이상이면 "A등급" 
			//80점이상이면 "B등급" 
			//70점이상이면 "C등급" 
			//그외에는 탈락
		System.out.print("점수2를 입력하세요: "); int score2 = scanner.nextInt();
		if(score2 >=90) System.out.println("A등급");
		else if(score2 >=80) System.out.println("B등급");
		else if(score2 >=70) System.out.println("C등급");
		else System.out.println("탈락");
		
		
		
	}
}
