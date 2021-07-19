package Day03;

import java.util.Scanner;

public class Day03_2 {
	public static void main(String[] args) {
		
		// 0. 입력객체 선언
		Scanner scanner = new Scanner(System.in);
				
		// 급여명세서 문제
		// 조건 입력받기 : 기본급, 수당
		// 출력 실수령액 : 기본급 +수당 - 세금(기본급10%)
		
		// 1. 변수에 입력값저장
		System.out.print("기본금 입력 :"); int basic = scanner.nextInt();
		System.out.print("수당 입력 :"); int bonus = scanner.nextInt();
		// 2. 변수 계산
		int real = basic + bonus -(int)(basic*0.1);
			//0.1은 실수이고 real은 정수이기에 강제 형변환을 해야 한다.
			//강제형변환(자료형변환)
				// 작은 자료형에서 큰 자료형으로 이동 가능
					//ex) int -> double은 가능
					// 추가로 long -> float도 가능하다.
				// 큰 자료형에서 작은 자료형 이동불가(강제변환=>데이터손실)
						// (새로운자료형)변수
							//double num1 = 10.5;
							//int num2 = num1;
				
		System.out.println("실 수령액 : "+real);
			
		// 지폐갯수세기 문제
		// 조건 입력받기 : 금액
		// 금액에 해당하는 지폐수 세기
		
		System.out.print("금액 입력: "); int price = scanner.nextInt();
		
		// 1. 십만원권 세기
		System.out.println("십만원권 :"+(price/100000)+"장");
		// 1. 금액에서 십만원권 빼기
			price -= (price/100000)*100000;
		// 2. 만원권 세기
		System.out.println("만원권 :"+(price/10000)+"장");
			price -= (price/10000)*10000;
		// 2. 천원권 세기
		System.out.println("천원권 :"+(price/1000)+"장");
			price -= (price/1000)*1000;
		// 2. 백원권 세기
		System.out.println("백원권 :"+(price/100)+"장");
			price -= (price/100)*100;
		
	
		
	}
	
}
