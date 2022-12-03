package practice.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

	public static void main(String[] args) {
		/*
		���� 1.
		��ȣ�� �̸��� ���� �л� Ŭ������ ���弼��.
		�л��� ��ȣ�� ������������ �����Ͽ� ����ϼ���.
		��ȣ�� ���� ��� �̸��� ������������ �����Ͽ� ����ϼ���.
		*/
		
		List<Student2> studentList = new ArrayList<>();
		Collections.addAll(studentList, new Student2(1, "����"), new Student2(1, "�뿵"), new Student2(2, "����"), new Student2(3, "����"), new Student2(4, "����"));
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