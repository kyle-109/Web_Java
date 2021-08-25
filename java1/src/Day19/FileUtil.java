package Day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {
	
	// 파일경로
		
		static String memberPath = "C:/Users/김정수/git/Web_Java/java1/src/Day19/memberlist.txt";// 회원파일경로
		static String boardPath = "C:/Users/김정수/git/Web_Java/java1/src/Day19/boardlist.txt";// 게시글파일경로
		static String replyPath = "C:/Users/김정수/git/Web_Java/java1/src/Day19/replylist.txt"; //게시글번호저장
		static String logPath = "C:/Users/김정수/git/Web_Java/java1/src/Day19/log.txt"; //총멤버수저장
		static String logPath2 = "C:/Users/김정수/git/Web_Java/java1/src/Day19/log2.txt"; //게시글번호저장
		static String logPath3 = "C:/Users/김정수/git/Web_Java/java1/src/Day19/log3.txt"; //댓글번호저장
//		static String memberPath = "memberlist.txt";// 회원파일경로
//		static String boardPath = "boardlist.txt";// 게시파일경로
//		static String logPath = "log.txt"; //총멤버수저장
//		static String logPath2 = "log2.txt"; //게시글번호저장		
		
	
	// 파일저장 메소드
	public static void filesave(int type, int content) throws Exception{
							// 인수 : type : 저장파일구분용
		FileOutputStream fileOutputStream = null;//타입에 따라서 달라질수 있으므로 선언만 한다 
		// 파일출력스트림 : FileOutputStream
		
		if(type==1) { // 회원저장할 경우
			fileOutputStream = new FileOutputStream(memberPath);
			// 리스트 -> 하나씩 객체 꺼내기 => 객체를 필드별 분류 => 파일 쓰기 => 바이트 변환 => 쓰기
			for(Member member : ConsoleProgram.memberList) {
				String outString = member.getNo()+","+member.getId()+","+member.getPassWord()+","+member.getName()+","+member.getEmail()+","+member.getPoint()+"\n";
				// ",": 필드구분용, "\n" : 회원구분용
				fileOutputStream.write(outString.getBytes());// 바이트로 변환후 쓰기
			}
			fileOutputStream.flush(); // 초기화[스트림안에 있는 바이트 제거]
			fileOutputStream.close(); // 스트림 닫기
		}
		if(type==2) { // 게시글 저장
			fileOutputStream = new FileOutputStream(boardPath);
			for(Board board : ConsoleProgram.boardList) {
				String outString = board.getBno()+","+board.getBtitle()+","+board.getBcontents()+","+board.getBwriter()+","+board.getBdate()+","+board.getBcount()+"\n";
				fileOutputStream.write(outString.getBytes());
			}
			fileOutputStream.flush();
			fileOutputStream.close();
		}
		
		if(type ==3 ) { // 댓글 저장
			fileOutputStream = new FileOutputStream(replyPath);
			for(Reply reply : ConsoleProgram.replyList) {
				String outString = reply.getRno()+","+reply.getBno()+","+reply.getRcontents()+","+reply.getRwriter()+"\n";
				fileOutputStream.write(outString.getBytes());
			}
			fileOutputStream.flush(); // 초기화[스트림안에 있는 바이트 제거]
			fileOutputStream.close(); // 스트림 닫기	
		}
	}
	
	
	public static void logSave(int type, int content) throws Exception{
		FileOutputStream fileOutputStream = null;
		if(type==1) {// 멤버수 저장
		fileOutputStream = new FileOutputStream(logPath);
		}
		if(type==2) {// 게시글수 저장
		fileOutputStream = new FileOutputStream(logPath2);
		}
		if(type==3) {// 댓글 수 저장
		fileOutputStream = new FileOutputStream(logPath3);
		}
		String outString = content+"\n";
		fileOutputStream.write(outString.getBytes());
		fileOutputStream.flush(); // 초기화[스트림안에 있는 바이트 제거]
		fileOutputStream.close(); // 스트림 닫기	
	}
	
	
	// 파일호출 메소드
	public static void fileload(int type) throws Exception{
							// 인수 : type : 불러올 것 선택
		FileInputStream fileInputStream = null; // 선언만
		
		if(type == 1) {//파일에 저장된 멤버 불러오기
			// 1.파일입력스트림에 파일연결[메모리 할당]
			fileInputStream = new FileInputStream(memberPath); 
			// 2. 스트림(단위: 바이트)로 가져오기
			byte[] bytearr = new byte[10000]; // 10kb 정도 배열
			fileInputStream.read(bytearr); // 파일을 스트림 바이트로 읽어와서 배열에 저장
			// 3. 문자열 변환 [바이트 => 문자열]
			String fileContents = new String(bytearr);// 바이트를 String으로 변환
			// 4. 회원별 분리하기 \n, 2명 입력하면 3조각이 나온다.(회원1,회원2,공백)
			String[] members = fileContents.split("\n");
			// 5. 회원내 필드별 분리
			//int count = 0 ;
			for( int i = 0 ; i<members.length-1 ;i++ ) {
			//for(String member : members) {// 모든 멤버에 대해서
				//count++;
				//if( member.length() == count ) {break;}
				//if(member.equals("")) {return;} // 마지막 member는 ""이므로 return으로 빠져나가기
				//String[] fields = member.split(",");
				String[] fields = members[i].split(",");
				//6. 분해된 필드를 객체로 저장. 회원번호랑 포인트는 int로 형변환(Integer.parseInt(String), 객체선언
				Member temp = new Member(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], Integer.parseInt(fields[5]));
				//7. 각 객체를 리스트에 저장
				ConsoleProgram.memberList.add(temp);
			}
			fileInputStream.close();//스트림닫기
		}// 파일에 저장된 멤버 불러오기
		
		if(type==0) {//파일에 저장된 로그(총 멤버수) 불러오기
			fileInputStream = new FileInputStream(logPath);
			byte[] bytes = new byte[1024];
			fileInputStream.read(bytes); // 파일을 스트림 바이트로 읽어와서 배열에 저장
			String temp = new String(bytes);
			if(temp.equals(null)) {
				ConsoleProgram.mtotalno=0;
			}
			else {
			String[] log = temp.split("\n");
			ConsoleProgram.mtotalno = Integer.parseInt(log[0]);//byte=>String=>Integer
			fileInputStream.close();
			}
		}// 파일에 저장된 로그(총 멤버수) 불러오기
		
		if(type==2) {// 게시글 불러오기
			fileInputStream = new FileInputStream(boardPath);
			byte[] bytes = new byte[10000];
			fileInputStream.read(bytes);
			String inString = new String(bytes);
			String[] boards = inString.split("\n");
			for(int i =0; i<boards.length-1; i++) {
							// 마지막은 공백이기 때문에
				String[] field = boards[i].split(",");
				Board board = new Board(Integer.parseInt(field[0]), field[1], field[2], field[3], field[4], Integer.parseInt(field[5]));
				ConsoleProgram.boardList.add(board);
				fileInputStream.close();
			}
 		}
		if(type==3) { // 게시물 번호저장
			fileInputStream = new FileInputStream(logPath2);
			byte[] bytes = new byte[1024];
			String inString = new String(bytes);
			if(inString.equals(null)) {
				ConsoleProgram.btotalno = 0;
			}
			else {
			String[] log2 = inString.split("\n");
			ConsoleProgram.btotalno = Integer.parseInt(log2[0]);
			fileInputStream.close();
			}
		}
		if(type ==4) {// 댓글 불러오기
			fileInputStream = new FileInputStream(replyPath);
			byte[] bytes = new byte[10000];
			fileInputStream.read(bytes);
			String inString = new String(bytes);
			String[] replys = inString.split("\n");
			for(int i =0; i<replys.length-1;i++) {
				String[] field = replys[i].split(",");
				Reply reply = new Reply(Integer.parseInt(field[0]), Integer.parseInt(field[1]), field[2], field[3]);
				ConsoleProgram.replyList.add(reply);
			}
			fileInputStream.close();
			
		}
		if(type ==5) { // 댓글 수 불러오기}
			fileInputStream = new FileInputStream(logPath3);
			byte[] bytes = new byte[1024];
			String inString = new String(bytes);
			if(inString.equals(null)) {
				ConsoleProgram.rtotalno = 0;
			}
			else {
			String[] log3 = inString.split("\n");
			ConsoleProgram.rtotalno = Integer.parseInt(log3[0]);
			fileInputStream.close();
			}
		}
	}
}	