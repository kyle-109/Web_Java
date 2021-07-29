package Day10;

public class Student extends Person{
					// 상속[연장] 슈퍼클래스
	
	// 이름과 나이는 슈퍼클래스로부터 상속받았기 때문에 사용가능
	private int grade;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int grade) {
		super(name, age);
		this.grade = grade;
		// TODO Auto-generated constructor stub
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override // 슈퍼클래스내 동일한 멤버를 재정의
	public void info() {
		super.info();
		System.out.println("학년은 "+grade);
	}
	
	
	
}
