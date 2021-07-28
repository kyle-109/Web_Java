package Day09;

public class Character {
	
	
	//1. 필드
	public String name; //이름
	protected int lv; //레벨
	int ex; //경험치
	private int power; //공격력
	final String code = "10"; // 상수 
	
	//2. 생성자
	
	
	//3. 메서드
		// set, get 메서드
	public void setpower(int power) {
		this.power = power;
	}
	public int getpower() {
		return power;
	}
	
	public void setlv(int lv) {
		this.lv = lv;
	}
	
	public int getlv() {
		return lv;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
}
