package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Domain.List;
import Domain.Member;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignupController implements Initializable{
	// fx:id 가져오기
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	 @FXML
	 private TextField txtid;

	 @FXML
	 private PasswordField txtpassword;

	 @FXML
	 private PasswordField txtpasswordconfirm;

	 @FXML
	 private TextField txtname;

	 @FXML
	 private TextField txtemail;

	 @FXML
	 private TextField txtphone;

	 @FXML
	 private Label btnsignup;

	 @FXML
	 private Label lblconfirm;

	 @FXML
	 void signup(MouseEvent event) throws Exception {
		 // 유효성 검사
		 	// 0. 중복 아이디 체크
		 for(Member member: Domain.List.members) {
			 if(txtid.getText().equals(member.getId())) {
				 lblconfirm.setText("중복된 아이디입니다");
				 return;
			 }
		 }
		 	// 1. 아이디는 4~10글자 이내
		 if(txtid.getText().length()<4||txtid.getText().length()>10) {
			 lblconfirm.setText("아이디는 4~10글자로 입력해주세요");
			 return;
		 }
		 	// 2. 비밀번호와 비밀번호확인이 동일해야한다
		 if(!txtpassword.getText().equals(txtpasswordconfirm.getText())) {
			 lblconfirm.setText("비밀번호가 다릅니다");
			 return;
		 }
		 
		 	// 3. 비밀번호는 8~15글자
		 if(txtpassword.getText().length()<8||txtpassword.getText().length()>15) {
			 lblconfirm.setText("비밀번호는 8~15글자로 입력해주세요");
			 return;
		 }
		 
		 	// 4. 이메일은 반드시 @ 포함되어야 한다.
		 if(!txtemail.getText().contains("@")) {
			 lblconfirm.setText("이메일에 @를 포함하세요");
			 return;
		 }
//		 try {
//		 Integer.parseInt(txtphone.getText());
//		 }catch(Exception e) {
//			 lblconfirm.setText("전화번호는 -빼고 숫자 11자리로 적어주세요");
//			 return;
//		 }
		 	// 5. 전화번호는 -제외한 11글자
		 if(txtphone.getText().contains("-") || txtphone.getText().length()!=11) {
			 lblconfirm.setText("전화번호는 -빼고 숫자 11자리로 적어주세요");
			 return;
		 }
		 //객체화
		 Member member = new Member(txtid.getText(), txtpassword.getText(), txtname.getText(), txtemail.getText(), txtphone.getText(), 100);
		 
		 // 멤버리스트 담기
		 //List.members.add(member);
		 //파일저장
		 //filesave(1);
		 //DB
		 MemberDao memberDao = MemberDao.getMemberDao();
		 boolean result = memberDao.signup(member);
		 
		 if(result) {
			 // 회원가입 성공[메시지 띄우고 해당 스테이지 닫기]
		 	 // 1. 메시지 객체 만들기
		 	 Alert alert = new Alert(AlertType.INFORMATION);
		 	 // 2. 메시지 내용 넣기
		 	 alert.setContentText("포르쉐 오너 가입을 축하합니다");
		 	 alert.setHeaderText("회원가입성공");
		 	 // 3. 메시지 실행
		 	 alert.showAndWait();//창을 열고 닫을때까지 기다리기
		 	 // 현재 회원가입 스테이지 끄기
		 	 btnsignup.getScene().getWindow().hide();
		 	 return;
		 }
		 else {
			 //DB 오류 혹은 아이디가 중복되어 있는 경우 실패
			 lblconfirm.setText("동일한 아이디가 존재합니다.");
			 return;
		 }
	 }
	 public static void filesave(int a) throws Exception {
		 FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/김정수/eclipse-workspace/javafx_project/src/Controller/member.txt");
		 // 내용저장
		 if(a==1) {
			 for(Member members : Domain.List.members)
			 {
				 String outString = members.getId()+","+members.getPassWord()+","+members.getName()+","+members.getEmail()+","+members.getPhoneNumber()+","+members.getPoint()+"\n";
				 fileOutputStream.write(outString.getBytes());
			 }
			 fileOutputStream.flush();
			 fileOutputStream.close();
		 }
		 // 내용없이 저장
		 else {
			 String outString = "";
			 fileOutputStream.write(outString.getBytes());
			 fileOutputStream.flush();
			 fileOutputStream.close();
		 }
	 }
}
