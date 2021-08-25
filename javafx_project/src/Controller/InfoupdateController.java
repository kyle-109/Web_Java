package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Dao.FileUtil;
import Dao.MemberDao;
import Domain.List;
import Domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InfoupdateController implements Initializable{
	
	// 사용자 정보수정페이지
	
	private String loginid;
	//private Member loginmember;
	private Member member=null;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 1. 로그인 회원정보 가져오기
		loginid = LoginController.getinstance().getloginid();
		
		MemberDao memberDao = MemberDao.getMemberDao();
		member = memberDao.getMember(loginid);
		txtname.setText(member.getName());
		txtemail.setText(member.getEmail());
		txtphone.setText(member.getPhoneNumber());
		
//		for(Member member : List.members) {
//			// 로그인한 사람의 정보를 갖고 와서
//			if(member.getId().equals(loginid)) {
//				loginmember = member;
//				// 2. 로그인된 회원의 이름, 이메일 연락처 표시
//				txtname.setText(member.getName());
//				txtemail.setText(member.getEmail());
//				txtphone.setText(member.getPhoneNumber());
//			}	
//		}
	}
	
    @FXML
    private Button btnupdate;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private PasswordField txtnewpassword;

    @FXML
    void update(ActionEvent event) throws Exception {
    	//1. 기존비밀번호를 입력받아 동일한 경우에만 수정
    	String password = txtpassword.getText();
    	
    	if(!member.getPassWord().equals(password)) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("비밀번호가 일치하지 않습니다.");
    		alert.setHeaderText("수정실패");
    		alert.showAndWait();
    		return;
    	}
    	// 2. 기존비밀번호와 동일한 경우 업데이트처리
    	member.setName(txtname.getText());
		member.setEmail(txtemail.getText());
		member.setPhoneNumber(txtphone.getText());
		// 3. 새로운 비밀번호가 없을경우[기존비밀번호사용] 
		if(!txtnewpassword.getText().equals("")) {
			member.setPassWord(txtnewpassword.getText());
		}
		// db업데이트 처리
		MemberDao memberDao = MemberDao.getMemberDao();
		boolean result = memberDao.updateMember(member);
		
		if(result) {
			// 업데이트 성공 메시지 => 로그아웃
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("회원정보가 수정되었습니다. 로그아웃 처리후 다시 로그인해주세요");
			alert.setHeaderText("회원정보수정성공");
			alert.showAndWait();
			// 현재스테이지 닫기
			btnupdate.getScene().getWindow().hide();//수정페이지 끄기
			
			// 개인정보를 바꿨으니 로그인 페이지로 이동
			Stage stage = new Stage();
			// 2. fxml 파일 객체화										// 현재 클래스와 패키지가 다르기 때문에
			Parent parent = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
			
			// 3. 씬 만들어서 fxml 파일 넣기
			Scene scene = new Scene(parent);
			
			// 4. 스테이지에 씬 넣기
			stage.setScene(scene);
			
			// 5. 스테이지 설정 및 실행
			stage.setResizable(false);// 스테이지 크기 변경불가
			stage.setTitle("포르쉐오너");// 스테이지 타이틀
			// 스테이지 아이콘
				// 1. 이미지 불러오기
				Image image = new Image("file:C:/Users/김정수/eclipse-workspace/javafx_project/src/FXML/porsche.png");
				stage.getIcons().add(image);
				stage.show();
			return;
		}
    	//1. 기존비밀번호를 입력받아서 동일한 경우에만 수정
//    	if(txtpassword.getText().equals(loginmember.getPassWord())) {
//    		// 입력한 값으로 회원정보업데이트
//    		loginmember.setName(txtname.getText());
//    		loginmember.setEmail(txtemail.getText());
//    		loginmember.setPhoneNumber(txtphone.getText());
//    		// 새비번이 비워져 있지 않으면 새로운 비번으로 설정.
//    		if(!txtnewpassword.getText().equals("")) {
//    			loginmember.setPassWord(txtnewpassword.getText());
//    		}
//    		
//    		//업데이트된 정보로 새로 파일에 저장
//    		//파일처리
//    		FileUtil.filesave(1);
//    		
//    		// 업데이트 성공 메시지 => 로그아웃
//    		Alert alert = new Alert(AlertType.INFORMATION);
//    		alert.setContentText("회원정보가 수정되었습니다. 로그아웃 처리후 다시 로그인해주세요");
//    		alert.setHeaderText("회원정보수정성공");
//    		alert.showAndWait();
//    		// 현재스테이지 닫기
//    		btnupdate.getScene().getWindow().hide();//수정페이지 끄기
//    		
//    		// 개인정보를 바꿨으니 로그인 페이지로 이동
//			Stage stage = new Stage();
//			// 2. fxml 파일 객체화										// 현재 클래스와 패키지가 다르기 때문에
//			Parent parent = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
//			
//			// 3. 씬 만들어서 fxml 파일 넣기
//			Scene scene = new Scene(parent);
//			
//			// 4. 스테이지에 씬 넣기
//			stage.setScene(scene);
//			
//			// 5. 스테이지 설정 및 실행
//			stage.setResizable(false);// 스테이지 크기 변경불가
//			stage.setTitle("포르쉐오너");// 스테이지 타이틀
//			// 스테이지 아이콘
//				// 1. 이미지 불러오기
//				Image image = new Image("file:C:/Users/김정수/eclipse-workspace/javafx_project/src/FXML/porsche.png");
//				stage.getIcons().add(image);
//				stage.show();
//    		return;
//    	}
//    	else {
//    		Alert alert = new Alert(AlertType.ERROR);
//    		alert.setContentText("비밀번호가 일치하지 않습니다.");
//    		alert.setHeaderText("수정실패");
//    		alert.showAndWait();
//    		return;
//    	}
    }
}
