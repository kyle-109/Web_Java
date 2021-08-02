package Day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Day12_4 {
	
	
	
	// 회원제 프로그램[파일처리]
	
	public static Member[] members = new Member[100];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 프로그램시작시  파일에서 회원들 가져오기
		try {
			FileInputStream fileInputStream = new FileInputStream("/home/kyle109/git/Web_Java/java1/src/Day12/members.txt");
			// 1. 입력스트림 읽어와서 배열에 저장.
			byte[] bytearr= new byte[1000];
			fileInputStream.read(bytearr);
			
			// 2. 바이트 => 문자열
			String entireStr = new String(bytearr);
			
			// 3. 회원구분짓기1
			String[] memberList = entireStr.split("\n");// 문자열.split("자르기기준");
			
			System.out.println(memberList.length);
			
			// 4. 객체간 필드 구분해서 배열에 저장
			for(int i = 0; i<memberList.length; i++) {
				String[] field = memberList[i].split(",");
				Member member = new Member(field[0], field[1], field[2]);
				
				for(int j = 0; j<members.length; j++) {
					if(members[j]==null) {
						members[j] = member;
						break;
					}
				}
			}
			
			
		}
		catch(Exception exp) {
			System.out.println("잘못된 파일 접근입니다.");
		}
		
		while(true) {
			try {
				System.out.println("1.회원가입 2.로그인");
				int ch = scanner.nextInt();
				if(ch == 1) {
					System.out.print("아이디 : "); String id = scanner.next();
					System.out.print("비밀번호 : "); String passWord = scanner.next();
					System.out.print("이름 : ");	String name = scanner.next();
					
					// 1. 객체 생성[ 이유 : 여러개 변수는 관리가 어렵다 => 하나로 묶음] Dto
					Member member = new Member(id, passWord, name);
					
					// 2. 배열 저장
					for(int i = 0; i<members.length; i++) {
						if(members[i]==null) {
							members[i]=member;
							break;
						}
					}
					// 3. 파일 저장
					FileOutputStream fileOutputStream = new FileOutputStream("/home/kyle109/git/Web_Java/java1/src/Day12/members.txt");
						
						// 1. 파일에 저장시 회원내 필드 구분 : , [쉼표]
						// 2. 파일에 저장시 회원간 구분 : \n [백슬래시]
						
						for(int i = 0; i<members.length; i++) {// 배열내 null이 아니면(회원이 존재하면)
							// 1. 각 필드 사이에 , 구분짓기 [메모장에서 빼올 때 필드간 구별]  2. 객체간[회원간] \n 구분짓기
							if(members[i]==null) {
								String strout = members[i].id+","+members[i].passWord+","+members[i].name+"\n";
								
								fileOutputStream.write(strout.getBytes());
							}
							else {
								break;
							}
						}
						
					
				}
				if(ch == 2) {}
			}
			catch(Exception exception) {
				System.out.println("[[[[1 혹은 2만 입력가능합니다]]]]");
			}
			
		}
	}
}
