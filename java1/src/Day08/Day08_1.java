package Day08;

public class Day08_1 {
	
	public static void main(String[] args) {
		
		// java는 100% 객체지향 언어
			// 객체: 설계도(클래스)를 기반으로 만들어진 대상
				// 클래스: 설계도
					// 모든 클래스는 object 클래스로부터 시작된다.
		
		// 클래스
			// 1. 멤버 : 필드, 생성자, 메소드
				// 필드 : 변수, 객체 등
				// 생성자 : 빈생성자, 모든 필드를 받는 생성자은 일반적으로 만들고 시작한다.  
				// 메소드[함수] : 미리 만들어진 코드
					// 1. 재활용 되는 코드 [여러번 사용되는 코드]
					// 2. 미리 작성된 하나의 코드들의 집합
					// 3. 인수와 반환
						// 인수 : 메소드 안으로 들어오는 데이터
						// 반환 : 메소드 밖으로 나가는 데이터[메소드 내 모든 메모리 초기화 => return 데이터해서 필요한 데이터를 꺼내온다.]
					// 4. 메소드 안에서 선언되는 메모리는 메소드 종료시 초기화[메모리 효율적 사용 가능]
				
					
		
		// 1. 회원가입 설계도
			// 상태[필드] : 1. 아이디 2. 닉네임 3. 비밀번호 4. 이름 5. 이메일 
			// 객체초기값[생성자] : 객체 생성시 필드의 값 유무
			// 행동[메소드] : 1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기 5. 회원탈퇴
			
		// 2. 게시판 설계도
			// 상태[필드]: 1. 닉네임 2. 비밀번호 3. 제목 4. 내용
			// 객체초기값[생성자]
			// 행동[메소드] : 1. 글쓰기 2. 글보기 3. 글삭제 4. 글수정 등
		
		
		// 예1) 빈생성자 [객체선언시 필드에 데이터X]
			// 1. 객체 선언 [ 클래스명 객체명[임의] = new 생성자(); ]
				// 깡통을 만들어서 추후에 넣을 것인지
				// 1. new : 객체 선언시 메모리 할당 연산자
				// 2. 생성자() : 클래스에 생성자 없을 경우 빈생성자 자동 생성
		Member member = new Member();
		
			// 2. 객체 내 멤버 접근시[ .=접근연산자]
				// 멤버 : 필드, 생성자, 메소드
		System.out.println(member.id);
		member.id = "zxc";
		member.nickName = "zxc";
		member.password = 1234;
		member.name = "zxc";
		member.email = "zxc@zxc";
		
		// 예2) 생성자 이용한 객체 선언[객체선언시 미리 필드에 데이터 넣기]
		Member member2 = new Member("qwe", "qwe", 1234, "qwe", "qwe@qwe");
									// 생성자(인수1, 인수2, 인수3, 인수4, 인수5)
										// 인수 : 생성자 안으로 들어가는 데이터
		System.out.println(member2.id);
		
		
		// 예3) 생성자 이용한 객체 선언2
		Member member3 = new Member("asd", 456);
		
		System.out.println(member3.id);
		
		
		// 메소드
		
		// 예1)
		System.out.println("회원 1 메소드 호출");
		member.info();
		System.out.println("회원 2 메소드 호출");
		member2.info();
		System.out.println("회원 3 메소드 호출");
		member3.info();
		
		// 예2) 반환타입이 있는 메소드 호출
		String email = member.getemail();
		System.out.println("getemail 메소드에 리턴된 결과 : "+email);
		
		// 예3) 인수와 반환이 있는 메서드 호출
		String result = member.setname("유재석");
		System.out.println("결과 : "+result+" 새로운 이름 : "+member.name);
				
		// 예4) 인수가 있는 메서드 호출
		member.setemail("ert@ert");
		System.out.println("결과 : "+member.email);
		
		
		
	}
}
