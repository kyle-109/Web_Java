package Day14;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

public class Day14_1 {
	
	public static void main(String[] args) {
		//oracle에서 제공하는 api 가이드를 보기 위해서 구글에 java자바버전 api 검색(ex. java14 api)
		
		// 협정세계시(UTC)
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
			System.out.println("협정시계 시간 : "+zonedDateTime);
		ZonedDateTime newyork = ZonedDateTime.now(ZoneId.of("America/New_York"));
			System.out.println("뉴욕 시간 : "+newyork);
		
		// Math 클래스 : 수학 계산 관련 메소드 제공
			int 정수1 = Math.abs(-5);
				System.out.println("절대값: "+ 정수1);
			double 실수1 = Math.abs(-3.14);
				System.out.println("절대값: "+ 실수1);
			
			double 실수2 = Math.ceil(5.3);
				System.out.println("올림: "+실수2);
			double 실수3 = Math.ceil(-5.3);
				System.out.println("올림: "+실수3);
				
			System.out.println("실수 5.3 내림: "+Math.floor(5.3));
			System.out.println("실수 -5.3 내림: "+Math.floor(-5.3));
			
			System.out.println("5, 9중 최댓값: "+ Math.max(5, 9));
			//max함수는 인수를 2개밖에 받지 못해서 많은 갯수를 비교할 경우 직접만들거나 for문을 돌려야 한다
			System.out.println("5, 9중 최솟값: "+ Math.min(5, 9));
			
			Random random = new Random();
			System.out.println("랜덤객체: "+ random.nextInt(30));
			System.out.println("랜덤(0~1): "+ Math.random());
			
			System.out.println("가까운 정수의 실수값[반올림]: "+ Math.rint(5.3));//5.0, 실수값으로 반환
			System.out.println("가까운 정수의 실수값[반올림]: "+ Math.rint(-5.5));//-6.0
			
			System.out.println("반올림: "+Math.round(5.5));//정수값으로 반환
			System.out.println("반올림: "+Math.round(-5.5));
			
			// 문제1: 12.3456; 소수 둘째자리에서 반올림하기 => 12.3
			double number1 = 12.3456;
			System.out.println((Math.round((number1*10)))/10.0);
			
			System.out.println("==============차량번호 10개 난수로 만들기=========================");
			// 문제2: 차량번호 랜덤으로 0000~9999 사이의 난수를 10개 생성
				//1. 차량번호 난수 10개 저장
				//2. 차량번호 끝자리가 홀수 // 차량번호 끝자리 짝수
			
			// 1. 랜덤객체 선언
			Random 랜덤 = new Random();
			String[] 차량번호 = new String[10];
			String[] 홀수차량 = new String[10];
			String[] 짝수차량 = new String[10];
			
			// 2. 난수 생성 10개
			for(int i = 0; i<10; i++) {
				차량번호[i]=String.format("%04d", 랜덤.nextInt(10000)); // 0~9999사이의 난수 생성
					// String.format("형식문자", 객체[데이터/값])
						// * 형식문자
							// %d: 정수		%f: 실수		%s :문자열
							// 자릿수
								// %숫자d: 데이터가 차지하는 자릿수
								// %0숫자d : 공백이면 0으로 채우기 
				System.out.println(차량번호[i]);
			}
			
			// 3. 끝번호가 홀수/짝수 구분
			for(int i = 0; i<10; i++) {
				int 끝번호 = Integer.parseInt(차량번호[i].substring(3));
				if(끝번호%2==1) {
					for(int j =0;j<10; j++) {
						if(홀수차량[j]==null) {
							홀수차량[j] = 차량번호[i]; 
							break;
						}
					}
				}
				else {
					for(int j =0;j<10; j++) {
						if(짝수차량[j]==null) {
							짝수차량[j] = 차량번호[i]; 
							break;
						}
					}
				}
			}
			
			// 4. 출력
			System.out.println("======홀수차량 목록======");
			for(String string : 홀수차량) {
				if(string != null) {
				System.out.println(string);
				}
			}
			// for 활용
			// for(자료형 임시객체 : 배열명)
				// 배열내 인덱스 0번부터 끝까지 하나씩 임시객체에 대입
			System.out.println("======짝수차량 목록======");
			for(String string : 짝수차량) {
				if(string !=null) {
				System.out.println(string);
				}
			}
			
			// 문자열 => 기존자료형으로 변환
				// 1. 정수형 : Integer.parseInt("문자열")
				// 2. 실수형 : Double.parseDouble("문자열")
				// 3. 논리형 : Boolean.parseBoolean("문자열")
			
			
			
			

			
	}
}
