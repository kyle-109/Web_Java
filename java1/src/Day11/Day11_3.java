package Day11;

import java.util.Scanner;

public class Day11_3 {
	public static void main(String[] args) {
		// 1. 인터페이스 선언
		ATM atm = null;
		// 2. 연결
		atm = new Bank();
		
		while(true) {
			System.out.println("1.신한 2.국민");
			Scanner scanner = new Scanner(System.in);
			
			int ch = scanner.nextInt();
			if(ch ==1 ) {
				
				atm = new Shinhan();
				// 슈퍼클래스에 연결된 인터페이스는 서브클래스내에서도 사용가능
				atm.menu();
			}
			
			
		}
	}
}
