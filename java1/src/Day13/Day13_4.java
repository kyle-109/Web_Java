package Day13;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Day13_4 {
	
	public static void main(String[] args) {
		
		// 날짜, 시간 관련된 클래스
		
		// 1. Date 클래스
		Date date = new Date(); // 시스템 오늘 날짜/시간 객체
		System.out.println("오늘 날짜/시간 : "+date);
		
		// 2. SimpleDateFormat 클래스 : 날짜 형식 변환
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy년 MM월 dd일 HH시 mm분 ss초");
		System.out.println("형식변환: "+simpleDateFormat.format(date));
		
		// 3. Calendar 클래스
		Calendar calendar = Calendar.getInstance(); // 클래스에 미리 만들어진 객체 가져오기
		System.out.println("캘린더 : "+calendar);
		
		int year = calendar.get(Calendar.YEAR);
		System.out.println("연도 : "+year);
		System.out.println("월 : "+(calendar.get(calendar.MONTH)+1)); // 0: 1월 ~~
		System.out.println("일 : "+calendar.get(calendar.DAY_OF_MONTH));// 날짜
		System.out.println("일 : "+calendar.get(calendar.DAY_OF_WEEK));// 1: 일요일 ~~
		if(calendar.get(calendar.DAY_OF_WEEK) ==1) {
			System.out.println("일");
		}
		if(calendar.get(calendar.DAY_OF_WEEK) ==2) {
			System.out.println("월");
		}
		if(calendar.get(calendar.DAY_OF_WEEK) ==3) {
			System.out.println("화");
		}
		if(calendar.get(calendar.DAY_OF_WEEK) ==4) {
			System.out.println("수");
		}
		if(calendar.get(calendar.DAY_OF_WEEK) ==5) {
			System.out.println("목");
		}
		if(calendar.get(calendar.DAY_OF_WEEK) ==6) {
			System.out.println("금");
		}
		if(calendar.get(calendar.DAY_OF_WEEK) ==7) {
			System.out.println("토");
		}
		
		// 시간
		System.out.println("오전/오후 : "+calendar.get(calendar.AM_PM));
		if(calendar.get(calendar.AM_PM)==0) {
			System.out.println("오전");
		}
		if(calendar.get(calendar.AM_PM)==1) {
			System.out.println("오후");
		}
		
		System.out.println("시: "+calendar.get(calendar.HOUR));
		System.out.println("시: "+calendar.get(calendar.MINUTE));
		System.out.println("시: "+calendar.get(calendar.SECOND));
		
	}
}
