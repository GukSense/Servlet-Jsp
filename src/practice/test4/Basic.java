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
//		System.out.println("���� �䱸����<1>");
//		Basic.caculate(scanner.nextInt());
		/*
		����ڰ� �Է��� ���� ���� ũ�Ⱑ �ٸ� �������� ����� ����Ѵ�.
		���� ��� ����ڰ� "8,7"�� ���� ���ڿ��� �Է��ϸ� ��ĥ���� �����Ѵ�. ��ĥ���� 
		2 * 1 ... 2 * 7, 3 * 1 ... 3 * 7, ... , 8 * 1 ... 8 * 7 ���� �����ϴ� ���� �ǹ��Ѵ�.
		*/
		System.out.println("���� �䱸����<2>");
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

