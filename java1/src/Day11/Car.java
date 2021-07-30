package Day11;

public class Car implements GearChange{
	
	// 필드
	Tire frontLeft = new Tire("앞왼쪽", 10);
	Tire frontRight = new Tire("앞오른쪽", 8);
	Tire backLeft = new Tire("뒤왼쪽", 9);
	Tire backRight = new Tire("뒤오른쪽", 4);
	// 생성자
	
	// 메소드
	@Override
	public int drive() {
		System.out.println("드라이브");
		if(frontLeft.roll() == false) {
			park();
			return 1; // 고장난 위치
		}
		if(frontRight.roll() == false) {
			park();
			return 2; // 고장난 위치
		}
		if(backLeft.roll() == false) {
			park();
			return 3; // 고장난 위치
		}
		if(backRight.roll() == false) {
			park();
			return 4; // 고장난 위치
		}
		return 0; // 이상없으면
	}
	
	
	@Override
	public void park() {
		System.out.println("주차");
	}
	
	@Override
	public int back() {
		System.out.println("후진");
		if(frontLeft.roll() == false) {
			park();
			return 1; // 고장난 위치
		}
		if(frontRight.roll() == false) {
			park();
			return 2; // 고장난 위치
		}
		if(backLeft.roll() == false) {
			park();
			return 3; // 고장난 위치
		}
		if(backRight.roll() == false) {
			park();
			return 4; // 고장난 위치
		}
		return 0; // 이상없으면
		
	}
	
	@Override
	public int neutral() {
		return 0;
	}
	
	
}
