package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.BoardDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class boardviewpageController implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		BoardDto boardDto = CommunitypageController.getinstance().getboard();
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

    }

    @FXML
    void boardlist(ActionEvent event) {
    	MainpageController.getinstance().loadpage("communitypage");
    }

    @FXML
    void boardupdate(ActionEvent event) {

    }

}
