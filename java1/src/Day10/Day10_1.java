package Day10;

public class Day10_1 {
	
	// 데이터 저장 공간 = 메모리
	
	// 클래스 => 메모리 설계
		// 멤버 : 필드, 생성자, 메서드
	
		// 상속 : extends 
			// 설계도 연장하기
			// 여러 클래스의 공통분모를 슈퍼클래스에 미리 설계하면 빠른 설계 가능
		// 형태 : 서브클래스명 extends 슈퍼클래스명
			// super : 슈퍼클래스의 생성자
				//super() : 빈 생성자
			// Override : 슈퍼클래스내 동일한 멤버 재정의
		// 주의
			//1. 설계도(메모리) 주는[슈퍼클래스] 설계도(메모리) 받는[서브클래스]
			// 서브클래스는 슈퍼클래스의 설계도 이용가능
			// 슈퍼클래스는 서브클래스의 설계도 이용불가
	public static void main(String[] args) {
		
		//1. 클래스를 이용한 객체 생성
		Person person1 = new Person("유재석", 20);
			//메소드 호출
			person1.info();

		//2. 상속받은 클래스를 이용한 객체 생성
		Student person2 = new Student("강호동", 21, 2);
			//메소드 호출
			person2.info();
				
		
	}
}
