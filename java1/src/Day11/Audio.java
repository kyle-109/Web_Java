package Day11;

public class Audio implements remote_controller{
	
	int noise = 0;
	
	@Override
	public void start() {
		System.out.println("오디오 실행");
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
		System.out.println("오디오 종료");
	}
}
