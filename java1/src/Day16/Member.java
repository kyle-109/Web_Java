package Day16;

public class Member<T> {

	private String memberName;
	private T[] memberList;
	
	public Member(String memberName) {
		this.memberName = memberName;
		memberList = (T[])new Object[10];
				// Object 클래스로 메모리 할당받고 자료형 변환
	}
	
	public void add(T t) {
		for(int i=0;i<memberList.length; i++) {
			if(memberList[i]==null)
			{
				memberList[i] = t;
				return;
			}
		}
		System.out.println("[[[명단이 꽉찼습니다]]]");
	}
	
	//get, set메소드
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public T[] getMemberList() {
		return memberList;
	}

	public void setMemberList(T[] memberList) {
		this.memberList = memberList;
	}
	
}
