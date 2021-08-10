package Day19;

public class Start {
	// start만 쓰레드 제공.
	public static void main(String[] args) {
		// 다른 클래스의 메소드 호출 방법
			// 1. static : 정적변수 [모든 프로그램내 메모리 사용]
				// 메소드 하나만 실행할 경우 이것이 좋다.
				// ConsoleProgram.programStart();
			// 2. ConsoleProgram => new로 메모리 주기
				// 객체를 생성하면 모든 멤버가 새로 생긴다
		ConsoleProgram consoleProgram = new ConsoleProgram();
		consoleProgram.programStart();
	}
}
