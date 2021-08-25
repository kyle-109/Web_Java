package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test2 extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
					// 1. 스테이지 객체명 정하기
		// 2. fxml 파일 객체화
		Parent parent = FXMLLoader.load(getClass().getResource("test1.fxml"));
			// Parent: fxml 파일내 객체화 클래스
		// 3. 씬
		Scene scene = new Scene(parent);// fxml 객체 씬에 넣기
		// 4. 스테이지
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
