package Day11;

public interface kiosk {
	// 필드
	
	// 추상메소드
	public void menu();
	public void select();
	public void pay();
	
	// 디폴트메소드
	public default void end() {
		System.out.println("키오스크 종료");
	}
}
