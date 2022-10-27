package practice;

import java.util.Scanner;

public class TryCatch {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("문자열을 입력하여 예외를 발생시키세요: ");
			int num = scanner.nextInt();
			System.out.println(num);
		}	catch(Exception e) {
			System.out.println("숫자만 입력가능합니다.");
			
			//e.printStackTrace();
		}
		
		System.out.println("프로그램이 종료됩니다.");

	}

}
