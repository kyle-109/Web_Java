package Day10;

public class Admin extends Member{
	
	private String adminGrade;
	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String id, String passWord, String adminGrade) {
		super(id, passWord);
		this.adminGrade = adminGrade;
		// TODO Auto-generated constructor stub
	}

	

	public String getAdminGrade() {
		return adminGrade;
	}

	public void setAdminGrade(String adminGrade) {
		this.adminGrade = adminGrade;
	}

	@Override
	public void info() {
		super.info();
		System.out.println("등급은 "+adminGrade);
	}
	
	
}
