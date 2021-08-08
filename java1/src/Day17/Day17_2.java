package Day17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Day17_2 {
	
	//set 컬렉션 : 저장순서가 없음[중복불가]
		// List는 저장순서가 존재[중복허용/인덱스로 식별가능]
	public static void main(String[] args) {
		
		// set 컬렉션
			// 종류: 1.HashSet 2.TreeSet
				// 메소드 
					// 1. .add(객체)
					// 2. .remove(객체)
					// 3. .size()
					// 4. .iterator()
						// Iterator 인터페이스
							// .hasNext() 다음 요소가 있는지 true/false
							// .next() 다음 요소 호출
		// HashSet 클래스
		
		HashSet<String> hashSet = new HashSet();
			// 추가
			hashSet.add("java");
			hashSet.add("python");
			hashSet.add("database");
			hashSet.add("c언어");
			hashSet.add("c++언어");
			hashSet.add("java"); // 중복 불가 // 저장 순서X
			
			// 출력
			System.out.println("hashset : "+hashSet);
			System.out.println("hashset 객체수 : "+hashSet.size());
			System.out.println("hashset 삭제");
			hashSet.remove("java");//인덱스가 없기에 객체를 넣어줘야 한다.
			System.out.println("hashset : "+hashSet);
			//get이 없다
			//System.out.println("hashset 첫번째 요소 : "+ hashSet.get);
			
			//호출
			//반복문 vs 순회
			for(String string: hashSet) {
				System.out.println(string); // 출력순서 보장X
			}
			
			Iterator<String> iterator = hashSet.iterator();
			
			while(iterator.hasNext()) {
				System.out.println("객체 : "+iterator.next());
				System.out.println(iterator.hasNext());
			}
		
			
		// 문제 2 : HashSet 클래스
			// 조건 1: 6개의 숫자 입력받기[중복없이]
			// 조건 2: 입력받은 6개 숫자 출력
			
			HashSet<Integer> hashSet2 = new HashSet();
			Scanner scanner = new Scanner(System.in);
			
			for(int i =0; i<6; i++) {
				
				System.out.print("숫자를 입력하세요: ");
				int num = scanner.nextInt();
				if(hashSet2.contains(num)) {
					i--;
				}
					hashSet2.add(num);
			}
			System.out.println("출력: "+hashSet2);
			
			// 해시: 데이터 저장하고 조회 사용되는 알고리즘
				// int 정수 = 3
				// 3[값] => 해시코드 변환
				// 해시코드값이 메모리 주소값 => 데이터 저장
					// 값이 즉 메모리주소 : 중복값X 저장순서X
				
			
			
		
	}
}
