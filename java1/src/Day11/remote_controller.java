package Day11;

public interface remote_controller {
	
	// 멤버: 상수, 추상메서드, default메서드
	
	int maxNoise = 10;
	int minNoise = 0;
	
	// 추상메서드 : 선언O, 정의X
	public abstract void start();
	public void end();
	public void setLevel(int noise);
	
	// default 메소드 : 선언O 정의 O
	public default void changeChannel() {
		System.out.println("채널변경");
	}
	
}
