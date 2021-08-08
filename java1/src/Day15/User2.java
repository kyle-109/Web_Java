package Day15;

public class User2 extends Thread{
	
	private Account account;
	
	public void setaccount(Account account) {
		this.setName("User2");// 스레드 이름 설정
		this.account = account;
	}
	
	@Override
	public void run() {
		account.setmoney(50);
	}
	
}
