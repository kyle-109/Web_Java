package Day11;

public class Lotteria implements kiosk{

	// 오버라이딩
	@Override
	public void menu() {
		// TODO Auto-generated method stub
		System.out.println("롯데리아 메뉴");
	}
	
	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("롯데리아 장바구니");
	}
	
	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("롯데리아 결제");
	}
	
}
