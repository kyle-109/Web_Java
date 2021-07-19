package Day03;

import java.util.Scanner;

public class Day03_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		문제3 : 하나의 정수를 입력받아 7의 배수인지 출력[ true , false ]
			System.out.print("정수를 입력하시오: "); int num1 = scanner.nextInt();
			System.out.println("입력한 수가 7의 배수입니까? "+((num1%7)==0));
//		문제4 : 하나의 정수를 입력받아 홀수 인지 확인 [ true , false ]
			System.out.print("정수를 입력하시오: "); int num2 = scanner.nextInt();
			System.out.println("입력한 수가 홀수입니까? "+((num2%2)!=0));
//		문제5 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 확인 [ true , false ]
			System.out.print("정수를 입력하시오: "); int num3 = scanner.nextInt();
			System.out.println("입력한 수가 7의 배수이면서 짝수입니까? "+((num2%2)==0&&(num1%7)==0));
//		문제6 : 두개의 정수를 입력받아 더 큰지 출력  [ true , false ]
			System.out.print("정수1를 입력하시오: "); int num4 = scanner.nextInt();
			System.out.print("정수2를 입력하시오: "); int num5 = scanner.nextInt();
			System.out.println("정수1이 정수2보다 큽니까? "+(num4>num5));
//		문제7 : 반지름을 입력받아 원 넓이 출력하기 
//			// 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]
			System.out.print("반지름을 입력하시오: "); int num6 = scanner.nextInt();
			System.out.println("원의 넓이는 "+(num6*num6*3.14));
//		문제8 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기
//			// 예) 54.5   84.3 이면    64.285714%
			System.out.print("실수1를 입력하시오: "); double num7 = scanner.nextDouble();
			System.out.print("실수2를 입력하시오: "); double num8 = scanner.nextDouble();
			System.out.println("실수1이 실수2의 몇 %입니까? "+((num7/num8)*100)+"%");
			System.out.printf("실수1이 실수2의 몇 %입니까? %.1f %%", ((num7/num8)*100));
				//형식문자 : %f [실수]
					//%.숫자f [숫자: 소수점 자리수]
					//%.2f [소수점 2자리수]
//		문제9 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기]
//			//사다리꼴 계산식 = > (윗변 * 밑변) * 높이 / 2
			System.out.print("윗변의 길이를 입력하시오: "); int num9 = scanner.nextInt();
			System.out.print("밑변의 길이를 입력하시오: "); int num10 = scanner.nextInt();
			System.out.print("높이를 입력하시오: "); int num11 = scanner.nextInt();
			System.out.println("사다리꼴의 넓이는 "+(((num9+num10)*num11)/2));
//		문제10: 키를 정수를 입력받아 표준체중 출력하기
//			//표준체중 계산식 = > (키 - 100) * 0.9
			System.out.print("키를 입력하시오: "); int num12 = scanner.nextInt();
			System.out.println("표준체중은 "+(((num12-100)*0.9)));
	}
}
