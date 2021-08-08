package Day15;

public class Music extends Thread{
	
	//필드 : 음악재생 여부 확인
	static boolean msw = true;
	
	//메소드 : 음악종료 메소드 msw => false
	public static void musicStop(boolean sw) {
		msw = sw;
		if(msw) {
			System.out.println("음악시작");
		}
		else {
			System.out.println("음악종료");
		}
		
	}
	
	@Override
	public void run() {
		while(msw) {
			//while(논리): 논리가 true 무한루프 실행
			System.out.println("음악재생중~~");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {	}
		}
	}
	
	
}
