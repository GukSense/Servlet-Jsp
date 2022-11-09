package practice.ch16;

import java.util.Calendar;

public class Calendar01 {

	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = now.get(Calendar.MONTH) + 1;
		System.out.println(month);
		
		int day = now.get(Calendar.DATE);
		System.out.println(day);
		
		int hour12 = now.get(Calendar.HOUR);
		System.out.println(hour12);
		
		int hour24 = now.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour24);
		
		int minute = now.get(Calendar.MINUTE);
		System.out.println(minute);
		
		int second = now.get(Calendar.SECOND);
		System.out.println(second);
		
		int millisecond = now.get(Calendar.MILLISECOND);
		System.out.println(millisecond);
		
		int ampm = now.get(Calendar.AM_PM);
		
		String strAmpm = ampm == 0 ? "AM" : "PM";
		System.out.println(ampm + ", " + strAmpm);		// 0: am 1: pm
		
		String[] strDayOfWeek = {"", "��", "��", "ȭ", "��", "��", "��", "��"};
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);	// 1:��, 2:��, 3:ȭ, 4:��, 5:��, 6:��, 7:�� ������ ���ڷκ�ȯ�ؼ� ���
		System.out.println(dayOfWeek + ", " + strDayOfWeek[dayOfWeek]);
		
		String strDateTime = year + "-" + month + "-" + day + " " + hour12 + ":" + second + "." + millisecond + " "
						+ strAmpm + " " + strDayOfWeek[dayOfWeek] + "����";
		
		System.out.println(strDateTime);
		System.out.println();
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.set(2030, 9, 7, 0, 0, 0);
		System.out.println(start.getTime());
		System.out.println(end.getTime());
		
		long diffMilli = end.getTimeInMillis() - start.getTimeInMillis();		//�и�������
		System.out.println(diffMilli + "�и���");
		long diffSecond = diffMilli / 1000;	//��
		System.out.println(diffSecond + " ��");
		long diffMinute = diffMilli / (60 * 1000);	//��
		System.out.println(diffMinute + " ��");
		long diffHour = diffMilli / (60 * 60 * 1000);	// �ð�
		System.out.println(diffHour + " �ð�");	
		long diffDay = diffMilli / (24 * 60 * 60 * 1000);
		System.out.println(diffDay + " ��");
		long diffYear = diffMilli / (365 * 24 * 60 * 60 * 1000);
		System.out.println(diffYear + " ��");
		System.out.println();
		
		System.out.print(diffDay / 365  + "�� ");
		System.out.println(diffDay % 365 + "�� ����");
		System.out.println();
	
		Calendar today = Calendar.getInstance();
		System.out.println(today.getTime().toString());
		
		today.add(Calendar.DATE, 1);
		System.out.println(today.getTime().toString());
		
		today.add(Calendar.DATE, -1);
		System.out.println(today.getTime().toString());
		
		today.set(Calendar.DATE, 22);
		System.out.println(today.getTime().toString());
	
	}

}


