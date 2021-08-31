package Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Dao.BoardDao;
import Domain.BoardDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class boardviewpageController implements Initializable{
	
	BoardDto boardDto = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//메소드 안에서 선언된 변수는 메소드 밖으로 못나감
//		BoardDto boardDto = CommunitypageController.getinstance().getboard();
		boardDto = CommunitypageController.getinstance().getboard();
		
		lblbwriter.setText("작성자: "+boardDto.getBwriter());
		lblbcount.setText("조회수: "+boardDto.getBcount());
		lblbdate.setText("작성일: "+boardDto.getBdate());
		txttitle.setText(boardDto.getBtitle());
		txtcontents.setText(boardDto.getBcontents());
		
		// 현재 게시물의 작성자와 로그인된 아이디와 같지 않을 경우에 삭제/수정 버튼 숨기기
		if(!boardDto.getBwriter().equals(LoginController.getinstance().getloginid())) {
			btnboardupdate.setVisible(false);
			btnboarddelete.setVisible(false);
		}
	}
	
    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontents;

    @FXML
    private Button btnboardlist;

    @FXML
    private Button btnboarddelete;

    @FXML
    private Button btnboardupdate;

    @FXML
    private Label lblbwriter;

    @FXML
    private Label lblbdate;

    @FXML
    private Label lblbcount;

    @FXML
    void boarddelete(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setContentText("해당 게시물을 정말 삭제하시겠습니까?");
    	alert.setTitle("게시물 삭제");
    	alert.setHeaderText("메시지");
    	
    	// Optional : null값을 포함한
    	Optional<ButtonType> optional = alert.showAndWait();
    	if(optional.get()==ButtonType.OK) {
    		//1. 삭제 실행
    		BoardDao boardDao = BoardDao.getboardDao();
    		boardDao.boarddelete(boardDto.getBno());
    		//2. 페이지 이동
    		MainpageController.getinstance().loadpage("communitypage");
    	}
    }

    @FXML
    void boardlist(ActionEvent event) {
    	MainpageController.getinstance().loadpage("communitypage");
    }

    @FXML
    void boardupdate(ActionEvent event) {
    	MainpageController.getinstance().loadpage("boardupdatepage");
    }

}
