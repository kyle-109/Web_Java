package Day11;

public class Television implements remote_controller{
					 // implements 인터페이스
	// 멤버: 필드, 생성자, 메소드
	
	int noise = 0;
	
	// 추상메서드 코드 구현 => 오버라이딩
	
	@Override
	public void start() {
		System.out.println("텔레비전 실행");
			
	}
	
	@Override
	public void end() {
		System.out.println("텔레비전 종료");
	}
	
	@Override
	public void setLevel(int noise) {
		if(noise > remote_controller.maxNoise) {
			noise = remote_controller.maxNoise;
		}else if(noise < remote_controller.minNoise) {
			noise = remote_controller.minNoise;
		}else {
			this.noise = noise;
		}
		System.out.println("현재 소음 : "+noise);
	}
	
}
