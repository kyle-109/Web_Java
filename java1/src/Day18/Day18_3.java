package Day18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Day18_3 {
	
	public static void main(String[] args) {
		
		
		// 스택 : 입출구 한방향 [LIFO] : 나중에 들어온 메모리 먼저 나감
			// 예) 동전상자, CTRL+Z[최근 명령어 되돌리기], 웹사이트 앞/뒤 페이지
				// push(저장)
				// pop(삭제)
			// Stack 클래스 : Vector 클래스 상속
		
		// 큐 : 입출구 양방향[FIFO]: 먼저 들어온 메모리 먼저출력
			// 예) 줄세우기, 인쇄
				// offer, poll
		
		// 
		Stack<Coin> coinWallet = new Stack<>();
		coinWallet.push(new Coin(100));
		coinWallet.push(new Coin(500));
		coinWallet.push(new Coin(10));

		// 출력
		System.out.println("동전지갑 : "+coinWallet);
		System.out.println("동전갯수 : "+coinWallet.size());
		for(Coin temp : coinWallet) {
			System.out.println(temp);
		}
		
		coinWallet.pop();// 삭제[마지막에 추가된 10원이 삭제]
		System.out.println("동전하나빼기: "+coinWallet);
		
		// 동전 모두 빼기
		while(!coinWallet.isEmpty()) {
			// 메모리가 비어 있지 않으면
			System.out.println(coinWallet.pop());
		}
		
		// 큐
			// 인터페이스 : 혼자서 메모리 할당X
				// 추상메소드 <= 클래스에서 오버라이딩[정의]
		Queue<Coin> coinWallet2 = new LinkedList<>();
		
		coinWallet2.offer(new Coin(100));
		coinWallet2.offer(new Coin(500));
		coinWallet2.offer(new Coin(10));
		
		System.out.println("동전지갑2: "+coinWallet2);
		System.out.println("삭제");
		
		coinWallet2.poll();
		
		System.out.println("동전지갑2: "+coinWallet2);
		
	}
}
