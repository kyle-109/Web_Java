package Day13;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Day13_1 {
	
	public static void main(String[] args){
		
		// API 클래스 : 미리 만들어진 클래스들
		
		// 1. String 클래스 : 바이트 => 문자열
			// 키보드 입력된 단위는 바이트단위 이동
				// 바이트단위는 ASCII 코드를 사용, 7비트=>2의 7제곱. 
		byte[] byteArr = {92, 72, 101, 34, 59, 84};
		
		String strArr = new String(byteArr);
		
		System.out.println("변환후 : "+strArr);
		
		byte[] byteArr2 = {104, 93, 82, 126, 32};
		String strArr2 = new String(byteArr2);
		System.out.println("변환후 : "+strArr2);
		
		// 1. 바이트 입력받아 배열저장
		byte[] byteArr3 = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		// 2. 바이트배열 => String 변환[생성자]
		String strArr3 = new String(byteArr3);
		System.out.println("변환후 : "+strArr3);
		
		String strArr4 = new String(byteArr3, 6, 4); // index 6부터 4개 변환, 7번째부터 4개.
		System.out.println("일부 변환후 : "+ strArr4);
		
		// 입력받기
		byte[] byteArr4 = new byte[100];
		System.out.print("입력 : ");
		try {
			// System.in : 키보드, System.out: 모니터
				// .read() : 입력값 읽기 메소드
			System.in.read(byteArr4); // 바이트로 저장
			String strArr5 = new String(byteArr4);
			System.out.println("입력값 : "+strArr5);
			//이 방법이 Scanner보다 속도가 더 빠르다.
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// 문자 추출 [charAT()]
		String strArr6 = "자바 프로그래밍";
		System.out.println("문자 추출: "+ strArr6.charAt(3));
		
			// 주민등록번호 이용한 남여 판별
			String idNumber =  "880420-2541144";
			char sex = idNumber.charAt(7);//8번째 요소
			
			switch(sex) {
			case'1':
			case'3':
				System.out.println("남자입니다");
				break;
			case'2':
			case'4':
				System.out.println("여자입니다.");
				break;
			}
			
		// 문자열 비교[equals()] 반환 : true/false
		String strArr7 = new String("유재석");
		String strArr8 = "유재석";
			// 객체 생성시 메모리 할당 연산자 : new
			// 예외 : 기본자료형, String
		System.out.println(strArr7 + strArr8);
		
		if(strArr7.equals(strArr8)) {
			System.out.println("두 문자는 equals");
		}
			// 문자열은 비교연산자 불가(==, !=), 논리연산자는 가능
		
		if(!strArr7.equals(strArr8)) {
			System.out.println("두 문자는 !equals");
		}
		
		// 문자열 ----> 바이트배열[getBytes()]
		String strArr9 = "안녕하세요";
						// 영문, 특수문자 : 1바이트(아스키코드에 있는 것)	한글: 2바이트
		byte[] byteArr5 = strArr9.getBytes();
		System.out.println("길이 : "+byteArr5.length);
		
		String strArr10 = new String(byteArr5);
		System.out.println("변환 : "+strArr10);
			
			// 한글 인코딩: EUC-KR(한글,영문만 사용가능->속도가 빠르다), UTF-8(다양한 언어지원->속도가 느리다)
			// 웹사이트 만들 때는 UTF-8
			try {
				byte[] byteArr6 = strArr9.getBytes("EUC-KR"); // 한글 한글자: 2바이트
				System.out.println("euc-kr 길이 : "+ byteArr6.length);
				
				byte[] byteArr7 = strArr9.getBytes("UTF-8"); // 한글 한글자: 3바이트
				System.out.println("UTF-8 길이 : "+byteArr7.length);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		
		
	}
}
