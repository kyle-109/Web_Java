package Day11;

public class SUV extends Car{
	Tire frontLeft = new KumhoTire("앞왼쪽", 10);
	
	public void getTireInfo() {
		System.out.println(frontLeft.toString());
		System.out.println(frontRight.toString());
	}
}
