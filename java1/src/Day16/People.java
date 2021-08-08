package Day16;

public class People {
	
	// 필드
	private String name;
	private int age;
	
	// 생성자
	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 메소드
	@Override
	public String toString() {
		return this.name+"("+this.age+")";
	}
	
	// get,set 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
