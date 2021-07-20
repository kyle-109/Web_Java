package Day04;

import java.util.Scanner;

public class exercise {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 플레이어의 선택 : "); String choice1 = scanner.next();
		System.out.print("두번째 플레이어의 선택 : "); String choice2 = scanner.next();
		if(choice1.equals(choice2)) {
			System.out.println("무승부입니다!");
		}
		else if(choice1.equals("가위") && choice2.equals("바위")) {
			System.out.println("두번째 플레이어가 이겼습니다.");
		}
		else if(choice1.equals("가위") && choice2.equals("보")) {
			System.out.println("첫번째 플레이어가 이겼습니다.");
		}
		else if(choice1.equals("바위") && choice2.equals("가위")) {
			System.out.println("첫번째 플레이어가 이겼습니다.");
		}
		else if(choice1.equals("바위") && choice2.equals("보")) {
			System.out.println("두번째 플레이어가 이겼습니다.");
		}
		else if(choice1.equals("보") && choice2.equals("가위")) {
			System.out.println("두번째 플레이어가 이겼습니다.");
		}
		else{
			System.out.println("첫번째 플레이어가 이겼습니다.");
		}
	}
}
