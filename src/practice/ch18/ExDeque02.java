package practice.ch18;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ExDeque02 {

	public static void main(String[] args) {
		QueueTicketDispenser2.takeNum();
		QueueTicketDispenser2.takeNum();
		QueueTicketDispenser2.takeNum();
		QueueTicketDispenser2.takeNum();
		QueueTicketDispenser2.takeNum();
		
		System.out.println("ù ��° �մ��� " + Restaurant2.firstGuest() + "�� �մ��Դϴ�.");
		System.out.println();
		
		Restaurant2.printQueue();
		
		while(Restaurant2.q.size() > 0) {
			Restaurant2.serving();
		}
		
		System.out.println();
		
		Restaurant2.printQueue();
		
		System.out.println("< deque�� ��������� �߰� �� ������ �����ϹǷ� ���ð� ť ��� ������ �����մϴ�. >");
		QueueTicketDispenser2.takeNum();
		QueueTicketDispenser2.takeNum();
		QueueTicketDispenser2.takeNum();
		Restaurant2.printQueue();
		
		Restaurant2.q.offerFirst(100);
		Restaurant2.printQueue();
		
		Restaurant2.q.offerLast(200);
		Restaurant2.printQueue();
		
		Restaurant2.q.pollFirst();
		Restaurant2.printQueue();
		
		Restaurant2.q.pollLast();
		Restaurant2.printQueue();

	}

}


class QueueTicketDispenser2 {
	private static int num = 1;
	
	public static int takeNum() {
		Restaurant2.q.offer(num);
		
		return num++;
	}
}

class Restaurant2 {
	public static Deque<Integer> q = new ArrayDeque<>();
	
	public static void serving() {
		int num = q.poll();
		
		System.out.println(num + "�� �մԿ��� �����Ǿ����ϴ�.");
	}
	
	public static void printQueue() {
		System.out.println("��⿭\n-----");
		for(Iterator<Integer> it = q.iterator(); it.hasNext();) {
			int num = it.next();
			
			System.out.println(num + "�� �մ�");
		}
		System.out.println();		
	}
	
	public static int firstGuest() {
		return q.peek();
	}
}