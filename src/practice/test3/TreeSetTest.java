package practice.test3;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		/*
		���� 1.
		60�� �̻��� �л����� ������ ����ϼ���. 60���� �����մϴ�.
		���� 2.
		�л����� ���� ���� �� ���� ���� �л��� ������ ����ϼ���.
		���� 3.
		80�� ���� ���� �����ϰ� ���� ������ ����ϼ���.
		���� 4.
		75���� ã�� ����ϼ���. ���ٸ� 75�� ���� ���� �����ϰ� ���� ������ ����ϼ���.
		*/
		
		NavigableSet<Integer> score = new TreeSet<>();
		score.add(60);
		score.add(80);
		score.add(90);
		score.add(75);
		score.add(55);
		
		System.out.println(score);
		
		System.out.println(score.tailSet(60, true));
		System.out.println(score.last());
		System.out.println(score.ceiling(80));
		System.out.println(score.higher(80));
		System.out.println(score.floor(75));
		System.out.println(score.lower(75));
		

	}

}
