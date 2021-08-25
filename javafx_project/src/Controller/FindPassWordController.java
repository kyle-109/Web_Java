package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Domain.List;
import Domain.Member;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class FindPassWordController implements Initializable{
	
	// confirm message 비워두기
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
		
	}

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtemail;

    @FXML
    private Label btnfindpassword;

    @FXML
    private Label lblconfirm;

    @FXML
    void findpassword(MouseEvent event) {
//    	for(Member member: List.members) {
//    		if(txtid.getText().equals(member.getId())&& txtemail.getText().equals(member.getEmail())) {
    	MemberDao memberDao = MemberDao.getMemberDao();		
    	String result = memberDao.findpassword(txtid.getText(), txtemail.getText());		
    	if(result!=null) {	
    		// 메시지
    			lblconfirm.setText("비밀번호를 찾았습니다");
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setContentText("회원님의 비밀번호는 "+result+"입니다");
    			alert.setHeaderText("비밀번호찾기");
    			alert.showAndWait();//띄우고 끄기 전까지 띄워두기
    			btnfindpassword.getScene().getWindow().hide(); // 비밀번호 찾기 페이지 끄기
    			return;
    		}
    	lblconfirm.setText("해당정보의 계정이 없습니다.");
    	}
    }
