package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Test1 extends Application{
	// 1. javafx로부터 상속받기[해당 클래스의 메모리 이용가능]
		// Application 클래스로부터 상속받기
	
	// 2. Application의 Start 메소드 재정의
		// javafx 실행
	@Override//ctrl+spacebar => 맨위의 start
	public void start(Stage stage) throws Exception {
			// 4. stage 객체 이름 정하기
		
		// 5. 컨테이너 만들기
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);// 컨테이너 내 컨트롤 정렬
//		vBox.prefHeight(500);
//		vBox.prefWidth(500);
			// 5-1. 컨테이너 => 컨드롤 구성
				Button button = new Button(); // 버튼객체 만들기
				button.setText("닫기"); // 버튼에 텍스트 설정
				button.setOnAction( e -> Platform.exit()); // 버튼을 클릭했을 때 플랫폼 닫기
				
			// 5-2.
				Label label = new Label(); // 레이블 객체 만들기(텍스트 상자) 
				label.setText("안녕하세요 javafx입니다"); // 레이블에 텍스트 설정
				label.setFont(new Font(30)); // 레이블에 글꼴 설정
				
		// 5-3. 컨테이너에 컨트롤 넣기
			vBox.getChildren().add(label);
			vBox.getChildren().add(button);
				
		// 6. 씬 만들기
		Scene scene = new Scene(vBox, 500, 500); // 컨테이너명, 가로길이, 세로길이(픽셀단위)
		// 7. 스테이지에 씬 넣기
		stage.setScene(scene);
		// 8. 스테이지 실행
		stage.show();
	}
	
	public static void main(String[] args) { // 메인 쓰레드가 있어야 하기 때문에
							//main메소드의 인수 args 배열 => 콘솔에 입력된 데이터 저장
		//3. Start 메소드 호출
			launch(args);
	}
}
