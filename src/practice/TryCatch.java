package practice;

import java.util.Scanner;

public class TryCatch {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("���ڿ��� �Է��Ͽ� ���ܸ� �߻���Ű����: ");
			int num = scanner.nextInt();
			System.out.println(num);
		}	catch(Exception e) {
			System.out.println("���ڸ� �Է°����մϴ�.");
			
			//e.printStackTrace();
		}
		
		System.out.println("���α׷��� ����˴ϴ�.");

	}

}
