package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;


	
public class Test {//Test class start

	
	static Scanner scanner = new Scanner(System.in);
	// 멤버 저장할 멤버배열
	static Member[] memberList = new Member[100]; 
	// 게시글 저장할 게시글배열 
	static Board[] boardList = new Board[100];
	
	//입력받기 위한 바이트 배열
	static byte[] memberByte = new byte[1000];
	static byte[] boardByte = new byte[1000];
	
	
	public static void main(String[] args) throws Exception{//main start
		
		// 멤버수
		int memberCount = 0;
		// 게시글수
		int boardCount = 0;
		// 로그인한 사람 닉네임
		String loginNickname = "";
		
		
		String entireMember = null;
		String entireBoard = null;
		
		
		//기존에 저장한 파일에서 멤버리스트에 저장
		try{
			FileInputStream memberIn = new FileInputStream("/home/kyle109/git/Web_Java/java1/src/practice/members.txt");
			memberIn.read(memberByte);
			entireMember = new String(memberByte);
			String[] memList = entireMember.split("\n");
			
			for(int n = 0; n<memList.length; n++) {
				String[] memField = memList[n].split(",");
				Member member = new Member(memField[0], memField[1], memField[2]);
				for(int o = 0; o<memberList.length; o++) {
					if(memberList[o]==null) {
						memberList[o]=member;
						memberCount+=1;
						break;
					}
				}
			}
			System.out.println("회원수:"+memberCount);
		}
		catch(Exception exp) {
			
			
		//기존에 저장한 파일에서 게시글리스트에 저장	
		}
		try{
			FileInputStream boardIn = new FileInputStream("/home/kyle109/git/Web_Java/java1/src/practice/boards.txt");
			boardIn.read(boardByte);
			entireBoard = new String(boardByte);
			String[] brdList = entireBoard.split("\n");
			
			for(int p = 0; p<brdList.length; p++) {
				String[] brdField = brdList[p].split(",");
				Board board = new Board(brdField[0], brdField[1], brdField[2]);
				for(int q = 0; q<boardList.length; q++) {
					if(boardList[q]==null) {
						boardList[q]=board;
						boardCount+=1;
						break;
					}
				}
			}
			System.out.println("게시글수"+boardCount);
		}
		catch(Exception exp) {
			
		}
		
		//기존파일에서 불러오고 새로 쓰면 기존 내용이 지워지기에
		//기존파일에 불러온 리스트 내용들을 먼저 출력해놓고
		//새로 추가한 내용을 출력해야 모두다 저장이 된다.
		FileOutputStream memberOut = new FileOutputStream("/home/kyle109/git/Web_Java/java1/src/practice/members.txt");
		FileOutputStream boardOut = new FileOutputStream("/home/kyle109/git/Web_Java/java1/src/practice/boards.txt");
		System.out.println(memberCount);
		System.out.println(boardCount);
		for(int z = 0; z<memberCount; z++) {
			String memOut = memberList[z].id+","+memberList[z].passWord+","+memberList[z].nickName+"\n";
			memberOut.write(memOut.getBytes());
		}
		for(int x = 0; x<boardCount; x++) {
			String brdOut = boardList[x].title+","+boardList[x].content+","+boardList[x].writer+"\n";
			memberOut.write(brdOut.getBytes());
		}
		while(true) {
			// 매번 초기화해야 할 변수들
			// 로그인가능여부
			boolean login = false;
			// 아이디 중복 여부
			boolean idOverlap = false;
			// 로그아웃 여부
			boolean logOut = false;
			
			// 뒤로가기 여부
			boolean back = false;
			
			String id;
			String passWord;
			
			System.out.println();
			System.out.println("[[[[ 회원제 게시판 ]]]]");
			System.out.print("1.로그인 2.회원가입 : ");
			int ch = scanner.nextInt();
			
			
			//로그인 선택
			if(ch == 1) {//1-1로그인 
				
				System.out.print("로그인할 아이디를 입력하세요: "); String Id = scanner.next();
				System.out.print("로그인할 비밀번호를 입력하세요: "); String PassWord = scanner.next();
				for(int i = 0; i<memberCount; i++) {
					if(memberList[i].id.equals(Id) && memberList[i].passWord.equals(PassWord)) {
						System.out.println();
						System.out.println("[[[로그인 완료]]]");
						loginNickname = memberList[i].nickName;
						login = true; //  로그인 가능
						break;// for문탈출
					}
				}	
				//로그인한 아이디와 비번이 일치한것이 없는 경우
				if(login == false) { 
					System.out.println("일치한 정보가 없습니다.");
					continue;//while(true)문 초기로 복귀
				}

				while(true)	{
					//로그인한 아이디와 비번이 일치한 것이 있는 경우
					System.out.println();
					System.out.println("[[[ "+Id+"님 반갑습니다. ]]]");
					System.out.print("1.글작성 2.글보기 3.로그아웃 : ");
					int ch2 = scanner.nextInt();
						
						//글작성 선택
						if(ch2 == 1) {
							// 제목, 내용, 작성자닉네임
							System.out.println("[[[ 글쓰기 페이지 ]]]");
							System.out.print("글제목: "); String title = scanner.next();
							System.out.print("글내용: "); String content = scanner.next();
							Board board = new Board(title, content, loginNickname);
							// 게시글배열에 게시글 추가
							boardList[boardCount]= board;
							// 게시글 갯수 하나 증가
							String totalBoard = boardList[boardCount].title+","+boardList[boardCount].content+","+boardList[boardCount].writer+"\n";
							System.out.println(totalBoard);
							boardOut.write(totalBoard.getBytes());
							System.out.println(boardCount);
							boardCount+=1;
							System.out.println(boardCount);
						}
						
						//글보기 선택
						if(ch2 == 2) {
							while(true) {
								System.out.println();
								System.out.println("[[[[[ 게시판 페이지 ]]]]]");
								//게시판 글들이 나열[제목][작성자][내용]
								System.out.println("[제목]\t\t[작성자]\t\t[내용]");
								for(int j = 0; j<boardCount; j++) {
									System.out.println(boardList[j].title+"\t"+boardList[j].writer+"\t\t"+boardList[j].content);
								}
								
								//선택지 수정, 삭제, 뒤로가기
								System.out.print("1.글수정 2.글삭제 3.뒤로가기 : ");
								int ch3 = scanner.nextInt();
								//글수정
								if(ch3 == 1) {
									System.out.print("수정하기 원하는 글의 제목을 입력하세요 : ");
									String title = scanner.next();
									for(int l = 0; l<boardCount; l++) {
										// 게시글의 제목과 입력한게 동일하고, 게시글의 저자와 로그인한 사람의 닉네임이 같으면
										if(boardList[l].title.equals(title) && boardList[l].writer.equals(loginNickname)) {
											System.out.print("제목을 다시 입력하세요:"); String revTitle = scanner.next();
											System.out.print("내용을 다시 입력하세요:"); String revContent = scanner.next();
											boardList[l].title = revTitle;
											boardList[l].content = revContent;
											break;
										}
									}
									System.out.println("글작성자가 아니므로 수정이 불가합니다.");
								}//글수정
							
								//글삭제
								if(ch3 == 2) {
									System.out.print("삭제하기 원하는 글의 제목을 입력하세요 : ");
									String title = scanner.next();
									for(int l = 0; l<boardCount; l++) {
										// 게시글의 제목과 입력한게 동일하고, 게시글의 저자와 로그인한 사람의 닉네임이 같으면
										if(boardList[l].title.equals(title) && boardList[l].writer.equals(loginNickname)) {
											boardList[l] = null;
											//게시글 갯수가 하나면 그냥 삭제하고 끝내면 된다.
											if(boardCount!=1) {
												//
												for(int m = l; m<boardCount-1; m++) { 
													boardList[m] = boardList[m+1]; 	  									  
												}
												boardList[boardCount-1]=null;
											}
											boardCount-=1;
											break;
										}
										System.out.println("글작성자가 아니므로 삭제가 불가합니다.");
									}
									
								}// 3-2.글삭제 end	
								//뒤로가기
								if(ch3 == 3) {
									back = true;
									break;
								}
							}// 3.글보기시 end(while)
							//로그아웃
							if(back == true) {
							continue;
							}
						}//2-2선택
					
						if(ch2 == 3) {
							System.out.println();
							System.out.println("[[[ 로그아웃 완료 ]]]");
							logOut = true;
							break;//로그인시의 무한루프 탈출
						}//2-3선택	
							
					}// 2번 로그인시 메뉴(while)
					if(logOut == true) {
					continue;// 다시 메뉴로 복귀
					}
				}// 1-1 로그인 선택 end
				
			
				// 회원가입선택
				if(ch == 2) {
					// 회원가입할 아이디, 비번, 닉네임 입력받아 배열에 넣기
					
					System.out.println();
					System.out.println("[[[[ 회원가입 페이지]]]]");
					System.out.print("아이디를 입력하세요: "); id = scanner.next();
					System.out.print("비밀번호를 입력하세요: "); passWord = scanner.next();
					System.out.print("닉네임를 입력하세요: "); String nickName = scanner.next();
					Member member = new Member(id, passWord, nickName);
					
					// 멤버가 0이면 굳이 동일한 아이디가 있는지 확인할 필요X
					if(memberCount>0) {
						System.out.println("멤버리스트 검색");
						for(int k = 0; k<memberCount; k++) {
							if(memberList[k].id.equals(id)) { // 멤버리스트에 있는 멤버의 아이디와 동일할 경우
								idOverlap = true; // 아이디 중복이 존재함.
								break;
							}
						}
					}
					if(idOverlap==true) {
						System.out.println("동일한 아이디를 사용하는 사람이 있습니다.");
						continue;//while(true)로 복귀
					}
					// 동일한 아이디가 없는 경우
					// 멤버리스트에 멤버추가
					memberList[memberCount]= member;
					String totalMembers = memberList[memberCount].id+","+memberList[memberCount].passWord+","+memberList[memberCount].nickName+"\n";
					memberOut.write(totalMembers.getBytes());
					memberCount+=1;// 회원수가 한명 늘었기 때문에
					System.out.println("[[회원가입완료]]");
					continue; // while(true)로 복귀
				}//1-2회원가입 선택시
				
				
		}// 첫번째 while end
	}//main end
}//Test class end
	
