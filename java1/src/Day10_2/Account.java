package Day10_2;

import java.util.Scanner;

public class Account {
		// 1. 계좌클래스 [슈퍼클래스]
			// 필드 : 계좌번호, 비밀번호, 예금액
			// 생성자 :
			// 메소드 : 계좌생성, 입급, 출금, 이체
	
	//필드
	private String accountNumber; // -포함O String 포함X int
	private String accountPassWord;
	private int accountMoney;
	
	// 생성자
	public Account() {
	}
	
	public Account(String accountNumber, String accountPassWord, int accountMoney) {
		this.accountNumber = accountNumber;
		this.accountPassWord = accountPassWord;
		this.accountMoney = accountMoney;
	}

	// 메소드
	//1. 계좌생성
	public void create() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[[[ 계좌번호: ]]]"); String number = scanner.nextLine();
		System.out.println("[[[ 비밀번호: ]]]"); String password = scanner.nextLine();
		System.out.println("[[[ 초기금액: ]]]"); int money = scanner.nextInt();
		
		//객체화
		Account account = new Account(number, password, money);
		// 배열
		for(int i = 0; i<Day10_3.accounts.length; i++) {
			if(Day10_3.accounts[i] == null) {
				Day10_3.accounts[i] = account;
				System.out.println("[[[ 계좌 생성 완료 ]]]");
				return; //메소드 종료
			}
		}
		System.out.println("[[[ 계좌 생성 불가 : 관리자에게 문의 바랍니다. ]]]");
	}
	//2. 입금[계좌번호와 입금액을 받아 입금처리]
	public void deposit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[[[ 계좌번호: ]]]"); String number = scanner.nextLine();
		System.out.println("[[[ 넣을 금액: ]]]"); int money = scanner.nextInt();
		int result = findAccount(number);
		if(result == -1) {
			return;
		}
		Day10_3.accounts[result].accountMoney+=money;
		System.out.println("[[ 계좌번호 "+number+"에 "+money+"원 입금했습니다. ]]");
	}
	//3. 출금[계좌번호와 비밀번호 입력받아 동일하면 출금처리]
	public void withdraw() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[[[ 계좌번호: ]]]"); String number = scanner.nextLine();
		System.out.println("[[[ 비밀번호: ]]]"); String password = scanner.nextLine();
		System.out.println("[[[ 뺄 금액: ]]]"); int money = scanner.nextInt();
		int result = findAccount(number);
		if(result == -1) {
			return;
		}
		if(Day10_3.accounts[result].accountMoney<money) {
			System.out.println("[[[ 예금액이 부족합니다 ]]]");
			return;
		}
		if(!(Day10_3.accounts[result].accountPassWord.equals(password))) 
		{
			System.out.println("[[[ 비밀번호가 틀렸습니다. ]]]");
			return;
		}
		if(Day10_3.accounts[result].accountPassWord.equals(password)) 
		{
		Day10_3.accounts[result].accountMoney-=money;
		System.out.println("[[ 계좌번호 "+number+"에 "+money+"원 출금했습니다. ]]");
		}
		
	}
	//4. 이체 [계좌번호 와 비밀번호 입력받아 동일하면 이체액을 받아 받는 사람의 계좌번호로 넣기]
	public void transfer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[[[ 출금할 계좌번호: ]]]"); String fromNumber = scanner.nextLine();
		System.out.println("[[[ 비밀번호: ]]]"); String password = scanner.nextLine();
		System.out.println("[[[ 받을 사람 계좌번호: ]]]"); String toNumber = scanner.nextLine();
		System.out.println("[[[ 보낼금액: ]]]"); int money = scanner.nextInt();
		int from = findAccount(fromNumber);
		int to = findAccount(toNumber);
		if(from == -1) {
			System.out.println("출금할 계좌번호가 일치 하지 않습니다");
			return;
		}
		if(to == -1) {
			System.out.println("이체할 계좌번호가 일치 하지 않습니다");
			return;
		}
		if(!(Day10_3.accounts[from].accountPassWord.equals(password))) 
		{
			System.out.println("[[[ 비밀번호가 틀렸습니다. ]]]");
			return;
		}
		if(Day10_3.accounts[from].accountMoney<money) {
			System.out.println("[[[ 예금액이 부족합니다 ]]]");
			return;
		}
		if(Day10_3.accounts[from].accountPassWord.equals(password)) 
		{
		Day10_3.accounts[from].accountMoney-=money;
		Day10_3.accounts[to].accountMoney+=money;
		System.out.println("[[ 계좌번호 "+ toNumber+"에 "+money+"원 송금했습니다. ]]");
		}
	}
	
	public int findAccount(String number) {
		// 메소드
		// 1. 반환타입 : int => 메소드 종료되면서 int형 데이터 return
		// 2. 인수 : String => 메소드 시작되면서 메소드로 들어오는 데이터[계좌를 찾기 위한 검사대상]
		for(int i = 0; i<Day10_3.accounts.length; i++) {
			if(Day10_3.accounts[i] !=null && Day10_3.accounts[i].accountNumber.equals(number)) {
				return i;
			}
		}
		System.out.println("[[ 동일한 계좌번호가 존재하지 않습니다 ]]");
		return -1;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountPassWord() {
		return accountPassWord;
	}

	public void setAccountPassWord(String accountPassWord) {
		this.accountPassWord = accountPassWord;
	}

	public int getAccountMoney() {
		return accountMoney;
	}

	public void setAccountMoney(int accountMoney) {
		this.accountMoney = accountMoney;
	}

	
	
}
