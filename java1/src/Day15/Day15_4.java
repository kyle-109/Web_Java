package Day15;

public class Day15_4 {
	// 동기화 [synchronized]
		// 여러개의 스레드가 하나의 메모리[변수, 메모리] 접근할때 순서매기기
			// 먼저 접근한 스레드가 끝날때까지 다음 스레드 대기
				// 먼저 접근한 스레드 끝나면 다음 스레드 접근
	public static void main(String[] args) {
		// 공동 계좌
		Account account = new Account();
		
		User1 user1 = new User1();
		user1.setaccount(account);
		user1.start();
		
		//setmoney의 Thread.sleep 2초동안
		//money에 user2의 50이 들어온다
		//synchoronized가 들어가면 
		//먼저 들어온 스레드가 끝날때까지 lock해서 
		//다른 스레드를 waiting 걸어버린다.
		User2 user2 = new User2();
		user2.setaccount(account);
		user2.start();
		
	}
}
