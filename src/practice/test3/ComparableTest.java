package practice.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

	public static void main(String[] args) {
		/*
		문제 1.
		번호와 이름을 가진 학생 클래스를 만드세요.
		학생의 번호를 오름차순으로 정렬하여 출력하세요.
		번호가 같을 경우 이름을 내림차순으로 정렬하여 출력하세요.
		*/
		
		List<Student2> studentList = new ArrayList<>();
		Collections.addAll(studentList, new Student2(1, "강국"), new Student2(1, "대영"), new Student2(2, "건주"), new Student2(3, "정훈"), new Student2(4, "현빈"));
		System.out.println(studentList);
		Collections.sort(studentList);
		System.out.println(studentList);
	}

}

class Student2  implements Comparable<Student2> {
	private int no;
	private String name;
	
	public Student2(int no, String name) {
		this.no = no;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getNo() {
		return no;
	}
	@Override
	public String toString() {
		return "(" + no + ", " + name + ")";
	}
	@Override
	public int compareTo(Student2 s) {
		int result = Integer.valueOf(no).compareTo(s.getNo());
			if(result == 0)
				result = name.compareTo(s.getName())*-1;
		return result;
	}
	
}