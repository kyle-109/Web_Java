package Day06;

public class Day06_1 {
	
	//제어문 : if[논리제어], switch[값제어]
	//반복문 : for, while, do~while
		// break, continue
	
	public static void main(String[] args) {
		
		
		// switch
			// 형태 : switch(key: 검사대상){case 검사 : 실행문}
			// 1. (key) 에 해당하는 case 찾은 후에 아래 case를 모두 실행
			// 2. break; : switch 혹은 반복문 탈출.
			// 3. 경우의 수가 정해져 있는 경우 switch가 더 빠르다.
			//    경우의 수를 알 수 없는 경우 if
		int score = 80;
		switch(score) {
		case 90: System.out.println("90점입니다."); break;
		case 80: System.out.println("80점입니다."); break;
		case 70: System.out.println("70점입니다."); break;
		default: System.out.println("탈락입니다."); break;
		}
		////////////////////////////////////////////////////
		if(score ==90) System.out.println("90점입니다");
		else if(score==80) System.out.println("80점입니다");
		else if(score==70) System.out.println("70점입니다");
		else System.out.println("탈락입니다");
		
		
		// 예2)
		int button = 3;
		switch(button) {
			case 1:System.out.println("1선택"); break;
			case 2:System.out.println("2선택"); break;
			case 3:System.out.println("3선택"); break;
			default :
		}
		
		// 예3) 세 점수의 평균이 90점이상이면 "A" 80점이상이면 "B" 나머지 탈락
		int korean = 80, english = 80, math = 90;
		int average = (korean + english + math)/3;
		switch(average/10) {
			case 9: System.out.println("A등급"); break;
			case 8: System.out.println("B등급"); break;
			default : System.out.println("탈락"); break;
		}
		
		// for : 조건에 따른 반복실행
//			for(초기값; 조건문; 증감식){실행문}
		for(int i = 0; i<10; i++) {
			if(i==3) continue; //가장 가까운 반복문으로 이동
			if(i==6) break;//가장 가까운 반복문을 탈출
			System.out.print(i+" ");
		}
			
		System.out.println();
//		// while : 조건에 따른 반복실행 = 무한루프
//			초기값
//			while (조건문) {
//				증감식
//			}
		int i = 0;
		while(i<10) {
			i++;
			if(i==3) continue;
			if(i==6) break; // 가장 가까운 반복문 탈출
			System.out.print(i+" ");
			i++;
		}
	}
	
}
