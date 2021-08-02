package Day13;

import java.util.Scanner;

public class Day13_3 {
	
	public static void main(String[] args) {
		
		// 도서 검색 프로그램
		// [도서명]
		// 1. 된다! 네이버 블로그&포스트
		// 2. 스프링 부트 실전 활용 마스터
		// 3. Tucker의 Go 언어 프로그래밍
		// 4. 혼자 공부하는 C 언어
		
		// 1. 검색을 입력받아 검색한 단어가 포함된 도서를 모두 출력하기
		// 2. 검색한 단어를 새로운 교체할 문자를 입력받아 교체하기
		
		String[] book = {"된다! 네이버 블로그&포스트","스프링 부트 실전 활용 마스터","Tucker의 Go 언어 프로그래밍","혼자 공부하는 C 언어"};
		
		System.out.print("검색하려는 단어를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
		String search = scanner.next();
			
		for(int i = 0; i<book.length; i++) {
			if(book[i].indexOf(search)!=-1) {
				System.out.println(search+"를 포함한 책은 \""+book[i]+"\"입니다");
			}
		}
		
		System.out.print("교체할 단어: ");
		String before = scanner.next();
		
		System.out.print("바뀐 단어: ");
		String after = scanner.next();
		
		for(int i = 0; i<book.length; i++) {
			if(book[i].indexOf(before)!=-1) {
				System.out.println("교체한 책 이름은 \""+book[i].replace(before, after)+"\"입니다");
			}
		}
		
	}
}
