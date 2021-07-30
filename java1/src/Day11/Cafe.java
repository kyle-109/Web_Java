package Day11;

public class Cafe implements kiosk{
	@Override
	public void menu() {
		System.out.println("카페 메뉴");
		
	}
	
	@Override
	public void select() {
		System.out.println("카페 장바구니");
		
	}
	
	@Override
	public void pay() {
		System.out.println("카페 결제");
		
	}
}
