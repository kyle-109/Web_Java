package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.Member;

public class MemberDao {
				// Dao: 데이터베이스 접근 객체
	
	// JDBC 주요 인터페이스
			// 1. connection : DB연결인터페이스 선언
			// 2. PreparedStatement: DB연결후 SQL 관리/조작 인터페이스
			// 3. resultSet : 쿼리 연결 인터페이스
	
	// 필드
	private Connection connection; // DB 연결인터페이스 선언
	
	private ResultSet resultSet; // 검색후 결과[SQL 실행후의 결과쿼리] 연결
	
	// dao 객체
	private static MemberDao memberDao = new MemberDao();
	
	// dao 객체 반환 메소드
	public static MemberDao getMemberDao() {
		return memberDao;
	}
	
	// 생성자
	public MemberDao() {
		
		
		// 1. 해당 드라이브를 가져오기
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. DB URL 연결
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx?serverTime=UTC", "root", "1234");
			System.out.println("DB 연동 성공");
		} catch (ClassNotFoundException e) {		
		} catch (SQLException e) {
		}
	}
		

		
	
	
	// 1. 회원가입 메소드 [인수 : 회원가입정보
	public boolean signup(Member member) {
		
		// 1. SQL 작성
		String sql = "insert into member(m_id, m_password, m_name, m_email, m_phone, m_point)values(?,?,?,?,?,?)";	
		// 2. SQL<->DB 연결[PreparedStatement : sql 관리 조작 ]
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql); // 예외처리 무조건 발생
			// 3. SQL 조작 [?에 값 넣기]
			preparedStatement.setString(1, member.getId());
			preparedStatement.setString(2, member.getPassWord());
			preparedStatement.setString(3, member.getName());
			preparedStatement.setString(4, member.getEmail());
			preparedStatement.setString(5, member.getPhoneNumber());
			preparedStatement.setInt(6, member.getPoint());
			// 4. SQL 실행
			preparedStatement.executeUpdate();
			// 5. SQL 결과// 회원가입성공
			return true;
		} catch (SQLException e) {} 
		
		return false;// 회원가입 실패시 false 반환
	}
	
	// 2. 로그인 메소드
	public boolean login(String id, String password) {
		
		// 1. SQL 작성
		String sql = "select * from member where m_id =? and m_password =?";
		
		// 2. 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//3.
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			//4. 실행(ResultSet: https://aricode.tistory.com/10 )
			resultSet=preparedStatement.executeQuery();
			//5. 결과[resultSet 초기값 null-> 결과1레코드->결과2레코드->결과3레코드
			if(resultSet.next()) {
				// sql 결과가 존재하면
				return true; // 존재하는 회원
			}
			return false; // 존재하지 않는 휘원
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.
		
		return false; // 로그인 실패 혹은 DB 오류
	}
	
	// 3. 아이디찾기 메소드
	public String findid(String email, String name) {
		
		// 1. SQL 작성
		String sql = "select * from member where m_email =? and m_name =?";
		
		// 2. 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//3.
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, name);
			//4. 실행(ResultSet: https://aricode.tistory.com/10 )
			resultSet=preparedStatement.executeQuery();
			//5. 결과[resultSet 초기값 null-> 결과1레코드->결과2레코드->결과3레코드
			if(resultSet.next()) {
				// sql 결과가 존재하면[resultSet의 초기값은 null]
				// .next(): 다음 레코드
				
				return resultSet.getString(1); // .getString(필드순서)문자열빼오기
				// return resultSet.getString(m_id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	// 4. 비밀번호찾기 메소드
	public String findpassword(String id, String email) {
		
		// 1. SQL 작성
		String sql = "select * from member where m_id =? and m_email =?";
		
		// 2. 
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//3.
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, email);
			//4. 실행(ResultSet: https://aricode.tistory.com/10 )
			resultSet=preparedStatement.executeQuery();
			//5. 결과[resultSet 초기값 null-> 결과1레코드->결과2레코드->결과3레코드
			if(resultSet.next()) {
				// sql 결과가 존재하면[resultSet의 초기값은 null]
				// .next(): 다음 레코드
				
				return resultSet.getString(2); // 쿼리결과 레코드에서 2번째 필드 가져와서 반환
				// .getString(필드순서)문자열빼오기
				// return resultSet.getString(m_password);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	// 5. 회원 호출 메소드[아이디 해당하는 회워 정보 호출]
	public Member getMember(String id) {
		
		String sql = "select * from member where m_id =?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//3.
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				// 쿼리가 존재하면
					// 회원 객체를 만들어서 반환하기
				Member member = new Member(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
			
				return member;//해당하는 회원의 정보 반환
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	// 6. 회원 수정 메소드
	public boolean updateMember(Member member) {
		String sql = "update member set m_password = ? , m_name=? , m_email=? , m_phone=? where m_id=? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getPassWord() );
			preparedStatement.setString(2, member.getName() );
			preparedStatement.setString(3, member.getEmail() );
			preparedStatement.setString(4, member.getPhoneNumber());
			preparedStatement.setString(5, member.getId() );
			
			preparedStatement.executeUpdate();
			return true;
			
		}catch (Exception e) {}
		return false;
	}
	// 7. 회원 탈퇴 메소드[아이디 해당하는 회원 레코드 삭제]
	public boolean deleteMember(String id) {
		String sql = "delete from member where m_id =?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			
			return true;
		} catch (Exception e) {}
		return false;
	}
}
