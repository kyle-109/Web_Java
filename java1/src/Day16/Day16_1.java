package Day16;

public class Day16_1 {
	
	public static void main(String[] args) {
		
		// 제네릭 : 하나의 값이 여러 다른 데이터 타입들을 가질 수 있는 기술
			// 자료형/클래스 => 매개값
			// 목적: 하나의 객체가 여러 개의 자료형으로 변경되는 경우
				// Integer 객체 -> String 객체 -> Char 객체
			// 자료형이 계속 바뀌어야 할 때 사용한다
			// 미리 만들어진 API가 제네릭을 쓰는 경우가 많다.
			// 내부 클래스로 외부에서 매개타입[자료형] 받기
		// 1. 제네릭 없는 경우
			// Object로 받아서
			// 매번 강제형변환을 해줘야 한다.
		Box box1 = new Box();
		box1.setobject("사과"); //String
			// Object 클래스 = String 클래스
			// 상위클래스는 하위 클래스를 담을 수 있다
			// Object가 자바에서 최상위 클래스이므로
		String name1 = (String)box1.getobject();
			// String 클래스 = Object 클래스
			// 하위 클래스는 상위 클래스를 담을 수 없다.
				// (String)Object 강제형변환
		System.out.println(name1);
		
		box1.setobject(new Apple());
			// Object 클래스 = 정의된 클래스
		Apple apple = (Apple)box1.getobject();
			// Apple 클래스 = Object 클래스[X]
				// (Apple)Object 강제형변환
		
		// 2. 제네릭 있는 경우
			// Object가 아닌 매개값으로 타입을 받는다
			// 매개값으로 자료형을 받아서
			// 알아서 형변환을 해준다.
		Box2<String> box2 = new Box2<>();
		box2.set제너릭객체("사과");
		String name2 = box2.get제너릭객체();
		System.out.println(name2);
		
		Box2<Integer> box3 = new Box2<>();
		box3.set제너릭객체(30);
		int count = box3.get제너릭객체();
		System.out.println(count);
		
		Box2<Apple> box4 = new Box2<>();
		box4.set제너릭객체(new Apple());
		Apple apple2 = box4.get제너릭객체();
		System.out.println(apple2);
		
		// 3. 멀티 제네릭
			// 매개 클래스(개발하는 사람이 입력하는 클래스에 따라서 객체가 만들어지거나 사용한다)
			// Product라는 객체안에 new Television객체랑 "스마트텔레비전"객체를 넣는다. 
		Product<Television, String> product1 = new Product<>();
		product1.setKind(new Television());
		product1.setModel("스마트텔레비전");
		System.out.println("제품1: "+product1.getKind() + product1.getModel());
		
		Product<Car,String> product2 = new Product<Car, String>();
												  // 뒷부분 생략가능, <>안 생략가능
		product2.setKind(new Car());
		product2.setModel("디젤자동차");
		System.out.println("제품2: "+product2.getKind()+product2.getModel());
		
		
	}
}
