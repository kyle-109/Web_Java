package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Start.Start;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainpageController implements Initializable{
	
	// 로그인시 뜨는 메인페이지
	
	// 현재 클래스[컨트롤러]의 객체화
	private static MainpageController instance;
	
	public MainpageController() {
		instance = this;
	}
	
	public static MainpageController getinstance() {
		return instance;
	}
	
	
	private String loginid;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		loginid = LoginController.getinstance().getloginid();
		// loginController에서 로그인된 아이디 가져오기
		// static이어서 호출가능
		//로그인한 사용자의 아이디로 초기값설정
		lblloginid.setText(loginid);
			
	}
	
    @FXML
    private BorderPane borderpane;

    @FXML
    private AnchorPane cp;

    @FXML
    private AnchorPane lp;

    @FXML
    private Label lblloginid;

    @FXML
    private Button btnlogout;

    @FXML
    private Label btncommunity;

    @FXML
    private Label btninfo;

    @FXML
    private Label btnproduct;

    @FXML
    private Label btnchatting;

    @FXML
    void chatting(MouseEvent event) {
    	loadpage("chattingpage");
    }

    @FXML
    void community(MouseEvent event) {
    	loadpage("communitypage");
    }

    @FXML
    void info(MouseEvent event) {
    	loadpage("infopage");
    }

    @FXML
    void logout(ActionEvent event) throws Exception { // 로그아웃을 클릭했을 때
    	
    	//0. 메시지를 띄우기 [확인/취소]
		// 메시지
		Alert alert = new Alert(AlertType.CONFIRMATION);//예,아니오가 달린 창
		alert.setContentText("로그아웃 하시겠습니까?");//창안의 내용
		alert.setHeaderText("로그아웃");//창의 이름
			
			// 해당 메시지에서 선택한 버튼 가져오기
			Optional<ButtonType> optional = alert.showAndWait();
				// null 포함한 모든 객체을 저장
			if(optional.get()==ButtonType.OK) {// 확인 버튼을 눌렀을 때
				//로그아웃창 끄기
				btnlogout.getScene().getWindow().hide();
				
				// 새 창띄우기
				Stage stage = new Stage();
				// 2. fxml 파일 객체화				
				// 현재 클래스와 패키지가 다르기 때문에
				// 다시 로그인 창으로 이동
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

		//System.out.println(optional);	

		return;
		
    	//1. 현재 스테이지 닫기[ 현재 컨트롤명.getScene().getWindow().hide();]
    //	btnlogout.getScene().getWindow().hide();
    	//2. 로그인 스테이지 열기
    	
    	
    }

    @FXML
    void product(MouseEvent event) {
    	loadpage("productpage");
    }
    
    //////////////////페이지전환메소드[메인 페이지의 cp에 표시할 fxml변환]////////////////////////////
    public void loadpage(String page) {
    	try {
			Parent parent = FXMLLoader.load(getClass().getResource("/FXML/"+page+".fxml"));
			borderpane.setCenter(parent);
    	} catch (IOException e) {

		}
    }
}
