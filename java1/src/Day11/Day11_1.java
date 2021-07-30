package Day11;

public class Day11_1 {
	
	// 인터페이스 : 사용자가 기기를 쉽게 동작시키는 시스템
		// 목적 : 여러 클래스들이 동일한 목적하에 동일한 기능을 수행
			// 유지보수성 높일 수 있음.
		// 형태
			// interface 이름
		// 멤버 : 상수, 추상메서드
			// 상수 : 고정된 변수
			// 추상메서드 : 선언O, 코드 구현X
				// 왜?? : 서로 다른 클래스들의 서로 다른 코드구현.
		// 키워드
			// abstract : 추상[기본값] [선언O 정의X]
			// default : 추상제거 [ 선언O 정의O]
	public static void main(String[] args) {
		
		// 리모컨 객체 생성
		remote_controller remote;
		
		// 리모컨에 클래스 연결
		remote = new Television();
		remote.start();
		remote.setLevel(5);
		remote.end();
		
		// 리모컨에 클래스 교체
		remote = new Audio();
		remote.start();
		remote.setLevel(15);
		remote.end();
		
		// 리모컨에 스마트텔레비전 클래스 교체
		remote = new smartTelevision();
		remote.start();
		remote.setLevel(5);
		remote.end();
	}
}
