package Day11;

import java.util.Scanner;

public class Day11_2 {
	
	public static void main(String[] args) {
		
		// 1. 인터페이스 선언
		kiosk kiosk = null; // 초기값을 null
		// 2. 연결 대상 선택
		Scanner scanner = new Scanner(System.in);
		System.out.print("1. 롯데리아 2. 카페");
		int place = scanner.nextInt();
		
		if(place == 1) {
			kiosk = new Lotteria();
		}
		if(place == 2) {
			kiosk = new Cafe();
		}
		
		while(true) {
			System.out.println("키오스크");
			System.out.println("1.메뉴 2.장바구니 3.결제 4.종료");
			int choice = scanner.nextInt();
			if(choice == 1) {kiosk.menu();}
			if(choice == 2) {kiosk.select();}
			if(choice == 3) {kiosk.pay();}
			if(choice == 4) {kiosk.end();}
		}
	}
}
