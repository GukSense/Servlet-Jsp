package practice.test2;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		/*
		���� 1.
		2000�� 12�� 1�� 
		2020�� 5�� 6�� 
		�� ��¥ ���� ���̸� ����Ͽ� n�� n�ϰ� ���� �������� ����ϼ���. 
		*/
		
		Calendar t1 = Calendar.getInstance();
		Calendar t2 = Calendar.getInstance();
		
		t1.set(2000, 11, 1);
		t2.set(2020, 5, 6);
		
		long diffMill = t2.getTimeInMillis() - t1.getTimeInMillis();
		long diffDay = diffMill / (24 * 60 * 60 * 1000);
		System.out.print(diffDay / 365 + "�� ");
		System.out.println(diffDay % 365 + "��");
		

	}

}
