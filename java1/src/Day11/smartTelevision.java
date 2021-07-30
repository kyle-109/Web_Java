package Day11;

public class smartTelevision implements remote_controller{
	
	int noise = 0;
	
	@Override
	public void start() {
		System.out.println("스마트 텔레비전 실행");
		
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
	
	@Override
	public void end() {
		System.out.println("스마트 텔레비전 종료");
	}
			
}
