package Day13;

import java.util.Scanner;

public class Day13_2 {
	
	public static void main(String[] args) {
		
		// 문자열 찾기 [indexOf()] 반환 : 찾은 문자의 인덱스 번호
		String strArr1 = "자바 프로그래밍";
		int index = strArr1.indexOf("프로그래밍");
		System.out.println("검색한 문자의 위치 : "+index);
			
			// 검색 활용
			String notebook = "재미있는 파이썬 입문기초";
			Scanner scanner = new Scanner(System.in);
			System.out.print("키워드 : ");
			String search = scanner.next();
			
			if(notebook.indexOf(search)!= -1) {
				System.out.println("파이썬 관련 서적입니다 : " + notebook);
			}else {
				System.out.println("파이썬 관련 서적이 아닙니다");
			}
			
		// 문자열 길이 [length()] 반환 : 문자수(공백포함)
			System.out.println("strArr1의 글자수 : "+strArr1.length());
			
			//유효성검사
			String idNumber = "8804202541255";
			if(idNumber.length()==13) {
				System.out.println("잘 입력하셨습니다.");
			}
			else {
				System.out.println("글자수가 틀렸습니다.");
			}
		// 문자열 잘라내기 [ substring() ] : 인덱스[위치] 기준
		System.out.println(idNumber.substring(7)); //인덱스 7부터 출력
		System.out.println(idNumber.substring(0, 6)); // 인덱스 0시작 인덱스 6전까지 출력
		
		// 문자열 분해 [ split() ] : 문자 기준
		String[] splitArr = idNumber.split("2");// 2를 기준으로 자르고 지운다.
		System.out.println(splitArr[0]); 
		System.out.println(splitArr[1]);  	
		System.out.println(splitArr[2]); 	
		System.out.println(splitArr[3]); 
		
		// 문자열 치환 [replace("교체할문자", "새로운문자")]
		String strArr2 = "자바 프로그래밍";
		String changeChar = strArr2.replace("자바", "JAVA");
		System.out.println(strArr2);
		System.out.println(changeChar);
		
		// 대소문자 변환[toLowerCase(): 소문자변환 toUpperCase(): 대문자변환]
		String strArr3 = "Java Programming";
		System.out.println("소문자 변환: "+strArr3.toLowerCase());
		System.out.println("대문자 변환: "+strArr3.toUpperCase());
		
		// 공백 제거 [trim()]: 앞뒤 공백 제거
		String strArr4 = "    자바        프로그래밍     ";
		System.out.println("공백제거: "+strArr4.trim());
		
		// 문자열 변환 [ valueOf() ] : 문자열로 변환
		String strArr5 = String.valueOf(10); // 숫자[int] 10을 문자열 10으로 변환
		System.out.println("숫자 -> 문자 : "+strArr5);
		String strArr6 = String.valueOf(10.5);// 소수점[double] 10.5를 문자열 10.5로 변환
		System.out.println("실수 -> 문자 : "+strArr6);
		
		String strArr7 = String.valueOf(true);
		System.out.println("논리 -> 문자: "+strArr7);
		
	}
	
}
