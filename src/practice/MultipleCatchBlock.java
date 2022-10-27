package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchBlock {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = {3, 5, 7};
		
		try {
			System.out.print(" 0~2 ���ڸ� �Է��ϼ���:");
			int i = scanner.nextInt();
			
			System.out.print("0�̿��� ���ڸ� �Է��ϼ���: ");
			int num = scanner.nextInt();
			
			System.out.println(arr[i] / num);
		} catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է°����մϴ�.");
		} catch(ArithmeticException e) {
				System.out.println("������ܰ� �߻��Ǿ����ϴ�.");
		} catch(Exception e) {
				System.out.println("���ܹ߻�!!!!!");
				e.printStackTrace();
		}
		
		System.out.println("���α׷��� ����˴ϴ�.");

	}

}

/*
���� 1.
i�� 0~2 �̿��� ���ڸ� �Է��Ͽ� ���ܸ� �߻� ��Ű����.
���� 2.
���ڿ��� �Է��Ͽ� ���ܸ� �߻� ��Ű����.
���� 3.
num�� 0�� �Է��Ͽ� ���ܸ� �߻� ��Ű����.
���� 4.
���ܰ� �߻����� �ʵ��� ���� �Է��� �� �����ϼ���.
*/
