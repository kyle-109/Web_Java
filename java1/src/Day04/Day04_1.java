package Day04;

import java.util.Scanner;

public class Day04_1 {
	
	//main + ctrl + spacebar
	public static void main(String[] args) {
		// 과제1 : 4개의 값을 입력받아 오름차순 출력
		// 내림차순으로 하고 싶으면 if안의 부등호를 반대로 바꿔라
		
		Scanner scanner = new Scanner(System.in);
		
		//syso + ctrl + spacebar
		System.out.print("정수1 : "); int num1 = scanner.nextInt();
		System.out.print("정수2 : "); int num2 = scanner.nextInt();
		System.out.print("정수3 : "); int num3 = scanner.nextInt();
		System.out.print("정수4 : "); int num4 = scanner.nextInt();
		
		// 스왑 = 교환
		//메모리와 메모리는 동시에 교환이 안된다.
		//그렇기에 임시변수(temp)를 만들어서 하나의 값을 임시저장해놓는다.
		//한 값을 임시저장한 변수에 대입하고, 대입시킨 변수에 임시변수를 대입한다.
		int temp; // 교환시 사용되는 임시변수
		
		//정렬
			//1. 첫번쨰 변수와 다른 변수와 비교 = 3번
		if(num1 > num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if(num1 > num3) {
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		if(num1 > num4) {
			temp = num1;
			num1 = num4;
			num4 = temp;
		}
			//2. 두번째 변수와 3,4비교 => 2번
		if(num2 > num3) {
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		if(num2 > num4) {
			temp = num2;
			num2 = num4;
			num4 = temp;
		}
			// 3번째 변수와 4 비교 => 1번
		if(num3 > num4) {
			temp = num3;
			num3 = num4;
			num4 = temp;
		}
		
		System.out.println("오름차순 : "+num1+num2+num3+num4);
		
		System.out.println("[[[ 로그인 페이지 ]]]");
		System.out.print("아이디를 입력하세요: "); String id = scanner.next();
		System.out.print("비밀번호를 입력하세요: "); int password = scanner.nextInt();
		
		if (id.equals("admin") && password == 1234) { // 문자열[클래스] 비교연산자 사용할 수 없다.
			System.out.println("로그인 성공");		  // String 클래스 비교메소드 = 문자열.equals("비교대상")
		}
		else if(!id.equals("admin")) {
			System.out.println("아이디가 다릅니다.");
		}
		else {
			System.out.println("비밀번호가 다릅니다.");
		}
		
		
		
	}
}
