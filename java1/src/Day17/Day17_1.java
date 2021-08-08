package Day17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Day17_1 {
	
	// 하드웨어
		// 1. 주기억장치 : [RAM] : 현재 실행중인 명령어 [휘발성] 
		// 2. 보조기억장치 : [C드라이브,USB,CD,DVD 등등] 파일처리, DB처리 등
	// 메모리[주기억장치] 관리 방법
		// 1. 변수 : [기본 자료형]메모리 할당
		// 2. 객체 : [클래스] 메모리 할당(클래스의 모든 내용+조금 더 들어간다(컴퓨터마다 다르다))
		// 3. 배열 : 변수/객체의 동일한 자료형의 여러 개 메모리 할당
			// 메모리 효율성 저하(처음에 메모리를 할당한다.)
			// 고정적
			// 검색은 빠르나, 삭제나 추가가 어렵다
		// 4. 리스트 : 추가/삭제는 빠르나, 검색이 느리다
			// 요소를 추가할 때마다 메모리 할당
			// 가변적
	
	
	// 컬렉션 프레임워크 : 메모리 관리 클래스들
		// 컬렉션 : 수집
		// [미리 만들어진 명령어들] 프레임워크[소프트웨어] VS 라이브러리[함수집합] VS API[인터페이스]
		// 프레임워크 안에 라이브러리 속해 있다.
		
	
	public static void main(String[] args) {
		
		// 리스트 : List 컬렉션
			// 종류 : 1.ArrayList(배열구조) 2.Vector, LinkedList
				// 메소드
					// 1. .add(객체명) : 객체 추가
						// add(인덱스번호, 객체명) : 해당 위치에 객체 추가 그 위치에 있는 것부터 뒤의 것들은 하나씩 뒤로 밀림
					// 2. .get(인덱스번호) : 해당 번호의 객체 호출
						// 인덱스 : 리스트에 저장되는 순서번호 [0 ~ ]
					// 3. .remove(인덱스번호) : 해당 번호의 객체 삭제
					// 4. .size() : 리스트내 객체수
					// 5. .contains(객체) : 리스트내 해당 객체 유무 확인
					// 6. .indexOf(객체) : 리스트내 해당 객체 위치
					// 7. .clear() : 리스트내 모든 요소 삭제
					// 8. .isEmpty() : 리스트가 비어있는지 확인 -> true/false
		
		// 1. ArrayList 클래스
		// String 객체 여러개를 담을 수 있는 리스트 객체 선언 
		ArrayList<String> arrayList = new ArrayList<>();
				//제네릭 리스트에 담을 자료형
		arrayList.add("java");
		arrayList.add("python");
		arrayList.add("database");
		arrayList.add("c언어");
		arrayList.add("c++언어");
		arrayList.add("java"); // 중복허용, 인덱스로 식별가능
		
		//출력
		System.out.println("arraylist : "+arrayList);
		
		//호출
		System.out.println("arraylist의 첫번째 요소 : "+arrayList.get(0));
		
		// 삭제
		System.out.println("arraylist의 두번째 요소 삭제");
		arrayList.remove(1);
		System.out.println("arraylist 삭제후 : "+arrayList);
		
		//리스트내 객체수
		System.out.println("arraylist 객체수 : "+arrayList.size());
		
		// 리스트와 반복문
		for(int i = 0; i<arrayList.size();i++) {
			System.err.println(arrayList.get(i));
		}
		// 리스트와 반복문
		
		for(String string : arrayList) {
			// 리스트내 모든 요소들을 하나씩 임시객체 대입(string)
			System.out.println(string);
		}
		
		// 특정 위치에 추가
		arrayList.add(1, "js");
		System.out.println("특정 위치에 추가 : " +arrayList);
		
		// 객체 검색
		System.out.println("arraylist java객체가 있는지 : "+arrayList.contains("java"));
		System.out.println("arraylist java객체의 위치"+ arrayList.indexOf("java"));
		
		// 리스트내 모든 요소 삭제
		arrayList.clear();
		System.out.println("arraylist : "+arrayList);
		
		// 2. Vector 클래스
			// ArrayList 메소드 사용법은 동일(super 클래스가 동일하기 때문에)
			// 차이점 : Vector메소드(동기화지원, Day15_4참고) vs ArrayList메소드(동기화지원X)
				// 메소드들의 synchronized 차이
				// 멀티쓰레드일 경우에는 Vector, 단일쓰레드일 경우에는 ArrayList를 쓰는 것이 좋다
		Vector<String> vector = new Vector<>();
		vector.add("java");//자동완성을 해서 메소드를 보면 시계아이콘이 우측아래에 있다
		
		// 3. LinkedList 클래스
			// 차이점 
				// ArrayList: 검색용이
				// LinkedList: 삽입, 삭제가 용이
		
		ArrayList<String> arrayList2 = new ArrayList<>();
		LinkedList<String> linkedList = new LinkedList<>();
		
		Long start;
		Long end;
		
		start = System.nanoTime();// 현재 시간[나노] 메소드
		for(int i = 0; i<10000; i++) {
			arrayList2.add(0, String.valueOf(i));	
		}
		end = System.nanoTime();
		
		System.out.println("arraylist 10000개 저장하는데 걸리는 시간: "+(end-start));
		
		start = System.nanoTime();
		for(int i =0;i<10000;i++) {
			linkedList.add(0, String.valueOf(i));
		}
		end = System.nanoTime();
		
		System.out.println("linkedlist 10000개 삽입하는데 걸리는 시간: "+(end-start));
		
		
		// 문제1 : 대기줄 프로그램[LinkedList 클래스]
		// 메뉴 [무한루프]
			// 현재 대기명단 출력
				// ~~~~
				// ~~~~
				// 1.대기 추가[인원수를 입력받아 => 대기번호 부여]
				// 2.대기 취소[대기번호를 입력받아 => 삭제]
				// 3.대기 입장[가장 앞번호를 입장]
		
		LinkedList<Integer> peopleList = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== 현재대기명단 ==== ");
			System.out.println("대기번호 \t인원수  현재 대기 소요시간 : "+peopleList.size()*5+"분");
			for(int i = 0; i<peopleList.size(); i++) {
				System.out.println((i+1)+"\t"+peopleList.get(i));
			}
			System.out.print("1.대기추가 2.대기취소 3.대기입장");
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.print("인원수 : ");
				int count= scanner.nextInt();
				peopleList.add(count);
				System.out.println("대기번호: "+peopleList.size());
			}
			if(ch==2) {
				System.out.print("취소할 대기번호: "); int delete = scanner.nextInt();
				peopleList.remove(delete-1); //번호-1 = 인덱스
				System.out.println("취소되었습니다");
			}
			if(ch==3) {
				if(peopleList.isEmpty())
					System.out.println("대기명단이 없습니다.");
				else {
				System.out.print("1번 입장~~");
				peopleList.remove(0);
				}
			}
		}
	}
	

}
