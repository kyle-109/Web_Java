package Controller;

import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class InfoController implements Initializable{
	
	// 사용자 정보 페이지
	private String loginid;
	
	// 로그인한 사용자의 정보로 초기화
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//1. 로그인된 아이디 가져오기
		loginid = LoginController.getinstance().getloginid();
		
		//파일처리
		MemberDao memberDao = MemberDao.getMemberDao();
		Member member = memberDao.getMember(loginid);
		
		txtid.setText(member.getId());
		txtname.setText(member.getName());
		txtemail.setText(member.getEmail());
		txtphone.setText(member.getPhoneNumber().substring(0, 3)+"-"+member.getPhoneNumber().substring(3, 7)+"-"+member.getPhoneNumber().substring(7, 11));
		txtpoint.setText(member.getPoint()+"");
		
		//2. 리스트에서 아이디를 찾아서
//		for(Member member : List.members) {
//			if(member.getId().equals(loginid)) {
//				txtid.setText(member.getId());
//				txtname.setText(member.getName());
//				txtemail.setText(member.getEmail());
//				txtphone.setText(member.getPhoneNumber().substring(0, 3)+"-"+member.getPhoneNumber().substring(3, 7)+"-"+member.getPhoneNumber().substring(7, 11));
//				txtpoint.setText(member.getPoint()+"");
//			}
//		}
	}
	
    @FXML
    private Label txtid;

    @FXML
    private Label txtname;

    @FXML
    private Label txtemail;

    @FXML
    private Label txtphone;

    @FXML
    private Label txtpoint;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;
    
    // 멤버 탈퇴
    @FXML
    void delete(ActionEvent event) throws Exception {
    	// 1. 메시지창으로 확인여부 물어보기
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setContentText("정말 회원탈퇴하시겠습니까?");
    	alert.setHeaderText("회원탈퇴");
    	
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		// 2. ok 눌렀을 때
    		// 3. db처리
    		MemberDao memberDao = MemberDao.getMemberDao();
    		boolean result=memberDao.deleteMember(loginid);
    		if(result) {
				//4. 모든 스테이지 종료하고 로그인창으로 이동
				btndelete.getScene().getWindow().hide();
				//5. 로그인창 띄우기
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
    		}
    		// 3-1. 리스트와 파일에서 제거후 업데이트
//    		for(Member member : List.members) {
//    			//3-1.리스트에서 삭제
//    			if(member.getId().equals(loginid)) {
//    				List.members.remove(member);
//    				//3-2. 파일처리
//    				FileUtil.filesave(1);
//    				//4. 모든 스테이지 종료하고 로그인창으로 이동
//    				btndelete.getScene().getWindow().hide();
//    				//5. 로그인창 띄우기
//    				Stage stage = new Stage();
//    				// 2. fxml 파일 객체화										// 현재 클래스와 패키지가 다르기 때문에
//    				Parent parent = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
//    				
//    				// 3. 씬 만들어서 fxml 파일 넣기
//    				Scene scene = new Scene(parent);
//    				
//    				// 4. 스테이지에 씬 넣기
//    				stage.setScene(scene);
//    				
//    				// 5. 스테이지 설정 및 실행
//    				stage.setResizable(false);// 스테이지 크기 변경불가
//    				stage.setTitle("포르쉐오너");// 스테이지 타이틀
//    				// 스테이지 아이콘
//    					// 1. 이미지 불러오기
//    					Image image = new Image("file:C:/Users/김정수/eclipse-workspace/javafx_project/src/FXML/porsche.png");
//    					stage.getIcons().add(image);
//    					stage.show();
//    			}
//    		}
        	
    		
    	}
    }
    
    // 회원정보 수정페이지로 이동
    @FXML
    void update(ActionEvent event) {
    	// 페이지 전환[메인페이지에서 메소드 불러오기]
    	MainpageController.getinstance().loadpage("infoupdatepage");
    	
    }

}
