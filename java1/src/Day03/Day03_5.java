package Day03;

import java.util.Scanner;

public class Day03_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		
		System.out.println("문제1");
		System.out.print("정수1을 입력하세요"); int num1 = scanner.nextInt();
		System.out.print("정수2을 입력하세요"); int num2 = scanner.nextInt();
		if(num1>num2) {
			System.out.println("더 큰수는 "+num1);
		}
		else if(num1<num2){
			System.out.println("더 큰수는 "+num2);
		}
		else {
			System.out.println("두 정수는 같다");
		}
		
		System.out.print("정수1을 입력하세요"); int num3 = scanner.nextInt();
		System.out.print("정수2을 입력하세요"); int num4 = scanner.nextInt();
		System.out.print("정수3을 입력하세요"); int num5 = scanner.nextInt();
		if(num3>num4 && num3>num5) {
			System.out.println("가장 큰수는 "+num3);
		}
		else if(num4>num3 && num4>num5) {
			System.out.println("가장 큰수는 "+num4);
		}
		else if(num5>num3 && num5>num4) {
			System.out.println("가장 큰수는 "+num5);
		}
		else {
			System.out.println("세 정수는 같다.");
		}
		
		System.out.print("정수1을 입력하세요"); int num6 = scanner.nextInt();
		System.out.print("정수2을 입력하세요"); int num7 = scanner.nextInt();
		System.out.print("정수3을 입력하세요"); int num8 = scanner.nextInt();
		System.out.print("정수4을 입력하세요"); int num9 = scanner.nextInt();
		int big = num6;
		if(big<num7) {
			big = num7;
		}
		if(big<num8) {
			big = num8;
		}
		if(big<num9) {
			big = num9;
		}
		System.out.println("가장 큰수는 "+big);
	}
}
