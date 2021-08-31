package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Domain.List;
import Domain.Member;
import javafx.animation.PauseTransition;
// 모든 import가 javafx.여야 한다!!!!
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

// fxml은 씬빌더에서 작성, Controller는 자바에서 만들었다.
// 둘을 연결하기 위해서는 fxml파일에 import 바로 다음<>안에 fx:controller="패키지명.컨트롤러 클래스명" 추가해야한다.
// module-info에 opens 패키지명 to javafx.graphics, javafx.fxml; 추가

public class LoginController implements Initializable{
								// Initializable : fxml 실행시 초기값 설정 인터페이스
	// 씬빌더에 정한 fx:id 가져오기
	// 씬빌더 프로그램 view => show sample controller skeleton => 복붙
	FileInputStream fileInputStream = null;
	
	// 현재 클래스[컨트롤러]의 객체
	private static LoginController instance; // 현재 클래스의 객체
	
	public LoginController() {// 현재클래스의 메모리 받아 객체 생성하는 생성자
		instance = this;
	}
	
	public static LoginController getinstance() { // 객체를 반환해주는 메소드
		return instance;
	}
	
	public String getloginid() { // 로그인시 입력된 아이디를 반환해주는 메소드
		return txtid.getText();
	}
	
	@Override // 초기 메소드 재정의
    public void initialize(URL arg0, ResourceBundle arg1) {
    		// fxml파일이 열렸을 때 초기 메소드
		
		//confirm message 비워두기
		lblconfirm.setText("");// 컨트롤명.setText(): 해당 컨트롤에 텍스트 설정
		
		//로딩이미지 가려놓기
		imgloading.setVisible(false);
		
		//저장해놓은 멤버를 불러오기
//		try {
//			fileInputStream = new FileInputStream("C:/Users/김정수/eclipse-workspace/javafx_project/src/Controller/member.txt");
//		} catch (FileNotFoundException e) {
//			try {
//				// 파일을 못 찾으면 빈 파일 생성
//				SignupController.filesave(0);
//			} catch (Exception e1) {
//				System.out.println("파일생성오류");
//				System.out.println("파일로드오류1");
//			}
//		}
//		// 불러온 파일 내용을 저장할 바이트배열
//		byte[] bytearr = new byte[10000];
//		try {
//			//내용을 바이트배열에 저장
//			fileInputStream.read(bytearr);
//		} catch (IOException e) {
//			System.out.println("파일로드오류2");
//		}
//		//바이트 배열을 문자열로 변환
//		String memberList = new String(bytearr);
//		// "\n"기준으로 멤버별로 나눠 문자열배열에 저장
//		String[] member = memberList.split("\n");
//		//각 멤버별로 멤버리스트에 차곡차곡 저장
//		for(int i =0; i<member.length-1; i++) {
//			String[] fields = member[i].split(",");
//			Member temp = new Member(fields[0], fields[1], fields[2], fields[3], fields[4], Integer.parseInt(fields[5]));
//			Domain.List.members.add(temp);
//		}
//		try {
//			fileInputStream.close();
//		} catch (IOException e) {
//			System.out.println("파일입력닫기오류");
//		}
		
	}
	
	@FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Label btnlogin;

    @FXML
    private Label btnsignup;

    @FXML
    private Label btnfindid;

    @FXML
    private Label btnfindpassword;

    @FXML
    private Label lblconfirm;

    @FXML    private ImageView imgloading;

