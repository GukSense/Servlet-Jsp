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
			System.out.print("엘컴퓨터 Notice 프로그램입니다. 메뉴를 선택하여주세요 => " );
			System.out.println("0: 공지작성&공지등록 1: 공지목록 보기 2: 공지삭제 3: 프로그램 종료 ");
		
			Menu menu = Menu.values()[scanner.nextInt()];
			
			switch(menu) {
				case WRITING_REGiSTRATION:
					System.out.println("공지를 작성해주세요: ");
					scanner.nextLine();
					String input = scanner.nextLine();
					n.setIntro(input);
					System.out.println("[공지등록]");
					NoticeService.addNotice(n);
					
					break;
				case LIST:
					System.out.println("모든공지리스트");
					NoticeService.pirntAllList();
					break;
				case REMOVE:
					NoticeService.removeNotice();
					System.out.println("[제일오래된 공지삭제]");
					break;
				case LOGOUT:
					run = false;
					break;
			}
			if(!run)
				break;
		}
		System.out.println("프로그램이 종료됩니다.");
		
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
		DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY년-MM월-dd일");
		
		return l.format(df);
	}
	
	public String toString() {
		return "날짜: " + getDate() + "  공지: " + intro;
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
문제 1.
공지사항 등록, 목록, 삭제 기능을 코딩하세요.
삭제 시 제일 오래된 공지사항을 삭제하세요.
공지사항의 등록, 목록, 삭제 상수는 enum을 사용하세요.
*/