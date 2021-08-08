package Day15;

import java.awt.Toolkit;

public class Sound extends Thread{
				 //extends 클래스명: 상속
	@Override
	public void run() { // 멀티스레드 메소드
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++) {
			toolkit.beep(); // 경고음
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
