package practice.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		/*
		문제 1.
		실행 결과와 구글링을 통해 각 컬렉션의 특징을 정리하세요.
		문제 2.
		중첩 리스트를 작성하고 임의의 값을 입력 및 출력하는 코드를 작성하세요.
		문제 3.
		리스트의 중복되는 값을 Set을 이용해 중복처리 후 결과를 출력하세요. 
		*/
	NumberTest[] arrNum = {
			new NumberTest(1),
			new NumberTest(2),
			new NumberTest(3),
			new NumberTest(3),
			new NumberTest(2),
			new NumberTest(1),
			new NumberTest(7),
			new NumberTest(8),
			new NumberTest(9)
			
	};
	
	NumberTest[] arrNum2 = {
			new NumberTest(1),
			new NumberTest(2),
			new NumberTest(3),
			new NumberTest(4),
			new NumberTest(5),
			
	};	
	
	
	List<NumberTest> list1 = new ArrayList<>(Arrays.asList(arrNum));
	List<NumberTest> list2 = new ArrayList<>(Arrays.asList(arrNum2));
		
	NumberTest.printList(list1);
	NumberTest.printSet(list1);
	System.out.println();
	NumberTest.printList(list2);
	NumberTest.printSet(list2);
	//
	System.out.println("==============");
	
	Collections.addAll(list1, arrNum);
	Collections.addAll(list2, arrNum);
	NumberTest.printList(list1);
	NumberTest.printSet(list1);
	System.out.println();
	NumberTest.printList(list2);
	NumberTest.printSet(list2);
	
	System.out.println("==============");

	Integer[] arrInt = {1,2,3,3,2,1,5,6,7,8,9}; 

	List<Integer> list3 = new ArrayList<>(Arrays.asList(arrInt));

	
	NumberTest.printListInteger(list3);
	NumberTest.printSetInteger(list3);
	}
	
	
}

class NumberTest {
	private int num;
	
	public NumberTest(int num) {
		this.num = num;
	}
	
	public static void printList(Collection<NumberTest> list) {
		System.out.print("[");
		for(Iterator<NumberTest> it = list.iterator(); it.hasNext();) {
			System.out.print(it.next());
		}
		System.out.println("]");
	}
	
	public static void printSet(Collection<NumberTest> list) {
		System.out.print("[");
		Set<NumberTest> hash = new LinkedHashSet<>(list);		
		for(Iterator<NumberTest> it = hash.iterator(); it.hasNext();) {
			System.out.print(it.next());
		}
		System.out.println("]");
	}
	
	
	//========================================================================
	
	public static void printListInteger(Collection<Integer> list) {
		System.out.print("[");
		for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
			System.out.print(it.next());
		}
		System.out.println("]");
	}
	
	public static void printSetInteger(Collection<Integer> list) {
		System.out.print("[");
		Set<Integer> hash = new HashSet<>(list);		
		for(Iterator<Integer> it = hash.iterator(); it.hasNext();) {
			
			System.out.print(it.next());
		}
		System.out.println("]");
	}
	
	
	
	@Override
	public String toString() {
		return "" + num +" " ;
	}
	
}