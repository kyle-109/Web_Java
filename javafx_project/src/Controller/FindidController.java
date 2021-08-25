package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Domain.List;
import Domain.Member;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class FindidController implements Initializable{
	
	//confirm message 비워두기
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private Label btnfindid;

    @FXML
    private Label lblconfirm;

    @FXML
    void findid(MouseEvent event) {
    	// 입력한 이름과 이메일이 동일한 경우 아이디를 메시지로 띄우기
//    	for(Member member: List.members) {
//    		if(txtname.getText().equals(member.getName())&& txtemail.getText().equals(member.getEmail())) {
    	MemberDao memberDao = MemberDao.getMemberDao();		
    	String result = memberDao.findid(txtemail.getText(), txtname.getText());
    		if(result!=null){
    		// 메시지
    			lblconfirm.setText("아이디를 찾았습니다");
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setContentText("회원님의 아이디는 "+result+"입니다");
    			alert.setHeaderText("아이디찾기");
    			alert.showAndWait();//띄우고 따로 끄지 않으면 계속 띄워둔다
    			btnfindid.getScene().getWindow().hide();//아이디찾기 페이지 끄기
    			return;
    		}
    		lblconfirm.setText("해당정보의 계정이 없습니다.");
    	}
    	
    }


