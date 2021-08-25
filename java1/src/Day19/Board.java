package Day19;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Board {
	
	// 필드
		private int bno = 0;// 1. 게시물번호
		private String btitle;// 2. 제목
		private String bcontents;// 3. 내용
		private String bwriter;// 4. 작성자
		private String bdate;// 5. 작성일
		private int bcount;// 6. 조회수
		
		Scanner scanner = new Scanner(System.in);
		
	// 생성자
		public Board() {
			
		}

		public Board(int bno, String btitle, String bcontents, String bwriter, String bdate, int bcount) {
			super();
			this.bno = bno;
			this.btitle = btitle;
			this.bcontents = bcontents;
			this.bwriter = bwriter;
			this.bdate = bdate;
			this.bcount = bcount;
		}
		// 메소드
			// 1. 모든 게시물 출력 메소드 // 리스트 모두 출력게시판메뉴 
		public void boardlist() { 
			System.out.println("[[ 커뮤니티 ]] ");
			System.out.println("번호\t제목\t작성자\t조회수\t작성일");
			for( Board board : ConsoleProgram.boardList ) {
				System.out.println(board.bno+"\t"+board.btitle+"\t"+board.bwriter+"\t"+board.bcount+"\t"+board.bdate);
			}
		}
		
//		public void boardlist(Member login) {
//			while(true) {
//				System.out.println("[[ 커뮤니티 ]]");//모든 출력물 출력
//				System.out.println("번호\t제목\t작성자\t조회수\t작성일");
//				for(Board board : ConsoleProgram.boardList) {
//					System.out.println(board.bno+"\t"+board.btitle+"\t"+board.bwriter+"\t"+board.bcount+"\t"+board.bdate);
//				}
//				System.out.println("[[[1.게시물등록 2.게시물조회 3.회원정보[수정/탈퇴] 4.로그아웃 ]]]");
//				int ch = scanner.nextInt();
//				if(ch == 1) {boardwrite(login);}
//				if(ch == 2) {boardview(login);}
//				if(ch == 3) {}
//				if(ch == 4) {
//					System.out.println("[[[ 로그아웃 되었습니다 ]]]");
//					break;
//				}
//			}
//		}
			
			// 3. 개별 게시물 출력 메소드(인수 : 로그인정보) [게시물 번호를 입력받아 해당 게시물의 모든 정보 출력
		public void boardview(Member login) {
			System.out.println("[[ 게시물번호 ]]: "); int bno = scanner.nextInt();
			for(Board board : ConsoleProgram.boardList) {
				if(board.bno == bno) {
					board.bcount++; // 조회수 증가
					System.out.println("제목 : "+board.btitle+" 작성일 : "+board.bdate+" 조회수 : "+board.bcount);
					System.out.println("작성자 : "+board.bwriter);
					System.out.println("내용 : "+board.bcontents);
					
					Reply temp = new Reply();//메소드 호출하기 위해서 
					System.out.println("===========댓글목록===========");
					temp.replylist(board.bno);
					
					// 댓글쓰기 추가
					if(board.bwriter.equals(login.getId())) {// 게시물작성자와 로그인된 정보의 아이디가 동일하면
						System.out.print("0.댓글쓰기 1.게시물수정 2.게시물삭제 3.댓글수정 4.댓글삭제");
					}
					else {
						System.out.print("0.댓글쓰기");
					}
					int ch = scanner.nextInt();
					
					if(ch==0) {// 댓글쓰기	
						temp.replywrite(board.bno, login);
					}
					if(ch==1) {// 게시물 수정
						System.out.println("[[ 해당 게시물 수정 ]]");
						scanner.nextLine(); // 문제점: 앞전에 next() 등이 있는경우
						System.out.print("[[ 제목 ]]: "); String btitle = scanner.nextLine();
						System.out.print("[[ 내용 ]]: "); String bcontents = scanner.nextLine();
						ConsoleProgram.boardList.get(bno-1).setBtitle(btitle);
						ConsoleProgram.boardList.get(bno-1).setBcontents(bcontents);
						// 파일 처리 (업데이트)
						try {
							FileUtil.filesave(2, 0);
						}catch(Exception e) {
							
						}
						System.out.println("[[수정되었습니다]]");
					}
					if(ch==2) { // 게시물 삭제, 해당게시물에 달린 댓글도 같이 삭제
						System.out.println("[[해당 게시물 삭제]]");
						ConsoleProgram.boardList.remove(board);// 현재 게시물를 리스트에 삭제
						ConsoleProgram.btotalno--; // 총 게시물 갯수 1개 차감
						for(Reply reply : ConsoleProgram.replyList) {//전체 댓글리스트
							if(reply.getRwriter().equals(login) && reply.getBno()==bno) {
								// 댓글작성자와 로그인한 사람이 동일한 사람이고, 댓글의 게시글번호와 지금 게시글번호가 동일하면
								ConsoleProgram.replyList.remove(reply);// 해당 댓글을 지우고
								ConsoleProgram.rtotalno--;// 총 댓글 갯수 1개 차감
							}
						}
						// 파일 처리 (업데이트)
						try {// 댓글과 총댓글갯수 업데이트
							FileUtil.filesave(3, 0); // 댓글 최신화
							FileUtil.logSave(3, ConsoleProgram.rtotalno);// 댓글수 최신화
						}catch(Exception e) {System.out.println("댓글관련에러");}
						try {
							FileUtil.logSave(2, ConsoleProgram.btotalno);// 게시글수 최신화
							FileUtil.filesave(2, 0);// 게시글 최신화
						}catch(Exception e) {System.out.println("게시글관련에러");}
						System.out.println("[[삭제되었습니다]]");
						return;
					}
					if(ch==3) {temp.fixReply(bno, login);}
					if(ch==4) {temp.removeReply(bno, login);}
				}
			}
		}
		
		
			// 4. 게시물 등록 메소드
		public void boardwrite(Member login) {
			
			// scanner.nextLine() 문제점 : 앞에 next() 등이 있을 경우
			scanner.nextLine();// 문제점 보완
			System.out.print("[[ 제목 ]]: "); String btitle = scanner.nextLine();
			System.out.print("[[ 내용 ]]: "); String bcontents = scanner.nextLine();
			
			String bwriter=login.getId(); // 로그인된 아이디
			// 1. 현재날짜/시간 클래스
			Date date = new Date();
			// 2. 형식변환 클래스
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm");
			String bdate =simpleDateFormat.format(date);
			// 객체
			try {
				FileUtil.fileload(3);
			}
			catch(Exception e) {}
			Board board = new Board(ConsoleProgram.btotalno+1, btitle, bcontents, bwriter, bdate, 0);
			ConsoleProgram.boardList.add(board);
			ConsoleProgram.btotalno++;
			// 파일처리
			try {
				FileUtil.logSave(2, ConsoleProgram.btotalno);
			}
			catch(Exception e) {}
			try {
				FileUtil.filesave(2, 0);
			}
			catch(Exception e) {}
//			System.out.println("board bno: "+board.getBno());
//			System.out.println("board totalno: "+totalno);
//			System.out.println("게시글리스트길이: "+ConsoleProgram.boardList.size());
			System.out.println("[[ 게시물 등록 완료 ]]");
		}

		
		
		public int getBno() {
			return bno;
		}

		public void setBno(int bno) {
			this.bno = bno;
		}

		public String getBtitle() {
			return btitle;
		}

		public void setBtitle(String btitle) {
			this.btitle = btitle;
		}

		public String getBcontents() {
			return bcontents;
		}

		public void setBcontents(String bcontents) {
			this.bcontents = bcontents;
		}

		public String getBwriter() {
			return bwriter;
		}

		public void setBwriter(String bwriter) {
			this.bwriter = bwriter;
		}

		public String getBdate() {
			return bdate;
		}

		public void setBdate(String bdate) {
			this.bdate = bdate;
		}

		public int getBcount() {
			return bcount;
		}

		public void setBcount(int bcount) {
			this.bcount = bcount;
		}
		
		
		
}
