package practice.ch18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ExCollections {

	public static void main(String[] args) {
		System.out.println(" <addAll> ");
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "A","D","B","C","E");
		System.out.println(list);
		System.out.println();
		
		System.out.println("< binarySearch  정렬 전 >");
		System.out.println(Collections.binarySearch(list, "D"));
		System.out.println();
		
		System.out.println("< sort >");
		Collections.sort(list);
		System.out.println(list);
		System.out.println();
		
		System.out.println("< binarySearch 정렬 후 >");
		System.out.println(Collections.binarySearch(list, "D"));
		System.out.println();
		
		System.out.println("< max, min >");
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		System.out.println();
		
		System.out.println("< replaceAll >");
		Collections.replaceAll(list, "A", "A2");
		System.out.println(list);
		System.out.println();
		
		System.out.println("< reverse >");
		Collections.reverse(list);
		System.out.println(list);
		System.out.println();
		
		System.out.println("< rotate >");
		Collections.rotate(list, 3);
		System.out.println(list);
		System.out.println();
		
		System.out.println("< shuffle >");
		Collections.shuffle(list);
		System.out.println(list);
		System.out.println();
		
		System.out.println("< singleton >");
		Set<String> set = Collections.singleton("A");
		System.out.println(set);
//		set.add("B");		// error
		System.out.println();

		System.out.println("< singletonList >");
		List<String> list2 = Collections.singletonList("B");
		System.out.println(list2);
		System.out.println();
		
		System.out.println("< reverseOrder >");
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		System.out.println();
		
		System.out.println("< swap >");
		Collections.swap(list, 0, 1);
		System.out.println(list);
		System.out.println();
		
		System.out.println(" <fill> ");
		Collections.fill(list, "Z");
		System.out.println(list);
		System.out.println();
	}

}
