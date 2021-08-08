package Day15;

public class Movie extends Thread{
	
	// 필드 : 영화재생 여부 확인
	static boolean mvsw = true;
	
	// 메소드 : 영화종료 메소드 mvsw => false
	public static void movieStop(boolean vsw) {
		mvsw = vsw;
		if(mvsw) {
			System.out.println("영화시작");
		}
		else {
			System.out.println("영화종료");
		}
	}
	
	@Override
	public void run() {
		while(mvsw) {
			System.out.println("영화재생중~~");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {}
		}
	}

}
