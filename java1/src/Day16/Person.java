package Day16;

public class Person {
	//Worker, Student의 super클래스
	
	// 필드
	private String name;
	
	// 생성자
	public Person(String name) {
		this.name = name;
	}

	
	// 메소드 = get, set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override // Object 클래스내 메소드 재정의
	public String toString() {
		return this.name;
	}
	
}
