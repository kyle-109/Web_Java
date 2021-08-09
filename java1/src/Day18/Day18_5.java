package Day18;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Day18_5 {
	//  과제1 :
	// 	역순으로 출력할 때 스택을 쓴다.
	//	[조건1] 스택구조
	//	[조건2] 입력받은 순서대로 스택에 저장
	//	[조건3] 역순으로 출력
	// 	입력 : ABC
	//	출력 : CBA
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 입력받은 문자열을 byte로 바꿔서 저장할 스택
		Stack<Byte> beforebytes = new Stack<>();
		
		System.out.print("문자를 입력하세요: ");
		String temp = scanner.next();
		
		// 입력받은 문장을 byte 변환
		byte[] bytearr = temp.getBytes();
		
		// 스택에서 팝해서 저장할 byte(원본문장의 byte 길이만큼 생성)
		byte[] afterbytes = new byte[bytearr.length];
		
		// 원래 문자열의 byte를 하나씩 스택에 저장
		for(int i=0; i<bytearr.length; i++) {
			beforebytes.push(bytearr[i]);
		}
		
		// 스택에서 byte를 하나씩 팝해서 거꾸로 출력할 byte에 저장
		for(int i=0; i<bytearr.length;i++) {
			afterbytes[i]=(beforebytes.pop());
		}
		
		// 거꾸로 출력할 byte를 String으로 변환
		String string = new String(afterbytes);
		System.out.println("거꾸로 출력: "+string);
	}
	
}
