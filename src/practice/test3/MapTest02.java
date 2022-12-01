package practice.test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest02 {

	public static void main(String[] args) {
		/*
		�ݺ� �л� ����� �����ϴ� ���� �ۼ��ϼ���.
		�л����� �ڽ��� ���ǰ�� �������� ����Ʈ�� �����ϴ�. 
		�л����� ġ�� ���ǰ�� Ƚ���� �ٸ� �� �ֽ��ϴ�.
		��� ���� �л��� �� �л��� ġ�� ���ǰ����� ������ ����ϼ���.
		���� ������ ���� Ŭ������ ����Ͽ� �ڵ��ϼ���.
		*/
		
		Student s1 = new Student("�ֿ�");
		s1.addMockTest(new mockTest(75, "2ȸ��"));
		
		Student s2 = new Student("���");
		s2.addMockTest(new mockTest(60, "1ȸ��"));
		
		Student s3 = new Student("����");
		s3.addMockTest(new mockTest(80, "3ȸ��"));
		
		
		List<Student> one = new ArrayList<>();
		one.add(s1);
		one.add(s3);
		List<Student> two = new ArrayList<>();
		two.add(s2);
		
		Grade className = new Grade();
		className.add("�̻������� ���̹��а�", one);
		className.add("�̻������� ���й�", two);
		
		className.printAllClass();
		
		
		
	}

}
class Grade {
	private Map<String, List<Student>> mapClass;
	
	public Grade() {
		 mapClass = new HashMap<>();
	}
	
	public void add(String className, List<Student> s) {
		mapClass.put(className, s);
	}
	
	public void printAllClass() {
		System.out.println(" <�̻������� �а� �л��� ���� �� ȸ��> ");
		for(Map.Entry<String, List<Student>> entry : mapClass.entrySet() ) {
			for(Student s : entry.getValue()) {
				System.out.print(entry.getKey() +"\n"+ s.getName());
				for(mockTest m : s.getMockTest()) {
					System.out.print(" =>" + m);
				}
				System.out.println("------");
			}
		}
	
	}
	
}
class Student {
	private String name;
	private List<mockTest> mockTest;
	
	public Student(String name) {
		this.name = name;
		mockTest = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<mockTest> getMockTest() {
		return mockTest;
	}

	public void addMockTest(mockTest mockTest) {
		this.mockTest.add(mockTest);
	}
	
	
}

class mockTest {
	private int score;
	private String num;
	
	public mockTest(int score, String num) {
		this.score = score;
		this.num = num;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public String toString() {
		return "���� : " + score + "Ƚ��: " + num; 
	}
	
}

