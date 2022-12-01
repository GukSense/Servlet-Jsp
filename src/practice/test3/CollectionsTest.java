package practice.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		/*
		���� 1.
		addAll �� �̿��� ����Ʈ�� ������ ������ �Է� ��
		binarySearch �� �̿��� �˻��ϼ���.
		���������� ���������� ���� �� ����ϼ���.
		���� 2.
		Arrays.asList�� �̿��� ����Ʈ ���� �� �ش� ����Ʈ�� ������ ���� �߰��ϼ���.
		���� 3.
		Arrays.equals �� Arrays.deepEquals �� ����Ͽ� 1���� �迭�� 2���� �迭�� ���� ���ϴ� �ڵ带 �ۼ��ϼ���.
		*/
		
		List<Integer> intg = new ArrayList<>();
		Collections.addAll(intg, 1,2,3,4,5,10,9,8,7,6);
		
		
		System.out.println(intg);
		System.out.println(Collections.binarySearch(intg, 4));	// ���index�� ��ȯ
		System.out.println();
		
		Collections.sort(intg);
		System.out.println(intg + " ��������");
		System.out.println();
		
		Collections.sort(intg, Collections.reverseOrder());
		System.out.println(intg + " ��������");
		System.out.println();
		
		
		Integer[] arrIntg = {1,2,3,4,5,6,7,8,9,10};
		Integer[] arrIntg2 = {1,2,3,4,5,6,7,8,9,10};	// if -> if = {10,9,8,7,6,5,4,3,2,1} false
		Integer[] arrIntg3 = {11,12,13,14,15,16,17,18,19,20};
		
		
		List<Integer> intg2 = Arrays.asList(arrIntg);
		System.out.println(intg2 + " asList check");
//		Collections.addAll(intg2, 100);	//error	
		/*
		 * Arrays.asList �� ������ ����Ʈ�� �����Ǿ� �־� ���Ҹ� ������ �� ���ٰ� �Ѵ�
		 * �׷��� �Ʒ��� ���� new ArrayList<>() �� Arrays.asList �ڵ带 ���μ� ����Ʈ�� �����ؾ� ����Ʈ ���Ҹ� ������ �� �ִ�. 
		 */
		intg2 = new ArrayList<>(Arrays.asList(arrIntg));
		Collections.addAll(intg2, 100);
		System.out.println(intg2 + " �� 100�߰�");
		System.out.println();
		
		System.out.println("<Use Arrays.equals>");
		System.out.println((Arrays.equals(arrIntg, arrIntg2) ? (Arrays.equals(arrIntg, arrIntg3) ? "true" : "f") : "false"));// arrIntg == arrIntg2
																															// arrIntg == arrIntg3
		
		System.out.println(arrIntg == arrIntg2);	//false
		System.out.println(arrIntg.equals(arrIntg2));//false
		System.out.println(Arrays.equals(arrIntg, arrIntg2));//true
		System.out.println();
		
		Integer[][] arrIntg4 = {{1,2,3},{4,5,6}};
		Integer[][] arrIntg5 = {{1,2,3},{4,5,6}};
		Integer[][] arrIntg6 = {{4,5,6},{1,2,3}};
		System.out.println("<Use Arrays.deepEquals>");
		System.out.println(Arrays.deepEquals(arrIntg4, arrIntg5));	//true
		System.out.println(Arrays.deepEquals(arrIntg4, arrIntg6));	//false
		System.out.println(Arrays.equals(arrIntg4, arrIntg5));		//true //error
		System.out.println(Arrays.equals(arrIntg4, arrIntg6));		//false //error
	}

}
