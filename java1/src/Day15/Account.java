package Day15;

public class Account {
	
	private int money;
	// private : 접근제한자 [ 현재 클래스내에서 호출 가능]
		// get, set 메소드 필요
	
	public int getmoney() {
		return money;
	}
	
	public synchronized void setmoney(int money) {
		this.money=money;
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {}
		
		System.out.println(Thread.currentThread().getName() +" "+ this.money);
	}
}
