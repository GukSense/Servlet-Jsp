package practice.test2;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		/*
		문제 1.
		2000년 12월 1일 
		2020년 5월 6일 
		두 날짜 간의 차이를 계산하여 n년 n일과 같은 패턴으로 출력하세요. 
		*/
		
		Calendar t1 = Calendar.getInstance();
		Calendar t2 = Calendar.getInstance();
		
		t1.set(2000, 11, 1);
		t2.set(2020, 5, 6);
		
		long diffMill = t2.getTimeInMillis() - t1.getTimeInMillis();
		long diffDay = diffMill / (24 * 60 * 60 * 1000);
		System.out.print(diffDay / 365 + "년 ");
		System.out.println(diffDay % 365 + "일");
		

	}

}
