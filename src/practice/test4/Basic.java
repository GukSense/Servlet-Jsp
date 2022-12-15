package practice.test4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basic {
	
	public static void caculate(int index) {
		int[][] result = new int[index+1][index+1];
		
		for(int i=2; i<=index; i++) {
			for(int j=1; j<=index; j++) {
				
				result[i][j] = i * j;
				System.out.println(result[i][j]);
			}
			System.out.println();
		}
		
	} 
	
	
	public static void caculate2(int first, int second) {
		int[][] result = new int[first+1][second+1];
		
		for(int i=2; i<=first; i++) {
			for(int j=1; j<=second; j++) {
				
				result[i][j] = i * j;
				System.out.println(result[i][j]);
			}
			System.out.println();
		}
		
	} 
	
	public static List<Integer> format(String inputString) {
		
		String[] splitedValue = inputString.split(",");
		
		int one = Integer.parseInt(splitedValue[0]);
		int two = Integer.parseInt(splitedValue[1]);
		
		List<Integer> list = new ArrayList<>();
		list.add(one);
		list.add(two);
		
		return list;
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("최종 요구사항<1>");
//		Basic.caculate(scanner.nextInt());
		/*
		사용자가 입력한 값에 따라 크기가 다른 구구단을 계산해 출력한다.
		예를 들어 사용자가 "8,7"과 같은 문자열을 입력하면 팔칠단을 구현한다. 팔칠단은 
		2 * 1 ... 2 * 7, 3 * 1 ... 3 * 7, ... , 8 * 1 ... 8 * 7 까지 구현하는 것을 의미한다.
		*/
		System.out.println("최종 요구사항<2>");
//		Basic.caculate2(
//				Basic.format(scanner.nextLine()).get(0),
//				Basic.format(scanner.nextLine()).get(1));

//		Basic.format(scanner.nextLine()).get(0);
	/*	
		System.out.println("test-------------");
		String str = scanner.nextLine();
		String[] splitedValue = str.split(",");
		System.out.println(splitedValue[0]);
		System.out.println(splitedValue[1]);
		
		int first = Integer.parseInt(splitedValue[0]);
		System.out.println(first);
		int second = Integer.parseInt(splitedValue[1]);
		System.out.println(second);
		List<Integer> list = new ArrayList<>();
		list.add(first);
		list.add(second);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println("test End--------------------");
	 */
	List<Integer> list = Basic.format(scanner.nextLine());
	
	Basic.caculate2(list.get(0),list.get(1));
	}

}

