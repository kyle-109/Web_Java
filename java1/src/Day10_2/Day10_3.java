package Day10_2;

import java.util.Scanner;

public class Day10_3 {
	// ATM 클래스
	
	//main 밖에 선언하는 이유: 다른 클래스나 패키지에서도 호출하기 위해서
	public static Account[] accounts = new Account[100];
		// 계좌객체 100개를 저장할 수 있는 배열
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1. 신한은행  2. 국민은행");
			int bank = scanner.nextInt();
			while(true) {
				int i = 1;
				if(i==-1) {break;}
				System.out.print("1. 계좌생성  ");
				System.out.print("2. 계좌입금  ");
				System.out.print("3. 계좌출금  ");
				System.out.print("4. 계좌이체  ");
				System.out.print("5. 뒤로가기 : ");
				int ch = scanner.nextInt();
				if(ch == 1) {
					if(bank == 1) {
						Shinhan shinhan1 = new Shinhan();
						shinhan1.create();
					}
					else {
						Kookmin kookmin1 = new Kookmin();
						kookmin1.create();
					}
				}
				if(ch == 2) {
					if(bank == 1) {
						Shinhan shinhan1 = new Shinhan();
						shinhan1.deposit();
					}
					else {
						Kookmin kookmin1 = new Kookmin();
						kookmin1.deposit();
					}
				}
				if(ch == 3) {
					if(bank == 1) {
						Shinhan shinhan1 = new Shinhan();
						shinhan1.withdraw();
					}
					else {
						Kookmin kookmin1 = new Kookmin();
						kookmin1.withdraw();
					}
				}
				if(ch == 4) {
					if(bank == 1) {
						Shinhan shinhan1 = new Shinhan();
						shinhan1.transfer();
					}
					else {
						Kookmin kookmin1 = new Kookmin();
						kookmin1.transfer();
					}
				}
				if(ch == 5) {
					i = -1;
				}
				if(i==-1) {
					break;
				}
			}
		}
	}
}
