package practice.test3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeTest2 {

	public static void main(String[] args) {
		/*
		���� 1.
		�ݺ����� �̿��� ����ڰ� �Է��� �޼������� �����ϼ���. 
		���������� �Է��� �޼��� ������ ȭ�鿡 ��µǵ��� �ڵ��ϼ���.
		quit�� �ԷµǸ� �ݺ����� ����Ǿ�� �մϴ�.
		*/
		
		
		Scanner s = new Scanner(System.in);
		while(true) {
			boolean run = true;
			
			Deque<String> message = new ArrayDeque<>();
			
			message.offer(s.nextLine());
			message.offer(s.nextLine());
			message.offer(s.nextLine());
			message.offer(s.nextLine());
			message.offer(s.nextLine());
			
			
			for (String m : message) {
				System.out.println(m);
			}
			System.out.println();
			
			message.poll();
			message.poll();
			
			
			for (String m : message) {
				System.out.println(m);
			}
			System.out.println();
		
			if(s.nextLine().equals("quit"))
				run = false;
			if(!run)
				break;
		}
		
		System.out.println("���α׷� ����");

	}

}
