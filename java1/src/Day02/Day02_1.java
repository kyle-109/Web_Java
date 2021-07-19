package Day02;

public class Day02_1 { //class start

	
	//주석
		//1. 한줄 주석 //
		//2. 여러줄 주석 /* */
	
	//자동완성
		// ctrl+spacebar
	//main 메서드
		// 코드를 읽어주는 역할(스레드 포함)
	
	// 출력
		//System.out.println();
	
	// 2진수(컴퓨터) : 0, 1 표현단위 한계
	// 10진수(사람) : 0~9
	// 8진수 : 0~7
	// 16진수 : 0~9 a b c d e f
	
	// 용량단위
		// 1bit : 0 혹은 1
		// 1byte => 8bit [01010101], 메모리의 기본단위
		// 1024byte => 1kb
		// 1024kb => 1mb
		// 1024mb => 1gb
	
	// 인코딩
		// 기계어 => 문자 변환
		// 1. 아스키코드
		// 2. 유니코드
		
	public static void main(String[] args) {//main start
		
		//변수: 데이터 저장하는 상자
			// 사람 : 1. 상자의 크기 2. 상자의 이름 3. 상자에 들어가는 값
			// 컴퓨터 : 메모리 = 저장장치(자원)
				// 1. 메모리 주소를 통해 변수 식별, 숫자가 편하다보니 주소를 16진수로 표현
				// 2. 메모리 크기(바이트 단위)
				// 3. 메모리 데이터
			// 자료형 : 메모리의 크기를 미리 정해진 형태
				// 왜? : 메모리 효율적으로 사용하자(메모리용량 증가 => 속도감소)
					
		
		// 1. 변수 선언과 초기값
		int 변수1 = 10;
		// 2. 자료형
			// 1. boolean : 1bit [true, false]
			boolean 논리변수 = true;
			System.out.println("논리변수 값은 "+논리변수);
				// boolean 논리변수2 = 10; 상자의 크기가 작기 때문에 오류.
			
			
			// 2. char : 2byte[0 ~ 65,000정도]
				// 아스키 코드 : 2진수 => 문자 변환 방식(영어, 특수문자)
					// 7bit => 128문자 표현 가능
						// 1byte => 영문
				// 유니코드[자바] : 2진수 => 문자 변환 방식(전세계 공용어도 포함)
						// 2byte => 한글
			char 문자변수 = 'a';
			System.out.println("문자변수 값은 "+문자변수);
			char 문자변수2 = 97;
			System.out.println("문자변수2 값은 "+문자변수2);
			char 문자변수3 = 98;
			System.out.println("문자변수3 값은 "+문자변수3);
			
			
			// 3. byte : 1byte[+-120정도]:정수
			byte 바이트변수 = 100;
			System.out.println("바이트변수 값은 "+바이트변수);
			byte 바이트변수2 = 'd';
			System.out.println("바이트변수2 값은 "+바이트변수);
			
			
			// 4. short : 2byte [+-3만 정도]
			short 숏변수 = 100;
			System.out.println("숏변수 값은 "+숏변수);
			short 숏변수2 = 'a';
			System.out.println("숏변수2 값은 "+숏변수2);
			
			
			// 5. int : 4byte [+-20억 정도]: 정수의 기본 타입
			int 인트변수 = 100;
			System.out.println("인트변수 값은 "+인트변수);
			int 인트변수2 = 'a';
			System.out.println("인트변수 값은 "+인트변수2);
				//int 인트변수3 = 10000000000; 100억이라 범위를 넘어선다.
				//System.out.println("인트변수 값은 "+인트변수3);
			System.out.println("java 정수타입 기본단위 :"+ (10));
			
			
			// 6. long : 8byte [+-20억 이상]
			long 롱변수 = 10000000000L; // 데이터 뒤에 L을 붙여야 한다.
			System.out.println("롱변수 값은 "+롱변수);
			
			// 7. float : 4byte [실수형/소수점 6자리]
			float 실수변수1 = 10.51111111111f;//데이터 뒤에 f,F를 붙여야 한다.
			System.out.println("실수변수1 값은 "+실수변수1);
			
			// 8. double : 8byte : 실수의 기본타입, 소수점 15자리까지
			double 실수변수2 = 10.511111111111111111111;
			System.out.println("실수변수2 값은 "+실수변수2);
			// 상자의 개념으로 어떤 값, 정보를 넣어주는 것
			
			// 기본 자료형에 문자열이 없음 => char는 문자.
			// 문자열 방법1 => 배열
				char[] 문자열1 = new char[3];
				문자열1[0] = '안';
				문자열1[1] = '녕';
				문자열1[2] = '하';
			
			// 문자열 방법2 => 클래스 => String: 문자열 관련 클래스
				String 문자열2 = "안녕하";
		
		
		
		
	}//main end
}//class end
