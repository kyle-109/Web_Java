package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Dao.BoardDao;
import Domain.BoardDto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class CommunitypageController implements Initializable{
	
	private static BoardDto boarddto;// 현재 클릭된 게시물의 아이템
	
	private static CommunitypageController instance;
	
	public CommunitypageController() {
		instance = this;
	}
	
	public static CommunitypageController getinstance() {
		return instance;
	}
	
	public BoardDto getboard() {
		return boarddto;
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 해당 페이지가 열렸을 떄 초기값을 설정해주는 메소드
		
		//1. DAO 객체
		BoardDao boardDao = BoardDao.getboardDao();
		//2. Dao 메소드 실행
		ObservableList<BoardDto> boardDtos = boardDao.boardlist();
		
		//3. 결과를 테이블의 각 필드에 값 넣기
		TableColumn tc = tableview.getColumns().get(0);//첫번쨰 열[필드] 가져오기
		tc.setCellValueFactory(new PropertyValueFactory<>("bno"));
		
		tc=tableview.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		
		tc=tableview.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("bwriter"));
		
		tc=tableview.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("bdate"));
		
		tc=tableview.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory<>("bcount"));
		

		//4. 테이블의 리스트 연결성공
		tableview.setItems(boardDtos);
		
		// 테이블에 행 클릭했을 때 이벤트
			//tableview.setOnMouseClicked((MouseEvent event) -> {실행코드});
									// 람다식: 익명메소드[인수->실행코드]
		tableview.setOnMouseClicked((MouseEvent event) -> {
			if(event.getButton().equals(MouseButton.PRIMARY)) { // 해당 이벤트가 클릭이면
				
						// 테이블에서 선택한 모델[행]의 아이템[셀값]
				boarddto = tableview.getSelectionModel().getSelectedItem();
				// 조회수 증가
				
				MainpageController.getinstance().loadpage("boardviewpage");
				
			}
		});
	}
	
	// fx:id

    @FXML
    private TableView<BoardDto> tableview; // ObservabelList만 받을 수 있다.
    			  // < > : 제네릭

    @FXML
    private Button btnboardwrite;

    @FXML
    void boardwrite(ActionEvent event) {
    	MainpageController.getinstance().loadpage("boardwritepage");
    }
}
