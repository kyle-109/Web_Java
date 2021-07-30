package Day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Day12_3 {
	
	// 변수, 배열는 메모리에 저장 => 프로그램이 종료되면 메모리는 다 초기화된다.
		// 주기억장치 : 현재 실행중인 프로그램[명령어] 기억
			// 전기X 저장X => 휘발성
			// 변수, 객체, 배열 등등
		// 보조기억장치[파일저장, DB, 클라우드]
			// 전기X 저장O => 비휘발성
			// 파일, DB 등등
		// 파일처리
			// 키보드[파일] ------------> 스트림(데이터흐름) ------------> 출력
				// 데이터흐름 : 바이트 단위 [비트 : 1bit = 0 혹은 1] [바이트 : 8bit => 1byte]
	public static void main(String[] args) throws Exception{
											// 예외 던지기
		FileOutputStream fileOutputStream = new FileOutputStream("/home/kyle109/eclipse-workspace/java.txt"); // 무조건 예외처리발생 : 만약에 파일이 없는 경우
			// FileOutputStream : 파일 출력해주는 클래스
				// new : 객체 메모리 할당
					// FileOutputStream(파일경로 확장자);
			String str = "이클립스에서 작성했습니다.";
				// 스트림은 문자열 자체를 출력할 수 없음
			System.out.println(str.getBytes());
			fileOutputStream.write(str.getBytes());
				// 1. 문자열 => 바이트 변환 [문자열.getBytes() : 바이트 변환 메소드]
				// 2. 스트림명.write( 바이트열 ) : 바이트 출력
	
//======================================================================================================================
			
		FileInputStream fileInputStream = new FileInputStream("/home/kyle109/eclipse-workspace/java.txt"); // 무조건 예외처리 발생: 만약에 파일이 없을 경우
		
		// 1. 스트림에서 바이트열 가져온다 한글은 2바이트, 영문/특수문자/띄어쓰기는 1바이트
		byte[] bytearr = new byte[1024]; //1024byte => 1kbyte 
		// 2. 가져온 바이트열 문자열 변환
		fileInputStream.read(bytearr);
			// 스트림명.read(바이트배열명) : 바이트 읽어오기 => 배열에 저장
		// 3. 
		String str2 = new String(bytearr); // 생성자에 바이트배열 넣기 => 문자열 변환
	
		System.out.println("현재 파일의 내용은 : "+ str2);
		
		
//=====================================================================================================================================
		// 키보드에 입력된 변수를 메모장에 계속 누적으로 쓰기
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("메모장에 입력할 텍스트 입력 : ");
			String str3 = scanner.next();
			String outstr = str3 +"\n";
			fileOutputStream.write(outstr.getBytes());	
		}
		
		
	}
}
