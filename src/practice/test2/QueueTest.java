package practice.test2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		NoticeService ns = new NoticeService();
		
//		n.setIntro(scanner.nextLine());
//		System.out.println(n.getIntro());
		while(true) {
			boolean run = true;
			Notice n = new Notice();
			System.out.print("����ǻ�� Notice ���α׷��Դϴ�. �޴��� �����Ͽ��ּ��� => " );
			System.out.println("0: �����ۼ�&������� 1: ������� ���� 2: �������� 3: ���α׷� ���� ");
		
			Menu menu = Menu.values()[scanner.nextInt()];
			
			switch(menu) {
				case WRITING_REGiSTRATION:
					System.out.println("������ �ۼ����ּ���: ");
					scanner.nextLine();
					String input = scanner.nextLine();
					n.setIntro(input);
					System.out.println("[�������]");
					NoticeService.addNotice(n);
					
					break;
				case LIST:
					System.out.println("����������Ʈ");
					NoticeService.pirntAllList();
					break;
				case REMOVE:
					NoticeService.removeNotice();
					System.out.println("[���Ͽ����� ��������]");
					break;
				case LOGOUT:
					run = false;
					break;
			}
			if(!run)
				break;
		}
		System.out.println("���α׷��� ����˴ϴ�.");
		
	}

}

class Notice {
	private String intro;

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String getDate() {
		LocalDate l = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY��-MM��-dd��");
		
		return l.format(df);
	}
	
	public String toString() {
		return "��¥: " + getDate() + "  ����: " + intro;
	}
	

}

class NoticeService {
	public static Queue<Notice> q;
	
	public NoticeService() {
		q = new LinkedList<>();
	}
	public static void addNotice(Notice n) {		
		q.offer(n);
	}
	
	public static void pirntAllList() {
		for(Notice n : q) {
			System.out.println(n);			
		}
	}
	
	public static void removeNotice() {
		q.poll();
	}
}

enum Menu {
	WRITING_REGiSTRATION, LIST, REMOVE, LOGOUT;	
}

/*
���� 1.
�������� ���, ���, ���� ����� �ڵ��ϼ���.
���� �� ���� ������ ���������� �����ϼ���.
���������� ���, ���, ���� ����� enum�� ����ϼ���.
*/