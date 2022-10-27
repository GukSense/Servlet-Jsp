package practice;

import java.util.Scanner;

public class Finally {

	public static void main(String[] args) {
		
		boolean run = true;
		
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		
		try {
			System.out.print("문자열을 발생시켜 예외를 발생시키세요.");
			num = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("숫자만 입력하세요.");
		} finally {
			System.out.println(num);
			System.out.println("예외의 발생 여부와 상관없이 실행됩니다.");
		}
	}

}

/*
문제 1.
예외의 여부와 상관없이 num의 값이 출력되도록 코딩하세요.
*/
