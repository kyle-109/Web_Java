package Day11;

public class Tire {
	
	//필드
	int tireLife;
	int rollNumber;
	String tireLocation;
	
	
	//생성자(객체 초기값)
	public Tire(String tireLocation, int tireLife) {
		this.tireLife = tireLife;
		this.tireLocation = tireLocation;
	}
	
	// 메소드(행동)
	public boolean roll() {
		rollNumber++;
		if(rollNumber < tireLife) {//타이어 수명 남음
			System.out.println(tireLocation + "타이어 수명 "+ (tireLife-rollNumber)+"회 남음");
			return true;
		}
		else {// 수명끝
			System.out.println(tireLocation + "타이어 펑크[교체바람]");
			return false;
		}
	}
}
