package practice.ch18;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class ExTreeSet {

	public static void main(String[] args) {
		//SortedSet<Integer> set = new TreeSet<>();
		NavigableSet<Integer> tvSet = new TreeSet<>();
		
		tvSet.add(300);
		tvSet.add(700);
		tvSet.add(100);
		tvSet.add(200);
		tvSet.add(200);
		tvSet.add(900);
		tvSet.add(870);
		
		System.out.println("< TV ������ �� >");
		for(Iterator<Integer> it = tvSet.iterator(); it.hasNext();) {
			System.out.println(it.next() + "��");
		}
		System.out.println("< TV �ְ� �� >");
		for(Iterator<Integer> it = tvSet.descendingIterator(); it.hasNext();) {
			System.out.println(it.next() + "��");
		}
		
		System.out.println("< TV �ְ� �� >");
		NavigableSet<Integer> reverseSet = tvSet.descendingSet();
		for(Iterator<Integer> it = reverseSet.iterator(); it.hasNext();) {
			System.out.println(it.next() + "��");
		}
		
		int money = 300;
		
		System.out.println("<���� ���� TV ���� >");
		SortedSet<Integer> availableSet = tvSet.headSet(money);
		System.out.println(availableSet);
		
		System.out.println("< ���� ���� TV ���� >");
		NavigableSet<Integer> availableSet2 = tvSet.headSet(money, true);
		System.out.println(availableSet2);
		
		System.out.println("< ���� �Ұ��� TV ���� >");
		NavigableSet<Integer> notAvailableSet = tvSet.tailSet(money, false);
		System.out.println(notAvailableSet);
		
		System.out.println("< 200�� �̻� 900�� �̸��� TV �˻� >");
		NavigableSet<Integer> searchSet = tvSet.subSet(200, true, 900, false);
		System.out.println(searchSet);
		
		System.out.println("< 750���̰ų� ���� �� ��� TV�� �˻� >");
		System.out.println(tvSet.ceiling(750));
		System.out.println("< 300���̰ų� ���� �� ��� TV�� �˻� >");
		System.out.println(tvSet.ceiling(300));
		
		System.out.println("< 750���̰ų� ���� �� �� TV�� �˻� >");
		System.out.println(tvSet.floor(750));
		System.out.println("< 300���̰ų� ���� �� �� TV�� �˻� >");
		System.out.println(tvSet.floor(300));
		System.out.println();
		
		System.out.println("< 750�� ���� ���� �� ��� TV�� �˻� >");
		System.out.println(tvSet.higher(750));
		System.out.println("< 750�� ���� ���� �� �� TV�� �˻� >");
		System.out.println(tvSet.lower(750));
		System.out.println();
		
		System.out.println("< ���� ��� TV�� �� TV �Ǹ� >");
		System.out.println(tvSet.pollFirst());
		System.out.println(tvSet.pollLast());
		
		System.out.println("< 870�� TV �Ǹ�>");
		System.out.println(tvSet.remove(870));
		System.out.println("< 550�� TV ��� ����>");
		System.out.println(tvSet.remove(870));
		
		System.out.println("< �Ǹ����� TV >");
		for (Iterator<Integer> it = tvSet.iterator(); it.hasNext(); )
			System.out.println(it.next() + "��");
	}

}
