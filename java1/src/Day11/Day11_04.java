package Day11;

public class Day11_04 {
	public static void main(String[] args) {
		
		Car car = new Car();
		SUV car1 = new SUV();
		Normal car2 = new Normal();
		car1.getTireInfo();
	
		for(int i = 1; i<=10; i++) {
			int index = car1.drive();
			
			switch(index) {
			case 1:
				System.out.println("[[[ 금호타이어로 교체 ]]]");
				car.frontLeft = new KumhoTire("앞왼쪽", 10);
				break;
			case 2:
				System.out.println("[[[ 금호타이어로 교체 ]]]");
				car.frontRight = new KumhoTire("앞오른쪽", 10);
				break;
			case 3:
				System.out.println("[[[ 금호타이어로 교체 ]]]");
				car.backLeft = new KumhoTire("뒤왼쪽", 10);
				break;
			case 4:
				System.out.println("[[[ 금호타이어로 교체 ]]]");
				car.backRight = new KumhoTire("뒤오른쪽", 10);
				break;
			}
			index = car2.drive();
			
			switch(index) {
			case 1:
				System.out.println("[[[ 금호타이어로 교체 ]]]");
				car.frontLeft = new KumhoTire("앞왼쪽", 10);
				break;
			case 2:
				System.out.println("[[[ 금호타이어로 교체 ]]]");
				car.frontRight = new KumhoTire("앞오른쪽", 10);
				break;
			case 3:
				System.out.println("[[[ 금호타이어로 교체 ]]]");
				car.backLeft = new KumhoTire("뒤왼쪽", 10);
				break;
			case 4:
				System.out.println("[[[ 금호타이어로 교체 ]]]");
				car.backRight = new KumhoTire("뒤오른쪽", 10);
				break;
			}
			
		}
	}
}

