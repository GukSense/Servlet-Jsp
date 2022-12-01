package practice.test3;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		/*
		문제 1.
		60점 이상인 학생들의 점수를 출력하세요. 60점을 포함합니다.
		문제 2.
		학생들의 시험 점수 중 가장 높은 학생의 점수를 출력하세요.
		문제 3.
		80점 보다 가장 근접하게 높은 점수를 출력하세요.
		문제 4.
		75점을 찾아 출력하세요. 없다면 75점 보다 가장 근접하게 낮은 점수를 출력하세요.
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
