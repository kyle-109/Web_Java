package Start;

import Dao.BoardDao;
import Dao.FileUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application{
	
	@Override // application 상속받아 오버라이딩
	public void start(Stage stage) throws Exception {
					// 1. stage 이름
		
		// 회원로드
		// FileUtil.fileload();
		
		
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
			Image image = new Image("file:C:/Users/김정수/git/Web_Java/javafx_project/src/FXML/porsche.png");
			stage.getIcons().add(image);
			stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args); // start 메소드 호출
	}
	
}
// 1. 씬빌더[fxml]
// 2. 컨트롤러[java]
// 3. fxml 파일에 fx:controller = "패키지명.컨트롤명" 추가해서 두 파일 연결

	// 씬빌더에서 작성된 컨테이너 or 컨트롤러 이름 정하기
	// login.fxml
	// fx:id
	// TextField : txtid
	// PasswordField : txtpassword
	// Label : btnlogin
	// 		On Mouse Clicked: login
	// Label : btnsignup
	// 		On Mouse Clicked: signup
	// Label : btnfindid
	// 		On Mouse Clicked: findid
	// Label : btnfindpassword
	// 		On Mouse Clicked: findpassword
	// Label : lblconfirm
	// ImageView : imgloading


	// signup.fxml
	// fx:id
	// TextField : txtid
	// PasswordField : txtpassword
	// PasswordField : txtpasswordconfirm
	// TextField : txtname
	// TextField : txtemail
	// TextField : txtphone
	// Label : btnsignup
	// Label : lblconfirm
	// 		On Mouse Clicked: signup

	// findid.fxml
	// fx:id
	// TextField : txtname
	// TextField : txtemail
	// Label : btnfindid
		//	On Mouse Clicked: findid
	// Label : lblconfirm

	// findpassword.fxml
	// fx:id
	// TextField : txtid
	// TextField : txtemail
	// Label : btnfindpassword
		//	On Mouse Clicked: findpassword
	// Label : lblconfirm
	
	/*
	 * mainpage.fxml
	 * 	BoarderPane 	boarderpane
		AnchorPane		lp
		AnchorPane		cp
		Lable			lblloginid
		Button			btnlogout
					OnAction : logout
		
		Lable		btncommunty
					OnMouseClicked : communty
		Lable		btnproduct
					OnMouseClicked : product
		Lable		btnchatting
					OnMouseClicked : chatting
		Lable		btninfo
					OnMouseClicked : info
	 * 
	 * 
	 */

	/*
	 * infopage.fxml
	 * 
	 * txtid
	 * txtname
	 * txtemail
	 * txtphone
	 * txtpoint
	 * btnupdate
	 * 		update
	 * btndelete
	 * 		delete
	 * 
	 */


	/*
	 * infoupdatepage.fxml
	 * 
	 * txtpassword
	 * txtnewpassword
	 * txtname
	 * txtemail
	 * txtphone
	 * btnupdate
	 * 		update
	 * 
	 * 
	 */
