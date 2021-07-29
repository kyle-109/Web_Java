package Day10;

public class Member {
	
	private String id;
	private String passWord;
	
//	public void test() {
//		this.getAdminGrade(); //서브 클래스 멤버 사용불가 
//	}
	
	public Member() {
		
	}
	
	public Member(String id, String passWord) {
		this.id = id;
		this.passWord = passWord;
	}
	
	public void info() {
		System.out.println("아이디는 "+id);
		System.out.println("비밀번호는 "+passWord);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
