package Day10_2;

public class Kookmin extends Account{
	// 3. 국민은행 클래스 [서브클래스]
		// 필드 : 은행코드 [final]
		// 생성자 : super
		// 메소드 : 오버라이딩
	private final String bankCode ="102"; // 은행식별용 코드

	public Kookmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kookmin(String accountNumber, String accountPassWord, int accountMoney) {
		super(accountNumber, accountPassWord, accountMoney);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void create() {
		System.out.println("[[ 국민은행 계좌 생성 페이지 ]]");
		super.create();
		
	}
	
	@Override
	public void deposit() {
		System.out.println("[[ 국민은행 계좌 입금 페이지 ]]");
		super.deposit();
	}
	
	@Override
	public void withdraw() {
		System.out.println("[[ 국민은행 계좌 출금 페이지 ]]");
		super.withdraw();
	}
	
	@Override
	public void transfer() {
		System.out.println("[[ 국민은행 계좌 이체 페이지 ]]");
		super.transfer();
	}
	
	
	
}
