package Day12;

public class exp {
	 // 파일이나 네트워크 쪽에서는 필수적으로 뜬다.
	public static void 예외함수() throws Exception{
		
		// 예외발생
		// class.forname("클래스명") : 무조건 예외발생 => 클래스가 없을 경우에 경우의수
		Class class1 = Class.forName("str");
	}
}
