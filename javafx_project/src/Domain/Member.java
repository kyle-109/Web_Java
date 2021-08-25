package Domain;

public class Member {
	private String id;
	private String passWord;
	private String name;
	private String email;
	private String phoneNumber;
	private int point;
	
	
	public Member() {}
	
	public Member(String id, String passWord, String name, String email, String phoneNumber, int point) {
		super();
		this.id = id;
		this.passWord = passWord;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.point = point;
	}

	// get,set메소드
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
}
