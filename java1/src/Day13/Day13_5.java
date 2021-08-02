package Day13;

import java.util.Calendar;
import java.util.Scanner;

public class Day13_5 {
	
	// 콘솔에 달력 출력하기
	
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		// 과제1 :
			// 입력받은 연도와 월의 해당하는 달력 표시
		// 과제2 :
			// 입력받은 시작연도/월 입력 ~ 끝연도/월 : 범위 달력 출력.
		System.out.print("출력할 달력의 년도 4자리를 입력하세요: ");
		int year = scanner.nextInt();
		System.out.print("출력할 달력의 달를 입력하세요: ");
		int month = scanner.nextInt();
		calendar(year, month);
		System.out.println();
		
		while(true) {
			System.out.print("출력할 달력의 시작년도 4자리를 입력하세요: ");
			int syear = scanner.nextInt();
			System.out.print("출력할 달력의 시작달를 입력하세요: ");
			int smonth = scanner.nextInt();
			System.out.print("출력할 달력의 끝년도 4자리를 입력하세요: ");
			int eyear = scanner.nextInt();
			System.out.print("출력할 달력의 끝달를 입력하세요: ");
			int emonth = scanner.nextInt();
			
			//시작년도가 끝년도보다 나중일 경우
			if(syear>eyear) {
				System.out.println("잘못된 입력입니다(시작년도가 끝년도보다 나중입니다)");
				continue;
			}
			//시작년도가 끝년도가 같을 경우
			else if(syear == eyear) {
				if(smonth>emonth) {
					System.out.println("잘못된 입력입니다.(시작달이 끝달보다 나중입니다)");
					continue;
				}
				else{
					for(int o = smonth; o<=emonth; o++) {
						calendar(syear, o);
						System.out.println();
					}
				}	
			}
			//시작년도가 끝년도보다 빠른경우 
			else {
				for(int i = smonth; i<13; i++) {
					calendar(syear,i);
					System.out.println();
				}
				for(int j = syear+1; j<eyear; j++) {
					for(int l = 1; l<13; l++) {
						calendar(j,l);
						System.out.println();
					}
				}
				for(int m = 1; m<=emonth; m++) {
					calendar(eyear, m);
					System.out.println();
				}
			}
		}
	}
	
	public static void calendar() {
		// 1. 캘린더 객체 선언
		Calendar calendar = Calendar.getInstance();
		
		// 2. 캘린더에서 연도, 월, 일 가져오기
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH)+1; //0:1월
		int today = calendar.get(calendar.DAY_OF_MONTH);
		
		// ** : 해당 월 1일 요일 찾기
		calendar.set(year,  month-1, 1); // calendar.set(연, 월, 일) 날짜 사용자 설정
		int sday = calendar.get(calendar.DAY_OF_WEEK);// 시작요일
		int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당월의 마지막 날
		
		
		
		// 3. 달력 출력
		System.out.println("===================="+year+"년"+month+"월=====================");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		// 4. 현재 월의 1일의 위치 앞에 공백으로 채우기
		for(int i = 1; i<sday; i++) {
			System.out.print("\t");
		}
		
		int ssday = sday; //요일의 시작변수 [토요일마다 줄바꿈]
		// 5. 각 요일에 날짜 표시
		for(int i = 1; i<=eday; i++) {
			System.out.print(i+"\t");
			// 6. 토요일 뒤로 줄바꿈 처리[7의 배수마다]
			if(ssday%7==0) {
				System.out.println();
			}
			ssday++;
		}
	}
	
	public static void calendar(int year, int month) {
		// 1. 캘린더 객체 선언
		Calendar calendar = Calendar.getInstance();
		
		// ** : 해당 월 1일 요일 찾기
		calendar.set(year,  month-1, 1); // calendar.set(연, 월, 일) 날짜 사용자 설정
		int sday = calendar.get(calendar.DAY_OF_WEEK);// 시작요일
		int eday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당월의 마지막 날
		
		
		
		// 3. 달력 출력
		System.out.println("===================="+year+"년"+month+"월=====================");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		// 4. 현재 월의 1일의 위치 앞에 공백으로 채우기
		for(int i = 1; i<sday; i++) {
			System.out.print("\t");
		}
		
		int ssday = sday; //요일의 시작변수 [토요일마다 줄바꿈]
		// 5. 각 요일에 날짜 표시
		for(int i = 1; i<=eday; i++) {
			System.out.print(i+"\t");
			// 6. 토요일 뒤로 줄바꿈 처리[7의 배수마다]
			if(ssday%7==0) {
				System.out.println();
			}
			ssday++;
		}
	}
}
