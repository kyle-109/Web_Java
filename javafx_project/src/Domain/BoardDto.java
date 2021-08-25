package Domain;

public class BoardDto {
			// Dto : 페이지간 이동 객체
	
	//필드
	private int bno;			//번호
	private String btitle;		//제목
	private String bcontents;	//내용
	private String bwriter;		//작성자
	private String bdate;		//작성일
	private int bcount;			//조회수
	
	//생성자[1.빈생성자 2.풀생성자 3.게시물등록시]
	public BoardDto() {}
	
	public BoardDto(int bno, String btitle, String bcontents, String bwriter, String bdate, int bcount) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontents = bcontents;
		this.bwriter = bwriter;
		this.bdate = bdate;
		this.bcount = bcount;
	}
	
	//게시물쓰기 생성자
	public BoardDto(String btitle, String bcontents, String bwriter) {
		this.btitle = btitle;
		this.bcontents = bcontents;
		this.bwriter = bwriter;
	}
	
	//메소드
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
