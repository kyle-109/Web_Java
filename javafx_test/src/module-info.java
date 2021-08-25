module javafx_test {
	requires javafx.controls;
	requires javafx.fxml; // 해당 라이브러리 사용
	
	// opens 패키지명 to 라이브러리명
	opens application to javafx.graphics, javafx.fxml;
	
}
