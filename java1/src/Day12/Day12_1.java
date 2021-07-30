package Day12;

import java.util.Scanner;

public class Day12_1 {
	
	// 예외처리 : 예외[오류] 발생했을 경우 처리 코드
		// 목적 : 예외가 발생했을 때 프로그램 종료 방지
		// 코드상 오류는 컴파일러[실행] X
		// 코드상 문제는 없지만 실행된 후에 프로그램 실행시 예외
		// 오류 처리방법
			// 1. if : 이미 알고 있는 예외일경우
			// 2. try~catch : 다양한 경우의 예외일 경우
		// 형태
			// try{예외가 발생할 것 같은 코드}catch(예외클래스 객체명){예외대체코드}finally{무조건 실행코드}
		// 예외 클래스 [Exception 예외클래스 중 슈퍼클래스]
			// 에러가 여러 개인 경우의 예외 발생시 Exception
			// 에러가 하나의 경우 콘솔창에 나온 에러를 명시(이게 Exception으로 두루뭉실하게 잡는 것보다 빠르다)
			
	public static void main(String[] args) {
		
		// 1. 객체가 null인 경우 출력, 정보출력
		try {
			// 예외가 발생하면 catch로 이동  // 아니면 그대로 실행
			String str = null; // 실행
			System.out.println(str); // 실행
			System.out.println(str.toString()); // 예외발생! => catch
		}
		catch(NullPointerException exception) {
			// 예외클래스명 객체명(임의)
			System.out.println("오류발생 사유 : "+exception);
			System.out.println("[[관리자에게 문의]]");
		}
		
		// 2. 배열에 index가 부족한 경우
		try {
			String[] 문자열배열 = new String[2];
				// String 객체 2개를 저장할 수 있는 배열
			문자열배열[0] = "강호동"; // 문제없음
			문자열배열[1] = "신동엽"; // 문제없음
			문자열배열[2] = "서장훈"; // 3번째 인원을 추가 // 예외발생 !!! => catch
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("오류발생 사유 : "+exception);
			System.out.println("[[ 더이상 인원을 추가할 수 없습니다 ]]");
		}
		
		// 3. 숫자 => 문자 변경 가능 // 문자 => 숫자 변경
		try { 
		String str2 = "100";
		String str3 = "a100";
		System.out.println(Integer.parseInt(str2));
						// Integer.parseInt(문자열) : 문자열 => 정수
		System.out.println(Integer.parseInt(str3)); // 예외발생!!
		}
		catch(NumberFormatException exception) {
			System.out.println("오류발생 사유 : "+ exception);
			System.out.println("[[ 문자가 포함되는 문자열은 숫자열 변환 불가]]");
		}
		
		// 4. 예외클래스를 모르는 경우
			// 예외클래스의 슈퍼클래스는 Exception.
		
		try {
			// 1. 
			String str = null; // 실행
			System.out.println(str); // 실행
			System.out.println(str.toString()); // 예외발생! => catch
			
			// 2.
			String[] 문자열배열 = new String[2];
			문자열배열[0] = "강호동"; // 문제없음
			문자열배열[1] = "신동엽"; // 문제없음
			문자열배열[2] = "서장훈"; // 3번째 인원을 추가 // 예외발생 !!! => catch
			
			//3.
			String str2 = "100";
			String str3 = "a100";
			System.out.println(Integer.parseInt(str2));
							// Integer.parseInt(문자열) : 문자열 => 정수
			System.out.println(Integer.parseInt(str3)); // 예외발생!!
		}
		catch(Exception exception) // 예외 슈퍼클래스가 아닌 서브클래스를 직접 명시하는 것이 더 빠르다.//
		{
			System.out.println("예외발생 : "+exception);
		}finally {
			System.out.println("예외가 있든 없든 무조건 실행되는 자리");
		}
		
		
		// 문제 1: 예외처리
		// 1. 무한루프 int형 숫자 계속 입력받기
		// 2. 문자입력시 예외처리발생
		// 3. 예외처리해서 다시 입력받기
		// Scanner scanner = new Scanner(System.in); // 키보드 입력된게 먼저 객체로 들어가기 때문에 여기에 선언하면 안된다.
		while(true) {
			try {
			// 예외가 예상되는 곳에 try{} 묶음
			Scanner scanner = new Scanner(System.in); // 객체 초기화를 위해서 이곳에 선언. new는 메모리 할당을 의미하기에 계속 메모리를 새로 할당
			System.out.print("숫자를 입력하세요 : ");
			int number = scanner.nextInt();
			}
			catch(Exception exception) {
				System.out.println("문자를 입력하셨습니다. 다시 입력해주세요");
			}	
	}
	}
}