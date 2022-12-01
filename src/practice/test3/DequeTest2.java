package practice.test3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeTest2 {

	public static void main(String[] args) {
		/*
		문제 1.
		반복문을 이용해 사용자가 입력한 메세지들을 저장하세요. 
		마지막으로 입력한 메세지 세개만 화면에 출력되도록 코딩하세요.
		quit가 입력되면 반복문은 종료되어야 합니다.
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
		
		System.out.println("프로그램 종료");

	}

}
