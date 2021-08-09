package Day18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Day18_4 {
	// 문제 1: 
	// Queue 4개 list 1개
		// 1. 전철 밀어내기
		// 2. 역 : 종점 -> 용산 -> 서울 -> 구로
		// 3. 종점역 : 전철 3개의 객체
		// 4. 출발 신호를 받아서 해당역에서 출발해서 다음역에 도착
		// 5. 역당 소요시간 2초
	
		// 메뉴[무한루프]
			// 전철 출발 신호 1.종점 2.용산 3.서울 4.구로
	
	// main 밖에 선언하는 이유 : 모든 메소드에서 호출하기 위해서
	public static Scanner scanner = new Scanner(System.in);
	public static Queue<Subway> end = new LinkedList<>();
	public static Queue<Subway> Yongsan = new LinkedList<>();
	public static Queue<Subway> Seoul = new LinkedList<>();
	public static Queue<Subway> Guro = new LinkedList<>();
	public static ArrayList<Queue<Subway>> stationList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		end.offer(new Subway("1호차"));
		end.offer(new Subway("2호차"));
		end.offer(new Subway("3호차"));
		
		stationList.add(end);
		stationList.add(Yongsan);
		stationList.add(Seoul);
		stationList.add(Guro);

		while(true) {
			stationState();
			System.out.print("전철출발신호[0.종점 1.용산 2.서울 3.구로]: ");
			int ch =  scanner.nextInt();
			if(ch==0) {
				startSign(ch);
			}
			if(ch==1) {
				startSign(ch);
			}
			if(ch==2) {
				startSign(ch);
			}
			if(ch==3) {
				startSign(ch);
			}
			
		}
	}  // main끝
	
	// 전철 출발 신호 [ 메소드화: 역번호에 따른 전철 출발 코드]
	public static void startSign(int station) {
	// main에서 써야하기에 무조건 static을 넣어야 한다!!!!
		//1. 해당역에 전철이 없는 경우
		if(stationList.get(station).isEmpty()) {
			System.out.println("[[현재 대기중인 전철이 없습니다]]");
			return;
		}
		
		//2. 해당역에서 전철 빼기
		Subway temp = stationList.get(station).poll();
		System.out.println("[[출발 : "+temp.name+"]]");
		System.out.println("[[소요시간 : 2초]]");
		
		// 2초간 쓰레드 멈추기
		try {
			Thread.sleep(2000); //무조건예외발생
		} catch (Exception e) {
		}
		
		// 3. 전 역에서 뺀 전철을 다음역에 넣기
			// 4. 만약에 다음역이 없으면 종점으로 오기
		if(station+1>=stationList.size()) {
			stationList.get(0).offer(temp);
		}
		else {
		stationList.get(station+1).offer(temp);
		}
		System.out.println("[[도착 : "+temp.name+"]]");
	}
	// 전철 현황 메소드
	public static void stationState() {
		System.out.println("현재 종점역의 전철현황: "+stationList.get(0));
		System.out.println("현재 용산역의 전철현황: "+stationList.get(1));
		System.out.println("현재 서울역의 전철현황: "+stationList.get(2));
		System.out.println("현재 구로역의 전철현황: "+stationList.get(3));
	}
}