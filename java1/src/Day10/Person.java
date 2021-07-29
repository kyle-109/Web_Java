package Day10;

public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void info() {
		System.out.println("이름은 "+name);
		System.out.println("나이는 "+age);
	}
	
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
