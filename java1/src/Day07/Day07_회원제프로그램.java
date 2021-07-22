package Day07;

import java.util.Scanner;

public class Day07_회원제프로그램 {
	
	// 회원가입, 로그인
	// 콘솔에서 하는 게 나중에 웹에서 하는것과 동일. 단지 api 사용만 추가하면 된다
		// [조건1] 2차원배열
		// [조건2] 최대 회원 100명 제한
			// 1. 아이디, 비번 배열에 저장
		// [조건3] 무한루프 [초기메뉴]
			// 1. 회원가입 [중복아이디X]
			// 2. 로그인
			// 3. 종료
		// [조건4] 로그인시 메뉴
			// 1. 회원탈퇴 2. 패스워드변경 3.로그아웃[초기메뉴]
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] people = new String[100][2]; //회원명부
		String[][] text = new String[100][2]; //게시판
		int count =0; //회원수
		int textCount=0;//글수
		String[][] temp = new String[1][2]; // 로그인시 사용하는 임시저장용 배열
		boolean condition = true; // 회원가입 트리거
		boolean condition2 = true; //로그인 트리거
		while(true) {
			System.out.print("[[[ 회원제 프로그램 ]]]");
			System.out.print("\n[[1.회원가입]] [[2.로그인]] [[3.종료]] : ");
			int choice = scanner.nextInt();
			if(choice==1) {
				while(true) {
				condition = true;
				System.out.print("사용할 아이디를 입력하시오:");
				people[count][0]=scanner.next();
				for(int i =0; i<count; i++) {
					if(people[i][0].equals(people[count][0])) {
						System.out.println("이미 사용중인 아이디입니다. 다시 입력해주세요");
						condition=false;
						break;
					}
				}
				if(condition==false) {
					continue;
				}
				System.out.print("사용할 비밀번호를 입력하시오:");
				people[count][1]=scanner.next();
				count++;
				System.out.println("회원가입완료");
				break;
				}
			}
			else if(choice==2) {
				if(count==0)
				{
					System.out.println("회원가입한 사람이 없습니다");
				}
				//2차원 배열인 경우
				//배열명.length:행길이
				//배열명[0].length:열길이
				while(true) {
				System.out.print("아이디를 입력하시오:");
				temp[0][0]=scanner.next();
				System.out.print("비밀번호를 입력하시오:");
				temp[0][1]=scanner.next();
				for(int i =0; i<count; i++) {
					if(people[i][0].equals(temp[0][0]) && people[i][1].equals(temp[0][1])) {
						System.out.println("[["+temp[0][0]+"]]  :로그인완료");
						
						while(true) {//로그인 된 후
							System.out.print("[[[ 회원제 프로그램 ]]]");
							System.out.print("\n[[1.회원탈퇴]] [[2.비밀번호변경]] [[3.로그아웃]] [[4.게시판 글쓰기]] [[5.게시판 글목록]]: ");
							int choice2 = scanner.nextInt();
							if(choice2==1) {
								//탈퇴한 회원뒤에 있는 회원들을 한칸씩 땡긴다.
								people[i][0]=null;//로그인한아이디
								people[i][1]=null;//로그인한 비번
								if(i!=count-1) {//로그인한 아이디가 맨 마지막 회원이 아닐경우
									for(int j = i ; j<count; j++) {//로그인한 아이디 뒤에 있는 회원들 당기기
										people[j][0] = people[j+1][0];
										people[j][1] = people[j+1][1];
									}
									people[count][0] = null;//맨 마지막회원자리는 비운다.ㄴ
									people[count][1] = null;
								}
								count--; //회원수가 줄었기때문에 1줄인다
								System.out.println("탈퇴가 완료되었습니다.");
								break;
							}
							else if(choice2==2) {
								System.out.println("[[[패스워드변경 페이지]]]");
								System.out.print("새로운 비밀번호를 입력하세요 :"); String newPassword = scanner.next();
								people[i][1]=newPassword;
								System.out.println("패스워드변경완료[[자동로그아웃됩니다]]");
								break;
							}
							else if(choice2==3) {//로그아웃
								System.out.println("[[로그아웃]] 로그아웃되었습니다.");
							}
							else if(choice2==4) {//게시판 글쓰기
								System.out.print("제목을 입력해주세요:\n"); text[textCount][0]= scanner.next();
								System.out.print("내용을 입력해주세요:\n"); text[textCount][1]= scanner.next();
								textCount++;
							}
							else {//게시판 글목록출력
								for(int l = 0; l<textCount; l++) {
									System.out.println(l+"번째 글 제목은 \""+text[l][0]+"\"입니다");
									System.out.println(l+"번째 글 내용은 \""+text[l][1]+"\"입니다");
								}
							}
							
						}
						
						condition2 = false;
						break;
					}
				}
				if(condition2 == false) {
					break;
				}
				System.out.println("일치하는 회원정보가 없습니다. 다시 입력해주세요");
				
					
				}
			}	
				
			
			else {
				System.out.println("[[종료]] 이용해주셔서 감사합니다");
				break;
			}
			
		}
	}
	
	//과제2 : 회원제프로그램
		//1. 로그인시 4. 글쓰기,  5. 글목록 메뉴 추가
		//2. 게시판 100개 저장하는 2차원배열[제목, 내용]
	
	
}
