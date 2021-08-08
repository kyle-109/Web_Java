package Day15;

import java.awt.Toolkit;

public class Day15_1 {
	//Toolkit은 java 11부터 지원x
	//내 컴퓨터에서는 java 8부터 지원
	
	// 스레드 : 프로세스 내에서 실행되는 흐름의 단위
		// 프로세스 : 연속적으로 실행중인 프로그램
			// 프로그램 : 작업을 수행하는 명령어[코드]집합
	// 멀티스레드
		// Thread
			// .run() : 멀티 스레드의 실행코드 정의
			// .start() : 멀티 스레드 시작[run 실행]
			// .getName() : 해당 스레드의 스레드 이름
			// .sleep() : 스레드 일시정지 // 단위가 밀리초, 1000밀리초 => 1초
			// .currentThread() : 현재 스레드의 정보
	
		// Runnable 인터페이스
			// run 추상메서드
	
				// 상속 vs 인터페이스
				// extends 하나의 클래스명
					// 하나만 상속가능하기에 상속받을 것이 있다면 인터페이스로 구현해야 여러가지 기능을 사용할 수 있다.
				// implements 여러 개의 인터페이스
	
	// 병행 처리 [컴퓨터 : 병행처리X]
		// 운영체제가 cpu로부터 자원을 할당받아 스레드에게 분배 [ 스케줄링 ] 
	
	public static void main(String[] args) throws Exception{
		// main 메소드 : Main Thread 포함 [ 단일 스레드 ]
		
		// 1. 단일 스레드 
		
		// 소리
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
//		for(int i=0; i<5; i++) {
//			toolkit.beep(); // 경고음
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		// 출력
//		for(int i=0; i<5; i++) {
//			System.out.println("띵");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} // 스레드 일시정지 [ 밀리초 1000 => 초]
//		}
		
		System.out.println("=======================멀티스레드 클래스 시작 ===================");
		
		// 2. 멀티 스레드 [소리와 출력 동시 실행]
		Thread thread = new Sound();
		thread.start(); // run메소드가 실행된다.
		//main스레드도 그대로 진행되다.
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} // 스레드 일시정지 [ 밀리초 1000 => 초]
		}
		
		System.out.println("=========멀티스레드 인터페이스 시작==========");
			// 3. 멀티 스레드
			Runnable runnable = new Sound2();
				// runnable : start 메소드 없음
			Thread thread2 = new Thread(runnable);
				// 해당 쓰레드클래스에 스레드인터페이스 넣기
			thread2.start();
			
			// 출력3
			for(int i=0; i<5; i++) {
				System.out.println("띵");
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} // 스레드 일시정지 [ 밀리초 1000 => 초]
			}
		System.out.println("=========멀티스레드 인터페이스 시작==========");
			// 4. 멀티스레드
			Thread thread3 = new Thread(new Runnable() {
				
				@Override
				public void run() {
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
			});
			thread3.start();
			// 출력4
			for(int i=0; i<5; i++) {
				System.out.println("띵");
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} // 스레드 일시정지 [ 밀리초 1000 => 초]
			}
			
			
	}
	
}
