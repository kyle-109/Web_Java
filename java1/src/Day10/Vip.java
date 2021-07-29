package Day10;

public class Vip extends Member{
	
	private String memberGrade;

//	public void test() {
//		this.getId();
//	}
	
	public Vip() {
		super();	
	}

	public Vip(String id, String passWord, String memberGrade) {
		super(id, passWord);
		this.memberGrade = memberGrade;
		
	}

	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		super.info();
		System.out.println("등급은 "+memberGrade);
	}
	
	
}
