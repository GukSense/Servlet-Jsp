package practice;

import java.util.Scanner;

public class Finally {

	public static void main(String[] args) {
		
		boolean run = true;
		
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		
		try {
			System.out.print("���ڿ��� �߻����� ���ܸ� �߻���Ű����.");
			num = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("���ڸ� �Է��ϼ���.");
		} finally {
			System.out.println(num);
			System.out.println("������ �߻� ���ο� ������� ����˴ϴ�.");
		}
	}

}

/*
���� 1.
������ ���ο� ������� num�� ���� ��µǵ��� �ڵ��ϼ���.
*/
