package Day06;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Day06_2 {
	// 1. 출력 // 2. 입력 // 3. 변수 // 4. 연산자 // 5. 제어문 // 6. 반복문
	
	// 변수 : 자료형 기반으로 선언된 메모리
	// 객체 : 클래스 기반으로 선언된 메모리
	
	// 배열 : 기준[인덱스]에 따른 나열
		// 목적 : 동일한 자료형/클래스의 여러개 메모리 관리
		// 인덱스 : 메모리가 저장된 순서 번호[ 0번 시작 ~~ ]
		// 선언 : 
		// 메서드: 배열명.length
		// 컴파일 후 크기변경 불가 [ 정해져있는 메모리 사용시 용이]
	
	//정렬이 되어있으면 검색이 빠르기에 중요하다
	
	// 변수 : 메모리[자원] 할당받아 데이터 저장하는 공간 1개
	public static void main(String[] args) {
		
		//배열선언
		int[] arr1 = new int[3]; // int형 변수 3개를 저장할 수 있는 메모리 할당받은 배열
		// 1. 자료형/클래스[]
			// 2. 배열명 (임의)
				// 3. new : 메모리할당 연산자
					// 4. int[배열의길이]
		// 배열 요소 호출 : [0] ~~ [2]	  // 3개인덱스인경우
		arr1[0] = 3;
		arr1[1] = 4;
		arr1[2] = 5;
		
		// 배열선언2: 선언과 동시에 초기값(메모리 생성시 기본값)
		String[] strarr2 = {"유재석", "강호동", "신동엽"};
							// String 클래스 객체 3개를 저장하는 메모리를 할당받은 배열
		// 배열 요소 호출
		System.out.println("배열 값 : "+strarr2); //메모리 주소 = 첫번째 인덱스 주소값 = 배열 주소값
		System.out.println("배열 0번째 값은 : "+strarr2[0]);
		System.out.println("배열 1번째 값은 : "+strarr2[1]);
		System.out.println("배열 2번째 값은 : "+strarr2[2]);
		System.out.println("배열의 길이 : "+ strarr2.length); //배열내 요소 개수
			// . : 접근연산자
		
		// 문제1 : 학생관리 프로그램 [배열]
			// 1. 학생수를 입력받아 학생수만큼 배열의길이 할당
			// 2. 메뉴 [1.학생수 2.점수입력 3.분석[등수,평균] 4.종료]
		
		Scanner scanner = new Scanner(System.in);
		
		int end = 0;
		int total = 0;
		int temp = 0;
		Integer[] scoreList = null;
		while(true) {// 무한루프 [종료조건: 4번 눌렀을때 break;]
			System.out.println("1.학생수 2.점수입력 3.분석 4.종료");
			System.out.print("선택 : "); int choice = scanner.nextInt();
			
			switch(choice) {
				case 1:
					System.out.print("학생수 입력 : ");
					int count = scanner.nextInt();
						// int[] scoreList : 동일한 이름으로 메모리 선언은 한번만
					scoreList = new Integer[count];
					System.out.println(count+"만큼 목록 생성");
					break;
				case 2:
					// 학생 수만큼 점수입력
					for(int i = 0; i<scoreList.length; i++) {
						// i는 0부터 배열의 최대길이전까지 1씩 증가하면서 반복
						System.out.print((i+1)+"번째 학생의 점수 입력 : ");
						scoreList[i] = scanner.nextInt();
						total += scoreList[i];
					}
					break;
				case 3:
					System.out.println("[[[분석: 등수(내림차순), 전체 평균]]]");
					//내림차순
					//1. 직접코드작성 
					for(int i = 0; i<scoreList.length; i++) {
						for(int j = i+1; j<scoreList.length; j++) {
							if (scoreList[i] < scoreList[j]) { // <내림차순 >오름차순
								temp = scoreList[j];
								scoreList[j]=scoreList[i];
								scoreList[i]=temp;
							}
						}
					}
					for(int k = 0; k<scoreList.length; k++) {
						System.out.println((k+1)+"등 점수 : "+scoreList[k]);
					}
					
					//2. 클래스이용[미리 만들어진 코드]
						// Arrays.sort(배열) // 오름차순
//					Arrays.sort(scoreList);
//						//내림차순 : 오름차순의 반대
//						Arrays.sort(scoreList , Collections.reverseOrder());
//							// Collections.reverseOrder() : 배열의 자료형 제공X, 클래스는 제공(배열을 Integer 클래스로 바꾼다)
//					for(int i = 0; i<scoreList.length; i++) {
//						System.out.println((i+1)+"등 점수 : "+scoreList[i]);
//					}
					
										
					
					//평균
					int average = total/scoreList.length;
					System.out.println("[[평균]] : "+ average);
					
					break;
				case 4:
					System.out.println("[[종료]]"); end = 1;
					break; //
				default :
					System.out.println("[[알 수 없는 번호입니다]]");
			}
			if(end == 1) break;
			
		}
	}	
}
