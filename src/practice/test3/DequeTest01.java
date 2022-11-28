package practice.test3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class DequeTest01 {

	public static void main(String[] args) {
		/* 
		문제 1.
		스마트폰의 알림기능은 마지막 알림부터 확인할 수 있습니다.
		알림 등록, 확인, 확인 시 제거 기능을 구현하세요.
		*/
		NotificationService ns = new NotificationService();
		
		NotificationService.addNotification(new Notification(1, "9:00 외출"));
		NotificationService.addNotification(new Notification(2, "Promise with Friends at10:00"));
		NotificationService.addNotification(new Notification(3, "11:00 StudyMySelf"));
		NotificationService.addNotification(new Notification(4, "12:00 LunchTime"));
		
		NotificationService.getAllNotification();
		System.out.println();
		NotificationService.getAllNotification();

	}

}

class Notification {
	private int no;
	private String contents;
	private static LocalTime time;
	private String nowTime;
	
	public Notification(int no, String contents) {
		this.no = no;
		this.contents = contents;
		time = LocalTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("H:mm:ss");
		this.nowTime = time.format(df);
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
	public String toString() {
		return "(" + no + ") " + nowTime + " " + contents; 
	}
	
}

class NotificationService {
	private static Deque<Notification> notificationStack;
	private static List<Notification> notificationList;
	
	public NotificationService() {
		notificationStack = new ArrayDeque<>();
		notificationList = new LinkedList<>();
	}
	
	public static void addNotification(Notification n) {
		notificationStack.push(n);
	}
	
	public static void getAllNotification() {
		boolean run = true;
		try {
			while(run) {
				System.out.println(notificationStack.pop());
			}			
		} catch(NoSuchElementException e) {
			run = false;
		}
	}
}