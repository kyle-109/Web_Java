package Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import Domain.Member;

public class FileUtil {
	
	// 파일 경로
	static String memberpath = "C:/Users/김정수/eclipse-workspace/javafx_project/src/Controller/member.txt";
	
	 public static void filesave(int a) throws Exception {
		 FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/김정수/eclipse-workspace/javafx_project/src/Controller/member.txt");
		 if(a==1) {
			 for(Member members : Domain.List.members)
			 {
				 String outString = members.getId()+","+members.getPassWord()+","+members.getName()+","+members.getEmail()+","+members.getPhoneNumber()+","+members.getPoint()+"\n";
				 fileOutputStream.write(outString.getBytes());
			 }
			 fileOutputStream.flush();
			 fileOutputStream.close();
		 }
		 else {
			 String outString = "";
			 fileOutputStream.write(outString.getBytes());
			 fileOutputStream.flush();
			 fileOutputStream.close();
		 }
	 }
	 
	 public static void fileload() {
		 try {
			FileInputStream fileInputStream = new FileInputStream(memberpath);
			byte[] bytes = new byte[10000];
			fileInputStream.read(bytes);
			String inString = new String(bytes);
			String[] Members = inString.split("\n");
			for(int i = 0; i<Members.length-1; i++) {
				String[] fields = Members[i].split(",");
				Member member = new Member(fields[0], fields[1], fields[2], fields[3], fields[4], Integer.parseInt(fields[5]));
				Domain.List.members.add(member);
			}
			fileInputStream.close();
		 } catch (Exception e) {}
		
	 }
}
