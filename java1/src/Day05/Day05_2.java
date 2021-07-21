package Day05;

import java.util.Scanner;

public class Day05_2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// for 문으로 별찍기.
		// 별1) 입력받은 정수만큼 별 출력
		System.out.print("1번째 문제 별 개수: ");
		int num = scanner.nextInt();
		for(int i=1; i<=num; i++) {
			System.out.print("* ");
		}
		System.out.println("\n====================");

		
//		// 별2) 입력받은 정수만큼 별 출력 [* 5개마다 줄바꿈]
//		System.out.print("2번째 문제 별 개수: ");
//		int num2 = scanner.nextInt();
//		for(int i = 1; i<=num2; i++) {
//			System.err.println("* ");
//			
//			//5개마다 줄바꿈처리 [5배수]
//			if(i%5==0) System.out.println();
//		}
//		System.out.println("\n====================");
		
		
		// 별3) 입력받은 줄만큼 출력
		System.out.print("3번째 문제 줄 개수:");
		int num3 = scanner.nextInt();
		for(int i = 1; i<=num3; i++) {
			for(int j = 1; j<=num3; j++) {
				if(j<=i) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}


		// 별4) 입력받은 줄만큼 출력
		System.out.print("4번째 문제 줄 개수:");
		int num4 = scanner.nextInt();
		for(int i = 1; i<=num4; i++) {
			for(int j = 1; j<=num4; j++) {
				if(j<=num4-i+1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		// 별5) 입력받은 줄만큼 출력
		System.out.print("5번째 문제 줄 개수:");
		int num5 = scanner.nextInt();
		for(int i = 1; i<=num5; i++) {
			for(int j = 1; j<=num5; j++) {
				if(j<=num5-i) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		// 별6) 입력받은 줄만큼 출력
		System.out.print("6번째 문제 줄 개수:");
		int num6 = scanner.nextInt();
		for(int i = 1; i<=num6; i++) {
			for(int j = 1; j<=num6; j++) {
				if(i<=j) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		// 별7) 입력받은 줄만큼 출력
		System.out.print("7번째 문제 줄 개수:");
		int num7 = scanner.nextInt();
		for(int i = 1; i<=num7; i++) {
			for(int j = 1; j<=(num7*2-1); j++) {
				if(j<(num7-i+1) || j>(num7+i-1)) {
					System.out.print(" ");
					
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		// 별8) 입력받은 줄만큼 출력
		System.out.print("8번째 문제 줄 개수:");
		int num8 = scanner.nextInt();
		for(int i = 1; i<=num8; i++) {
			for(int j = 1; j<=(num8*2-1); j++) {
				if(j<(num8-i+1) || j>(num8+i-1)) {
					System.out.print(" ");
				}		
				else {
					System.out.print(i);
				}					
			}
			System.out.println();
		}

		// 별9) 입력받은 줄만큼 출력
		System.out.print("9번째 문제 줄 개수:");
		int num9 = scanner.nextInt();
		for(int i = 1; i<=num9; i++) {
			for(int j = 1; j<=(num9*2-1); j++) {
				if(j<i || j>(num9*2-i)) {
					System.out.print(" ");
					
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		// 별10) 입력받은 줄만큼 출력
		System.out.print("10번째 문제 줄 개수:");
		int num10 = scanner.nextInt();
		for(int i = 1; i<num10; i++) {
			for(int j = 1; j<=(num10*2-1); j++) {
				if(j<(num10-i+1) || j>(num10+i-1)) {
					System.out.print(" ");
					
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for(int i = 1; i<=num10; i++) {
			for(int j = 1; j<=(num10*2-1); j++) {
				if(j<i || j>(num10*2-i)) {
					System.out.print(" ");
					
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		// 별11) 입력받은 줄만큼 출력
		System.out.print("11번째 문제 줄 개수:");
		int num11 = scanner.nextInt();
		for(int i = 1; i<=(num11*2-1); i++) {
			for(int j = 1; j<=(num11*2-1); j++) {
				if(j==i || j==(num11*2-i)) {
					System.out.print("*");
					
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}	
		
		// 별12) 입력받은 줄만큼 출력
		System.out.print("12번째 문제 줄 개수:");
		int num12 = scanner.nextInt();
		for(int i = 1; i<=(num12*2-1); i++) {
			for(int j = 1; j<=(num12*2-1); j++) {
				if(i<=num12) {
					if(j<=i || j>=(num12*2-i)) {
						System.out.print("*");
					
					}
					else {
						System.out.print(" ");
					}
				}
				else {
					if(j>=i || j<=(num12*2-i)) {
						System.out.print("*");
					
					}
					else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}	

		
		
	}
}
