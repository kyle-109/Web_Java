package Day11;

public class Bank implements ATM{
	String accountNumber;
	int money;
	
	@Override
	public void menu() {
		System.out.println("메뉴페이지");
		
	}
	@Override
	public void create() {
		System.out.println("계좌생성페이지");
		
	}
	@Override
	public void deposit() {
		System.out.println("예금페이지");
		
	}
	@Override
	public void withdraw() {
		System.out.println("출금페이지");
		
	}
	@Override
	public void transfer() {
		System.out.println("이체페이지");
		
	}
	@Override
	public void showMoney() {
		System.out.println("잔금페이지");
		
	}
}
