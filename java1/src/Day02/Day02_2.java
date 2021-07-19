package Day02;

import java.util.Scanner;
	//import: 다른 파일에 있는 라이브러리(클래스) 가져오기
	//import 패키지명.클래스
public class Day02_2 {//class start
	
	// 입력받기
	public static void main(String[] args) {//main start
		
		// 1. Scanner 클래스 : 입력관련 클래스
		//scanner 객체는 하나만 만들면 된다.
		Scanner 입력객체 = new Scanner(System.in);
		//Scanner 클래스로 입력객체가 생성하기
			// 1. Scanner : 입력관련된 메소드 제공
				//2. 입력객체 : 객체의 이름[임의값]
					// 3. new : 객체의 메모리 할당 연산자
						// 4. Scanner() : 클래스의 생성자
							// 5. System.in : 입력장치(키보드)
		
		//키보드로부터 입력받은 값을 Scanner 객체에 저장
		//엔터를 기준으로 초기화하는데, 이전에 입력받은 값을 저장하기 위해서
		//nextInt(), next()를 통해서 값을 불러와 따로 만든 변수에 저장
		System.out.println(" 정수 입력 : ");
		// 1. 변수 생성
		int 입력정수;
		// 2. 변수에 입력값 저장
		입력정수 = 입력객체.nextInt();//입력객체에서 정수형 빼오기.
		// 3. 변수출력
		System.out.println("현재 입력한 정수는 : "+입력정수);
		
		System.out.println("문자열 입력: ");
		// 1. 문자열 객체 생성
		String 문자열 = 입력객체.next();//입력객체에서 문자열 빼오기
		System.out.println("현재 입력한 문자열: "+ 문자열);
		
		입력객체.nextLine(); // nextLine():문제점 보완, 공백포함가능
		System.out.println("공백포함 입력: ");
		String 문자열2 = 입력객체.nextLine();
		System.out.println("현재 입력한 문자열은 : "+문자열2);
		
		
		//예제1 : 2명의 이름과 1~3교시까지의 출석여부를 입력받아 출력
		//System.out.println("===========출석부==========");
		//System.out.println("성명\t1교시\t2교시\t3교시");
		//System.out.println("유재석\t출석\t출석\t출석");
		//System.out.println("유재석\t출석\t출석\t출석");
		//System.out.println("==========================");
	}//main end
	
}//class end
