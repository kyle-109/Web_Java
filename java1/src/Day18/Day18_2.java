package Day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day18_2 {
	
	public static void main(String[] args) {
		
		// 컬렉션 중첩
		// 예1) List 컬렉션 => map
		
		ArrayList<HashMap<String, Integer>> arrayList = new ArrayList<>();
				// 제네릭은 컬렉션 가능
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<String, Integer> map2 = new HashMap<>();
			// 2개의 맵을 리스트에 답기;
			arrayList.add(map); map.put("유재석", 80);
			arrayList.add(map2); map2.put("유재석", 100);
			// 2개의 맵은 메모리가 각각 다르기에 키값이 같아도 문제가 안된다.
		System.out.println("arraylist 2개의 map : "+arrayList);
		
		// 예2 ) map => list 컬렉션[*] : 다수의 리스트 관리용    순서가 존재
		HashMap<String, ArrayList<String>> map3 = new HashMap<>();
		
			ArrayList<String> list = new ArrayList<>();
			
		map3.put("1", list);
		System.out.println(map3);
		
		//  예3) set 컬렉션 => map.    순서가 없는 대신 중복값을 막아준다.
		HashSet<HashMap<String, Integer>> set = new HashSet<>();
		
			HashMap<String, Integer> map4 = new HashMap<>();
		
		set.add(map4);
		
		System.out.println(set);
		
		
		// 문제 1 : 제품재고[제품명, 재고]관리
			// [조건1] 분류: 의류, 가방 => 2개의 map
			// [조건2] map key:제품명 value:재고
			// [조건3] 2개의 map을 관리하는 재고 리스트 생성
		
		// 0. 구성
		HashMap<String, Integer> clothingmap = new HashMap<>();
			clothingmap.put("나이키상의", 20);
			clothingmap.put("나이키하의", 10);
		HashMap<String, Integer> bagmap = new HashMap<>();
			bagmap.put("나이키가방", 5);
			bagmap.put("아디다스가방", 10);
			
		ArrayList<HashMap<String, Integer>> productList = new ArrayList<>();
		productList.add(clothingmap);
		productList.add(bagmap);
			
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("리스트목록: 1.의류 2.가방");
			
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("전체목록: "+productList.get(ch-1));
				System.out.println("전체제품명: "+productList.get(ch-1).keySet());
				System.out.println("나이키상의 재고: "+productList.get(ch-1).get("나이키상의"));
				System.out.println("나이키하의 재고: "+productList.get(ch-1).get("나이키하의"));
			}
			
			if(ch==2) {
				System.out.println(productList.get(ch-1));
			}
		}
		
	}
}
