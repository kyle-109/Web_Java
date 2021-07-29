package Day10;

public class Day10_2 {
	// 회원 클래스로 상속받아 vip 클래스, 관리자 클래스, 일반 클래스
		// 슈퍼클래스 : 회원클래스
			// 아이디, 비밀번호
			//생성자
			// 메소드 : 회원정보 출력 메소드
	
		// 서브클래스 : vip, 관리자, 일반
			// vip : 회원등급
			// 관리자 : 관리자직급
				// 회원정보 메소드 오버라이딩
	
	public static void main(String[] args) {
		
		// 1. 슈퍼클래스 객체
		Member member = new Member("qwe", "qwe");
		
		// 2. 서브클래스 객체
		Vip vip = new Vip("asd", "asd", "gold");
		Admin admin = new Admin("zxc", "zxc", "CEO");
		
		// 슈퍼클래스로 배열
		Member[] members = new Member[3];
			members[0] = member;
			members[1] = vip;
			members[2] = admin;
			// 슈퍼클래스로 선언된 배열에는 서브클래스도 저장 가능
			
		
		Vip[] vips = new Vip[3];
			//vips[0] = member; 불가능
			vips[1] = vip;
			//vips[2] = admin; 불가능
			// 서브클래스로 선언된 배열에는 슈퍼클래스 저장 불가능
		Admin[] admins = new Admin[3];
			//admins[0] = member;
			//admins[1] = vip;
			admins[2] = admin;
	
	}
}
