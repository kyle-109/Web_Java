module javafx_project {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	
	// opens 패키지명 to 라이브러리명
	opens Start to javafx.graphics, javafx.fxml;
	opens Controller to javafx.graphics, javafx.fxml;
	opens Dao to java.sql;
	opens Domain to javafx.base;
}
