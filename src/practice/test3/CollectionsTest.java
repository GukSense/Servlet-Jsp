package practice.test3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		/*
		문제 1.
		addAll 을 이용해 리스트에 임의의 값들을 입력 후
		binarySearch 를 이용해 검색하세요.
		오름차순과 내림차순을 적용 후 출력하세요.
		문제 2.
		Arrays.asList를 이용해 리스트 생성 후 해당 리스트에 임의의 값을 추가하세요.
		문제 3.
		Arrays.equals 와 Arrays.deepEquals 를 사용하여 1차원 배열과 2차원 배열의 값을 비교하는 코드를 작성하세요.
		*/
		
		List<Integer> intg = new ArrayList<>();
		Collections.addAll(intg, 1,2,3,4,5,10,9,8,7,6);
		
		
		System.out.println(intg);
		System.out.println(Collections.binarySearch(intg, 4));	// 요소index를 반환
		System.out.println();
		
		Collections.sort(intg);
		System.out.println(intg + " 오름차순");
		System.out.println();
		
		Collections.sort(intg, Collections.reverseOrder());
		System.out.println(intg + " 내림차순");
		System.out.println();
		
		
		Integer[] arrIntg = {1,2,3,4,5,6,7,8,9,10};
		Integer[] arrIntg2 = {1,2,3,4,5,6,7,8,9,10};	// if -> if = {10,9,8,7,6,5,4,3,2,1} false
		Integer[] arrIntg3 = {11,12,13,14,15,16,17,18,19,20};
		
		
		List<Integer> intg2 = Arrays.asList(arrIntg);
		System.out.println(intg2 + " asList check");
//		Collections.addAll(intg2, 100);	//error	
		/*
		 * Arrays.asList 로 생성한 리스트는 고정되어 있어 원소를 제거할 수 없다고 한다
		 * 그래서 아래와 같이 new ArrayList<>() 로 Arrays.asList 코드를 감싸서 리스트를 생성해야 리스트 원소를 삭제할 수 있다. 
		 */
		intg2 = new ArrayList<>(Arrays.asList(arrIntg));
		Collections.addAll(intg2, 100);
		System.out.println(intg2 + " 값 100추가");
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
