package Day04;

import java.util.Scanner;


public class Day04_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//문제2: 키오스크 프로그램
				//	0. 금액을 입력받아 제품 구매 => 장바구니 담기 => 결제
				//	1. 제품: 1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제
		int cokeNum = 10; int fantaNum = 10; int ciderNum = 10; //재고 변수
		while(true) {
			//제품들의 변수들
			int cokeBuy = 0; int fantaBuy = 0; int ciderBuy = 0; //구매갯수 변수
			int totalPrice = 0;
			while(true) { // 무한루프 [ while{}: 괄호안 코드가 무한실행]
				System.out.println("[[[[ 자판기 ]]]]");
				if(cokeNum == 0) 
				{
					System.out.print("[[[ 1.콜라[제품준비중] ");
				}
				else {
					System.out.print("[[[ 1.콜라[300] ");
				}
				if(fantaNum == 0) 
				{
					System.out.print(" 2.환타[제품준비중] ");
				}
				else {
					System.out.print(" 2.환타[200] ");
				}
				if(ciderNum == 0) 
				{
					System.out.print(" 3.사이다[제품준비중] ");
				}
				else {
					System.out.print(" 3.사이다[100] ");
				}
				System.out.println(" 4.결제 ]]]");
				System.out.print("[[ 선택 ]]: "); int choice = scanner.nextInt();
				if( choice == 1) {
					System.out.println("[[[ 콜라를 담았습니다. ]]]");
					//1. 재고가 없을 경우 구매 불가
					if(cokeNum>0) {// 재고가 있을 경우
						cokeBuy++;
						cokeNum--;
					}
					else {
						System.out.println("[[[ 콜라 재고가 없습니다 ]]]");
					}
				}
				if( choice == 2) {
					System.out.println("[[[ 환타를 담았습니다. ]]]");
					//1. 재고가 없을 경우 구매 불가
					if(fantaNum>0) {// 재고가 있을 경우
						fantaBuy++;
						fantaNum--;
					}
					else {
						System.out.println("[[[ 환타 재고가 없습니다 ]]]");
					}
				}
				if( choice == 3) {
					System.out.println("[[[ 사이다를 담았습니다. ]]]");
					//1. 재고가 없을 경우 구매 불가
					if(ciderNum>0) {// 재고가 있을 경우
						ciderBuy++;
						ciderNum--;
					}
					else {
						System.out.println("[[[ 사이다 재고가 없습니다 ]]]");
					}
				}
				if( choice == 4) {
					System.out.println("[[[ 장바구니 ]]]");
					if(cokeBuy == 0 && fantaBuy == 0 && ciderBuy == 0) {System.out.println("[[[ 구매하신 제품이 없습니다. ]]]");}
					else {
						if( cokeBuy !=0) {System.out.println("콜라 구매수 : "+ cokeBuy + ", 결제액 : "+cokeBuy*300);}
						if(fantaBuy !=0){System.out.println("환타 구매수 : "+ fantaBuy + ", 결제액 : "+fantaBuy*200);}
						if(ciderBuy !=0){System.out.println("사이다 구매수 : "+ ciderBuy + ", 결제액 : "+ciderBuy*100);}
						totalPrice = (cokeBuy*300)+(fantaBuy*200)+(ciderBuy*100);
						System.out.println("결제하시겠습니까? 예[1] 아니요[0]"); int choice2 = scanner.nextInt();
						if( choice2 == 1) {
							System.out.println("[[[ 금액 투여 ]]] : "); int price = scanner.nextInt();
							//1. 총결재액보다 금액이 적은 경우 결제X
							if(price < totalPrice) {
								System.out.println("[[ 금액 부족(초기화면) ]]]");
								cokeNum+=cokeBuy;
								fantaNum+=fantaBuy;
								ciderNum+=ciderBuy;
								break;
							}
							else {
								price -= totalPrice;
								System.out.println("[[[ 결제완료 ]]] : 잔돈 : "+price);
								break;
							}
						}
						if( choice2 == 0) {
							System.out.println("[[[ 초기 화면으로 이동 ]]]");
							cokeNum+=cokeBuy;
							fantaNum+=fantaBuy;
							ciderNum+=ciderBuy;
							break;
						}
					
						break; // while 종료
					}
				}
			} // 무한루프 종료 지점.
		}
	}
}
