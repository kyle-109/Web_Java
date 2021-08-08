package Day16;

public class Course <T>{
					//매개클래스
	
	private String courseName;
	private T[] memberList; //매개클래스
		// 외부로부터 현재클래스로 들어온 자료형/클래스으로 배열 선언
	
	//생성자
	public Course(String courseName, int memberNum) {
		this.courseName = courseName;
		// this.현재클래스 멤버
		this.memberList = (T[])new Object[memberNum]; // 인원수만큼 배열의 크기 할당
				// 제네릭 타입으로 메모리할당X(중요!!!!)
				// Object이기에 강제로 형변환진행
	}
	// 배열에 추가하는 메소드 [코스에 인원 추가]
	public void add(T parameter) {
		// private vs public : 접근제한자
		
		for(int i = 0; i<memberList.length; i++) {
			// i는 0부터 배열의 크기까지 1씩 증가
			if(memberList[i] == null) {
				memberList[i] = parameter;
				break;
			}
		}
		
	}
	
	//get, set
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public T[] getMemberList() {
		return memberList;
	}
	public void setMemberList(T[] memberList) {
		this.memberList = memberList;
	}
}
