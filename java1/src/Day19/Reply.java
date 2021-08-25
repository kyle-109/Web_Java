package Day19;

import java.util.Scanner;

public class Reply {
	// 필드
	private int rno; // 댓글번호
	private int bno; // 어떤 게시물의 댓글인지 식별용
	private String rcontents; // 댓글 내용
	private String rwriter; // 댓글 작성자
	
	
	Scanner scanner = new Scanner(System.in);
	// 생성자
		// 1. 빈생성자
	public Reply() {}
		// 2. 모든필드 생성자

	public Reply(int rno, int bno, String rcontents, String rwriter) {
		this.rno = rno;
		this.bno = bno;
		this.rcontents = rcontents;
		this.rwriter = rwriter;
	}

	// 메소드
		// 1. 댓글쓰기[인수 : 게시물 번호]
	public void replywrite(int bno, Member login) {
		System.out.println("[[ 댓글 내용 ]]: "); String rcontents = scanner.nextLine();
		
		try {
		FileUtil.fileload(5);
		}catch (Exception e) {}
		// 객체
		Reply reply = new Reply(ConsoleProgram.rtotalno+1, bno, rcontents, login.getId());
		// 리스트에 추가
		ConsoleProgram.replyList.add(reply);
		// 파일처리
		ConsoleProgram.rtotalno++;
		try {
		FileUtil.filesave(3, 0);
		FileUtil.logSave(3, ConsoleProgram.rtotalno);
		}catch(Exception e) {
			
		}
	}
		
		// 2. 댓글 출력[인수 : 게시물 번호] : 해당 게시물번호가 일치하는 댓글만 출력
	public void replylist(int bno) {
		System.out.println("작성자\t내용");
		for(Reply reply : ConsoleProgram.replyList) {
			if(reply.getBno() == bno) {// 현재 게시물의 번호와 댓글의 게시물번호가 같으면
				System.out.println(reply.getRwriter()+"\t"+reply.getRcontents());
			}
		}
	}
		// 3. 댓글 삭제
	public void removeReply(int bno, Member login) {
		for(Reply reply : ConsoleProgram.replyList) {
			if(reply.getBno() == bno) {// 현재 게시물의 번호와 댓글의 게시물번호가 같으면
				if(reply.getRwriter().equals(login.getId())) {// 댓글 작성자와 현재 작성자가 같으면
					ConsoleProgram.replyList.remove(bno-1);// 댓글 삭제
					ConsoleProgram.rtotalno--;// 총 댓글 갯수 감소
					try {//삭제했으니 파일최신화
						FileUtil.filesave(3, 0);//댓글최신화
						FileUtil.logSave(3, ConsoleProgram.rtotalno);//댓글수 최신화
						}catch(Exception e) {}
				}
			}
		}
	}
		// 4. 댓글 수정
	public void fixReply(int bno, Member login) {
		for(Reply reply : ConsoleProgram.replyList) {
			if(reply.getBno() == bno) {// 현재 게시물의 번호와 댓글의 게시물번호가 같으면
				if(reply.getRwriter().equals(login.getId())) {// 댓글 작성자와 현재 작성자가 같으면
					System.out.print("[[ 내용을 입력하세요 ]]: "); String rcontents = scanner.nextLine();
					ConsoleProgram.replyList.get(bno-1).setRcontents(rcontents);// 내용 최신화
					try {//수정했으니 파일최신화
						FileUtil.filesave(3, 0);//댓글최신화
						}catch(Exception e) {}
				}
			}
		}
	}
		// 5. get, set 메소드
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getRcontents() {
		return rcontents;
	}

	public void setRcontents(String rcontents) {
		this.rcontents = rcontents;
	}

	public String getRwriter() {
		return rwriter;
	}

	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}
	

	
}	
