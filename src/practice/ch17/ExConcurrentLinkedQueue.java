package practice.ch17;

import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ExConcurrentLinkedQueue {

	public static void main(String[] args) {
		
		Thread printService = new Thread(new PrintService());
		printService.start();
		
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.print("����Ʈ �� ������ �Է��ϼ���: ");
			Printer.print(new Paper(s.nextLine()));
		}

	}

}

class Printer {
	public static void print(Paper p) {
		PrintService.q.offer(p);
	}
}

class PrintService implements Runnable  {
	// public static Queue<Paper> q = new LinkedList<>();	// ������� ���� ���� �߻�
	public static Queue<Paper> q = new ConcurrentLinkedQueue<>();
	
	@Override
	public void run() {
		while (true) {
			System.out.println("\n����Ʈ ��� ���Դϴ�...");
			try {
				for(Iterator<Paper> it = q.iterator(); it.hasNext();) {
					Paper p = it.next();
					
					System.out.println("\n����Ʈ ���Դϴ�...\n---");
					Thread.sleep(3000);
					System.out.println(p.getContents());
					q.remove();
					System.out.println("����Ʈ�� �Ϸ�Ǿ����ϴ�!!!");
				}
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Paper {
	private String contents;
	public Paper(String contents) {
		this.contents = contents;
	}
	public String getContents() {
		return contents;
	}
}