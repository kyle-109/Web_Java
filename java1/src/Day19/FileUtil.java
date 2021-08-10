package Day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {
	
	// 파일경로
		// 회원파일경로
		static String memberPath = "memberlist.txt";
		static String logPath = "log.txt";
		// 게시파일경로
		// 댓글파일경로
	
	// 파일저장 메소드
	public static void filesave(int type, int content) throws Exception{
							// 인수 : type : 저장파일구분용
		FileOutputStream fileOutputStream = null;//타입에 따라서 달라질수 있으므로 선언만 한다 
		// 파일출력스트림 : FileOutputStream
		
		if(type==0) { // 로그저장할 경우
			fileOutputStream = new FileOutputStream(logPath);
			String string = content+"\n";
			fileOutputStream.write(string.getBytes());
			fileOutputStream.flush(); // 초기화[스트림안에 있는 바이트 제거]
			fileOutputStream.close(); // 스트림 닫기
		}
		
		if(type==1) { // 회원저장할 경우
			fileOutputStream = new FileOutputStream(memberPath);
			// 리스트 -> 하나씩 객체 꺼내기 => 객체를 필드별 분류 => 파일 쓰기 => 바이트 변환 => 쓰기
			for(Member member : ConsoleProgram.memberlist) {
				String outString = member.getNo()+","+member.getId()+","+member.getPassWord()+","+member.getName()+","+member.getEmail()+","+member.getPoint()+"\n";
				// ",": 필드구분용, "\n" : 회원구분용
				fileOutputStream.write(outString.getBytes());// 바이트로 변환후 쓰기
			}
			fileOutputStream.flush(); // 초기화[스트림안에 있는 바이트 제거]
			fileOutputStream.close(); // 스트림 닫기
		}
		if(type==2) {}
		if(type==3) {}
		
	}
	
	// 파일호출 메소드
	public static void fileload(int type) throws Exception{
							// 인수 : type : 불러올 것 선택
		FileInputStream fileInputStream = null; // 선언만
		
		if(type == 1) {//파일에 저장된 멤버 불러오기
			fileInputStream = new FileInputStream(memberPath);// 파일경로설정
			byte[] bytearr = new byte[1024000]; // 파일의 크기 => 임의
			fileInputStream.read(bytearr); // 파일을 스트림 바이트로 읽어와서 배열에 저장
			// 1. 문자열 변환
			String fileContents = new String(bytearr);// 바이트를 String으로 변환
			// 2. 회원별 분류
			String[] members = fileContents.split("\n");
			// 3. 필드별 분류
			for(String member : members) {// 모든 멤버에 대해서
				if(member.equals("")) {return;} // member가 ""이면 return으로 빠져나가기
				String[] fields = member.split(",");
				//회원번호랑 포인트는 int로 형변환(Integer.parseInt(String), 객체선언
				Member temp = new Member(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], Integer.parseInt(fields[5]));
				//리스트에 저장
				ConsoleProgram.memberlist.add(temp);
			}
			fileInputStream.close();//스트림닫기
		}// 파일에 저장된 멤버 불러오기
		
		if(type==0) {//파일에 저장된 로그(총 멤버수) 불러오기
			fileInputStream = new FileInputStream(logPath);
			byte[] bytearr = new byte[1024];
			fileInputStream.read(bytearr); // 파일을 스트림 바이트로 읽어와서 배열에 저장
			Member.totalno = Integer.parseInt(new String(bytearr));//byte=>String=>Integer
			
			fileInputStream.close();
		}// 파일에 저장된 로그(총 멤버수) 불러오기
		
	}
}