    @FXML
    void findid(MouseEvent event) throws Exception{
    	Stage stage = new Stage();
    	Parent parent = FXMLLoader.load(getClass().getResource("/FXML/findid.fxml"));
    	Scene scene = new Scene(parent);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void findpassword(MouseEvent event) throws Exception {
    	Stage stage = new Stage();
    	Parent parent = FXMLLoader.load(getClass().getResource("/FXML/findpassword.fxml"));
    	Scene scene = new Scene(parent);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void login(MouseEvent event) {// 로그인 버튼 클릭시
    	//아이디가 비어있을 때 
    	if(txtid.getText().equals("")) {
    		lblconfirm.setText("아이디를입력해주세요");
    		return;
    	}
    	//비밀번호가 비어있을때 
    	if(txtpassword.getText().equals("")) {
    		lblconfirm.setText("비밀번호를입력해주세요");
    		return;
    	}
    	
    	
    	imgloading.setVisible(true); // 로딩이미지 다시 표시
    	
    	// 2초간 일시 정지[PauseTransition : javafx 중지 클래스]
    	PauseTransition pauseTransition = new PauseTransition();// 객체 생성
    	pauseTransition.setDuration(Duration.seconds(2));		// 일시정지 시간 설정
    	//pauseTransition.setOnFinished(인수 -> {실행코드});
    	
    	// 익명 메소드[람다식]
    		// 인수 -> {실행코드}
    	pauseTransition.setOnFinished(인수 -> {
    				// 일시정지가 끝나면 실행되는 코드
    		imgloading.setVisible(false); // 로딩이미지 숨기기
    		
    		// DB처리
    		MemberDao memberDao = MemberDao.getMemberDao();
    		boolean result = memberDao.login(txtid.getText(), txtpassword.getText());
    		
    		if(result) {// 로그인 성공
        		// mainpage 실행
    			Stage stage2 = new Stage();
    			try {
					Parent parent = FXMLLoader.load(getClass().getResource("/FXML/mainpage.fxml"));
					Scene scene = new Scene(parent);
					stage2.setScene(scene);
					stage2.setResizable(false);// 스테이지 크기 변경불가
					stage2.setTitle("포르쉐오너");// 스테이지 타이틀
					// 스테이지 아이콘
						// 1. 이미지 불러오기
					Image image = new Image("file:C:/Users/김정수/eclipse-workspace/javafx_project/src/FXML/porsche.png");
					stage2.getIcons().add(image);
					stage2.show();
						
				} catch (Exception e) {}
    		// 기존 스테이지 닫기
    		btnlogin.getScene().getWindow().hide();
    		return;
    		}
    		else {// 로그인 실패
    			lblconfirm.setText("올바른 회원정보가 아닙니다");
    		}
//    		// 입력한 정보가 리스트[회원목록]에 존재하면
//    		for(Member member : List.members) {
//	        	if(txtid.getText().equals(member.getId())&&txtpassword.getText().equals(member.getPassWord())) {
//	        		lblconfirm.setText("[[ 로그인성공 ]]");
//	        		
//	        		// mainpage 실행
//	        			Stage stage2 = new Stage();
//	        			try {
//							Parent parent = FXMLLoader.load(getClass().getResource("/FXML/mainpage.fxml"));
//							Scene scene = new Scene(parent);
//							stage2.setScene(scene);
//							stage2.setResizable(false);// 스테이지 크기 변경불가
//							stage2.setTitle("포르쉐오너");// 스테이지 타이틀
//							// 스테이지 아이콘
//								// 1. 이미지 불러오기
//							Image image = new Image("file:C:/Users/김정수/eclipse-workspace/javafx_project/src/FXML/porsche.png");
//							stage2.getIcons().add(image);
//							stage2.show();
//								
//						} catch (Exception e) {}
//	        		// 기존 스테이지 닫기
//	        		btnlogin.getScene().getWindow().hide();
//	        		return;
//	        	}
//    		}
        
        	
    		
    	});
    	
    	
    	pauseTransition.play(); // 정지 클래스 시작
    		

    	
    	
    	
    }

    @FXML
    void signup(MouseEvent event) throws Exception{// 회원가입을 눌렀을 때  
    	//1. 스테이지 생성
    	Stage stage = new Stage();
    	
    	//2. fxml 불러오기
    	Parent parent = FXMLLoader.load(getClass().getResource("/FXML/signup.fxml"));
    	//파일이 없을 경우 예외가 발생하기에 무조건 예외발생
    	
    	//3. 씬 생서우 [씬에 fxml 넣기]
    	Scene scene = new Scene(parent);
    	//4. 스테이지 실행[스테이지에 씬 넣기]
    	stage.setScene(scene);
    	stage.show();
    }
}
