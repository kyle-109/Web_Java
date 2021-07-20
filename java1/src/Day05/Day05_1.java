package Day05;

public class Day05_1 {
		
		//수업날짜별 진도현황
		// 1. 출력
		// 2. 변수, 자료형
		// 3. 연산자, 제어문
		// 4. 제어문
		// 5. 반복문
	
		// 반복문 [조건에 따른 반복실행], 어디서부터 어디까지 어떻게 반복할지
			// for, while, do~while
			
			// 1. for: 어디서부터 어디까지 어떻게 증가하면서 반복실행
				// for(초기값, 조건문, 증감식){ 실행문; }
			// 2. for 중첩
				// for1(){for2(){for3(){}}}
				// 총 실행횟수: for1 실행횟수 * for2 실행횟수 *for3 실행횟수
		public static void main(String[] args) {
			
			// 예1)
			for(int i = 0; i<10; i++) {
				System.out.print(i+" ");
				// i = 0일때 조건:T 반복실행 O
				// 증감식[i+1] i = 1 일때 조건 : T 반복실행 O
				// ~~~~~~~~~~~~~~~~~~~~~~~~
				// 증감식[i+1] i = 10일때 조건 : F 반복종료
				}
				// 1. 초기값(int i = 0) : for 시작변수의 값
				// 2. 조건문(i<10) : True이면 반복문 실행 아니면 [false] 실행X
				// 3. 증감식(i++/i=i+1/i+=1) : 변수의 증감단위
			System.out.println("\n====================");
			// 예2)
			for( int i = 0; i<=50; i++) {
				System.out.print(i+" ");
			}
			// 예3)
			System.out.println("\n====================");
			for(int i = 0; i<=50; i+=3) {
				System.out.print(i+" ");
			}
			
			// 예4)
			System.out.println("\n====================");
			int total=0;
			for(int i = 1; i<=50; i++) {
				total+=i;
			}
			System.out.println("1부터 50까지 누적합계는 "+total);
			
			// 예5)
			System.out.println("\n====================");
			int total2=0;
			for(int i = 0; i<=50; i+=7) {
				total2+=i;
			}
			System.out.println("1~50까지 7배수들의 누적합계 :"+total2);
			int total3=0;
			for(int i = 1; i<=50; i++) {
				if(i%7==0) {
					total3+=i;
				}
			}
			System.out.println("1~50까지 7배수들의 누적합계 :"+total3);
			
			// 예6) 2단 구구단 [2단: 상수 곱:변수]
			System.out.println("\n====================");
			for(int multiple = 1; multiple<=9; multiple++) {
				// multiple은 1부터 9까지 1씩 증가하면서 반복실행(9번 실행)
				System.out.println("2 X "+multiple+" = "+ (2*multiple));
			}
			//for 중첩
			for(int i = 0; i<=5; i++) {
				System.out.println("i의 위치: "+i);
				for(int j= 0; j<=5; j++) {
					System.out.println("----- j의 위치: "+j+"그리고 현재 i의 위치: "+i);
					
					//i가 1번 실행마다 j는 5번 실행
					//i는 총 6번실행 => j는 30번 실행
				}
			}

			// 예7) 2~15단 구구단 
				// 단: 2~15단까지 1씩 증가하면서 반복
					// 곱은 단마다 1~9까지 1씩 증가하면서 반복
			System.out.println("\n====================");
			for(int i = 1; i<=15; i++) {
				System.out.println("==="+i+"단 결과");
				for(int j = 1; j<=9; j++) {
					System.out.println(i+" X "+j+" = "+(i*j));
				}
			}
			
		
		
		
		
		}
		
			
	
	
}
